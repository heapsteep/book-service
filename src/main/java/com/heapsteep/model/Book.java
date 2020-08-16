package com.heapsteep.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter @Getter
@Entity
@Table(name = "book_details")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookTitle;
    private String bookPublisher;
    private String bookIsbn;
    private String bookNumberOfPages;
    private String bookYear;
}