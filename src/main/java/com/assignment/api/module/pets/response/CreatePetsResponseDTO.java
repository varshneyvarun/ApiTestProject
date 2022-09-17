package com.assignment.api.module.pets.response;

import com.assignment.api.module.pets.request.Category;
import com.assignment.api.module.pets.request.Tag;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain=true)
public class CreatePetsResponseDTO {

    public int id;
    public Category category;
    public String name;
    public List<String> photoUrls;
    public List<Tag> tags;
    public String status;

}
