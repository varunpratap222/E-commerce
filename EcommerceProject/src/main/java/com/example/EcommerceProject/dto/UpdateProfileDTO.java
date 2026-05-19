package com.example.EcommerceProject.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileDTO {

    private String name;

    private String phone;

    private String address;
}