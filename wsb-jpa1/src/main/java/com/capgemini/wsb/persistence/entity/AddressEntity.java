package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, unique = true)
	private Long id;

	@Column(nullable = false, length = 150)
	private String city;

	@Column(nullable = false)
	private String addressLine1;

	@Column
	private String addressLine2;

	@Column(nullable = false, length = 10)
	private String postalCode;

	// Relacja wiele-do-wielu z PatientEntity, z kaskadowaniem operacji zapisu i łączenia oraz leniwym ładowaniem
	@ManyToMany(mappedBy = "addresses", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Collection<PatientEntity> patients;

	// Relacja wiele-do-wielu z DoctorEntity, z kaskadowaniem operacji zapisu i łączenia oraz leniwym ładowaniem
	@ManyToMany(mappedBy = "addresses", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Collection<DoctorEntity> doctors;

	// Gettery i settery dla pól klasy

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Collection<PatientEntity> getPatients() {
		return patients;
	}

	public void setPatients(Collection<PatientEntity> patients) {
		this.patients = patients;
	}

	public Collection<DoctorEntity> getDoctors() {
		return doctors;
	}

	public void setDoctors(Collection<DoctorEntity> doctors) {
		this.doctors = doctors;
	}
}
