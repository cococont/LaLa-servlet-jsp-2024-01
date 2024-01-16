package model;

import java.io.Serializable;

public class Dept implements Serializable {
	private String id;
	private String name;
	
	public Dept() {}

	public Dept(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + "]";
	}
	
}