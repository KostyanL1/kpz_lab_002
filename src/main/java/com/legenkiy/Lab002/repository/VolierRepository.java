package com.legenkiy.Lab002.repository;


import com.legenkiy.Lab002.model.Volier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolierRepository  extends JpaRepository<Volier, Integer> {
}
