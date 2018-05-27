package py.pol.una.electiva3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	private static final String VEHICLE = "{/idVehicle}";
	
	@Autowired
	private VehiculoRepository repository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllVehicle(){
		
		List<VehiculoModel> model = new ArrayList<>();
		
		List<Vehiculo> listVehicle = (List<Vehiculo>) repository.findAll();
		
		if(listVehicle.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		for (Vehiculo vehiculo : listVehicle) {
			
			model.add(new VehiculoModel(vehiculo.getVehiculoPK().getMatricula(),
					vehiculo.getVehiculoPK().getDni(),
					vehiculo.getModelo(),
					vehiculo.getColor(),
					vehiculo.getFechaentrada(),
					new ClienteModel(vehiculo.getCliente().getDni(),
							vehiculo.getCliente().getNombre(),
							vehiculo.getCliente().getApellido(),
							vehiculo.getCliente().getDireccion(),
							vehiculo.getCliente().getTelefono())));
		}
		
		return new ResponseEntity<List<VehiculoModel>>(model, HttpStatus.OK);
	}
	
	@GetMapping(value = VEHICLE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicle(@PathParam("idVehicle") String matricula){
		
//		Vehiculo vehiculo = repository.findOne(idVehicle);
//		VehiculoModel model = new VehiculoModel(vehiculo.getVehiculoPK().getMatricula(),
//				vehiculo.getVehiculoPK().getDni(),
//				vehiculo.getModelo(),
//				vehiculo.getColor(),
//				vehiculo.getFechaentrada(),
//				new ClienteModel(vehiculo.getCliente().getDni(),
//						vehiculo.getCliente().getNombre(),
//						vehiculo.getCliente().getApellido(),
//						vehiculo.getCliente().getDireccion(),
//						vehiculo.getCliente().getTelefono()));
		return null;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveVehicle(@RequestBody Object vehicle){
		
		return null;
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateVehicle(@RequestBody Object vehicle){
		
		return null;
	}
	
	@DeleteMapping(value = VEHICLE)
	public ResponseEntity<?> deleteVehicle(@PathParam("idVehicle") Integer idVehicle){
		
		return null;
	}

}
