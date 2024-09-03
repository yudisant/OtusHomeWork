package factory;

import animals.Animals;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;

public class AnimalFactory {

    private int age;
    private int weight;
    private String name;
    private String color;

    public AnimalFactory(int age, int weight, String name, String color) {
        this.age = age;
        this.weight = weight;
        this.name = name;
        this.color = color;
    }
    public Animals create(AnimalData animalData) {
        switch (animalData) {
            case DUCK: {
                return new Duck(name, age, weight, color);
            }
            case DOG: {
                return new Dog(name, age, weight, color);
            }
            case CAT:{
                return new Cat(name, age, weight, color);
            }
        }
        return null;
    }

}
