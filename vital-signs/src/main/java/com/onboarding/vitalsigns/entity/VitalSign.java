package com.onboarding.vitalsigns.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class VitalSign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	@Column(name = "heart_rate")
	private Float heartRate;

	@Column(name = "temperature")
	private Float temperature;

	@Column(name = "blood_pressure")
	private Float bloodPressure;

}
