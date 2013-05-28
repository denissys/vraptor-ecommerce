package br.com.kwikemart.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@MappedSuperclass
public abstract class AbstractEntity implements java.io.Serializable {

	private static final long serialVersionUID = -262897143810647953L;

	@Id
	@GeneratedValue
	protected Long id;

	@Column(name = "insert_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = true)
	protected Timestamp insertDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AbstractEntity() {
		this.id = null;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public String toString() {
		String returnString = "\nObject " + this.getClass().getSimpleName()
				+ " -> [" + ReflectionToStringBuilder.toString(this) + "]";
		return returnString;
	}

	public boolean isPersisted() {
		return this.id != null;
	}

}
