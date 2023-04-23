package com.bezkoder.spring.login.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="recipes")
public class Recipe implements Serializable {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;  
	  private String title;
	  private String description;
	  private String ingredients;
	  private int time;
	  
	  @ManyToOne
	  @JoinColumn(name = "id_level")
	  private Level level ;
	  
	  
	  @ManyToOne
	  @JoinColumn(name = "id_category")
	  private Category category ;
	  
}
