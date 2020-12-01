package com.example.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String name;
}
