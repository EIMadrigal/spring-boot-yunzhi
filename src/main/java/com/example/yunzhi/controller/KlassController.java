package com.example.yunzhi.controller;

import com.example.yunzhi.model.Klass;
import com.example.yunzhi.service.KlassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("class")
public class KlassController {

    private final static Logger logger = LoggerFactory.getLogger(KlassController.class.getName());

    @Autowired
    KlassService klassService;

    @GetMapping
    public List<Klass> getAll(@RequestParam String name) {
        logger.info(name);
        return this.klassService.getAll(name);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Klass get(@PathVariable Long id) {
        return this.klassService.getById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Klass klass) {
        this.klassService.update(id, klass);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Klass klass) {
        this.klassService.save(klass);
    }

}
