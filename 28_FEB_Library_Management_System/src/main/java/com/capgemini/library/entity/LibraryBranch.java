package com.capgemini.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "library_branches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String name;

    private String location;

    private String contactNumber;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("branch")
    private List<Book> books;

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    
    
}

