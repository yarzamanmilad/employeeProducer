package com.example.producer;

import com.example.producer.domain.Employee;
import com.example.producer.domain.User;
import com.example.producer.producer.EmployeeProducer;
import com.example.producer.producer.UserProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling
@RequiredArgsConstructor
public class Application  implements CommandLineRunner {
    @Autowired
    private HelloRabbitProducer producer;

    private final EmployeeProducer employeeProducer;
    private final Employee employee;
    private final UserProducer userProducer;
    private final User user;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // producer.SendHello("hi Milad");
        user.setId(1l).setName("milad");
        userProducer.sendMsg(user);


        user.setId(2l).setName("hosain");
        userProducer.sendMsg(user);
        //userProducer.sendMsg(user);
        for (long i = 0; i < 5000; i++) {
            employee.setId((i)).setName("employee_"+i);
           employeeProducer.sendMessage(employee);
        }
    }
}
