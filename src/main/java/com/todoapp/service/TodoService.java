package com.todoapp.service;

import com.todoapp.dto.TodoDto;
import com.todoapp.entity.Todo;
import com.todoapp.mapper.TodoMapper;
import com.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper mapper;

    public TodoService(TodoRepository todoRepository, TodoMapper mapper) {
        this.todoRepository = todoRepository;
        this.mapper = mapper;
    }

    public TodoDto.Response createTodo(TodoDto.Post todoPostDto) {
        Todo todo = mapper.todoPostToTodoEntity(todoPostDto);
        Todo save = todoRepository.save(todo);
        return mapper.todoEntityToTodoResponse(save);
    }

    public TodoDto.Response getTodo(long id) {
        Todo todo = todoRepository.findById(id).get();

        return mapper.todoEntityToTodoResponse(todo);
    }

    public List<TodoDto.Response> getAllTodos() {
        List<Todo> all = todoRepository.findAll();
        return mapper.todoListToTodoResponseList(all);
    }

    public TodoDto.Response modifyTodo(long id, TodoDto.Patch todoPatchDto) {
        todoPatchDto.setId(id);
        Todo todo = mapper.todoPatchToTodoEntity(todoPatchDto);
        Todo save = todoRepository.save(todo);
        return mapper.todoEntityToTodoResponse(save);
    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    public void deleteTodo(long id) {
        Todo todo = todoRepository.findById(id).get();
        todoRepository.delete(todo);
    }
}
