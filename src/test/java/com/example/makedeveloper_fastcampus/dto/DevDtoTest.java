package com.example.makedeveloper_fastcampus.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DevDtoTest {
    @Test
    void test(){
        final DevDto devDto = DevDto.builder()
                .name("snow")
                .age(31)
                .startAt(LocalDateTime.now())
                .ExperienceYears(2)
                .build();
    }
}