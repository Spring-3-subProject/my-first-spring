package hello.hellospring.repository;

import hello.hellospring.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo save(Todo todo);
    Optional<Todo> findById(Long id);
    Optional<Todo> findByTitle(String title);
    List<Todo> findAll();
}

