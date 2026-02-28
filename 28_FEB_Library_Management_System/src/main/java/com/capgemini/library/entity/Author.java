package com.capgemini.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String name;

    @Column(nullable = true)
    private String biography;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("authors")
    private Set<Book> books;

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
    
    
    
    
}


