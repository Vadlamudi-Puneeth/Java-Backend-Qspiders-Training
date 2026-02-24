package com.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.model.Appointment;
import com.model.Doctor;
import com.model.MedicalRecord;
import com.model.Patient;
import com.service.AppointmentToPrescriptionService;
import com.service.DoctorToAppointmentService;
import com.service.DoctorToPatientService;
import com.service.PatientToMedicalRecordService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainApp {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	private static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		
//		patientsToMedicalRecordMethodsCheck(); //(uni one-To-one)
		
//		departmentToDoctor(); //(Bi One-To-many)
		
//		doctorToAppointment(); // (Uni One-to-Many)
		
//		appointmentToPrescription(); // (Uni One-to-One)
		
		doctorToPatient(); // (Bi many to many)
		
	}
	
	public static void doctorToPatient() {
		 DoctorToPatientService service =
	                new DoctorToPatientService(em);

	        
	        service.createAssignments();

	        service.patientsOfDoctor("Mehta");
	        service.doctorsOfPatient("Ali");

	        service.discharge(1,1);
	}
	
	public static void appointmentToPrescription() {

		EntityManager em = emf.createEntityManager();

		AppointmentToPrescriptionService service =
		        new AppointmentToPrescriptionService(em);

		service.appointmentToPrescription();
	}
	
	
	
	public static void doctorToAppointment() {
		DoctorToAppointmentService das = new DoctorToAppointmentService(em);
		
		Appointment a1 = new Appointment(LocalDateTime.of(LocalDate.now(), LocalTime.NOON), "SCHEDULED", "flu");
		Appointment a2 = new Appointment(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT), "CANCELLED", "ellergy");
		Appointment a3 = new Appointment(LocalDateTime.of(LocalDate.now(), LocalTime.now()), "CANCELLED", "snoring");
		
		Doctor d = new Doctor("puneeth", "heart","56789023");
		d.getAppointments().add(a1);
		d.getAppointments().add(a2);
		d.getAppointments().add(a3);
		
//		das.createDoctorWithAppointment(d);
		das.updateScheduleOfAppointment(1);
		
		
	}
	
	
	public static void patientsToMedicalRecordMethodsCheck() {
		PatientToMedicalRecordService ps = new PatientToMedicalRecordService(em);
		
		Patient p = new Patient("puneeth", LocalDate.of(2005, 03, 26), "B+", "87656789022");
		MedicalRecord mr = new MedicalRecord(LocalDate.now(), "flu", "Rest 3 days");
		
		ps.createMedicalRecord(p, mr);
		ps.getPatientById(2);// here we cannot get the patient from the medical record because it is uni directional
		
		ps.updatePatientMedicalRecords(1, "Follow-up required");
		ps.deletePatient(1);// both the patient and his/her medical records are deleted
		
	}
}
