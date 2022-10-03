package cl.losheroes.springboot.api.v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.losheroes.springboot.api.v1.entities.AdressEntity;
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

		return adressRepository.findById(id).get();
	}

	@Override
	public AdressEntity add(AdressEntity adress) {
		return adressRepository.save(adress);

	}

	@Override
	public AdressEntity update(AdressEntity adress, Long id) {

		AdressEntity a = findById(id);

		if(!a.equals(null)) {

			adress.setIdAdress(id);
			adress.setCustomer(a.getCustomer());

			return adressRepository.save(adress);
		}

		return null;
	}

	@Override
	public AdressEntity delete(Long id) {

		AdressEntity a = findById(id);

		if(!a.equals(null)) {

			adressRepository.deleteById(id);
			return a;
		}
		return null;

	}

}
