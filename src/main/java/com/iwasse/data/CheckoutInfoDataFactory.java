package com.iwasse.data;

import com.iwasse.model.CheckoutData;
import net.datafaker.Faker;

import java.util.Locale;

public class CheckoutInfoDataFactory {

    private static final Faker faker = new Faker(new Locale("en-US"));

    public CheckoutInfoDataFactory() {}

    public static CheckoutData createCheckoutInfo(){
        return CheckoutData.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .zipCode(faker.address().zipCode())
                .build();
    }

}
