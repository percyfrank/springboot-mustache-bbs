package com.mustache.bbs.controller.web;

import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/hospitals")
@Slf4j
public class HospitalController {
    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping(value = "")
    public String list(@RequestParam(required = false) String keyword, Model model, Pageable pageable) {
        Page<Hospital> hospitals;

        if(keyword == null) {
            hospitals = hospitalRepository.findAll(pageable);
        } else {
            hospitals = hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);
        }

        log.info("size : {}", hospitals.getSize());
        log.info("keyword : {}", keyword);

        model.addAttribute("keyword", keyword);
        model.addAttribute("hospitals", hospitals);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());

        return "hospitals/list";
    }

    @GetMapping(value = "/{id}")
    public String detail(@PathVariable Integer id, Model model) {

        Optional<Hospital> optdetail = hospitalRepository.findById(id);

        if(!optdetail.isEmpty()) {
            model.addAttribute("detail", optdetail.get());
            return "hospitals/detail";
        } else {
            return "hospitals/error";
        }
    }
}
