package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);

    List<Hospital> findByRoadNameAddressContaining(String keyword);
    List<Hospital> findByHospitalNameStartingWith(String keyword);
    List<Hospital> findByHospitalNameEndsWith(String keyword);

    List<Hospital> findByPatientRoomCountBetween(int keyword1, int keyword2);

    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int a, int b);

}
