package peaksoft.spting_boot_res_api.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int age;
    @CreatedDate
    private LocalDate created;
    private boolean isActive;
}
