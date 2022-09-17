package com.assignment.api.module.pets.request;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class CreatePetsRequestDTO {

    public int id;
    public Category category;
    public String name;
    public List<String> photoUrls;
    public List<Tag> tags;
    public String status;

}
