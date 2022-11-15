package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Hospital;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void findByBusinessTypeNameIn() {
        ArrayList<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);

        for(var hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }
    @Test
    void containing() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("광진구");
        for(var hospital : hospitals) {
            System.out.println(hospital.getRoadNameAddress());
        }
    }
    @Test
    void startsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartingWith("경희");
        for(var hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }
    @Test
    void endWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("병원");
        for(var hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    void between() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetween(10,20);
        for(var hospital : hospitals) {
            System.out.printf("%s %d\n",hospital.getHospitalName(), hospital.getPatientRoomCount());
        }
    }

    @Test
    void orderByDesc() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(10,20);
        for(var hospital : hospitals) {
            System.out.printf("%s %d\n",hospital.getHospitalName(), hospital.getPatientRoomCount());

        }
    }

    @Test
    void name() {
        Optional<Hospital> hospital = hospitalRepository.findById(1);
        Hospital hp = hospital.get();
        Assertions.assertThat(hp.getId()).isEqualTo(1);
    }
}