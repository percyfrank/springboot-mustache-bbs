package com.mustache.bbs.service;

import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


class HospitalServiceTest {

    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    void setUp() {
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("13 -> 폐업중, 3 -> 영업중 으로 잘 나오는가")
    public void codeToNameTest() throws Exception {

        Hospital openHospital = Hospital.builder()
                .id(2321)
                .businessStatusCode(13)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(openHospital));
        HospitalResponse openHospitalResponse = hospitalService.getHospital(2321);
        assertEquals("영업중", openHospitalResponse.getBusinessStatusName());


        Hospital closedHospital = Hospital.builder()
                .id(2322)
                .businessStatusCode(3)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(closedHospital));
        HospitalResponse closedHospitalResponse = hospitalService.getHospital(2322);
        assertEquals("폐업", closedHospitalResponse.getBusinessStatusName());
    }

}