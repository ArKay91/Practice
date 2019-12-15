package coingame;

public class Coin{

    private String coinOption= "";
    public String[] conValue = {"Heads", "Tails"};
    
    Coin(){
        int randNumber = (Math.random() < 0.5) ? 0 : 1;
        coinOption = coinValue[randNumber];
    }

    public String getCoinOption(){
        return coinOption;
    }
}