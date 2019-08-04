import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class shipgame {

    public static void main(String[] args){
        String[] alphabet = {"A", "B", "C", "D", "E", "F"};

        Integer[][] map = initmap();
        Integer[][] knownmap = {{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0},
                                {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};

        System.out.println("Welcome to the bridge Admiral! \nWe detected enemy ships nearby.");
        System.out.println("Our radar cannot find their locations. We must randomly attack. We only have 10 missiles");
        System.out.println("To attack write down the attacking position. First latter, than number. Eg: E3.\n");

        for (int i = 0; i < 10; i++) {
            printMap(knownmap, alphabet);

            System.out.println("Attack:");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine().toUpperCase();

            Integer locY = Arrays.asList(alphabet).indexOf(Character.toString(s.charAt(0)));
            Integer locX = Integer.parseInt(Character.toString(s.charAt(1))) -1;

            Integer attackLoc = map[locY][locX];
            if (attackLoc.equals(1)){
                knownmap[locY][locX] = 1;
                System.out.println("Enemy ship is shot. It sinks!");
            } else {
                knownmap[locY][locX] = 2;
                System.out.println("We missed!");
            }
        }

        System.out.println("We need to escape now admiral. Sorry. Enemy Locations were:");
        printMap(map, alphabet);

    }


    public static Integer[][] initmap(){
        Integer[][] map =  {{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};

        for (int i = 0; i < 6; i++) {
            Integer randX = new Random().nextInt(6);
            Integer randY = new Random().nextInt(6);
            map[randY][randX] = 1;
        }

        return map;
    }

    public static void printMap(Integer[][] knownMap, String[] alphabet){
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
