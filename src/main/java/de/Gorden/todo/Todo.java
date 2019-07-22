package de.Gorden.todo;

import java.util.Date;

public class Todo {
	private int id;
	private String user;
	private String desc;
	private Date tagetDate;
	private boolean isDone;

	public Todo(int id, String user, String desc, Date tagetDate, boolean isDone) {
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.tagetDate = tagetDate;
		this.isDone = isDone;
	}
	
	@Override
	public String toString() {
		return String.format("ToString - Todo [id=%s, user=%s, desc=%s, tagetDate=%s, isDone=%s]", id, user, desc, tagetDate,
				isDone);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTagetDate() {
		return tagetDate;
	}
	public void setTagetDate(Date tagetDate) {
		this.tagetDate = tagetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
