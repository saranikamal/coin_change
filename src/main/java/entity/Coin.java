package entity;

public class Coin {
    private int[] changeList ={1, 2, 5, 10, 20, 50, 100, 200} ;

    private int changeListSize = changeList.length;

    public int getChangeListSize() {
        return changeListSize;
    }

    public int getChangeListICoinByIndex(int index) {
        return changeList[index];
    }
}
