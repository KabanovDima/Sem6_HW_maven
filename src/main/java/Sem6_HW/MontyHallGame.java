package Sem6_HW;
import lombok.Data;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;

public class MontyHallGame {
    private int numberOfDoors;
    private int carPosition;
    private int playerChoice;
    private RandomDataGenerator randomDataGenerator;

    public MontyHallGame(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        this.randomDataGenerator = new RandomDataGenerator();
        readyToGame();
    }

    private void readyToGame(){
        carPosition = randomDataGenerator.nextInt(0, numberOfDoors - 1);
//        System.out.println("carPosition: " + carPosition);
        playerChoice = randomDataGenerator.nextInt(0, numberOfDoors - 1);
//        System.out.println("playerChoice: " + playerChoice);

    }

    public boolean playAndSwitchDoor(){
        int revealedDoor;
//        Генерируется случайное число revealedDoor, которое представляет собой номер двери,
//        которую Монти Холл открывает, чтобы показать игроку, что за ней нет приза. При этом
//        генерируется число до тех пор, пока revealedDoor не станет отличным от позиции
//        автомобиля (carPosition) и выбора игрока (playerChoice), чтобы Монти не открыл дверь с
//        автомобилем и не открыл дверь, за которой уже стоит игрок.
        do{revealedDoor = randomDataGenerator.nextInt(0, numberOfDoors - 1);
//            System.out.println("revealedDoor: " + revealedDoor);
        } while (revealedDoor == carPosition || revealedDoor == playerChoice);

        int newChose;
//        Генерируется новый выбор игрока newChoice, представляющий дверь, за которой игрок
//        решает переключиться после того, как Монти открыл одну из дверей. При этом также
//        генерируется число до тех пор, пока newChoice не станет отличным от предыдущего выбора
//        игрока и открытой двери Монти.
        do{newChose = randomDataGenerator.nextInt(0, numberOfDoors - 1);
//            System.out.println("newChose: " + newChose);
        } while (newChose == playerChoice || newChose == revealedDoor);

        playerChoice = newChose;

        return playerChoice == carPosition;

    }
}


