package com.legenkiy.Lab002.service;

import com.legenkiy.Lab002.model.Volier;
import com.legenkiy.Lab002.model.enums.VolierType;
import com.legenkiy.Lab002.repository.VolierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolierService {

    private final VolierRepository volierRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VolierService(VolierRepository volierRepository, JdbcTemplate jdbcTemplate) {
        this.volierRepository = volierRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Volier> getAll(){
        return volierRepository.findAll();

    }

    public Volier getById( int id){
        return volierRepository.findById(id).orElseThrow();
    }

    public void save(Volier volier){
        volierRepository.save(volier);
    }
    public void delete(int id){
        volierRepository.deleteById(id);
    }
    public void addAnimal(int id){
        Volier volier = getById(id);
        if (volier.getMaxCountAnimals() > volier.getCountAnimals()){
            volier.setCountAnimals(volier.getCountAnimals() + 1);
            save(volier);
        }

    }
    public void removeAnimal(int id){
        Volier volier =getById(id);
        if (volier.getCountAnimals() > 0 ){
            volier.setCountAnimals(volier.getCountAnimals() - 1);
            save(volier);
        }
    }

    public List<Volier> getFreeVoliers(){
        return jdbcTemplate.query("select * from volier where count_animals < volier.max_count_animals",
                new BeanPropertyRowMapper<>(Volier.class));
    }




}
