package peaksoft.spting_boot_res_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.spting_boot_res_api.dto.StudentRequest;
import peaksoft.spting_boot_res_api.dto.StudentResponse;
import peaksoft.spting_boot_res_api.dto.StudentResponseView;
import peaksoft.spting_boot_res_api.service.StudentService;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
@PreAuthorize("hasAuthority('SUPER_ADMIN')")
@Tag(name = "Student API", description ="User with role admin can add,update, delete or get all students")
public class StudentController {

    private final StudentService service;

    @PostMapping
    @Operation(summary = "create student", description = "we can create student")
    public StudentResponse create(@RequestBody StudentRequest request) {
        return service.create(request);
    }

    @PutMapping("{id}")
    @Operation(summary = "update student", description = "we can update student by id")
    public StudentResponse update(@PathVariable long id, @RequestBody StudentRequest request) {
        return service.update(id, request);
    }

    @GetMapping("{id}")
    @Operation(summary = "find student", description = "we can find student by id")
    public StudentResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "delete student", description = "we can delete student by id")
    public StudentResponse delete(@PathVariable long id) {
        return service.deleteById(id);
    }

//    @GetMapping
//    public List<StudentResponse> getAllStudents() {
//        return service.getAllStudents();
//    }

    @GetMapping
    @Operation(summary = "Get allStudentsAndSearch", description = "We can get all students and search")
    public StudentResponseView getAllStudents(@RequestParam(name = "text", required = false) String text,
                                              @RequestParam int page,
                                              @RequestParam int size) {
        return service.getAllStudentsPagination(text, page, size);
    }

}
