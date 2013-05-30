package br.com.kwikemart.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private String name;

	@Getter @Setter
	private String description;

	@Getter @Setter
	private Double price;
	
	@Getter @Setter
	private String imageFilename;

}