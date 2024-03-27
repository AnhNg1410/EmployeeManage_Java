package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID, posit;
	private Department depart;
	private double baseSal, salary, seniority;
	private String usernameString, passwordString;
	
	public Employee() {
		super();
	}

	public Employee(String name, String phones, Boolean gender, Address address, LocalDate birth, String posit,
			Department depart, double seniority, double baseSal) {
		super(name, phones, gender, address, birth);
		this.posit = posit;
		this.depart = depart;
		this.seniority = seniority;
		this.baseSal = baseSal;
		this.salary = baseSal + depart.getSalaryRate()*(1 + seniority/100.0);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public double getSeniority() {
		return seniority;
	}

	public void setSeniority(double seniority) {
		this.seniority = seniority;
	}

	public double getBaseSal() {
		return baseSal;
	}

	public void setBaseSal(double baseSal) {
		this.baseSal = baseSal;
	}
	
	public double getSalary() {
		return baseSal * depart.getSalaryRate()*(1 + seniority/100.0);
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosit() {
		return posit;
	}

	public void setPosit(String posit) {
		this.posit = posit;
	}

	public String getUsernameString() {
		return usernameString;
	}

	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
			"Employee [ID=" + ID + ", depart=" + depart + ", seniority=" + seniority + ", baseSal=" + baseSal
				+ ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ID, depart, salary, seniority);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(depart, other.depart)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& seniority == other.seniority;
	}
	
	public void assign(Employee empOther) {
		super.assign((Person) empOther);
		this.setDepart(empOther.getDepart());
		this.setPosit(empOther.getPosit());
		this.setSeniority(empOther.getSeniority());
		this.setBaseSal(empOther.getBaseSal());
		this.setUsernameString(empOther.getUsernameString());
		this.setPasswordString(empOther.getPasswordString());
	}
	
	public String getNameGender(Boolean b) {
		if(b) return "Men";
		return "Women";
	}
	
	public static String setFormatDate(String s) {
		return s.replace("-", "/");
	}
}
