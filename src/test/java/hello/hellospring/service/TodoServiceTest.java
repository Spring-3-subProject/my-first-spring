package hello.hellospring.service;

import hello.hellospring.domain.Todo;
import hello.hellospring.repository.MemoryTodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static hello.hellospring.service.TodoService.DUPLICATE_TITLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TodoServiceTest {
    TodoService todoService;
    MemoryTodoRepository todoRepository;

    @BeforeEach
    public void beforeEach() {
        todoRepository = new MemoryTodoRepository();
        todoService = new TodoService(todoRepository);
    }

    @AfterEach
    public void afterEach() {
        todoRepository.clearStore();
    }

    @Test
    public void create() throws Exception {
        Todo todo = new Todo();
        todo.setTitle("laundry");

        Long saveId = todoService.create(todo);

        Todo findTodo = todoRepository.findById(saveId).get();
        assertEquals(todo.getTitle(), findTodo.getTitle());
    }

    @Test
    public void validateDuplicateTodo() throws Exception {
        Todo todo1 = new Todo();
        todo1.setTitle("spring1");

        Todo todo2 = new Todo();
        todo2.setTitle("spring1");

        todoService.create(todo1);

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> todoService.create(todo2));

        assertThat(e.getMessage()).isEqualTo(DUPLICATE_TITLE);
    }
}
