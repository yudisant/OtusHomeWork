import animals.Animals;
import data.AnimalData;
import data.Commands;
import factory.AnimalFactory;
import utils.ValidateNumber;

import java.util.*;

public class Main {
    private static Scanner scanner;
    private static ValidateNumber validateNumber;

    private static int enterNumberData(String errorMessage, int attempt) {

        if (attempt == 0) {
            return -1;
        }

        String dataStr = scanner.next();

        while (!validateNumber.isNumber(dataStr)) {
            System.out.println(errorMessage);
            dataStr = scanner.next();
        }
        int number = Integer.parseInt(dataStr);
        if(number > 0) {
            if (number < 100) {
            return number;
        }
            }
        System.out.println(errorMessage);
        enterNumberData(errorMessage, --attempt);
        return -1;
    }

    public static void main(String[] args) {
        validateNumber = new ValidateNumber();
        scanner = new Scanner(System.in);

        List<Animals> animal = new ArrayList<>();

        while (true) {

            System.out.println("Введи команду ADD, LIST, EXIT: ");
            String input = scanner.next().toUpperCase(Locale.ROOT).trim();
            Commands commands = Commands.of(input);

            switch (commands) {
                case ADD:

                    while (true) {
                        System.out.print("Введите тип животного: ");
                        System.out.println(Arrays.toString(AnimalData.values()));
                        String animalType = scanner.next().toUpperCase().trim();

                        boolean isAnimalValid = false;
                        for (AnimalData animalData : AnimalData.values()) {
                            if (animalData.name().equals(animalType)) {
                                isAnimalValid = true;
                                break;
                            }
                        }

                        if (!isAnimalValid) {
                            System.out.println("Недопустимый тип животного.");
                            continue;
                        }

                        System.out.println("Введите возраст животного: ");
                        int animalAge = enterNumberData("Неверно введён возраст! \nПовторите ввод: ", 5);
                        if (animalAge == -1) {
                            System.out.println("Вы потратили все попытки ввода");
                            continue;
                        }
                        System.out.println("Введите вес животного: ");
                        int animalWeight = enterNumberData("Неверно введён вес! \nПовторите ввод: ", 5);
                        if (animalWeight == -1) {
                            System.out.println("Вы потратили все попытки ввода");
                            continue;
                        }

                        System.out.println("Введите имя животного: ");
                        String animalName = scanner.next();

                        System.out.println("Введите цвет животного: ");
                        String animalColor = scanner.next();

                        AnimalFactory animalFactory = new AnimalFactory(animalAge, animalWeight, animalName, animalColor);

                        Animals animals = animalFactory.create(AnimalData.valueOf(animalType.toUpperCase(Locale.ROOT)));
                        animal.add(animals);

                        animals.say();

                        break;
                    }
                    break;

                case LIST:
                    if (animal.isEmpty()) {
                        System.out.println("Список пуст. Добавьте животное(ADD) или выйдите(EXIT)");
                    }
                    animal.forEach(System.out::println);
                    break;

                case EXIT:
                    System.exit(0);

                default:
                    System.out.println("Неверная команда!");
            }
        }
    }
}
