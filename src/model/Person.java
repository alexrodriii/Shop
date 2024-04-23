package model;

public class Person {
	protected String name;
	protected int age;
	public Person(String name,int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge () {
		return age;
	}
	public void setAge (int Age) {
		this.age = age;
	}
}  
