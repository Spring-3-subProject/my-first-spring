package hello.hellospring.service;

import hello.hellospring.domain.Todo;
import hello.hellospring.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

public class TodoService {
    public static final String DUPLICATE_TITLE = "Duplicate title";
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 추가
    public long create(Todo todo) {
        validateDuplicateTodo(todo);
        todoRepository.save(todo);
        return todo.getId();
    }

    private void validateDuplicateTodo(Todo todo) {
       todoRepository.findByTitle(todo.getTitle())
               .ifPresent(td -> {
                   throw new IllegalStateException(DUPLICATE_TITLE);
               });
    }

    public List<Todo> findTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findOne(Long todoId) {
        return todoRepository.findById(todoId);
    }

}
