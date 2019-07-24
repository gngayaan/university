package cloud.university;

import java.util.Collections;
import java.util.*;

public class Main {

	public static void main(String[] args){
		
		Test test = new Test();
		
		List<String> list = Arrays.asList("Computer Science","Physics");
		System.out.println(test.listComputerScienceStudentNames());
		test.listGraduatedStudents(list.stream().findFirst()).stream().forEach(s -> System.out.println(s.getName()));
		System.out.println(test.groupStudentsByFieldOfStudy());

	}
	
}
