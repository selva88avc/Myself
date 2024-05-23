package com.stackroute.notificationservice.test;

import com.stackroute.notificationservice.model.Notification;
import com.stackroute.notificationservice.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class NotificationServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNotifyProductUpdate() {
        // Arrange
        int productId = 123;
        Notification expectedNotification = new Notification();
        ResponseEntity<Notification> expectedResponseEntity = new ResponseEntity<>(expectedNotification, HttpStatus.OK);

        when(restTemplate.getForEntity(any(String.class), eq(Notification.class), eq(productId)))
                .thenReturn(expectedResponseEntity);

        // Act
        Notification actualNotification = notificationService.notifyProductUpdate(productId);

        // Assert
        assertEquals(expectedNotification, actualNotification);
    }


    @Test
    void testFallback() {
        // Arrange
        int productId = 789;
        Exception exception = new RuntimeException("Something went wrong");

        // Act
        Notification fallbackNotification = notificationService.fallback(productId, exception);

        // Assert
        // Verify that the fallback method returns a Notification object
        assertEquals(Notification.class, fallbackNotification.getClass());
    }
}
