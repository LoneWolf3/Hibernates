package com.sac.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "boolean_usertype")
@TypeDefs({ @TypeDef(name = JeeNeeUserType.NAME, typeClass = JeeNeeUserType.class) })
public class BooleanUserType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "TRUE_INDICATOR", length = 4)
	@Type(type = JeeNeeUserType.NAME)
	private Boolean trueIndicator;
	
	@Column(name = "FALSE_INDICATOR", length = 4)
	@Type(type = JeeNeeUserType.NAME)
	private Boolean falseIndicator;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long Id;
	
	
	public Boolean getTrueIndicator() {
		return trueIndicator;
	}

	public void setTrueIndicator(Boolean trueIndicator) {
		this.trueIndicator = trueIndicator;
	}

	public Boolean getFalseIndicator() {
		return falseIndicator;
	}

	public void setFalseIndicator(Boolean falseIndicator) {
		this.falseIndicator = falseIndicator;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}