package br.com.kwikemart.entity;

import static br.com.kwikemart.enums.ProductStatus.ENABLED;
import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.kwikemart.enums.ProductStatus;

@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	@Column(nullable = false)
	private String name;

	@Getter @Setter
	@Column(nullable = false)
	private String description;

	@Getter @Setter
	@Column(nullable = false)
	private Double price;
	
	@Getter @Setter
	private String imageFilename;
	
	@Getter @Setter
	@Enumerated(STRING)
	@Column(nullable = false)
	private ProductStatus status = ENABLED;

}