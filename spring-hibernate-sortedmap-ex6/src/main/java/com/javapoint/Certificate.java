package com.javapoint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="certificatetypes")
public class Certificate implements Comparable<String> {

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

	
	@Override
	public int compareTo( String o2) {

		final int beforeInt = -1;
		final int afterInt = 1;
		final  boolean beforeBoolean = false;
		final  boolean afterBoolean = true;
		
		if (o2==null)
			return beforeInt;
		else if (this == null)
			return afterInt;
		else 
	         return this.compareTo(o2);
		
	}
	
	public String toString() {
		return("\n certificate id:" + id + " certificate name:" + certificateName );
	}
}
