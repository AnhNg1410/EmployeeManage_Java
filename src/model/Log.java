package model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Log implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate dayLogDate;
	private LocalTime timeLogTime;
	private String contextString;
	private String employee;
	
	public Log() {
		
	}
	
	public Log(LocalDate dayLogDate, LocalTime timeLogTime, String contextString, String employee) {
		this.dayLogDate = dayLogDate;
		this.setTimeLogTime(timeLogTime);
		this.contextString = contextString;
		this.employee = employee;
	}

	public LocalDate getDayLogDate() {
		return dayLogDate;
	}

	public void setDayLogDate(LocalDate dayLogDate) {
		this.dayLogDate = dayLogDate;
	}

	public LocalTime getTimeLogTime() {
		return timeLogTime;
	}

	public void setTimeLogTime(LocalTime timeLogTime) {
		this.timeLogTime = timeLogTime;
	}

	public String getContextString() {
		return contextString;
	}

	public void setContextString(String contextString) {
		this.contextString = contextString;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contextString, dayLogDate, employee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		return Objects.equals(contextString, other.contextString) && Objects.equals(dayLogDate, other.dayLogDate)
				&& Objects.equals(employee, other.employee);
	}

	@Override
	public String toString() {
		return "Log [dayLogDate=" + dayLogDate + ", contextString=" + contextString + ", employee=" + employee + "]";
	}
	
	public String writeLog(String userString, String actionString) {
		String logString = "[" + LocalDate.now().toString() + "] [" + LocalTime.now().toString() + "]"
				+ "==" + userString + " : " + actionString;
		return logString;
	}
	
	public static void write(String userString, String actionString, String file) {
		Log log = new Log(LocalDate.now(), LocalTime.now(), userString, actionString);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(log);
			oos.flush(); oos.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
	
}
