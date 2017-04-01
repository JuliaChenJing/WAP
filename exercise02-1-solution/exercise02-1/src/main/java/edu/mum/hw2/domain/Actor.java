package edu.mum.hw2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Actor {
	
	// NOTE Some Eclipse versions may show the error: Attribute "" has invalid mapping type in this context
	// It's due to the JPA mapping validation done by the Eclipse precompiler
	// In this case you can ignore the problem because it is supported by the ORM
	
	private String name;
	@Column(name="character_name")
	private String character;
	private int rating;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
