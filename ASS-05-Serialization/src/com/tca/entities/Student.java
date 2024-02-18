package com.tca.entities;

import java.io.Serializable;
/*
* The serialization runtime associates with each serializable class a version
* number, called a serialVersionUID, which is used during deserialization to
* verify that the sender and receiver of a serialized object have loaded
* classes for that object that are compatible with respect to serialization.
* If the receiver has loaded a class for the object that has a different
* serialVersionUID than that of the corresponding sender's class, then
* deserialization will result in an {@link InvalidClassException}.
* A serializable class can declare its own serialVersionUID explicitly by
* declaring a field named {@code "serialVersionUID"} that must be static,
* final, and of type {@code long}:
* 
* If a serializable class does not explicitly declare a serialVersionUID, then
* the serialization runtime will calculate a default serialVersionUID value
* for that class based on various aspects of the class.
*/

public class Student implements Serializable	
{
	private static final long serialVersionUID = 1L;
	private int rno;
	private String name;
	private double per;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	

}
