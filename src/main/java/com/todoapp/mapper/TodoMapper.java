package com.todoapp.mapper;

import com.todoapp.dto.TodoDto;
import com.todoapp.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TodoMapper {
    Todo todoPostToTodoEntity(TodoDto.Post todoPatchDto);
    TodoDto.Response todoEntityToTodoResponse(Todo todo);
    List<TodoDto.Response> todoListToTodoResponseList(List<Todo> todos);
    Todo todoPatchToTodoEntity(TodoDto.Patch todoPatchDto);
}
