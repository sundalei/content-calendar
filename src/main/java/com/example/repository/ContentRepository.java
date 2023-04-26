package com.example.repository;

import java.util.List;

import com.example.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.example.model.Content;
import org.springframework.data.repository.query.Param;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    
    List<Content> findByTitleContains(String title);

    @Query("SELECT * FROM Content WHERE status = :status")
    List<Content> listByStatus(@Param("status") Status status);
}
