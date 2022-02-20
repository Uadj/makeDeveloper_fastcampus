package com.example.makedeveloper_fastcampus.controller;

import com.example.makedeveloper_fastcampus.dto.CreateDeveloper;
import com.example.makedeveloper_fastcampus.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;

    @PostMapping("/create-developer")
    public ResponseEntity<CreateDeveloper.Response> createDeveloper(
            @Valid @RequestBody CreateDeveloper.Request request
    ) {
        return ResponseEntity.ok(
                dMakerService.createDeveloper(request)
        );
    }
}
