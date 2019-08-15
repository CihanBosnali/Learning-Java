// you can change all this to "java.util.*;", if you prefer.
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BattleshipGame { // always keep file name and class name same. use PascalCase for class name.

    public static void main(String[] args){
        String[] alphabet = {"A", "B", "C", "D", "E", "F"};

        // use primitives whenever you can. not mentioned in further edits.
        // note that for template (aka. container) types (eg. ArrayList<Integer>) you will have to use class types.
        int[][] map = initmap();

        // may be better to use nested for loop to initialize if you 
        // need to enter values but Java initializes integers to 0 by default.
        int[][] knownmap = new int[6][6];

        System.out.println("Welcome to the bridge Admiral! \nWe detected enemy ships nearby.");
        System.out.println("Our radar cannot find their locations. We must randomly attack. We only have 10 missiles");
        System.out.println("To attack write down the attacking position. First latter, than number. Eg: E3.\n");

        // reuse Scanner for all input
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            printMap(knownmap, alphabet);

            System.out.println("Enter attack:"); // make it clear user input is required.
            String s = scan.nextLine().toUpperCase();

            int locY = Arrays.asList(alphabet).indexOf(Character.toString(s.charAt(0)));
            int locX = Integer.parseInt(Character.toString(s.charAt(1))) -1;

            int attackLoc = map[locY][locX];
            // could use switch statement for conciseness.
            if (attackLoc == 1) { // use .equals() only for Class types.
                knownmap[locY][locX] = 1;
                System.out.println("Enemy ship is shot. It sinks!");
            } else if (attackLoc == 0) { // 
                knownmap[locY][locX] = 2;
                System.out.println("We missed!");
            } else if (attackLoc == 2) { // check for repeated input.
                System.out.println("We already shot there, please choose again.");
                i--; // slight hack to take input again.
                continue;
            }
        }

        // always close input.
        scan.close();

        System.out.println("We need to escape now admiral. Sorry. Enemy Locations were:");
        printMap(map, alphabet);

    }


    public static int[][] initmap(){
        Integer[][] map =  {{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};
        // initialize random object once
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            // points may overlap. to make sure, randomize until empty spot found
            int here = 1;
            int randX, randY;
            while (here == 1) {
                randX = rand.nextInt(6);
                randY = rand.nextInt(6);
                here = map[randX][randY];
            }
            map[randY][randX] = 1;
        }

        return map;
    }

    public static void printMap(int[][] knownMap, String[] alphabet){
        System.out.println("   1 2 3 4 5 6");

        for (int i = 0; i < 6; i++) {
            String newline = "";
            newline += alphabet[i];
            newline += " |";

            for (int j = 0; j < 6; j++) {
                if (knownMap[i][j].equals(0)){
                    newline += " |";
                } else if (knownMap[i][j].equals(1)){
                    newline += "X|";
                } else if (knownMap[i][j].equals(2)){
                    newline += "O|";
                }
            }

            System.out.println(newline);
        }
    }
}
