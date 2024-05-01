package com.legenkiy.Lab002.service;

import com.legenkiy.Lab002.model.Corm;
import com.legenkiy.Lab002.model.enums.Category;
import com.legenkiy.Lab002.repository.CormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CormService {

    private final CormRepository cormRepository;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CormService(CormRepository cormRepository, JdbcTemplate jdbcTemplate) {
        this.cormRepository = cormRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Corm> getAll(){
        return cormRepository.findAll();
    }
    public Corm getById(int id){
        return cormRepository.findById(id).orElseThrow();
    }
    public void save(Corm corm){
        cormRepository.save(corm);
    }
    public void delete(int id){
        cormRepository.deleteById(id);
    }
    public List<Corm> getCormByCategory(Category category){
        return jdbcTemplate.query("select * from corm where category=?", new Object[]{category.toString()} ,
                new BeanPropertyRowMapper<>(Corm.class));

    }
}
