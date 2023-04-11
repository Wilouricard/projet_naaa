package appli_sport_jpa.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import appli_sport_jpa.config.JpaConfig;
import appli_sport_jpa.entities.Coach;
import appli_sport_jpa.services.CoachServices;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
public class AppSportTestCoach {
	
	static AnnotationConfigApplicationContext ctx = null;
	
	@Autowired
	CoachServices coachServices;
	
	@BeforeAll
	static void initSpring() {
		ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
	}
	@BeforeEach
	void getProgrammeServices() {
		coachServices = ctx.getBean(CoachServices.class);
	}
	
	@AfterAll
	static void closeString() {
		ctx.close();
	}
	
	@Test
	void coachServiceExistenceTest() {
		assertNotNull(coachServices);
	}
	@Test
	void createOrUpdateTest() {
		Coach coach = new Coach("nomeC1", "nomeC1", "C1@mail", "C1Login", "Mdp-C1", 10, LocalDate.now());
		coachServices.createOrUpdate(coach);
		assertNotNull(coach.getId());
		System.out.println(coach.getId());
		assertNotNull(coach.getMdp());
		System.out.println(coach.getMdp());
	}
	
	@Test
	void DeleteTest() {
		Coach coach = new Coach("nomeC1", "nomeC1", "C1@mail", "C1Login", "Mdp-C1", 10, LocalDate.now());
		coachServices.createOrUpdate(coach);
		assertNotNull(coachServices.getAll());
		coachServices.delete(coach);
		
	}
	
	
	
}
