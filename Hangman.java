import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Hangman {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean play = true;
        while(play) {
            //Greeting
            System.out.println("Howdy! Welcome to Hangman!");
            System.out.println("Can you guess the word? You have 6 tries!");
            //Game
            boolean game = true;
            int tries = 6;
            String word = "";
            List<Character> guessedLetters = new ArrayList<Character>();
            try {
                word = Game.getWord();
            } catch(Exception e) {
                System.out.println("Game failed to load.");
                game = false;
            }
            while(game) {
                Game.printGallows(tries);
                String lines = "";
                int numCorrectLetters = 0;
                for (int i = 0; i < word.length(); i++){
                    boolean hasBeenGuessed = false;
                    for (char elem : guessedLetters) {
                        if (elem == word.charAt(i)) {
                            hasBeenGuessed = true;
                            numCorrectLetters = numCorrectLetters + 1;
                        }
                    }
                    if (hasBeenGuessed) {
                        System.out.print(word.charAt(i) + " ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println(lines);
                String guesses = "";
                for (int i = 0; i < guessedLetters.size(); i++){
                    guesses = guesses + guessedLetters.get(i) + " ";
                }
                char guessedLetter;
                System.out.println("Guess a letter! Letters you have guessed: " + guesses);
                guessedLetter = Character.toUpperCase(input.nextLine().charAt(0));
                while (guessedLetters.contains(guessedLetter)){
                    System.out.println("You already guessed that, silly. Try again! Letters you have guessed: " + guesses);
                    guessedLetter = Character.toUpperCase(input.nextLine().charAt(0));
                }
                guessedLetters.add(guessedLetter);
                if (word.indexOf(guessedLetter) == -1) {
                    tries = tries - 1;
                }
                if (tries == 0 || numCorrectLetters == word.length() - 1) {
                    System.out.println("You've been hanged, partner!");
                    game = false;
                }
            }
            System.out.println("The word was: " + word);
            //Ask for repeat play
            System.out.println("Play again? Y / N");
            String response = input.nextLine();
            while (!response.equals("N") && !response.equals("Y")){
                System.out.println("That's not a valid response, ya goose! Type 'Y' or 'N'.");
                response = input.nextLine();
            }
            if (response.equals("N")) {
                play = false;
            }
        }
        input.close();
    }
}