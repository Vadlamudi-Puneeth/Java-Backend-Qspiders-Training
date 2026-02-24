package com.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime appointDate;
	private String status;
	private String reason;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "prescription_id")
	private Prescription prescription;

	public Appointment(LocalDateTime appointDate, String status, String reason) {
		super();
		this.appointDate = appointDate;
		this.status = status;
		this.reason = reason;
	}

	public Appointment() {}


	public long getId() {
		return id;
	}


	public LocalDateTime getAppointDate() {
		return appointDate;
	}


	public void setAppointDate(LocalDateTime appointDate) {
		this.appointDate = appointDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Prescription getPrescription() {
		return prescription;
	}


	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointDate=" + appointDate + ", status=" + status + ", reason=" + reason
				+  ", prescription=" + prescription + "]";
	}
	
}
