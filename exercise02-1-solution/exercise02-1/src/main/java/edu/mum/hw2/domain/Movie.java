package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String category;
	@Lob
	private byte[] cover;
	private String comment;
	private int rating;
	@ElementCollection
	Collection<Actor> actors = new ArrayList<Actor>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Collection<Actor> getActors() {
		return actors;
	}
	public void setActors(Collection<Actor> actors) {
		this.actors = actors;
	}	
	
}
