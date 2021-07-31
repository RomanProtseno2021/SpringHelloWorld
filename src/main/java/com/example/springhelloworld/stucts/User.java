package com.example.springhelloworld.stucts;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

}
