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

import cl.losheroes.springboot.api.v1.entities.CustomerEntity;
import cl.losheroes.springboot.api.v1.services.ICustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@GetMapping("")
	public ResponseEntity<List<CustomerEntity>> getAll() {
		return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> getById(@PathVariable Long id) {
		return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<CustomerEntity> add(@RequestBody CustomerEntity customer) {
		return new ResponseEntity<>(customerService.add(customer),HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public  ResponseEntity<CustomerEntity> update(@RequestBody CustomerEntity customer, @PathVariable Long id) {
		return new ResponseEntity<>(customerService.update(customer, id), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerEntity>delete(@PathVariable Long id) {
		return new ResponseEntity<CustomerEntity>(customerService.delete(id), HttpStatus.OK);

	}

}
