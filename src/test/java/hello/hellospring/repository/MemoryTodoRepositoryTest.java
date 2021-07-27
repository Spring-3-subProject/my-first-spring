package hello.hellospring.repository;

import hello.hellospring.domain.Todo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryTodoRepositoryTest {
    MemoryTodoRepository repository = new MemoryTodoRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Todo todo = new Todo();
        todo.setTitle("spring study");

        repository.save(todo);

        Todo result = repository.findById(todo.getId()).get();
        assertThat(result).isEqualTo(todo);
    }

    @Test
    public void findByTitle() {
        Todo todo1 = new Todo();
        todo1.setTitle("spring1");
        repository.save(todo1);

        Todo todo2 = new Todo();
        todo2.setTitle("spring2");
        repository.save(todo2);

        Todo result = repository.findByTitle("spring1").get();
        assertThat(result).isEqualTo(todo1);
    }

    @Test
    public void findAll() {
        Todo todo1 = new Todo();
        todo1.setTitle("spring1");
        repository.save(todo1);

        Todo todo2 = new Todo();
        todo2.setTitle("spring2");
        repository.save(todo2);

        List<Todo> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
