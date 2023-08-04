package CH1.GuessingGame;

// This class is where all the functions occur
public class GuessingGame {
    PlayerClass playerOne;
    PlayerClass playerTwo;
    PlayerClass playerThree;

    public void startGame(){
        playerOne = new PlayerClass();
        playerTwo = new PlayerClass();
        playerThree = new PlayerClass();

        int playerOneGuess = 0;
        int playerTwoGuess = 0;
        int playerThreeGuess = 0;

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 2);
        System.out.println("The computer has generated a random number between 0 and 9.");
        System.out.println("The random number should be: " + targetNumber + "\n");

        while (true) {

            playerOne.makeGuess();
            playerTwo.makeGuess();
            playerThree.makeGuess();

            playerOneGuess = playerOne.number;
            System.out.println("\tPlayer 1 has guessed: " + playerOneGuess);

            playerTwoGuess = playerTwo.number;
            System.out.println("\tPlayer 2 has guessed: " + playerTwoGuess);

            playerThreeGuess = playerThree.number;
            System.out.println("\tPlayer 3 has guessed: " + playerThreeGuess + "\n");

            if (playerOneGuess == targetNumber) {
                p1isRight = true;
                System.out.println("Player 1 has guessed the targeted number!");
            }
            if (playerTwoGuess == targetNumber) {
                p2isRight = true;
                System.out.println("Player 2 has guessed the targeted number!");
            }
            if (playerThreeGuess == targetNumber) {
                p3isRight = true;
                System.out.println("Player 3 has guessed the targeted number!");
            }

            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("We have a winner!");
                System.out.println("Game is over.");
                break;
            }
            else {
                System.out.println("All players have answered incorrectly.\n");
            }

        }
    }

}
