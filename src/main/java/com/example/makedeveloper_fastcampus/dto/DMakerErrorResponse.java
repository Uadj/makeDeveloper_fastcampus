package com.example.makedeveloper_fastcampus.dto;

import com.example.makedeveloper_fastcampus.exception.DMakerErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DMakerErrorResponse {
    private DMakerErrorCode errorCode;
    private String errorMessage;

}
