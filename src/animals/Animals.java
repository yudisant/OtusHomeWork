package animals;

public abstract class Animals {
    private String name;
    private int age;
    private int weight;
    private String color;

    public Animals(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    void go() {
        System.out.println("Я иду");
    }

    void eat() {
        System.out.println("Я ем");
    }

    void drink() {
        System.out.println("Я пью");
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + name + ", мне " + age + " " + years() + ", я вешу - " + weight + " кг, мой цвет - " + color;
    }

    private String years() {
        int ostatok = age % 10;

        if(age >= 11 || ostatok == 0 || ostatok >=5) {
            return "лет";
        }

        if(ostatok >= 2) {
            return "года";
        }

        return "год";

    }
}
