package fr.ligo.ligo.services.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Arbp {

	/*
	 * La fonction find by type du service arborescence va chercher tous les champs
	 * de l'arborescence qui n'ont pas de parents dans un premier temps,elle leur
	 * assigne leurs enfants ensuite grâce à la fonction getRecursive et du modèle
	 * ReqRefChampArbo avec enfant composé du champ parent (data) et de ses enfants
	 * (children)
	 */
	public List<ReqRefChampArboAvecEnfant> findByType(String type) {
		// récupération des champs qui n'ont pas de parents (sans leurs enfants)
//		List<ReqRefChampsArboDTO> champArboSansEnfantParent = repository.findByTypeArbo(type).stream()
//				.map(this::convertToReqRefChampsArboDTO).collect(Collectors.toList());
		// liste des champs avec leurs enfants
//		List<ReqRefChampArboAvecEnfant> listReqRefChampArboAvecEnfant = new ArrayList<ReqRefChampArboAvecEnfant>();
//
//		ReqRefChampArboAvecEnfant reqRefChampArboAvecEnfant;
//		// appel à getrecursive pour assigner les enfants à chaque champ
//		for (ReqRefChampsArboDTO champArboSansEnfant : champArboSansEnfantParent) {
//			reqRefChampArboAvecEnfant = new ReqRefChampArboAvecEnfant(champArboSansEnfant);
//			reqRefChampArboAvecEnfant.setChildren(getRecursive(reqRefChampArboAvecEnfant));
//			listReqRefChampArboAvecEnfant.add(reqRefChampArboAvecEnfant);
//		}
//		return listReqRefChampArboAvecEnfant;
		return null;
	}

	public class ReqRefChampArboAvecEnfant {
		private ReqRefChampsArboDTO data;
		private List<ReqRefChampArboAvecEnfant> children;

		public ReqRefChampArboAvecEnfant(ReqRefChampsArboDTO data) {
			this.data = data;
		}

		public ReqRefChampArboAvecEnfant() {
		}

		public ReqRefChampsArboDTO getData() {
			return data;
		}

		public void setData(ReqRefChampsArboDTO data) {
			this.data = data;
		}

		public List<ReqRefChampArboAvecEnfant> getChildren() {
			return children;
		}

		public void setChildren(List<ReqRefChampArboAvecEnfant> children) {
			this.children = children;
		}
	}

	public class ReqRefChampsArboDTO {


		private Long idChampArbo;


		private String nomChampArbo;


		private String typeArbo;


		private Long idReqClause;

		private Long idParentChampArbo;

		public Long getIdChampArbo() {
			return idChampArbo;
		}

		public void setIdChampArbo(Long idChampArbo) {
			this.idChampArbo = idChampArbo;
		}

		public String getNomChampArbo() {
			return nomChampArbo;
		}

		public void setNomChampArbo(String nomChampArbo) {
			this.nomChampArbo = nomChampArbo;
		}

		public String getTypeArbo() {
			return typeArbo;
		}

		public void setTypeArbo(String typeArbo) {
			this.typeArbo = typeArbo;
		}

		public Long getIdReqClause() {
			return idReqClause;
		}

		public void setIdReqClause(Long idReqClause) {
			this.idReqClause = idReqClause;
		}

		public Long getIdParentChampArbo() {
			return idParentChampArbo;
		}

		public void setIdParentChampArbo(Long idParentChampArbo) {
			this.idParentChampArbo = idParentChampArbo;
		}


		@Override
		public int hashCode() {
			return Objects.hash(idChampArbo, idParentChampArbo, idReqClause, nomChampArbo, typeArbo);
		}



	}
//		/**
//		 * La fonction getRecursive appelée par findByType parcourt tous les champs afin
//		 * de récupérer leurs enfants elle s'appelle ensuite elle-même jusqu'à ce que
//		 * tous les champs en sortie n'aient plus d'enfants
//		 * @param reqRefChampArboAvecEnfant : le champ discriminant avec tous ses enfants
//		 * @return tous les champs discriminats avec leurs enfants
//		 */
//		private List<ReqRefChampArboAvecEnfant> getRecursive(ReqRefChampArboAvecEnfant reqRefChampArboAvecEnfant) {
//			// appel à la fonction findchild du repo et conversion en DTO
//			List<ReqRefChampArboAvecEnfant> children = this.repository
//					.findChild(reqRefChampArboAvecEnfant.getData().getIdChampArbo()).stream()
//					.map(this::convertToReqRefChampsArboDTO).map(ReqRefChampArboAvecEnfant::new)
//					.collect(Collectors.toList());
//			List<ReqRefChampArboAvecEnfant> childrenRempli = new ArrayList<>();
//			// appel recursif pour parcourir tous les champs et assigner les enfants
//			for (ReqRefChampArboAvecEnfant child : children) {
//				child.setChildren(getRecursive(child));
//				childrenRempli.add(child);
//			}
//			return childrenRempli;
//		}

	}
