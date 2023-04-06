package com.todoapp.controller;

import com.todoapp.dto.TodoDto;
import com.todoapp.entity.Todo;
import com.todoapp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoDto.Response> createTodo(@RequestBody TodoDto.Post todoPostDto) {
        return new ResponseEntity<>(todoService.createTodo(todoPostDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto.Response>> getAllTodos() {
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto.Response> getTodo(@PathVariable("id") long id) {
        return new ResponseEntity<>(todoService.getTodo(id), HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoDto.Response> modifyTodo(@PathVariable("id") long id, @RequestBody TodoDto.Patch todoPatchDto) {
        return new ResponseEntity<>(todoService.modifyTodo(id, todoPatchDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<TodoDto.Response> deleteAllTodos() {
        todoService.deleteAllTodos();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
