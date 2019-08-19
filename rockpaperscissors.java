import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors { // you know by now.
    public static void main(String[] args){
        String[] answers = {"Rock","Paper","Scissors"};
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        while (true) {
            System.out.println("0 - Rock, 1 - Paper, 2 - Scissors"); //specify how a user can exit.

            // suggestion: use humanAnswer and computerAnswer for var. names
            int answer = s.nextInt(); // use nextInt instead of nextLine->parseInt
            int computer = r.nextInt(3);

            if (answer == computer){
                System.out.println("You both chose " + answers[answerInt]);
            } else if ((answer + 1) % 3 == computer) { // nice RPS checker.
                System.out.println("Computer chose " + answers[computer] + ". Computer Wins");
            } else if ((answer + -1) % 3 == computer) {
                System.out.println("Computer chose " + answers[computer] + ". You Win");
            } else {
                s.close();
                break;
            }
        }
    }
}
