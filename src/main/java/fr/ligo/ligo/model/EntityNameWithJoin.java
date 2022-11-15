package fr.ligo.ligo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityNameWithJoin {
	String name;
	Set<String> listOfJoin;
}
