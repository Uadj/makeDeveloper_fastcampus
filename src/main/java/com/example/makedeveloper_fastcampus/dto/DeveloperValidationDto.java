package com.example.makedeveloper_fastcampus.dto;

import com.example.makedeveloper_fastcampus.entity.Developer;
import com.example.makedeveloper_fastcampus.exception.DMakerErrorCode;
import com.example.makedeveloper_fastcampus.type.DeveloperLevel;
import com.example.makedeveloper_fastcampus.type.DeveloperSkillType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperValidationDto {
    private DMakerErrorCode errorCode;
    private String errorMessage;
}
