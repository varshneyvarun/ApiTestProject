package com.assignment.api.module.pets.response;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Tag {

    public int id;
    public String name;

}
