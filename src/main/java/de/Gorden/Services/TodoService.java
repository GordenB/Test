package de.Gorden.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import de.Gorden.Form.TodoForm;

@Service
public class TodoService {
	private static List<TodoForm> todos = new ArrayList<TodoForm>();
	private static int todoCount = 3;
	
	

	static {
		todos.add(new TodoForm(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
		todos.add(new TodoForm(2, "in28Minutes", "Learn Struts", new Date(), false));
		todos.add(new TodoForm(3, "in28Minutes", "Learn Hibernate", new Date(), false));
	}
	public List<TodoForm> retrieveTodos(String user) {
		List<TodoForm> filteredTodos = new ArrayList<TodoForm>();
		for (TodoForm todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new TodoForm(++todoCount, name, desc, targetDate, isDone));
	}
	public void deleteTodo(int id) {
		Iterator<TodoForm> iterator = todos.iterator();
		while (iterator.hasNext()) {
			TodoForm todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	}
