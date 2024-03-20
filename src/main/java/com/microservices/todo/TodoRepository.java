package com.microservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoRepository {
	
	private static List<Todo> allTodos = new ArrayList<Todo>();
	private static long idCounter = 0;
	
	static{
		allTodos.add(new Todo(++idCounter, "Achin", "Learn to play carrom", new Date(), false));
		allTodos.add(new Todo(++idCounter, "Tapan", "Learn to play Volleyball", new Date(), true));
		allTodos.add(new Todo(++idCounter, "Achin", "Learn to play Kabadi", new Date(), true));
	}
	public List<Todo> findAllTodos() {
		// TODO Auto-generated method stub
		return this.allTodos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo != null) {
			allTodos.remove(todo);
			return todo;
		}
		
		return null;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		for (Todo todo:allTodos) {
			//System.out.println(todo);
			
			if(todo.getId() == id) {
				//System.out.println("Id Found: " + id);
				return todo;
			}
		}
		
		return null;
	}
	
	public Todo save (Todo todo) {
		if(todo.getId() == -1) {
			todo.setId(++idCounter);
			allTodos.add(todo);
		} else {
			deleteById(todo.getId());
			allTodos.add(todo);
		}
		return todo;
	}

}
