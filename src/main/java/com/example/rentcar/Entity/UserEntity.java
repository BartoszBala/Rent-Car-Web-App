package com.example.rentcar.Entity;


import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String street;
    private String city;
    private String postCode;
    private int actived;
    private String roles = "";
    private String permissions="";

    public UserEntity(String login, String password, String roles, String permissions) {
        PasswordEncoder passwordEncoder;
        this.login = login;
        this.password = password;
        this.actived = 1;
        this.roles = roles;
        this.permissions = permissions;
    }

    public List<String> getRoleList() {

        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){

        if(this.permissions.length()>0){

            return Arrays.asList(this.permissions.split(","));
        }

        return new ArrayList<>();

    }
}
