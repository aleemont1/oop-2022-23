package it.unibo.apice.oop.p04objects;

import java.util.Calendar;

class Person2 { // dichiarazione classe
	static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	String name;
	int birth;
	boolean married;
	
	Person2(String name, int birth, boolean married) {
		this.name = name;
		this.birth = birth;
		this.married = married;
	}

	Person2(String name, int birth) { // richiama costruttore a 3 arg..
		this(name,birth,false);
	}
	
	Person2(String name) {
		this(name,Person2.currentYear); // richiama costruttore a 2 arg..
	}
}