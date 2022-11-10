package fr.ligo.ligo.services;

import fr.ligo.ligo.model.EntityTypeCustom;
import fr.ligo.ligo.services.exception.LigoException;
import fr.ligo.ligo.services.exception.RequestNoLinkException;
import org.hibernate.metamodel.internal.MetamodelImpl;
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;
import org.hibernate.metamodel.model.domain.spi.PersistentAttributeDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class RequestContructorImpl implements RequestContructor{

	@Autowired
	private EntityManager entityManager;
	public static final String REGEX_ALPHANUMERIQUE = "^[-@.,/:'%!éèàâôûîêùç°#&+\\w\\s]*$";
	public static final String REGEX_NUMERIQUE = "^(0|[1-9]\\d*)$";
	public static final String REGEX_DATE = "^(0?[1-9]|[12]\\d|3[01])[/\\-](0?[1-9]|1[012])[/\\-]\\d{4}$";
	Logger logger = LoggerFactory.getLogger(RequestContructorImpl.class);
	private static final String PACKAGE_ENTITY = "package";
	public static final List<String> LIST_TABLE_PRIORITAIRE = List.of("EntityName");

	/**
	 * Récupére une list de nom d'entity JPA permettant de faire le lien entre deux
	 * entity
	 *
	 * @param from nom de l'entity java de départ (utilisé dans le from), le
	 *             parametre doit contenir le nom de la class précédé du package
	 *             dans lequel il se trouve ex :
	 *             fr.capeb.isabat.socle.common.entity.ArtArtisanGeo
	 * @param to   nom de l'entity java d'arrivée, Le parametre doit contenir le nom
	 *             de la class précédé ou non du nom de package ex : ArtArtisanGeo
	 *             ou fr.capeb.isabat.socle.common.entity.ArtArtisanGeo
	 * @param path nom de l'entity Java obligatoire pour aller du point from au
	 *             point to
	 * @return List de nom d'entity java, le premier étant la class de départ
	 */
	private List<String> getListJoin(String from, String to, String path)
			throws RequestNoLinkException, LigoException {

		List<String> hibernateEntityName;
		// Récupération du Model JPA
		MetamodelImpl metamodel = (MetamodelImpl) entityManager.getMetamodel();

		// Récupération du point de départ
		EntityTypeCustom entityTypeCustom = new EntityTypeCustom(new ArrayList<>(),
				(EntityTypeImpl) metamodel.getEntityTypeByName(PACKAGE_ENTITY + from));

		if (entityTypeCustom.getEntityType() == null) {
			throw new LigoException("Aucune entity correspondante pour la class : " + from);
		} else {

			hibernateEntityName = findLink(entityTypeCustom, to, path);
		}

		if (hibernateEntityName == null) {
			throw new RequestNoLinkException("Impossible de lié les tables : " + from + " " + to);
		}

		return hibernateEntityName;

	}

	/**
	 * Algorithme de recherche des tables de lien entre 2 tables
	 *
	 * @param from EntityTypeCustom de la table de départ
	 * @param to   de l'entity java d'arrivée, Le parametre doit contenir le nom de
	 *             la class précédé ou non du nom de package ex : ArtArtisanGeo ou
	 *             fr.capeb.isabat.socle.common.entity.ArtArtisanGeo
	 * @return List de nom d'entity java, le premier étant la class de départ
	 */
	private List<String> findLink(EntityTypeCustom from, String to, String path) {
		List<String> hibernateEntityName = null;
		Queue<EntityTypeCustom> queue = new ArrayDeque<>();
		queue.add(from);

		EntityTypeCustom current;

		List<EntityTypeCustom> alreadyVisited = new ArrayList<>();

		while (!queue.isEmpty()) {
			current = queue.remove();
			logger.debug("Visited node with value: {}", current.getEntityType().getJavaType().getName());

			// Si true on a trovué la table
			if (current.getEntityType().getJavaType().getName().contains(to)) {
				// Permets de forcé un path par l'ago
				if (path == null || (current.getPath().stream().anyMatch(str -> str.contains(path)))) {
					// Ajout du path pour retrouver la table
					hibernateEntityName = current.getPath();
					// Ajout de la table
					hibernateEntityName.add(current.getEntityType().getJavaType().getName());

					// Sorti
					queue.clear();
					logger.debug("Path trouvé : {}", current.getPath());
				}

			} else {
				// Evite de boucler a l'infini
				alreadyVisited.add(current);

				// Ajout des tables lié a la table courante dans la queue de traitement
				addLinkedTableFromCurrentInQueue(queue, current);

				// Evite de boucler a l'infini
				queue.removeAll(alreadyVisited);
			}
		}
		return hibernateEntityName;
	}

	/**
	 * Ajoute des EntityTypeCustom dans la file de traitement, récupération des
	 * entites lié a l'entity courante et ajout de celles ci dans la file de
	 * traitement
	 *
	 * @param queue   file d'attente
	 * @param current Entity courante
	 */
	private void addLinkedTableFromCurrentInQueue(Queue<EntityTypeCustom> queue, EntityTypeCustom current) {
		Set<PersistentAttributeDescriptor> attributes = current.getEntityType().getDeclaredAttributes();
		List<String> newPath;
		LinkedList<EntityTypeCustom> entityTypeCustoms = new LinkedList<>();

		for (PersistentAttributeDescriptor attribute : attributes) {

			if (!attribute.getPersistentAttributeType().toString().equals("BASIC")
					&& !attribute.getPersistentAttributeType().toString().equals("EMBEDDED")) {

				// Ajout du path
				newPath = new ArrayList<>(current.getPath());
				newPath.add(current.getEntityType().getJavaType().getName());

				entityTypeCustoms.add(new EntityTypeCustom(newPath, (EntityTypeImpl) attribute.getValueGraphType()));
			}

		}
//		TODO list of priority not sure to do it, it's better to manage directly the entity for close some path
//		orderListByListOfPriority(entityTypeCustoms);

		// Ajout a la queue les entités à traiter
		queue.addAll(entityTypeCustoms);
	}

	private static void orderListByListOfPriority(LinkedList<EntityTypeCustom> entityTypeCustoms) {
		List<EntityTypeCustom> entityPrioritaires = entityTypeCustoms.stream()
				.filter(e -> LIST_TABLE_PRIORITAIRE.contains(e.getEntityType().getName())).toList();
		for (int i = 0; i < entityPrioritaires.size(); i++) {
			String entityPrioritaire = entityPrioritaires.get(i).getEntityType().getName();
			int index = i;
			for (int j = 0; j < entityTypeCustoms.size(); j++) {
				if (entityPrioritaire.equals(entityTypeCustoms.get(j).getEntityType().getName())) {
					index = j;
				}

			}
			Collections.swap(entityTypeCustoms, index, i);

		}
	}
}
