package model;

/**
 * @author Sara
 */
public class Coin {
    public int[] getChangeList() {
        return changeList;
    }

    private final int[] changeList = {1, 2, 5, 10, 20, 50, 100, 200};

    private final int changeListSize = changeList.length;

    /**
     *
     * @return returns the list of the coins we have.
     */
    public int getChangeListSize() {
        return changeListSize;
    }

    /**
     *
     * @param index The index of a required coin from the changeList
     * @return Given an index, this method returns the coin of that index from the changeList
     */
    public int getChangeListCoinByIndex(int index) {
        return changeList[index];
    }
}
