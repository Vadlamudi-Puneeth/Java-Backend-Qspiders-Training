package com.capgemini.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;

    @Column(unique = true)
    private String isbn;

    private int publishYear;

    private int copiesTotal;

    private int copiesAvailable;

    private String status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @JsonIgnoreProperties("books")
    private Set<Author> authors;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("books")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id")
    @JsonIgnoreProperties("books")
    private LibraryBranch branch;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("book")
    private List<Loan> loans;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public int getCopiesTotal() {
		return copiesTotal;
	}

	public void setCopiesTotal(int copiesTotal) {
		this.copiesTotal = copiesTotal;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LibraryBranch getBranch() {
		return branch;
	}

	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
    
    
    
}


