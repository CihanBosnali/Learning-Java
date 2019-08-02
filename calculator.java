import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        while (true){
            System.out.println("Write your equation like: A operation B. eg: 1 + 2 . Operations are +,-,*,/");

            Scanner scan = new Scanner(System.in);
            String equation = scan.nextLine();
            String[] parts = equation.split(" ");
            Double first = Double.parseDouble(parts[0]);
            Double second = Double.parseDouble(parts[2]);

            Double end = 0.0;

            if (parts[1].equals("+")){
                end = first + second;
            } else if (parts[1].equals("-")) {
                end = first - second;
            } else if (parts[1].equals("*")) {
                end = first * second;
            } else if (parts[1].equals("/")) {
                end = first / second;
            } else {
                System.out.println("ERROR: you didn't write a valid equation");
                continue;
            }

            System.out.println(end);
        }
    }
}
