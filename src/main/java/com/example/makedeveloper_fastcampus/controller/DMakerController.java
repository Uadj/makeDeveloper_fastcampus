package com.example.makedeveloper_fastcampus.controller;

import com.example.makedeveloper_fastcampus.dto.CreateDeveloper;
import com.example.makedeveloper_fastcampus.dto.DeveloperDetailDto;
import com.example.makedeveloper_fastcampus.dto.DeveloperDto;
import com.example.makedeveloper_fastcampus.dto.EditDeveloper;
import com.example.makedeveloper_fastcampus.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;

    // 모든 개발자 조회
    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers(){
        log.info("GET /developers HTTP/1.1");
        return dMakerService.getAllDevelopers();
    }
    // 아이디로 조회
    @GetMapping("/developer/{memberId}")
    public DeveloperDetailDto getDeverloperDetail(
            @PathVariable String memberId
    ){
        log.info("GET /developer/{memberId} HTTP/1.1");
        return dMakerService.getDeveloperDetail(memberId);
    }
    // 개발자 등록
    @PostMapping("/create-developer")
    public ResponseEntity<CreateDeveloper.Response> createDeveloper(
            @Valid @RequestBody CreateDeveloper.Request request
    ) {
        return ResponseEntity.ok(
                dMakerService.createDeveloper(request)
        );
    }
    @PutMapping("/developer/{memberId}")
    public DeveloperDetailDto editDeveloper(
            @PathVariable String memberId,
            @Valid @RequestBody EditDeveloper.Request request
    ){
        log.info("PUT /developer/{memberId} HTTP/1.1");
        return dMakerService.editDeveloper(memberId, request);
    }
}
