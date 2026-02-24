package com.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String medicines;
    private String dosage;
    private LocalDate issuedDate;
    private boolean isActive;
    
    private Prescription prescription;

    public Prescription(){}

    public Prescription(String medicines, String dosage,
                        LocalDate issuedDate, boolean isActive){
        this.medicines = medicines;
        this.dosage = dosage;
        this.issuedDate = issuedDate;
        this.isActive = isActive;
    }
    
    

    public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId(){ return id; }

    public String getMedicines(){ return medicines; }
    public void setMedicines(String medicines){ this.medicines = medicines; }

    public String getDosage(){ return dosage; }
    public void setDosage(String dosage){ this.dosage = dosage; }

    public LocalDate getIssuedDate(){ return issuedDate; }
    public void setIssuedDate(LocalDate issuedDate){ this.issuedDate = issuedDate; }

    public boolean isActive(){ return isActive; }
    public void setActive(boolean active){ isActive = active; }
}