package fr.ligo.ligo;

import fr.ligo.ligo.model.EntityTypeCustom;
import fr.ligo.ligo.model.ReqClause;
import fr.ligo.ligo.services.EntityLigoSystem;
import fr.ligo.ligo.services.EntityLigoSystemScan;
import fr.ligo.ligo.services.exception.LigoException;
import fr.ligo.ligo.services.exception.RequestNoLinkException;
import fr.ligo.ligo.services.request.RequestContructorImpl;
import org.hibernate.metamodel.internal.MetamodelImpl;
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication

@EntityScan(basePackages = { "fr.ligo.ligo.entities" })
@ComponentScan(basePackages = { "fr.ligo.ligo.services" })
@EntityLigoSystemScan(basePackages = { "fr.ligo.ligo.entities" })
//@EnableJpaRepositories(basePackages = { "" })
public class LigoApplication {

	public static void main(String[] args) {

		GenericWebApplicationContext applicationContext = (GenericWebApplicationContext) SpringApplication.run(LigoApplication.class, args);
		RequestContructorImpl service = applicationContext.getBean(RequestContructorImpl.class);


		Set<ReqClause> reqClauseSet = Set.of(new ReqClause("Currency", null),new ReqClause("Product", null));
		service.constructFromAndInner(reqClauseSet);



	}

}
