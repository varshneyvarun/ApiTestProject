package com.assignment.api.module.users.response;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class CreateUsersResponseDTO {

    public int code;
    public String type;
    public String message;

}
