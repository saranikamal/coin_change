package utility;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Sara
 * Test cases to check the functionality of the greedy algorithm we have used to get the minimum number of coins.
 */
class GreedyTest {

    private Algorithm greedy = new Greedy();

    @Test
    void getMinimumNumberOfCoinsTestOne() {
        int amount = 123;
        List<Integer> minimumNumberOfCoins = greedy.getMinimumNumberOfCoins(amount);
        assertEquals(4,minimumNumberOfCoins.size());
    }

    @Test
    void getMinimumNumberOfCoinsTestTwo() {
        int amount = 2;
        List<Integer> minimumNumberOfCoins = greedy.getMinimumNumberOfCoins(amount);
        assertEquals(1,minimumNumberOfCoins.size());
    }

    @Test
    void getMinimumNumberOfCoinsTestThree() {
        int amount = 300;
        List<Integer> minimumNumberOfCoins = greedy.getMinimumNumberOfCoins(amount);
        assertEquals(2,minimumNumberOfCoins.size());
    }
}