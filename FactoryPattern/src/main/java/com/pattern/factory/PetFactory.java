package com.pattern.factory;

import org.springframework.stereotype.Component;

@Component
public class PetFactory {
	
	public Pet createPet(String animalType)
	{
		Pet pet = null;
		switch (animalType) {
		case "dog":
			pet = new Dog();
			break;
		default:
			new UnsupportedOperationException("unknown animal type");
		}
		return pet;
	}
}
