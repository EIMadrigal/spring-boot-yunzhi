package com.example.yunzhi.controller;

import com.example.yunzhi.model.Klass;
import com.example.yunzhi.repository.KlassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("class")
public class KlassController {

    private final static Logger logger = LoggerFactory.getLogger(KlassController.class.getName());

    @Autowired
    KlassRepository klassRepository;

    @GetMapping
    public List<Klass> getAll(@RequestParam String name) {
        logger.info(name);
        return this.klassRepository.findAllByNameContains(name);
    }

}
