package zoo.service;

import zoo.model.*;

import javax.jws.WebParam;
import java.util.ArrayList;

public class Service {

    public static ArrayList<Animal> serviceShowAnimals(){
        Model.addMySQLToClassPath();
        return Model.showAnimals();
    }

    public static void serviceAddAnimal(String animalName, int animalAge, String animalClass){
        Model.addMySQLToClassPath();
        Model.insertInto(animalName, animalAge, animalClass);

    }

}
