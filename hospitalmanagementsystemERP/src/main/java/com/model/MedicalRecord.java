package com.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDate recordDate;
	private String diagnosis;
	private String notes;
	
	public MedicalRecord() {}
	
	public MedicalRecord(LocalDate recordDate, String diagnosis, String notes) {
		super();
		this.recordDate = recordDate;
		this.diagnosis = diagnosis;
		this.notes = notes;
	}
	public long getId() {
		return id;
	}
	
	public LocalDate getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", recordDate=" + recordDate + ", diagnosis=" + diagnosis + ", notes="
				+ notes + "]";
	}
	
	
	
	
}
