package com.bezkoder.spring.login.models;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Getter
	@Setter
	@NoArgsConstructor
	@Entity
	@Table(name="levels")
	public class Level {
		  @Id
		  @GeneratedValue(strategy = GenerationType.IDENTITY)
		  private Integer id;  
		  private String title;
	}
