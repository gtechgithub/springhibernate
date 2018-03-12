package com.javapoint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="certificateidx")
public class Certificate {

	@Id
	private int id;
	
	@Column(name="certificate_name")
	private String certificateName;
	
	
	Certificate(){
		
	}
	
	Certificate(String certificateName){
		this.certificateName = certificateName;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCertificateName() {
		return certificateName;
	}


	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}


	public String toString() {
		return("\n certificate id:" + id + " certificate name:" + certificateName );
	}
}
