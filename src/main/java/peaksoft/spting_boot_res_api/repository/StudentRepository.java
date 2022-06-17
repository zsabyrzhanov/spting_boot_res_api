package peaksoft.spting_boot_res_api.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.spting_boot_res_api.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("select s from Student s where upper(s.name) like concat('%',:text,'%') " +
            "or upper(s.surname) like concat('%',:text,'%') or upper(s.email) like concat('%',:text,'%')")
    List<Student> searchAndPagination(@Param("text") String text, Pageable pageable);
}
