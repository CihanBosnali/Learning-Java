import java.util.Random;
import java.util.Scanner;

public class guessnumber {

    public static void main(String[] args){

        System.out.println("Choose a range:");
        Scanner s = new Scanner(System.in);
        String r = s.nextLine();
        Integer range = Integer.parseInt(r);

        while (true){
            Integer rand = new Random().nextInt(range);
            System.out.println("New Game Started. You have 10 guesses");
            for (int i = 0; i < 10; i++) {
                System.out.println("Guess:");
                Scanner scan = new Scanner(System.in);
                String ans = scan.nextLine();
                Integer answer = Integer.parseInt(ans);

                if (answer.equals(rand)){
                    System.out.println("You guessed right! You win!!!");
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
