package com.pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pattern.factory.Pet;
import com.pattern.factory.PetFactory;
import com.pattern.factory.Task;
import com.pattern.factory.TaskBuilder;
import com.pattern.qualifire.Animal;
import com.pattern.repository.President;
import com.pattern.repository.PresidentRepository;

@RestController
public class DesignPatternController {

	@Autowired
	private PetFactory petFactory;

	@Autowired
	private PresidentRepository presidentRepository;
	
	@GetMapping("/factPattern")
	public String defaultMessage() {
		return "welcome in spring boot";
	}

	@GetMapping("/petFactory/{name}/{type}")
	public Pet getPetObject(@PathVariable("name") String name, @PathVariable("type") String animalType) {
		Pet pet = petFactory.createPet(animalType);
		pet.setName(name);
		pet.feed();
		return pet;
	}
	
	
	@GetMapping("/taskbuilder")
	public Task getTask() {
		Task task=new TaskBuilder(4).setDescription("First Task").setDone(true).setSummary("Get result from list").build();
		return task;
	}
	
	
	
	@GetMapping("/president/{id}")
	public President getPresident(@PathVariable Long id)
	{
		System.out.print("President");
		return presidentRepository.findById(id).get();
	}
	
	
	//@Qualifier(value="dog")
	//@Autowired(required=false)
	Animal animal;
	
	@Scope
	@Autowired(required=false)
	public void Animal(@Qualifier("pet") Animal animal) {
		this.animal=animal;
	}
	
	
	
	@GetMapping("/DogQuality")
	public String quality() {
		
		return animal.qualities();
	}
	
	

}
