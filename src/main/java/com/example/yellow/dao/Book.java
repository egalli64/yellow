package com.example.yellow.dao;

import java.util.Objects;

public class Book {
	private int id_book;
	private String title;
	private String author;
	private String genre;

	public Book(int id_book, String title, String author, String genre) {
		this.id_book = id_book;
		this.title = title;
		this.author = author;
		this.genre = genre;
	}
	
	public Book(String title, String author,String genre) {
		this.title = title;
		this.author = author;
		this.genre= genre;	
		}
	
	public Book() {
	}
	

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, genre, id_book, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(genre, other.genre) && id_book == other.id_book
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [id_book=" + id_book + ", title=" + title + ", author=" + author + ", genre=" + genre + "]";
	}
	
	
}
