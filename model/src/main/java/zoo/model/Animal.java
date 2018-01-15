package zoo.model;

public class Animal {
    public String getAnimalName() {
        return animalName;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public void setAnimalClass(String animalClass) {
        this.animalClass = animalClass;
    }

    private String animalName;
    private int animalAge;
    private String animalClass;


}
