package fr.ligo.ligo.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.ArrayList;
import java.util.List;

public class BeanUtils {

	public static List<String> getBeansWithAnnotation(GenericApplicationContext applicationContext, Class<?> annotationClass) {
		List<String> result = new ArrayList<String>();
		ConfigurableListableBeanFactory factory = applicationContext.getBeanFactory();
		for(String name : factory.getBeanDefinitionNames()) {
			BeanDefinition bd = factory.getBeanDefinition(name);
			if(bd.getSource() instanceof AnnotatedTypeMetadata) {
				AnnotatedTypeMetadata metadata = (AnnotatedTypeMetadata) bd.getSource();
				if (metadata.getAnnotationAttributes(annotationClass.getName()) != null) {
					result.add(name);
				}
			}
		}
		return result;
	}
}