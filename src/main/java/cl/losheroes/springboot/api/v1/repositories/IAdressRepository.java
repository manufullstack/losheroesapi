package cl.losheroes.springboot.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.losheroes.springboot.api.v1.entities.AdressEntity;

public interface IAdressRepository extends JpaRepository<AdressEntity, Long>{

}
