package com.legenkiy.Lab002.repository;


import com.legenkiy.Lab002.model.Animal;
import com.legenkiy.Lab002.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query(value = "select * from animal where category = ?1 ", nativeQuery = true)
    List<Animal> findByCategory(String category);
}
