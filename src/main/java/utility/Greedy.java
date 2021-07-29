package utility;

import model.Coin;

import java.util.ArrayList;
import java.util.List;

public class Greedy extends Algorithm {

    Coin coin = new Coin();

    public List<Integer> getMinimumNumberOfCoins(int amount) {
        List<Integer> result = new ArrayList<>();
        for (int i = coin.getChangeListSize() - 1; i >= 0; i--) {
            while (amount >= coin.getChangeListCoinByIndex(i)) {
                amount -= coin.getChangeListCoinByIndex(i);
                result.add(coin.getChangeListCoinByIndex(i));
            }
        }
        return result;
    }

    public int[] getCoinList() {
        return coin.getChangeList();
    }

}
