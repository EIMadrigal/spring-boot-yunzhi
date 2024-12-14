package com.example.yunzhi.service.impl;

import com.example.yunzhi.model.Klass;
import com.example.yunzhi.repository.KlassRepository;
import com.example.yunzhi.service.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlassServiceImpl implements KlassService {

    @Autowired
    KlassRepository klassRepository;

    @Override
    public List<Klass> getAll(String name) {
        return this.klassRepository.findAllByNameContains(name);
    }

    @Override
    public Klass getById(Long id) {
        return this.klassRepository.findById(id).get();
    }

    @Override
    public void save(Klass klass) {
        this.klassRepository.save(klass);
    }

    @Override
    public void update(Long id, Klass klass) {
        Klass oldKlass = klassRepository.findById(id).get();
        oldKlass.setName(klass.getName());
        oldKlass.setTeacher(klass.getTeacher());
        klassRepository.save(oldKlass);
    }

}
