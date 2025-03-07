package ajc.formation.soprasteria.appliSport;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ajc.formation.soprasteria.appliSport.entities.Client;
import ajc.formation.soprasteria.appliSport.services.ClientServices;


@SpringBootTest
@Transactional
@Rollback
class AppSportTestClient {
	
	@Autowired
	ClientServices clientService;

	
	@Test
	void clientServiceExistTest() {
		assertNotNull(clientService);
	}
	
//	@Test
//	void insertTest() {
//		Client client = new Client("Bob",0,null, null);
//		clientService.createClientFreemium(client);
//		assertNotNull(client.getId());
//		System.out.println(client.getId());
//	}
//	
//	@Test
//	void deleteTest() {
//		Client client = new Client("Bob",0,null, null);
//		clientService.createClientPremium(client);
//		System.out.println(clientService.findAll().size());
//		assertNotNull(clientService.findAll());
//		clientService.deleteById(client.getId());
//		
//	}
	
	@Test
	void findTest() {
		assertNotNull(clientService.findAll());
	}

}
