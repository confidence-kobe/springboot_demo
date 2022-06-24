package com.kobedu.boot.demo01.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "person")
@Component
@ToString
@Getter
@Setter
@Data
public class Person {

    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<Pet>> allPets;
    public Person(String userName,Integer age){
        this.age = age;
        this.userName = userName;
    }
}