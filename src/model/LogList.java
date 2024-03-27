package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class LogList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Log> logList;
	private String fileString;
	
	public LogList(ArrayList<Log> logList, String fileString) {
		super();
		this.logList = logList;
		this.fileString = fileString;
	}

	public ArrayList<Log> getLogList() {
		return logList;
	}

	public void setLogList(ArrayList<Log> logList) {
		this.logList = logList;
	}

	public String getFileString() {
		return fileString;
	}

	public void setFileString(String fileString) {
		this.fileString = fileString;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileString, logList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogList other = (LogList) obj;
		return Objects.equals(fileString, other.fileString) && Objects.equals(logList, other.logList);
	}

	@Override
	public String toString() {
		return "LogList [logList=" + logList + ", fileString=" + fileString + "]";
	}
	
	
}
