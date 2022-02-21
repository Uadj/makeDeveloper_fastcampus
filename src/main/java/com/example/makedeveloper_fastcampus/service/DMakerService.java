package com.example.makedeveloper_fastcampus.service;

import com.example.makedeveloper_fastcampus.dto.CreateDeveloper;
import com.example.makedeveloper_fastcampus.dto.DeveloperDetailDto;
import com.example.makedeveloper_fastcampus.dto.DeveloperDto;
import com.example.makedeveloper_fastcampus.entity.Developer;
import com.example.makedeveloper_fastcampus.exception.DMakerErrorCode;
import com.example.makedeveloper_fastcampus.exception.DMakerException;
import com.example.makedeveloper_fastcampus.repository.DeveloperRepository;
import com.example.makedeveloper_fastcampus.type.DeveloperLevel;
import com.example.makedeveloper_fastcampus.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.makedeveloper_fastcampus.exception.DMakerErrorCode.*;
import static org.springframework.data.repository.util.ClassUtils.ifPresent;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
        Developer developer = Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .name(request.getName())
                .age(request.getAge())
                .build();
        developerRepository.save(developer);
        return CreateDeveloper.Response.fromEntity(developer);
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request){

        DeveloperLevel DeveloperLevel = request.getDeveloperLevel();
        Integer experienceYear = request.getExperienceYears();
        if(DeveloperLevel == DeveloperLevel.SENIOR && experienceYear < 10){
            throw new DMakerException(LEVEL_EXPERIENCE_YEAR_NOT_MATCHED);
        }
        if(DeveloperLevel == DeveloperLevel.JUNGIOR && (experienceYear < 4 || experienceYear >10)){
            throw new DMakerException(LEVEL_EXPERIENCE_YEAR_NOT_MATCHED);
        }
        if(DeveloperLevel == DeveloperLevel.JUNIOR && experienceYear > 4){
            throw new DMakerException(LEVEL_EXPERIENCE_YEAR_NOT_MATCHED);
        }

        developerRepository.findByMemberId(request.getMemberId())
        .ifPresent((developer->{
            throw new DMakerException(DUPLICATED_MEMBER_ID);
        }));
    }

    public List<DeveloperDto> getAllDevelopers() {
        return developerRepository.findAll()
                .stream().map(DeveloperDto::fromEntity)
                .collect(Collectors.toList());
    }
    public DeveloperDetailDto getDeveloperDetail(String memberId) {
        return developerRepository.findByMemberId(memberId)
                .map(DeveloperDetailDto::fromEntity)
                .orElseThrow(()-> new DMakerException(NO_DEVELOPER));
    }
}
