package org.codejudge.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="T_DRVR")
@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DRVR_ID",updatable=false,nullable=false)
	private Long id;
	
	@Column(name="NM",nullable=false)
	private String name;
	
	@Column(name="MBL",unique=true,nullable=false)
	private String mobile;
	
	@Column(name="EML",unique=true,nullable=false)
	private String email;
	
	@Column(name="LIC_NO",unique=true,nullable=false)
	private String licenseNo;
	
	@Column(name="CAR_NO",unique=true,nullable=false)
	private String carNo;
	
	@Column(name="LAT")
	private double laitude;
	
	@Column(name="LONG")
	private double longitude;
}
