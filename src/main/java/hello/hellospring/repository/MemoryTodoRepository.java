package hello.hellospring.repository;

import hello.hellospring.domain.Todo;

import java.util.*;

// TODO 동시성 문제 고려: ConcurrentHashMap, AtomicLong 사용
public class MemoryTodoRepository implements TodoRepository {
    private static Map<Long, Todo> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Todo save(Todo todo) {
        todo.setId(++sequence);
        store.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        return store.values().stream()
                .filter(todo -> todo.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
