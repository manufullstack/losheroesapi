package cl.losheroes.springboot.api.v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.losheroes.springboot.api.v1.controllers.exceptions.BadRequestException;
import cl.losheroes.springboot.api.v1.controllers.exceptions.NotFoundException;
import cl.losheroes.springboot.api.v1.controllers.exceptions.RepeatedEmailException;
import cl.losheroes.springboot.api.v1.controllers.exceptions.RepeatedRutException;
import cl.losheroes.springboot.api.v1.entities.AdressEntity;
import cl.losheroes.springboot.api.v1.entities.CustomerEntity;
import cl.losheroes.springboot.api.v1.entities.PhoneEntity;
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

		CustomerEntity customer = customerRepository.findById(id).get(); 
		
		if(!customer.equals(null)) {
			
			return customer;
		}
		
		throw new NotFoundException("Customer with id: "+id);
	}
	 
	public boolean validateRepeated(List<CustomerEntity> list, boolean flag, CustomerEntity customer) {
		
		for (CustomerEntity l : list) {
			
			
			if(l.getEmail().equals(customer.getEmail())) {
				
				flag= true;
				throw new RepeatedEmailException(customer.getEmail());
			}
			
			if(l.getRut().equals(customer.getRut())) {
				
				flag= true;
				throw new RepeatedRutException(customer.getRut());
				 
			}
		
		}
		

		return flag;
	}
	
	@Override
	public CustomerEntity add(CustomerEntity customer) {
		
		

		List<CustomerEntity> customers = findAll();

		if (!customers.isEmpty()) {

			if (!validateRepeated(customers, false, customer)) {
				
				List<?> phones = customer.getPhones();
				List<?> adresses = customer.getAdresses();
				
				customer.setRut(customer.getRut().toLowerCase());
				
				if(phones.size() == 0 || adresses.size() == 0) {
					
					return customerRepository.save(customer);
				}
				
				
				throw new BadRequestException("Customer Phones or Adresses Not Allowed");
				
			}

		} else {
			
			return customerRepository.save(customer);
		}

		throw new BadRequestException("Customer");

	}

	@Override
	public CustomerEntity update(CustomerEntity customer, Long id) {
		
		
		
		CustomerEntity customerUpdate = customerRepository.findById(id).get();

		if (!customerUpdate.equals(null)) {

			
			
			if(customerUpdate.getEmail().equals(customer.getEmail())) {
				
				throw new RepeatedEmailException(customer.getEmail());
			}
			
			if(customerUpdate.getRut().equals(customer.getRut())) {
				
				throw new RepeatedRutException(customer.getRut());
			}
			
			customerUpdate.setRut(customer.getRut().toLowerCase());
			customerUpdate.setNames(customer.getNames());
			customerUpdate.setSurnames(customer.getSurnames());
			customerUpdate.setEmail(customer.getEmail());
			customerUpdate.setBirthday(customer.getBirthday());
			
			return customerRepository.save(customerUpdate);
		}

		throw new NotFoundException("Customer with id: "+id);
	}

	@Override
	public CustomerEntity delete(Long id) {
		
		CustomerEntity c = findById(id);
		

		if (!c.equals(null)) {

			customerRepository.deleteById(id);
			return c;
		}
		throw new NotFoundException("Customer with id: "+id);
	}

}
