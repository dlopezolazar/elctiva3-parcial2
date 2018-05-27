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

import py.pol.una.electiva3.entity.Repuestos;
import py.pol.una.electiva3.model.RepuestoModel;
import py.pol.una.electiva3.repository.RepuestoRepository;

@RestController
@RequestMapping("/repuesto")
public class RepuestoController {
	
	private static final String REPUESTO = "/{idRepuesto}";
	
	@Autowired
	private RepuestoRepository repository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllRepuesto(){
		
		try {
			List<RepuestoModel> model = new ArrayList<>();
			
			List<Repuestos> listRepuestos = (List<Repuestos>) repository.findAll();
			
			if(listRepuestos.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			for (Repuestos repuesto : listRepuestos) {
				
				model.add(new RepuestoModel(repuesto.getCodRepuesto(),
						repuesto.getNombre(),
						repuesto.getPrecio()));
				
			}
			
			return new ResponseEntity<List<RepuestoModel>>(model, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = REPUESTO, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCliente(@PathVariable Integer idRepuesto){
		
		try {
			Repuestos repuesto = repository.findOne(idRepuesto);
			
			if(repuesto==null){
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			RepuestoModel model = new RepuestoModel(repuesto.getCodRepuesto(),
					repuesto.getNombre(),
					repuesto.getPrecio());
			
			return new ResponseEntity<RepuestoModel>(model, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCliente(@RequestBody Repuestos repuesto){
		try {
			
			repository.save(repuesto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCliente(@RequestBody RepuestoModel repuesto){
		try {
			if(repuesto.getCodRepuesto()!=null){
				Repuestos rep = repository.findOne(repuesto.getCodRepuesto());
				if(rep != null){
					rep.setNombre(repuesto.getNombre());
					rep.setPrecio(repuesto.getPrecio());
					repository.save(rep);
				} else{
					return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				}
			}
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = REPUESTO)
	public ResponseEntity<?> deleteCliente(@PathVariable Integer idRepuesto){
		try {
			Repuestos repuesto = repository.findOne(idRepuesto);
			
			if(repuesto==null){
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			repository.delete(idRepuesto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
