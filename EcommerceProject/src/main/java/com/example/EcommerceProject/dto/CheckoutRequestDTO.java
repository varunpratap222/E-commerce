package com.example.EcommerceProject.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckoutRequestDTO {

    private String fullName;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String pincode;

    private String paymentMethod;


}
