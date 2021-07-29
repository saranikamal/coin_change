package utility;

import model.Coin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sara
 */
public class Greedy extends Algorithm {

    Coin coin = new Coin();

    /**
     * @param amount The amount of money the user enters
     * @return Returns the minimum number of coins (denominations).
     */
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

    /**
     * @return Returns the list of the coins we have
     */
    public int[] getCoinList() {
        return coin.getChangeList();
    }

}
