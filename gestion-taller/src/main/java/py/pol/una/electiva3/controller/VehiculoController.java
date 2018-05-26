package py.pol.una.electiva3.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
	
	private static final String VEHICLE = "{/idVehicle}";
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllVehicle(){
		
		
		return null;
	}
	
	@GetMapping(value = VEHICLE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicle(@PathParam("idVehicle") Integer idVehicle){
		
		
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
