package com.example.rentcar.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@Service
public class FilterDto {

    @NotBlank(message = "pole nie może być puste")
  List<String> carTypes;
    List<String> brands;
}

