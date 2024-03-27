package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name, phones;
	private Boolean gender;
	private Address address;
	private LocalDate birth;
	
	public Person() {
	}

	public Person(String name, String phones, Boolean gender, Address address, LocalDate birth) {
		this.name = name;
		this.phones = phones;
		this.gender = gender;
		this.address = address;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
//	public String getBirthString() {
//		return getBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy");
//	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", phones=" + phones + ", gender=" + gender + ", address=" + address + ", birth=" + birth + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birth, gender, name, phones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(birth, other.birth)&& Objects.equals(gender, other.gender) 
				&& Objects.equals(name, other.name) && Objects.equals(phones, other.phones);
	}
	
	public void assign(Person empOther) {
		this.setName(empOther.getName());
		this.setBirth(empOther.getBirth());
		this.setAddress(empOther.getAddress());
		this.setGender(this.getGender());
		this.setPhones(empOther.getPhones());
	}
	
}
