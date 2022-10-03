package cl.losheroes.springboot.api.v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.losheroes.springboot.api.v1.controllers.exceptions.NotFoundException;
import cl.losheroes.springboot.api.v1.controllers.exceptions.RepeatedException;
import cl.losheroes.springboot.api.v1.entities.AdressEntity;
import cl.losheroes.springboot.api.v1.entities.CustomerEntity;
import cl.losheroes.springboot.api.v1.repositories.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public List<CustomerEntity> findAll() {

		return customerRepository.findAll();
	}

	@Override
	public CustomerEntity findById(Long id) {

	
		return customerRepository.findById(id).get();
	
	}
	 
	public boolean validateRepeated(List<CustomerEntity> list, boolean flag, CustomerEntity customer) {
		
		for (CustomerEntity l : list) {
			
			
			if(l.getEmail().equals(customer.getEmail())) {
				
				flag= true;
				throw new RepeatedException("Email Repeated");
			}
			
			if(l.getRut().equals(customer.getRut())) {
				
				flag= true;
				throw new NotFoundException("Rut Repeated");
				 //break;
				 
			}
		
		}
		

		return flag;
	}
	
	@Override
	public CustomerEntity add(CustomerEntity customer) {
		
		customer.setRut(customer.getRut().toLowerCase());

		List<CustomerEntity> customers = findAll();

		if(!customers.isEmpty()) {
			
			
			if (!validateRepeated(customers, false, customer)) { 
				
				return customerRepository.save(customer);
			}
			
	}else {
		return customerRepository.save(customer);
		}
	


		System.out.println("retorno null");


		return null;

	}

	@Override
	public CustomerEntity update(CustomerEntity customer, Long id) {
		
		customer.setRut(customer.getRut().toLowerCase());
		
		CustomerEntity customerUpdate = customerRepository.findById(id).get();

		if (!customerUpdate.equals(null)) {

			
			
			if(customerUpdate.getEmail().equals(customer.getEmail())) {
				
				throw new RepeatedException("Email Repeated");
			}
			
			if(customerUpdate.getRut().equals(customer.getRut())) {
				
				throw new NotFoundException("Rut Repeated");
			}
			
			customerUpdate.setRut(customer.getRut());
			customerUpdate.setNames(customer.getNames());
			customerUpdate.setSurnames(customer.getSurnames());
			customerUpdate.setEmail(customer.getEmail());
			customerUpdate.setBirthday(customer.getBirthday());
			
			return customerRepository.save(customerUpdate);
		}

		return null;
	}

	@Override
	public CustomerEntity delete(Long id) {
		CustomerEntity c = findById(id);

		if (!c.equals(null)) {

			customerRepository.deleteById(id);
			return c;
		}
		return null;
	}

}
