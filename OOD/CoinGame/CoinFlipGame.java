
package coingame;

public class CoinFlipGame{
    public static void main(String[] args){
        CoinFlip theCoinGame = new CoinFlip("Karthik", "Himanka");
        String usersAnswers;
        do{
            theCoinGame.startGame();
            System.out.println("Play Again ?");

            Scanner playGameAgain  = new Scanner(System.in);
            usersAnswers = playGameAgain.nextLine();    
        }while((usersAnswers.startsWith("y") || usersAnswers.startsWith("Y")));
    }
}