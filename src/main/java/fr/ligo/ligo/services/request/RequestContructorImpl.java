package fr.ligo.ligo.services.request;

import fr.ligo.ligo.model.EntityNameWithJoin;
import fr.ligo.ligo.model.EntityTypeCustom;
import fr.ligo.ligo.model.ReqClause;
import fr.ligo.ligo.services.EntityLigoSystem;
import fr.ligo.ligo.services.EntityLigoSystemScan;
import fr.ligo.ligo.services.exception.LigoException;
import fr.ligo.ligo.services.exception.RequestNoLinkException;
import fr.ligo.ligo.util.BeanUtils;
import org.hibernate.metamodel.internal.MetamodelImpl;
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;
import org.hibernate.metamodel.model.domain.spi.PersistentAttributeDescriptor;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class RequestContructorImpl implements RequestContructor{


	@Autowired
	GenericApplicationContext applicationContext;
	@Autowired
	private EntityManager entityManager;
	public static final String REGEX_ALPHANUMERIQUE = "^[-@.,/:'%!éèàâôûîêùç°#&+\\w\\s]*$";
	public static final String REGEX_NUMERIQUE = "^(0|[1-9]\\d*)$";
	public static final String REGEX_DATE = "^(0?[1-9]|[12]\\d|3[01])[/\\-](0?[1-9]|1[012])[/\\-]\\d{4}$";
	Logger logger = LoggerFactory.getLogger(RequestContructorImpl.class);
	private static final String PACKAGE_ENTITY = "package";
	public static final List<String> LIST_TABLE_PRIORITAIRE = List.of("EntityName");



	/**
	 * Construit les clauses FROM et select en HQL a partir d'objets
	 * RelReqSauvegardeSelect et RelReqSauvegardeWhere
	 *
	 * @param clauseList List de RelReqSauvegardeSelect utilisé pour la requete
	 */
	public List<EntityNameWithJoin> constructFromAndInner(Set<ReqClause> clauseList)   {
		List<String> basePackagesFromApplicationAnnotationEntityLigoSystemScan =
				List.of(ClassUtils.getUserClass(applicationContext.getBeansWithAnnotation(EntityScan.class).values()
						.iterator().next().getClass()).getAnnotation(EntityLigoSystemScan.class).basePackages());
		List<EntityNameWithJoin> listOf3SmallestTableOfJoin = new ArrayList<>();
		for (String basepackage : basePackagesFromApplicationAnnotationEntityLigoSystemScan){
			Reflections reflections = new Reflections(basepackage);
			Set<Class<?>> possibleFromEntities = reflections
					.getTypesAnnotatedWith(EntityLigoSystem.class);
			for (Class<?> entity : possibleFromEntities){
				EntityNameWithJoin entityNameAndListOfJoinCurrent = new EntityNameWithJoin(entity.getName(),getSumTableToLink(clauseList, entity.getTypeName()));
				if (listOf3SmallestTableOfJoin.size() < 3 && entityNameAndListOfJoinCurrent.getListOfJoin().size() != 0){
					listOf3SmallestTableOfJoin.add(entityNameAndListOfJoinCurrent);
				}else if(entityNameAndListOfJoinCurrent.getListOfJoin().size() != 0) {
					 Optional<EntityNameWithJoin> opt =listOf3SmallestTableOfJoin
							.stream().filter(obj -> obj.getListOfJoin().size() < entityNameAndListOfJoinCurrent.getListOfJoin().size())
							.collect(Collectors.toList())
							.stream().min(Comparator.comparingInt(i -> i.getListOfJoin().size()));
					 if (opt.isPresent()){
						Collections.replaceAll(listOf3SmallestTableOfJoin, opt.get() , entityNameAndListOfJoinCurrent);
					 }
				}
			}
		}

//		List<String> annotatedClasses = types.stream()
//				.map(clazz -> clazz.getAnnotation(EntityLigoSystem.class))
//				.collect(Collectors.toList());



//		StringBuilder fromAndInnerArt = new StringBuilder("FROM ArtArtisanGeo as ArtArtisanGeo ");
//		StringBuilder fromAndInnerGeo = new StringBuilder("FROM GeoPersonne as GeoPersonne ");
//
//		if (croiser) {
//			fromAndInnerArt = new StringBuilder("FROM ArtArtisanGeo as ArtArtisanGeoBis");
//			fromAndInnerGeo = new StringBuilder("FROM GeoPersonne as GeoPersonneBis ");
//		}
//		StringBuilder from;
//
//		Integer nbTableArt;
//		nbTableArt = getSumTableToLink(clauseList, "", fromAndInnerArt);
//
//		Integer nbTableGeo;
//		nbTableGeo = getSumTableToLink(clauseList, "", fromAndInnerGeo);
//
//		if ((nbTableGeo == null || nbTableGeo == 0) && (nbTableArt == null || nbTableArt == 0)) {
//			throw new LigoException("Aucune table de départ valide pour la requete, ni ArtArtisanGeo ni GeoPersonne");
//		} else {
//			if (nbTableGeo == null || nbTableGeo == 0) {
//				from = fromAndInnerArt;
//			} else if (nbTableArt == null || nbTableArt == 0) {
//				from = fromAndInnerGeo;
//			} else if (nbTableArt <= nbTableGeo) {
//				from = fromAndInnerArt;
//			} else {
//				from = fromAndInnerGeo;
//			}
//		}
//		from.append(CARACTERE_ESPACE);

		return listOf3SmallestTableOfJoin;
	}


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
	public List<String> getListJoin(String from, String to, String path)
			throws RequestNoLinkException, LigoException {

		List<String> hibernateEntityName = new ArrayList<>();
		// Récupération du Model JPA
		MetamodelImpl metamodel = (MetamodelImpl) entityManager.getMetamodel();

		// Récupération du point de départ
		EntityTypeCustom entityTypeCustom = new EntityTypeCustom(new ArrayList<>(),
				(EntityTypeImpl) metamodel.getEntityTypeByName(from));

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


	private Set<String> getSumTableToLink(Set<ReqClause> clauseList, String startTable) {
		Set<String> listAllTable = new HashSet<>();
		try {
			for (ReqClause reqClause : clauseList) {
				List<String> listTable = this.getListJoin(startTable, reqClause.getTable(),
						reqClause.getTableRequiredInPath());
				listAllTable.addAll(listTable);
			}
		} catch ( RequestNoLinkException | LigoException e  ) {
			logger.error(e.getMessage());
			listAllTable.clear();
		}
		return listAllTable;
	}

	private Integer getSumTableToLink(Set<ReqClause> clauseList, String startTable, StringBuilder fromAndInnerArt) {
		Set<String> listAllTable = new HashSet<>();
		try {
			for (ReqClause reqClause : clauseList) {
				List<String> listTable = this.getListJoin(startTable, reqClause.getTable(),
						reqClause.getTableRequiredInPath());
				listAllTable.addAll(listTable);
				this.generateHQLFromAndInnerJoin(listTable, fromAndInnerArt);
			}
		} catch (ClassNotFoundException | RequestNoLinkException | LigoException e  ) {
			logger.error(e.getMessage());
			listAllTable.clear();
		}
		return listAllTable.size();
	}

	/**
	 * Generate la partie From et innerJoin, tel que : listTable.get(0) correspond
	 * au fromAndInnerJoin et la suite de listTable est dans l'ordre,
	 * listTable.get(i-1) a bien un dépendance vers listTable.get(i)
	 *
	 * @param listTable List de table permettant d'en lier 2 autres. listTable[0] =
	 *                  table from
	 * @throws ClassNotFoundException
	 */
	private void generateHQLFromAndInnerJoin(List<String> listTable, StringBuilder fromAndInnerJoin)
			throws ClassNotFoundException {

		// Démarrage a 1 car 0 = Table de départ/From
		for (int i = 1; i < listTable.size(); i++) {

			String attributOfJoin = listTable.get(i - 1);
			Class<?> entityBefore = Class.forName(listTable.get(i - 1));
			Class<?> entity = Class.forName(listTable.get(i));

			// Parcours les entity lié a la table i-1, si une correspond a un lien a la
			// table i alors on récupère le nom de l'attribut java
			for (Field field : entityBefore.getDeclaredFields()) {
				if (field.getType().equals(entity)) {
					// GENERATE Inner Join Field Simple
					attributOfJoin = field.getName();
				} else if (field.getType().equals(Set.class) || field.getType().equals(List.class)) {
					// GENERATE Inner Join Field type List Set
					if (((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0].equals(entity)) {
						attributOfJoin = field.getName();
					}
				}
			}

			StringBuilder innerJoin = new StringBuilder();
			innerJoin.append(" LEFT OUTER JOIN ");
			innerJoin.append(listTable.get(i - 1).replaceFirst(PACKAGE_ENTITY, ""));
			innerJoin.append(".");
			innerJoin.append(attributOfJoin);
			innerJoin.append(" as ");
			innerJoin.append(listTable.get(i).replaceFirst(PACKAGE_ENTITY, ""));
			if (!fromAndInnerJoin.toString().contains(innerJoin.toString())) {
				fromAndInnerJoin.append(innerJoin);
			}

		}
	}
}
