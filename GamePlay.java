//Import Scanner library for input/outputs
import java.util.Scanner;

//Main Class for the game
//Gameplay class Start

public class GamePlay {
    private Person player;
    private Numbers randomNumber;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay game = new GamePlay();

        game.randomNumber = new Numbers();
        game.randomNumber.generateNumber();

        System.out.print("What is your first name? ");
        String firstName = sc.nextLine();
