package com.example.yunzhi.service;

import com.example.yunzhi.model.Klass;

import java.util.List;

public interface KlassService {

    Klass getById(Long id);

    void update(Long id, Klass klass);

    List<Klass> getAll(String name);

    void save(Klass klass);

}
