package com.prac.prac.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student beka = new Student(
                    "Beka",
                    LocalDate.of(2001, Month.NOVEMBER, 25),
                    "bekadessalegn@gmail.com"
            );
            Student buzz = new Student(
                    "BuZz",
                    LocalDate.of(2000, Month.DECEMBER, 5),
                    "buzzbkm@gmail.com"
            );
            studentRepository.saveAll(
                    List.of(beka, buzz)
            );
        };
    }
}
