package com.assignment.api.module.users.request;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class CreateUsersRequestDTO {


    public int id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public int userStatus;


}
