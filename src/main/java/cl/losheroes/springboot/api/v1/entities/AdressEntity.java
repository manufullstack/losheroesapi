package cl.losheroes.springboot.api.v1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adresses")
public class AdressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adress_id")
	private Long idAdress;

	@Column(name = "adress_customer")
	private String adressCustomer;


	@ManyToOne(optional = false)
	@JoinColumn(name="customer_id")
	@JsonIgnore
	private CustomerEntity customer;

	public Long getIdAdress() {
		return idAdress;
	}

	public void setIdAdress(Long idAdress) {
		this.idAdress = idAdress;
	}

	public String getAdressCustomer() {
		return adressCustomer;
	}

	public void setAdressCustomer(String adressCustomer) {
		this.adressCustomer = adressCustomer;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
}
