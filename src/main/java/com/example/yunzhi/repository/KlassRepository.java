package com.example.yunzhi.repository;

import com.example.yunzhi.model.Klass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KlassRepository extends CrudRepository<Klass, Long> {

    List<Klass> findAllByNameContains(String name);

}
