package com.ZeroCool.RestDataJPASpringBoot.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private Integer pages;
	@Column
	private Double price;
	@Column(name="release_date")
	private LocalDate releaseDate;
	@Column
	private Boolean online;
	

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public int getPages() {
		// TODO Auto-generated method stub
		return pages;
	}

	public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate,
			Boolean online) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
		this.releaseDate = releaseDate;
		this.online = online;
	}

}
