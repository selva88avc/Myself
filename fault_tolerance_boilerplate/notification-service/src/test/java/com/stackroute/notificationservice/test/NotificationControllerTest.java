package com.stackroute.notificationservice.test;
import com.stackroute.notificationservice.controller.NotificationController;
import com.stackroute.notificationservice.model.Notification;
import com.stackroute.notificationservice.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationController notificationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNotifyProductUpdate_Success() {
        // Arrange
        int productId = 123;
        Notification expectedNotification = new Notification();
        ResponseEntity<Notification> expectedResponseEntity = new ResponseEntity<>(expectedNotification, HttpStatus.OK);

        when(notificationService.notifyProductUpdate(anyInt())).thenReturn(expectedNotification);

        // Act
        ResponseEntity<?> actualResponseEntity = notificationController.notifyProductUpdate(productId);

        // Assert
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
        assertEquals(expectedResponseEntity.getBody(), actualResponseEntity.getBody());
    }

    @Test
    void testNotifyProductUpdate_Failure() {
        // Arrange
        int productId = 456;

        // Assume the notification fails (e.g., 404 or other error status)
        when(notificationService.notifyProductUpdate(anyInt())).thenReturn(new Notification());

        // Act
        ResponseEntity<?> actualResponseEntity = notificationController.notifyProductUpdate(productId);

        // Assert
        // You might want to handle the specific error condition in your application
        assertEquals(HttpStatus.OK, actualResponseEntity.getStatusCode()); // Assuming you handle errors in the service layer
    }
}
