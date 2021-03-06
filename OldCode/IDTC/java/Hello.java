package Hello;
import java.io.*;
import java.util.*;

public class Hello{
    public static void main(String args[]) throws IOException, InterruptedException{
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Would you like to play a game? (yes or no)");
        String player1answer = keyboard.readLine();
        if(player1answer.equals("yes")){
            System.out.println("\nWhat is Player 1's name?");
            String player1 = keyboard.readLine();
            System.out.println("Hello " + player1 + ".\nWhat is Player 2's name?");
            String player2 = keyboard.readLine();
            System.out.println("Hello " + player2 + ".");

            String player1side = "";
            String player2side = "";
            while(1 == 1){
                System.out.println("\n" + player1 + ", pick heads or tails.");
                player1side = keyboard.readLine();
                System.out.println("\n" + player1 + " picked " + player1side + ".");

                if(player1side.equals("heads")){
                    player2side = "tails";
                    System.out.println(player2 + " gets tails.");
                    break;

                }else if(player1side.equals("tails")){
                    player2side = "heads";
                    System.out.println(player2 + " gets heads.");
                    break;

                }else{
                    System.out.println("You must pick heads or tails.");
                }
            }

            int player1totalwins = 0;
            int player2totalwins = 0;
            Random numbermaker = new Random();
            while(player1totalwins < 5 && player2totalwins < 5){
                int player1score = 0;
                int player2score = 0;

                System.out.println("\nHow many tosses?");
                String input = keyboard.readLine();
                int numberOfTosses = Integer.parseInt(input);

                for(int toss = 0; toss < numberOfTosses; toss++){
                    Thread.sleep(0);

                    if(numbermaker.nextDouble() < .5){
                        System.out.println(player1side + ". " + player1 + " gains a point.");
                        player1score = player1score + 1;

                    }else{
                        System.out.println(player2side + ". " + player2 + " gains a point.");
                        player2score = player2score + 1;
                    }
                }
                System.out.println(player1 + " Score = " + player1score);
                System.out.println(player2 + " Score = " + player2score);
                if(player1score == player2score){
                    System.out.println("It's a tie.");

                }else if(player1score > player2score){
                    System.out.println(player1 + " WINS!");
                    player1totalwins = player1totalwins + 1;

                }else{
                    System.out.println(player2 + " WINS!");
                    player2totalwins = player2totalwins + 1;
                }
                System.out.println(player1 + "s Total Wins = " + player1totalwins);
                System.out.println(player2 + "s Total Wins = " + player2totalwins);

                if(player1totalwins == 5){
                    System.out.println(player1 + " IS THE CHAMPION!");

                }else if(player2totalwins == 5){
                    System.out.println(player2 + " IS THE CHAMPION!");

                }else{
                    System.out.println("Press enter to start the flips again.");
                    keyboard.readLine();
                }
            }

        }else{
            System.out.println("\nFine.");
        }
    }
}
