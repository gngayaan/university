package cloud.university;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	private University university = new University();
	private String fieldOfStudy = "Computer Science";
	/**
	 * @return The names of students who study computer science
	 */
	public Collection<String> listComputerScienceStudentNames() {
		List<String> names = new ArrayList<>();
		for (Student student : university.getStudents()) {
			if (student.getFieldOfStudy().equals(fieldOfStudy)) {
				names.add(student.getName());
			}
		}

		return names;
	}

	/**
	 * @param fieldOfStudy
	 *            An optional filter. If provided then the result contains only
	 *            those students studying that field. Otherwise all graduated
	 *            students will be returned.
	 * @return The set of graduated students matching the filter.
	 */
	 public Collection<Student> listGraduatedStudents(Optional<String> fieldOfStudy) {

		 List<Student> listOfStudents = null;
	 	if (fieldOfStudy.isPresent()){
			listOfStudents =  university.getStudents()
					.stream()
					.filter(u -> u.getFieldOfStudy().equals(fieldOfStudy.get()))
					.collect(Collectors.toList());
		}

		 if (listOfStudents.isEmpty() || !fieldOfStudy.isPresent()){
			 listOfStudents = university.getStudents().stream().filter( u -> u.getHasGraduated() == true).collect(Collectors.toList());
		 }
		 return listOfStudents;
	 }

	/**
	 * @return A Map containing a list of students per each subject that they
	 *         study (i.e. the key is their fieldOfStudy).
	 */
	 public Map<String, List<String>> groupStudentsByFieldOfStudy() {
		 Map<String, List<String>> myMaps = new HashMap<String, List<String>>();
		 
		 for (Student student : university.getStudents()) {
			  if (!myMaps.containsKey(student.getFieldOfStudy())) {
		            myMaps.put(student.getFieldOfStudy(), new ArrayList<String>());
		        }
		        myMaps.get(student.getFieldOfStudy()).add(student.getName());
		 }
		return myMaps;
	 }

}
