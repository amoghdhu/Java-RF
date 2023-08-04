package CH1.GuessingGame;
// In this class I will make a class to make players

public class PlayerClass {
    int number = 0;
    public void makeGuess() {
        number = (int) (Math.random() * 2);
    }
}
