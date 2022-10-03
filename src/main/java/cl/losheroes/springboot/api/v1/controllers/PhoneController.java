package cl.losheroes.springboot.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.losheroes.springboot.api.v1.entities.PhoneEntity;
import cl.losheroes.springboot.api.v1.services.IPhoneService;

@RequestMapping("/api/v1")
@RestController
public class PhoneController {


	@Autowired
	private IPhoneService phoneService;


	@GetMapping("/phones")
	public ResponseEntity<List<PhoneEntity>> findAll(){
		return new ResponseEntity<>(phoneService.findAll(),HttpStatus.OK);
	}

	@GetMapping(path = "/phones/{id}")
	public ResponseEntity<PhoneEntity> getById(@PathVariable Long id){
		return new ResponseEntity<>(phoneService.findById(id),HttpStatus.OK);
	}

	@PostMapping("/customers/{id}/phones")
	public ResponseEntity<PhoneEntity> add(@RequestBody PhoneEntity phone,@PathVariable Long id){
		return new ResponseEntity<>(phoneService.add(phone,id),HttpStatus.CREATED);

	}

	@PutMapping("/phones/{id}")
	public ResponseEntity<PhoneEntity> update(@RequestBody PhoneEntity phone,@PathVariable Long id){
		return new ResponseEntity<>(phoneService.update(phone,id), HttpStatus.CREATED);

	}

	@DeleteMapping("/phones/{id}")
	public ResponseEntity<PhoneEntity> delete(@PathVariable Long id){
		return new ResponseEntity<>(phoneService.delete(id), HttpStatus.OK);
	}
}
