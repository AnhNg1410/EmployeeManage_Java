package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String depart, departCode;
	private int ID;
	private double salaryRate;
	
	public Department() {
	}

	public Department(String depart, String departCode, int id, double salaryRate) {
		this.depart = depart;
		this.departCode = departCode;
		this.ID = id;
		this.salaryRate = salaryRate;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDepartCode() {
		return departCode;
	}

	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}

	public double getSalaryRate() {
		return salaryRate;
	}

	public void setSalaryRate(double salaryRate) {
		this.salaryRate = salaryRate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Department [depart=" + depart + ", posit=" + departCode + ", salaryRate=" + salaryRate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(depart, departCode, salaryRate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(depart, other.depart) && Objects.equals(departCode, other.departCode)
				&& Double.doubleToLongBits(salaryRate) == Double.doubleToLongBits(other.salaryRate);
	}
	
	public static ArrayList<Department> getDepartmentsList() {
		ArrayList<Department> departList = new ArrayList<Department>();
		
		Department pers = new Department("Personnel", "PERS", 1, 1.5); departList.add(pers);
		Department mark = new Department("Marketing", "MARK", 2, 1.6); departList.add(mark);
		Department acon = new Department("Accounting", "ACON", 3, 1.6); departList.add(acon);
		Department busi = new Department("Business", "BUSI", 4, 1.6); departList.add(busi);
		Department serv = new Department("Service", "SERV", 5, 1.3); departList.add(serv);
		Department tech = new Department("Tech", "TECH", 6, 1.7); departList.add(tech);
		return departList;
	}
	
	public static Department getDepartbyID(int id) {
		return getDepartmentsList().get(id);
	}
	
	public static Department getDepartbyName(String departName) {
		ArrayList<Department> departList = Department.getDepartmentsList();
		for (Department department : departList) {
			if(department.getDepart().equals(departName)) {
				return department;
			}
		}
		return null;
	}
}
