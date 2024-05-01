package com.legenkiy.Lab002.repository;

import com.legenkiy.Lab002.model.Corm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CormRepository extends JpaRepository<Corm, Integer> {

}
