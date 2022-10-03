package cl.losheroes.springboot.api.v1.services;

import java.util.List;

import cl.losheroes.springboot.api.v1.entities.PhoneEntity;

public interface IPhoneService {

	public List<PhoneEntity> findAll();

	public PhoneEntity findById(Long id);

	public PhoneEntity add(PhoneEntity phone, Long id);

	public PhoneEntity update(PhoneEntity phone, Long id);

	public PhoneEntity delete(Long id);


}
