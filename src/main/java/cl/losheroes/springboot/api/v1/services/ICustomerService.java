package cl.losheroes.springboot.api.v1.services;

import java.util.List;

import cl.losheroes.springboot.api.v1.entities.CustomerEntity;

public interface ICustomerService {

	public List<CustomerEntity> findAll();

	public CustomerEntity findById(Long id);

	public CustomerEntity add(CustomerEntity customer);

	public CustomerEntity update(CustomerEntity customer, Long id);

	public CustomerEntity delete(Long id);
}
