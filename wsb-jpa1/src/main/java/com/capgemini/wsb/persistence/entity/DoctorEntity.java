package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, unique = true)
	private Long id;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 50, unique = true)
	private String telephoneNumber;

	@Column(unique = true, length = 100)
	private String email;

	@Column(nullable = false, unique = true, length = 50)
	private String doctorNumber;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	// Relacja jeden-do-wielu z VisitEntity, z usuwaniem osieroconych wizyt i leniwym ładowaniem
	@OneToMany(mappedBy = "doctor", orphanRemoval = true, fetch = FetchType.LAZY)
	private Collection<VisitEntity> visits;

	// Relacja wiele-do-wielu z AddressEntity, z kaskadowaniem operacji zapisu i łączenia oraz leniwym ładowaniem
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(
			name = "DOCTOR_TO_ADDRESS",
			joinColumns = @JoinColumn(name = "DOCTOR_ID"),
			inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
	)
	private Collection<AddressEntity> addresses;

	// Gettery i settery dla pól klasy

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Collection<VisitEntity> getVisits() {
		return visits;
	}

	public void setVisits(Collection<VisitEntity> visits) {
		this.visits = visits;
	}

	public Collection<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<AddressEntity> addresses) {
		this.addresses = addresses;
	}
}
