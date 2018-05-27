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

import py.pol.una.electiva3.entity.Vehiculo;
import py.pol.una.electiva3.model.ClienteModel;
import py.pol.una.electiva3.model.VehiculoModel;
import py.pol.una.electiva3.repository.VehiculoRepository;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
	
	private static final String VEHICLE = "/{matricula}";
	
	@Autowired
	private VehiculoRepository repository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllVehicle(){
		
		try {
			List<VehiculoModel> model = new ArrayList<>();
			
			List<Vehiculo> listVehicle = (List<Vehiculo>) repository.findAll();
			
			if(listVehicle.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			for (Vehiculo vehiculo : listVehicle) {
				
				model.add(new VehiculoModel(vehiculo.getMatricula(), 
						vehiculo.getModelo(), 
						vehiculo.getColor(), 
						vehiculo.getFechaentrada(), 
						new ClienteModel(vehiculo.getDni().getDni(), 
								vehiculo.getDni().getNombre(), 
								vehiculo.getDni().getApellido(), 
								vehiculo.getDni().getDireccion(), 
								vehiculo.getDni().getTelefono())));
				
			}
			
			return new ResponseEntity<List<VehiculoModel>>(model, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping(value = VEHICLE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicle(@PathVariable String matricula){
		
		try {
			Vehiculo vehiculo = repository.findOne(matricula);
			
			if(vehiculo==null){
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			VehiculoModel model = new VehiculoModel(vehiculo.getMatricula(),
					vehiculo.getModelo(),
					vehiculo.getColor(),
					vehiculo.getFechaentrada(),
					new ClienteModel(vehiculo.getDni().getDni(), 
							vehiculo.getDni().getNombre(), 
							vehiculo.getDni().getApellido(), 
							vehiculo.getDni().getDireccion(), 
							vehiculo.getDni().getTelefono()));
			
			return new ResponseEntity<VehiculoModel>(model, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveVehicle(@RequestBody Vehiculo vehicle){
		try {
			repository.save(vehicle);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateVehicle(@RequestBody VehiculoModel vehicle){
		try {
			if(vehicle.getMatricula()!=null){
				Vehiculo vehiculo = repository.findOne(vehicle.getMatricula());
				if(vehiculo != null){
					repository.save(vehiculo);
				} else{
					return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				}
			}
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = VEHICLE)
	public ResponseEntity<?> deleteVehicle(@PathVariable String matricula){
		try {
			Vehiculo vehiculo = repository.findOne(matricula);
			
			if(vehiculo==null){
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
