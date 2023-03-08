package com.example.airlinebackend.Model;

import com.example.airlinebackend.Model.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String id;

    @Field
    private String firstName;

    @Field
    private String lastName;

    @Field
    private String email;

    @Field
    private String password;

    @Field
    private String passportNumber;

    @Field
    private String phoneNumber;

    @Field
    private Role role;
}
