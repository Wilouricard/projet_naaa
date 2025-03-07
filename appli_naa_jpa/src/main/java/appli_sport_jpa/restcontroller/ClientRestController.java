package appli_sport_jpa.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import appli_sport_jpa.entities.Client;
import appli_sport_jpa.entities.jsonviews.JsonViews;
import appli_sport_jpa.services.ClientServices;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
	
	@Autowired
	private ClientServices clientSrv;
	
//	@GetMapping("")
//	public String Hey() {
//		return "Hey";
//	}
	
	@GetMapping("")
	@JsonView(JsonViews.Client.class)
	public List<Client> findAll() {
		return clientSrv.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client getById(@PathVariable Long id) {
		Client client = null;
		client = clientSrv.findById(id);
		return client;
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Client.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		clientSrv.save(client);
		return client;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		Client clientEnBase = clientSrv.findById(id);
		if (client.getNom() != null) {
			clientEnBase.setNom(client.getNom());
		}
		if (client.getPrenom() != null) {
			clientEnBase.setPrenom(client.getPrenom());
		}
		if (client.getEmail() != null) {
			clientEnBase.setEmail(client.getEmail());
		}
		if (client.getLogin() != null) {
			clientEnBase.setLogin(client.getLogin());
		}
		if (client.getMdp() != null) {
			clientEnBase.setMdp(client.getMdp());
		}
		if (client.getPointsDeSucces() != null) {
			clientEnBase.setPointsDeSucces(client.getPointsDeSucces());
		}
		if (client.getDateNaissance() != null) {
			clientEnBase.setDateNaissance(client.getDateNaissance());
		}
		clientEnBase.setPremium(client.isPremium());
		if (client.getProgramme() != null) {
			clientEnBase.setProgramme(client.getProgramme());
		}
		clientSrv.save(clientEnBase);
		return clientEnBase;
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientSrv.deleteById(id);
	}

}
