package cl.losheroes.springboot.api.v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.losheroes.springboot.api.v1.controllers.exceptions.BadRequestException;
import cl.losheroes.springboot.api.v1.controllers.exceptions.NotFoundException;
import cl.losheroes.springboot.api.v1.entities.AdressEntity;
import cl.losheroes.springboot.api.v1.entities.CustomerEntity;
import cl.losheroes.springboot.api.v1.entities.PhoneEntity;
import cl.losheroes.springboot.api.v1.repositories.IPhoneRepository;

@Service
public class PhoneServiceImpl implements IPhoneService {


	@Autowired
	private IPhoneRepository phoneRepository;


	@Override
	public List<PhoneEntity> findAll() {

		return phoneRepository.findAll();
	}

	@Override
	public PhoneEntity findById(Long id) {
		
		PhoneEntity phone = phoneRepository.findById(id).get(); 
		
		if(!phone.equals(null)) {
			
			return phone;
		}
		
		throw new NotFoundException("Phone with id: "+id);
	}

	@Override
	public PhoneEntity add(PhoneEntity phone, Long id) {

		CustomerEntity customer = new CustomerEntity();

		customer.setCustomerId(id);

		phone.setCustomer(customer);

		phoneRepository.save(phone);

		List<PhoneEntity> phones = findAll();
	
		for (PhoneEntity p : phones) {
			
			if(p.getNumberPhone().equals(phone.getNumberPhone())){
				
				return phone;
			}
		}
		
		throw new BadRequestException("Phone");
	}

	@Override
	public PhoneEntity update(PhoneEntity phone, Long id) {

		PhoneEntity p = findById(id);

		if(!p.equals(null)) {

			phone.setIdPhone(id);
			phone.setCustomer(p.getCustomer());

			return phoneRepository.save(phone);
		}

		throw new NotFoundException("Phone with id: "+id);

	}

	@Override
	public PhoneEntity delete(Long id) {

		PhoneEntity p = findById(id);

		if(!p.equals(null)) {

			phoneRepository.deleteById(id);
			return p;
		}
		throw new NotFoundException("Phone with id: "+id);
	}


}
