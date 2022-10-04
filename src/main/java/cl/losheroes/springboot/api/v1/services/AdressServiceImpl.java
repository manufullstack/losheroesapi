package cl.losheroes.springboot.api.v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.losheroes.springboot.api.v1.controllers.exceptions.BadRequestException;
import cl.losheroes.springboot.api.v1.controllers.exceptions.NotFoundException;
import cl.losheroes.springboot.api.v1.entities.AdressEntity;
import cl.losheroes.springboot.api.v1.entities.CustomerEntity;
import cl.losheroes.springboot.api.v1.entities.PhoneEntity;
import cl.losheroes.springboot.api.v1.repositories.IAdressRepository;

@Service
public class AdressServiceImpl implements IAdressService{

	@Autowired
	private IAdressRepository adressRepository;

	@Override
	public List<AdressEntity> findAll() {

		return adressRepository.findAll();
	}

	@Override
	public AdressEntity findById(Long id) {
		
		AdressEntity adress = adressRepository.findById(id).get(); 
		
		if(!adress.equals(null)) {
			
			return adress;
		}
		
		throw new NotFoundException("Adress with id: "+id);
	}
	
	

	@Override
	public AdressEntity add(AdressEntity adress, Long id) {
		
		
		CustomerEntity customer = new CustomerEntity();

		customer.setCustomerId(id);

		adress.setCustomer(customer);

		adressRepository.save(adress);
		
	
		List<AdressEntity> adresses = findAll();
	
		for (AdressEntity a : adresses) {
			
			if(a.getAdressCustomer().equals(adress.getAdressCustomer())){
				
				return adress;
			}
		}
		
		throw new BadRequestException("Adress");
		
	}

	@Override
	public AdressEntity update(AdressEntity adress, Long id) {

		AdressEntity a = findById(id);

		if(!a.equals(null)) {

			adress.setIdAdress(id);
			adress.setCustomer(a.getCustomer());

			return adressRepository.save(adress);
		}

		throw new NotFoundException("Adress with id: "+id);
	}

	@Override
	public AdressEntity delete(Long id) {

		AdressEntity a = findById(id);

		if(!a.equals(null)) {

			adressRepository.deleteById(id);
			return a;
		}
		throw new NotFoundException("Adress with id: "+id);
	}

}
