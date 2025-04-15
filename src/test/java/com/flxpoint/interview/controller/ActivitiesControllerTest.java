package com.flxpoint.interview.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.flxpoint.interview.controller.ActivitiesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActivitiesControllerTest {
    @Autowired
    private ActivitiesController activitiesController;

    @Test
    void testGetActivities() {
        var result = activitiesController.activities();
        assertNotNull(result);
    }
}
