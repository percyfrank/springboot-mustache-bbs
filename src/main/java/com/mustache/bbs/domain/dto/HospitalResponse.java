package com.mustache.bbs.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalResponse {
    private Integer id;
    private LocalDate licenseDate;
    private String phone;
    private String fullAddress;
    private String hospitalName;

    private Integer healthcareProviderCount;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;

    private String businessStatusName;

    public HospitalResponse(Integer id, String openServiceName, Integer openLocalGovernmentCode, String managementNumber, LocalDate licenseDate, Integer businessStatus, Integer businessStatusCode, String phone, String fullAddress, String roadNameAddress, String hospitalName, String businessTypeName, Integer healthcareProviderCount, Integer patientRoomCount, Integer totalNumberOfBeds, Float totalAreaSize) {
        this.id = id;
        this.licenseDate = licenseDate;
        this.phone = phone;
        this.fullAddress = fullAddress;
        this.hospitalName = hospitalName;
        this.healthcareProviderCount = healthcareProviderCount;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.totalAreaSize = totalAreaSize;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }

}
