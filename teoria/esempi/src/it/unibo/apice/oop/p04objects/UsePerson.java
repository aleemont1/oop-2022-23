package it.unibo.apice.oop.p04objects;

class UsePerson {
	public static void main(String[] s) {
		// Persona p1=new Person(); NO!!
		Person p2 = new Person("Mario Rossi");
		Person p3 = new Person("Gino Bianchi", 1979);
		Person p4 = new Person("Carlo Verdi", 1971, true);
		System.out.println(p4.name+p2.name+p3.name);
	}
}