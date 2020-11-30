package com.example.producer;

import com.example.producer.domain.Employee;
import com.example.producer.producer.EmployeeProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
@RequiredArgsConstructor
public class Application implements CommandLineRunner {
    @Autowired
    private HelloRabbitProducer producer;

    private final EmployeeProducer employeeProducer;
    private final Employee employee;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // producer.SendHello("hi Milad");
        for (long i = 0; i < 50000; i++) {
            employee.setId((i)).setName("employee_"+i);
            employeeProducer.sendMessage(employee);
        }
    }
}
