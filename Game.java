import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class Game {
    public static String getWord() throws FileNotFoundException {
        Scanner s = new Scanner(new File("sowpods.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        Random rand = new Random();
        String word = list.get(rand.nextInt(list.size()));
        return word;
    }

    public static void printGallows(int tries){
        System.out.println("    _____  ");
        System.out.println("    |    | ");
        if (tries < 6) {
            System.out.println("    O    |");
        } else {
            System.out.println("         | ");
        }
        if (tries < 3) {
            System.out.println("   /|\\   | ");
        } else if (tries < 4) {
            System.out.println("   /|    | ");
        } else if (tries < 5) {
            System.out.println("    |    | ");
        } else {
            System.out.println("         | ");
        }
        if (tries == 1) {
            System.out.println("   /     | ");
        } else if (tries == 0) {
            System.out.println("   / \\   | ");
        } else {
            System.out.println("         | ");
        }
        System.out.println("       ----- ");
    }
}
