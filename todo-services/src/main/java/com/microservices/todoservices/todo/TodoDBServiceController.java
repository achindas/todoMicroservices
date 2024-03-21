package com.microservices.todoservices.todo;


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

//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoDBServiceController {

	@Autowired
	private TodoRepository todoRepo;
	
	@Autowired
	private TodoDBRepository todoDBRepo;
	
	@GetMapping(path = "/todo-services/db/get-all-todos/user/{username}/todos")
	public List<Todo> retrieveAllTodos(@PathVariable String username){
		return this.todoDBRepo.findByUsername(username);
	}
	
	@GetMapping(path = "/todo-services/db/get-todo/user/{username}/todo/{todo_id}")
	public Todo retrieveTodoById(@PathVariable String username, 
			@PathVariable long todo_id){
		
		Todo todo = todoDBRepo.findById(todo_id).get();
		
		if(todo != null) {
			return todo;
		}
		
	return null;
	
	}
	
	@DeleteMapping(path = "/todo-services/db/delete-todo/user/{username}/todo/{todo_id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, 
			@PathVariable long todo_id){
		
		todoDBRepo.deleteById(todo_id);
		
		return ResponseEntity.noContent().build();
	
	}
	
	@PutMapping(path = "/todo-services/db/update-todo/user/{username}/todo/{todo_id}")
	public Todo updateTodoById(@PathVariable String username, 
			@PathVariable long todo_id, @RequestBody Todo todo){
		
		return todoDBRepo.save(todo);
	}
	
	@PostMapping(path = "/todo-services/db/add-todo/user/{username}/todo")
	public ResponseEntity<Void> addTodo (@PathVariable String username,
			@RequestBody Todo todo) {
		
		//System.out.println("Username: " + username);
		todo.setUsername(username);
		Todo createdTodo = todoDBRepo.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
