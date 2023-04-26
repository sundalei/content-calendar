package com.example.repository;

import com.example.model.Content;
import com.example.model.Status;
import com.example.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findById(Integer id) {
        return contents.stream().filter(content -> content.id().equals(id)).findFirst();
    }
    
    public void save(Content content) {
    	contents.removeIf(c -> c.id().equals(content.id()));
    	contents.add(content);
    }
    
    public boolean existsById(Integer id) {
    	return contents.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contents.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    public void init() {
        Content c = new Content(1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contents.add(c);
    }
}
