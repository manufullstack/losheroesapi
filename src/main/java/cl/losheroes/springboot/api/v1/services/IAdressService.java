package cl.losheroes.springboot.api.v1.services;

import java.util.List;

import cl.losheroes.springboot.api.v1.entities.AdressEntity;

public interface IAdressService {


	public List<AdressEntity> findAll();

	public AdressEntity findById(Long id);

	public AdressEntity add(AdressEntity adress);

	public AdressEntity update(AdressEntity adress, Long id);

	public AdressEntity delete(Long id);

}
