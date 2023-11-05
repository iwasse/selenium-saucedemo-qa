package com.iwasse.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CheckoutData {

    private String firstName;
    private String lastName;
    private String zipCode;

}
