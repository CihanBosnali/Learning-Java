import java.util.Scanner;
import java.util.Random;

public class rockpaperscissors {
    public static void main(String[] args){
        String[] answers = {"Rock","Paper","Scissors"};

        while (true) {
            System.out.println("0 - Rock, 1 - Paper, 2 - Scissors");
            Scanner s = new Scanner(System.in);

            String answer = s.nextLine();
            Integer answerInt = Integer.parseInt(answer);

            Integer computer =  new Random().nextInt(3);

            if (answerInt.equals(computer)){
                System.out.println("You both chose " + answers[answerInt]);
            } else if ((answerInt + 1) % 3 == computer) {
                System.out.println("Computer chose " + answers[computer] + ". Computer Wins");
            } else if ((answerInt + -1) % 3 == computer) {
                System.out.println("Computer chose " + answers[computer] + ". You Win");
            } else {
                break;
            }
        }
    }
}
