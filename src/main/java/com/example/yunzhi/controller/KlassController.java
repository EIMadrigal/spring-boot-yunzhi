package com.example.yunzhi.controller;

import com.example.yunzhi.model.Klass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KlassController {

    private final static Logger logger = LoggerFactory.getLogger(KlassController.class.getName());

    public List<Klass> getAll(@RequestParam String name) {
        logger.info(name);
        return null;
    }

}
