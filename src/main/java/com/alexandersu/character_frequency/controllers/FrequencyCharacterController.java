package com.alexandersu.character_frequency.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FrequencyCharacterController {

    /**
     * getCharacterFrequency
     * строка в формате, например: aaaaabcccc
     * return коллекцию отсартированную по убыванию значения
     */
    @GetMapping("/character-frequency")
    public Map<Character, Integer> getCharacterFrequency(@RequestParam String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (newValue, oldValue) -> oldValue, LinkedHashMap::new));

    }
}
