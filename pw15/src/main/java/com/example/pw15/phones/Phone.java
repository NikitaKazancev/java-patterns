package com.example.pw15.phones;

import com.example.pw15.manufactures.Manufacture;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "phones")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private List<Manufacture> manufactures;

	private String name;

	@Column(name = "creation_year")
	private int creationYear;

	public Phone() {}

	public String getName() {
		return name;
	}

	public int getCreationYear() {
		return creationYear;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreationYear(int creationYear) {
		this.creationYear = creationYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
