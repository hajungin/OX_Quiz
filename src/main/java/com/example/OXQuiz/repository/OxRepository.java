package com.example.OXQuiz.repository;

import com.example.OXQuiz.entity.Ox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OxRepository extends JpaRepository<Ox, Long> {
    @Query(value = "SELECT * FROM ox ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Ox RandomQuery();
}
