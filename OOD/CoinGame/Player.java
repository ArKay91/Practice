package coingame;

public class Player{
    private String name = "";
    private String coinOption = "";
    public String[] coinValue = {"Heads", "Tails"};

    Player(String newName){
        name = newName;
    }
    public String getCoinOption(){
        return coinOption;
    } 

    public void setCoinOption(String opponentFlip){
        coinOption = (opponentFlip == "Heads") ? "Tails" : "Heads";
    } 

    public String getRandCoinOption(){
        int randNumber = (Math.random() < 0.5) ? 0 : 1;
        coinOption = coinValue[randNumber];

        return coinValue[randNumber]; 
    }

    public void didPlayerWin(String winningFlip){
        if(coinOption == winningFlip){
            System.out.println(name + " won with a flip of " + coinOption);
        }else{
            System.out.println(name + " lost with a flip of " + coinOption);
        }
    }
}