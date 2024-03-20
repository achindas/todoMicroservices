package com.springservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoServiceController {

	@Autowired
	private TodoRepository todoRepo;
	
	@GetMapping(path = "/get-all-todos/user/{username}/todos")
	public List<Todo> retrieveAllTodos(@PathVariable String username){
		return this.todoRepo.findAllTodos();
	}
	
	@GetMapping(path = "/get-todo/user/{username}/todo/{todo_id}")
	public Todo retrieveTodoById(@PathVariable String username, 
			@PathVariable long todo_id){
		
		Todo todo = todoRepo.findById(todo_id);
		
		if(todo != null) {
			return todo;
		}
		
	return null;
	
	}
	
	@DeleteMapping(path = "/delete-todo/user/{username}/todo/{todo_id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, 
			@PathVariable long todo_id){
		
		Todo todo = todoRepo.deleteById(todo_id);
		
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		
	return ResponseEntity.notFound().build();
	
	}
	
	@PutMapping(path = "/update-todo/user/{username}/todo/{todo_id}")
	public Todo updateTodoById(@PathVariable String username, 
			@PathVariable long todo_id, @RequestBody Todo todo){
		
		return todoRepo.save(todo);
	}
	
	@PostMapping(path = "/add-todo/user/{username}/todo")
	public ResponseEntity<Void> addTodo (@PathVariable String username,
			@RequestBody Todo todo) {
		
		Todo createdTodo = todoRepo.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
