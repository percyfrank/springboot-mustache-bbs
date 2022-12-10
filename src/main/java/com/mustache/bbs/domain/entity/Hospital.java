package com.mustache.bbs.domain.entity;

import com.mustache.bbs.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "nation_wide_hospitals")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Hospital {

    @Id
    private Integer id;

    private String openServiceName;
    private Integer openLocalGovernmentCode;

    @Column(length = 40)
    private String managementNumber;

    private LocalDate licenseDate;
    private Integer businessStatus;
    private Integer businessStatusCode;

    @Column(length = 20)
    private String phone;

    @Column(length = 200)
    private String fullAddress;

    @Column(name = "road_name_address",length = 200)
    private String roadNameAddress;

    @Column(name = "hospital_name",length = 50)
    private String hospitalName;

    @Column(length = 10)
    private String businessTypeName;

    private Integer healthcareProviderCount;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;

    // Hospital 엔티티를 Hospital DTO로 만들어주는 부분
    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse(hospital.getId(),hospital.getOpenServiceName(),
                hospital.getOpenLocalGovernmentCode(),hospital.getManagementNumber(),
                hospital.getLicenseDate(),hospital.getBusinessStatus(),hospital.getBusinessStatusCode(),
                hospital.getPhone(),hospital.getFullAddress(),hospital.getRoadNameAddress(),
                hospital.getHospitalName(), hospital.getBusinessTypeName(),hospital.getHealthcareProviderCount(),
                hospital.getPatientRoomCount(),hospital.getTotalNumberOfBeds(), hospital.getTotalAreaSize());
    }
}
