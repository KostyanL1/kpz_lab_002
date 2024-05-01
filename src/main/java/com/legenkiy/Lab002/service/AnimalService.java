package com.legenkiy.Lab002.service;


import com.legenkiy.Lab002.exceptions.NotSuitableCormException;
import com.legenkiy.Lab002.model.Animal;
import com.legenkiy.Lab002.model.Corm;
import com.legenkiy.Lab002.model.Volier;
import com.legenkiy.Lab002.model.enums.Category;
import com.legenkiy.Lab002.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final CormService cormService;
    private final VolierService volierService;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, CormService cormService, VolierService volierService, JdbcTemplate jdbcTemplate) {
        this.animalRepository = animalRepository;
        this.cormService = cormService;
        this.volierService = volierService;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public Animal getById(int id) {
        return animalRepository.findById(id).orElseThrow();
    }

    public List<Animal> getAllByCategory(String category) {
        return animalRepository.findByCategory(category);
    }

    public void save(Animal animal, int volierId, int cormId) {
        if(animal.getCorm() == null){
            Corm corm = cormService.getById(cormId);
            animal.setCorm(corm);
            Volier volier = volierService.getById(volierId);
            animal.setVolier(volier);
            volierService.addAnimal(volierId);
            animalRepository.save(animal);
        }

        if (!animal.getCategory().equals(animal.getCorm().getCategory())) {
            throw new NotSuitableCormException("Не підходящий корм!");
        }
    }

    public void delete(int id) {
        Animal animal = getById(id);
        volierService.removeAnimal(animal.getVolier().getId());
        animalRepository.deleteById(id);
    }

    public void edit(Animal animal, int id) {

        jdbcTemplate.update("update animal set weight=?, corm_id=?, volier_id=? where id=?",
                animal.getWeight(), animal.getCorm().getId(), animal.getVolier().getId(), id);
    }
}
/*Animal animal1 = getById(id);
        animal1.setVolier(animal.getVolier());
        if (animal.getCorm().getCategory().equals(animal1.getCategory())){
            animal1.setCorm(animal.getCorm());
        }
        animal1.setWeight(animal.getWeight());

        save(animal1, animal1.getVolier().getId(), animal1.getCorm().getId());
    }*/