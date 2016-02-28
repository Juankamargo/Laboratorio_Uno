/*
 * 
 *The program generates a number between 1-100, a then the user must guess the number 
 */


/**
 *
 * @author Juan Carlos Camargo Lizarazo
 */
public class DF4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Scanner read = new java.util.Scanner(System.in);
        
        String playAgain = "y";
        while(playAgain.equals("y"))
        {
            GuessingGame();
            System.out.println("Would you like to play another game(y/n) ");
            playAgain= read.nextLine();
        }
        
        
        // TODO code application logic here
    }

    private static void GuessingGame()
    {
        java.util.Scanner read = new java.util.Scanner(System.in);
        int answer = (int) Math.floor((Math.random()*100)+1);
        int guess = 0, numGuesses = 1;
        while (numGuesses<=7 && guess!=answer)
        {
            System.out.println("Give it a try :)  ");
            guess = read.nextInt();
            if (guess<answer)
                System.out.println("Higher boy.... aim higher  ");
            else 
                if(guess>answer)
                    System.out.println("Lower boy.... ur too excited  ");
                else
                    System.out.println("U Win!! Damn ur good at this, c'mon, let's do it again, I promise I´ll beat you next time");
            numGuesses++;
        }
        if(numGuesses>7)
            System.out.println("Ur out of chances, it was pretty easy, can´t believe u couldn´t do it, anyways, u can always try again :)   ");
        
        
        
    }
}
