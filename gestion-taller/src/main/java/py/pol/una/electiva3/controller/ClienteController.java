package py.pol.una.electiva3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.pol.una.electiva3.entity.Cliente;
import py.pol.una.electiva3.model.ClienteModel;
import py.pol.una.electiva3.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private static final String CLIENTE = "/{cedula}";
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllCliente(){
		
		try {
			List<ClienteModel> model = new ArrayList<>();
			
			List<Cliente> listClient = (List<Cliente>) repository.findAll();
			
			if(listClient.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			for (Cliente cliente : listClient) {
				
				model.add(new ClienteModel(cliente.getCedula(), 
								cliente.getNombre(), 
								cliente.getApellido(), 
								cliente.getDireccion(), 
								cliente.getTelefono()));
				
			}
			
			return new ResponseEntity<List<ClienteModel>>(model, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = CLIENTE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCliente(@PathVariable Integer cedula){
		
		try {
			Cliente cliente = repository.findOne(cedula);
			
			if(cliente==null){
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			ClienteModel model = new ClienteModel(cliente.getCedula(), 
							cliente.getNombre(), 
							cliente.getApellido(), 
							cliente.getDireccion(), 
							cliente.getTelefono());
			
			return new ResponseEntity<ClienteModel>(model, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCliente(@RequestBody Cliente cedula){
		try {
			repository.save(cedula);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCliente(@RequestBody ClienteModel cliente){
		try {
			if(cliente.getCedula()!=null){
				Cliente cli = repository.findOne(cliente.getCedula());
				if(cli != null){
					cli.setNombre(cliente.getNombre());
					cli.setApellido(cliente.getApellido());
					cli.setTelefono(cliente.getTelefono());
					repository.save(cli);
				} else{
					return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				}
			}
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = CLIENTE)
	public ResponseEntity<?> deleteCliente(@PathVariable Integer cedula){
		try {
			Cliente cliente = repository.findOne(cedula);
			
			if(cliente==null){
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			repository.delete(cedula);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
