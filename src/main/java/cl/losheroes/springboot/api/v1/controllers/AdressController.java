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

import cl.losheroes.springboot.api.v1.entities.AdressEntity;
import cl.losheroes.springboot.api.v1.entities.CustomerEntity;
import cl.losheroes.springboot.api.v1.services.IAdressService;

@RestController
@RequestMapping("/api/v1/")
public class AdressController {


	@Autowired
	private IAdressService adressService;

	@GetMapping(path = "/adresses")
	public ResponseEntity<List<AdressEntity>> getAll(){
		return new ResponseEntity<>(adressService.findAll(),HttpStatus.OK);
	}

	@GetMapping(path = "/adresses/{id}")
	public ResponseEntity<AdressEntity> getById(@PathVariable Long id){
		return new ResponseEntity<>(adressService.findById(id),HttpStatus.OK);
	}

	@PostMapping(path = "customers/{id}/adresses")
	public  ResponseEntity<AdressEntity>add(@PathVariable Long id, @RequestBody AdressEntity adress){

		CustomerEntity customer = new CustomerEntity();
		customer.setCustomerId(id);

		adress.setCustomer(customer);
		return new ResponseEntity<>(adressService.add(adress), HttpStatus.CREATED);
	}

	@PutMapping(path = "/adresses/{id}")
	public ResponseEntity<AdressEntity> update(@PathVariable Long id, @RequestBody AdressEntity adress){

		 return new ResponseEntity<>(adressService.update(adress,id), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/adresses/{id}")
	public ResponseEntity<AdressEntity> delete(@PathVariable Long id){

		return new ResponseEntity<>(adressService.delete(id), HttpStatus.OK);
	}



}
