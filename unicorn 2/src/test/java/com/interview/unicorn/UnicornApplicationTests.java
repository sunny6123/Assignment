package com.interview.unicorn;

import com.interview.unicorn.controller.UnicornController;
import com.interview.unicorn.exception.UnicornNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UnicornApplicationTests {

    private UnicornController unicornController;

    @Autowired
    public UnicornApplicationTests(UnicornController unicornController) {
        this.unicornController = unicornController;
    }

    @Test
    public void givenNoUnicornsShouldReturnErrorResponse() {
        String errorMessage = "";
        try {
            unicornController.getAllUnicornDetails().getStatusCode();
        } catch (UnicornNotFoundException ex) {
            errorMessage = ex.getMessage();
        }
        assertThat(errorMessage).isEqualTo("No unicorns are found");
    }

    @Test
    public void givenInvalidUnicornsShouldReturnErrorResponse() {
        String errorMessage = "";
        try {
            unicornController.getUnicornDetailsById(1000);
        } catch (UnicornNotFoundException ex) {
            errorMessage = ex.getMessage();
        }
        assertThat(errorMessage).isEqualTo("No matching unicorn found with id 1000");
    }

    @Test
    public void saveInvalidUnicornsShouldReturnErrorResponse() {
        String errorMessage = "";
        try {
            unicornController.storeDetails(null);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }
        assertThat(errorMessage).isEqualTo("Invalid unicorn details");
    }

    @Test
    public void updateInvalidUnicornsShouldReturnErrorResponse() {
        String errorMessage = "";
        try {
            unicornController.updateDetails(100,null);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }
        assertThat(errorMessage).isEqualTo("No matching unicorn found with id 100");
    }
}