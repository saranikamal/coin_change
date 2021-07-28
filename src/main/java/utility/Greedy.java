package utility;

import entity.Coin;

import java.util.ArrayList;
import java.util.List;

public class Greedy implements Algorithm {

    Coin coin = new Coin();

    @Override
    public List<Integer> getMinimumNumberOfCoins(int amount) {
        List<Integer> result = new ArrayList<>();
        for (int i = coin.getChangeListSize() - 1; i >= 0; i--) {
            while (amount >= coin.getChangeListICoinByIndex(i)) {
                amount -= coin.getChangeListICoinByIndex(i);
                result.add(coin.getChangeListICoinByIndex(i));
            }
        }
        return result;
    }
}
