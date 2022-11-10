package fr.ligo.ligo.model;


import lombok.Data;
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;

import java.util.List;
import java.util.Objects;

@Data
public class EntityTypeCustom   {

	private List<String> path;
	private EntityTypeImpl entityType;


	public EntityTypeCustom(List<String> path, EntityTypeImpl entityType) {
		this.path = path;
		this.entityType = entityType;
	}

}
