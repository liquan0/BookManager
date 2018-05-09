package com.bwie.entity;

import java.sql.Date;

public class Student {
	
	/* id`       varchar(36)  
	 name`      varchar(20)  
	 password` varchar(30)   
	 sex`         varchar(20)
	 brithday` date DEFAULT  
	 hobby`     varchar(200) 
	 stype`     varchar(60)  
*/
	
      private     String   id;
      private     String   name;
      private   String    password;
      private     String  sex;
      private    Date    brithday;
      private   String  hobby;
    
	
      
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	private    String   stype;



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password="
				+ password + ", sex=" + sex + ", brithday=" + brithday
				+ ", hobby=" + hobby + ", stype=" + stype + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
