package com.service;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.model.Appointment;
import com.model.Prescription;

public class AppointmentToPrescriptionService {

    private EntityManager em;

    public AppointmentToPrescriptionService(EntityManager em) {
        this.em = em;
    }

    public void appointmentToPrescription() {

        em.getTransaction().begin();

        Prescription p = new Prescription(
                "Paracetamol",
                "1 tablet twice daily",
                LocalDate.now(),
                true
        );

        Appointment a1 = new Appointment(
                LocalDateTime.now(),
                "SCHEDULED",
                "Fever"
        );

        a1.setPrescription(p);

        em.persist(a1);   // cascade saves prescription


        Appointment a2 = new Appointment(
                LocalDateTime.now().plusHours(1),
                "COMPLETED",
                "General Checkup"
        );

        a2.setPrescription(null);

        em.persist(a2);

        em.getTransaction().commit();


        System.out.println("\n----- Reading appointments -----");

        Appointment r1 = em.find(Appointment.class, a1.getId());
        Appointment r2 = em.find(Appointment.class, a2.getId());

        printAppointment(r1);
        printAppointment(r2);
    }


    private void printAppointment(Appointment appt) {

        System.out.println("Appointment ID: " + appt.getId());

        if (appt.getPrescription() != null) {
            System.out.println("Medicines: " +
                    appt.getPrescription().getMedicines());
        } else {
            System.out.println("No prescription");
        }
    }
}