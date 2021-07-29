package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Sara
 */
class CoinTest {
    private final Coin coin = new Coin();

    @Test
    void getChangeListSize() {
      int size = coin.getChangeListSize();
      assertEquals(8,size);
    }

    @Test
    void getChangeListCoinByIndex() {
      int coinAtIndex = coin.getChangeListCoinByIndex(5);
      assertEquals(50,coinAtIndex);
    }
}