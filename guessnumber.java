import java.util.Random;
import java.util.Scanner;

public class GuessNumber { // as always.

    public static void main(String[] args){

        System.out.println("Choose a range:");
        Scanner s = new Scanner(System.in);
        String r = s.nextLine();
        Integer range = Integer.parseInt(r);
        Random randomizer = new Random(); // use single randomizer

        while (true) {
            int rand = randomizer.nextInt(range);
            System.out.println("New Game Started. You have 10 guesses");
            for (int i = 0; i < 10; i++) {
                System.out.println("Guess:");
                String ans = s.nextLine();
                int answer = Integer.parseInt(ans);

                if (answer == rand) {
                    System.out.println("You guessed right! You win!!!");
                    s.close(); // always close before exiting.
                    break;
                } else if (answer < rand){
                    System.out.println("Your guess is smaller than answer. Sorry.");
                } else if (answer > rand){
                    System.out.println("Your guess is greater than answer. Sorry.");
                }
            }
            System.out.println("The random number was " + rand);
        }

    }
}
