package com.moonhotels.MoonhotelsHUB.domain.model;

import org.junit.jupiter.api.Test;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

class HubSearchRequestTest {

    private final Validator validator;

    public HubSearchRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testValidRequest() {
        LocalDate checkIn = LocalDate.of(2018, 10, 20);
        LocalDate checkOut = LocalDate.of(2018, 10, 25);
        HubSearchRequest validRequest = new HubSearchRequest(1, checkIn, checkOut, 2, 1, "USD");
        var violations = validator.validate(validRequest);
        assertTrue(violations.isEmpty(), "Valid request should have no violations.");
    }

    @Test
    void testInvalidRequest() {
    	LocalDate checkIn = LocalDate.of(2018, 10, 20);
        LocalDate checkOut = LocalDate.of(2018, 10, 25);
        HubSearchRequest invalidRequest = new HubSearchRequest(1, checkIn, checkOut, 0, 1, "EUR");
        var violations = validator.validate(invalidRequest);
        assertFalse(violations.isEmpty(), "At least one guest is required");
    }
}
