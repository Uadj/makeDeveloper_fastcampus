package com.example.makedeveloper_fastcampus.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class DevDto {
    String name;
    Integer age;
    Integer ExperienceYears;
    LocalDateTime startAt;
}
