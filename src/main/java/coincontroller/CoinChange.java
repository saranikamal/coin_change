package coincontroller;

import utility.Greedy;
import utility.InputOutput;

import java.util.List;

public class CoinChange {
    private final InputOutput inputOutput = new InputOutput();
    private Greedy algo = new Greedy();


    public void runProgram() {
        int input;
        List<Integer> minimumNumberOfCoins;
        while (true) {
            input = inputOutput.getInput();
            minimumNumberOfCoins = algo.getMinimumNumberOfCoins(input);
            inputOutput.showOutput(minimumNumberOfCoins, algo.getCoinList());
        }
    }
}
