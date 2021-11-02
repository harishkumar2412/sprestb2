package dxc.b2.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class will query the database and get the students required
 * @author Admin
 *
 */

@Service
public class StudentService {
	
	List<Student> students = new ArrayList<>();
	
	@Autowired
	StudentRepository sRepository;
	

	public void createStudents() {

		students.add(new Student(1, "aaa", 1, 11));
		students.add(new Student(2, "bbb", 2, 22));
		students.add(new Student(3, "ccc",3, 33));
		students.add(new Student(4, "ddd", 4, 44));
	}
	
	
	public List<Student> getStudents(){
		//createStudents();
		return sRepository.findAll();
	}
	
	
	public Student findStudent(int id) {
		
		Student student=  students.stream()   //convert the students list to a stream
				.filter(s -> s.getId() == id )
				.findFirst()
				.get();
		
		return student;
	}


	public void addStudent(Student student) {
		//students.add(student);
		sRepository.save(student);
		System.out.println("added a student "+ student.getName());

	}

}
