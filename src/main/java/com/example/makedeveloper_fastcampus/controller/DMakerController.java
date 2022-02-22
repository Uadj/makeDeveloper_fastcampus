package com.example.makedeveloper_fastcampus.controller;

import com.example.makedeveloper_fastcampus.dto.*;
import com.example.makedeveloper_fastcampus.exception.DMakerException;
import com.example.makedeveloper_fastcampus.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;

    // 모든 개발자 조회
    @GetMapping("/developers")
    public List<DeveloperDto> getAllEmployedDevelopers(){
        log.info("GET /developers HTTP/1.1");
        return dMakerService.getAllEmployedDevelopers();
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
    @DeleteMapping("/developer/{memberId}")
    public DeveloperDetailDto developerDetailDto(
            @PathVariable String memberId
    ){
        return dMakerService.deleteDeveloper(memberId);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DMakerException.class)
    public DMakerErrorResponse handleException(DMakerException e,
                                               HttpServletRequest request
    ){
        log.error("errorCode : {}, url: {}, message: {}", e.getDMakerErrorCode(),
                request.getRequestURI(), e.getDetailMessage());
        return DMakerErrorResponse.builder()
                .errorCode(e.getDMakerErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();
    }
}
