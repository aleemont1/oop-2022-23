package it.unibo.apice.oop.p04objects;

import java.util.Calendar;

class Person { // dichiarazione classe
	static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	String name;
	int birth;
	boolean married;

	Person(String name) {
		this.name = name;
		this.birth = Person.currentYear;
		this.married = false;
	}

	Person(String name, int birth) {
		this.name = name;
		this.birth = birth;
		this.married = false;
	}

	Person(String name, int birth, boolean married) {
		this.name = name;
		this.birth = birth;
		this.married = married;
	}
}