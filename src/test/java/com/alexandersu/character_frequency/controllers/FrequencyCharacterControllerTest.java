package com.alexandersu.character_frequency.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FrequencyCharacterControllerTest {

    @Test
    void testGetCharacterFrequency1() {
        // Создание экземпляра контроллера
        FrequencyCharacterController controller = new FrequencyCharacterController();

        // Выполнение запроса и получение результата
        Map<Character, Integer> result = controller.getCharacterFrequency("aaaaabcccc");

        // Проверка результата
        assertEquals(3, result.size());
        assertEquals(5, result.get('a').intValue());
        assertEquals(1, result.get('b').intValue());
        assertEquals(4, result.get('c').intValue());
    }

}