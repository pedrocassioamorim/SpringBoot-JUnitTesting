package org.bootcampspringboot.junitandmockito.resources.exceptions;

import org.bootcampspringboot.junitandmockito.services.exceptions.DataIntegratyViolationException;
import org.bootcampspringboot.junitandmockito.services.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceExceptionHandlerTest {
    @InjectMocks
    private ResExceptionHandler exceptionHandler;

    private static final String userNotFoundInDb = "User not found in DB";
    private static final String emailOnDB = "User already on database";
    private static final String exception = "Exception";



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenUserNotFoundReturnAResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler
                .userNotFound(new UserNotFoundException(userNotFoundInDb),new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(userNotFoundInDb, response.getBody().getError());
        assertEquals(404, response.getBody().getStatus());
        assertNotEquals("/user/2", response.getBody().getPath());
        assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());
        assertFalse(response.getBody().getMessage().isEmpty());
        assertTrue(response.equals(response));

    }

    @Test
    void whenUserAlreadyInDatabase() {
        ResponseEntity<StandardError> response = exceptionHandler
                .userInDatabase(new DataIntegratyViolationException(emailOnDB),new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(emailOnDB, response.getBody().getError());
        assertEquals(400, response.getBody().getStatus());
        assertFalse(response.getBody().getMessage().isEmpty());
        assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());
        assertFalse(response.getBody().getMessage().isEmpty());
        assertNotEquals("/user/2", response.getBody().getPath());
        assertTrue(response.equals(response));


    }
}