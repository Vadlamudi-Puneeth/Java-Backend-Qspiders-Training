package com.example.eventannouncement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class EventResponseDTO {
	
	private String title;
	private String description;
	private String eventType;
	private String location;
	private LocalDate eventDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String organizerName;
	private String contactPhone;
	private String status;
	
	
	
}
