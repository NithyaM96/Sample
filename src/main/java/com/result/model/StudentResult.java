package com.result.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentresult")
public class StudentResult {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int regno;
	private String name;

	private int mark1, mark2, mark3, mark4, mark5, total;
	private double average;
	private String result;

	public StudentResult() {
		super();
		
	}

	public StudentResult(int regno, String name, int mark1, int mark2, int mark3, int mark4, int mark5, int total,
			double average, String result) {
		super();
		this.regno = regno;
		this.name = name;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.mark4 = mark4;
		this.mark5 = mark5;
		this.total = total;
		this.average = average;
		this.result = result;

	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark1() {
		return mark1;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}

	public int getMark3() {
		return mark3;
	}

	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}

	public int getMark4() {
		return mark4;
	}

	public void setMark4(int mark4) {
		this.mark4 = mark4;
	}

	public int getMark5() {
		return mark5;
	}

	public void setMark5(int mark5) {
		this.mark5 = mark5;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
