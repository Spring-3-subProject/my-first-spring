package hello.hellospring.controller;

import hello.hellospring.domain.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
    @GetMapping("api/ping")
    @ResponseBody
    public String pingpongApi() {
        return "pong";
    }

    @GetMapping("api/todo")
    @ResponseBody
    public Todo createTodoApi() {
        Todo todo = new Todo();
        todo.setDone(false);
        todo.setTitle("empty title");
        return todo;
    }
}

