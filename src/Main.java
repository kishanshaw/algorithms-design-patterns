import java.util.logging.Level;
import java.util.logging.Logger;
import algorithms.dynamicprogramming.GameOptimalStrategy;

public class Main {

    static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        GameOptimalStrategy gameOptimalStrategy = new GameOptimalStrategy();
        int[] arr = new int[] { 20, 5, 4, 6 };
        logger.log(Level.INFO, "Max points : {0}", gameOptimalStrategy.getMaximumPoints(arr));
    }

}
