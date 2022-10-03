package cl.losheroes.springboot.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.losheroes.springboot.api.v1.entities.PhoneEntity;

public interface IPhoneRepository extends JpaRepository<PhoneEntity, Long> {

}
