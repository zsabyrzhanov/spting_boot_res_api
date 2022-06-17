package peaksoft.spting_boot_res_api.mapper;

import org.springframework.stereotype.Component;
import peaksoft.spting_boot_res_api.dto.StudentResponse;
import peaksoft.spting_boot_res_api.entity.Student;

import java.util.*;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setEmail(student.getEmail());
        response.setName(student.getName());
        response.setSurname(student.getSurname());
        response.setAge(student.getAge());
        response.setActive(student.isActive());
        response.setCreated(student.getCreated());
        return response;
    }

    public List<StudentResponse> view(List<Student> students){
        List<StudentResponse> responses = new ArrayList<>();
        for (Student student : students){
            responses.add(viewStudent(student));
        }
        return responses;
    }
}
