package Sem6_HW;


import java.util.HashMap;
import java.util.Map;

public class Main {
    private static  final int numOfSimulator = 1000;

    public static void main(String[] args) {
        Map<Boolean, Integer> result = new HashMap<>();
        result.put(true,0); //win
        result.put(false, 0); //lost

        for (int i = 0; i < numOfSimulator; i++) {
            MontyHallGame game = new MontyHallGame(3);
            boolean win = game.playAndSwitchDoor();
            result.put(win, result.get(win)+1);
        }

        System.out.printf("Result after %s simulations: \n", numOfSimulator);
        System.out.printf("Wins: %s \n", result.get(true));
        System.out.printf("Losses: %s \n", result.get(false));
    }
}
