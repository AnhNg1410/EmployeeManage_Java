package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class EmployModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Employee> employList;
	private String fileName;
	private int numID = 0;
	
	public EmployModel() {
		this.employList = new ArrayList<Employee>();
	}

	public EmployModel(ArrayList<Employee> employList, String fileName) {
		this.employList = employList;
		this.fileName = fileName;
	}

	public ArrayList<Employee> getEmployList() {
		return employList;
	}

	public void setEmployList(ArrayList<Employee> employList) {
		this.employList = employList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getNumID() {
		return numID;
	}

	public void setNumID(int numID) {
		this.numID = numID;
	}

	@Override
	public String toString() {
		return "EmployModel [employList=" + employList + ", fileName=" + fileName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employList, fileName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployModel other = (EmployModel) obj;
		return Objects.equals(employList, other.employList) && Objects.equals(fileName, other.fileName);
	}
	
	public boolean ExistCheck(Employee employee) {
		return employList.contains(employee);
	}
	
	public Employee IDCheck(String id) {
		for(Employee emp : employList) {
			if(emp.getID().equals(id)) {
				return emp;
			}
		}
		return null;
	}
	
	public void InsertEmp(Employee employee) {
		employee.setID(employee.getDepart().getDepartCode() + numID);
		numID ++;
		this.employList.add(employee);
	}
	
	public void RemoveEmp(Employee employee) {
		for(Employee emp : employList) {
			if(emp.getID().equals(employee.getID())){
				this.employList.remove(emp);
				return;
			}
		}
	}
	
	public void ClearList() {
		this.employList.clear();
	}
	
	public void UpdateEmp(Employee employee,  Employee emp) {
		emp.setID(employee.getID());
		this.RemoveEmp(employee);
		this.employList.add(emp);
	}
	
	public Employee getEmpByID(String id) {
		return IDCheck(id);
	}
}
