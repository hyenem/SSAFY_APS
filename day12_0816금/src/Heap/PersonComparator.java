package Heap;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o2.age - o1.age;
	}
	
}
