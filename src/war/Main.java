//@authors Alex Csorba and Julian Powell
package war;
import java.io.PrintStream;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        PrintStream output = new PrintStream(out);
        ConsoleInterface consoleInterface = new ConsoleInterface(output);

        int seed = Integer.parseInt(args[0]);

        War warGame = new War(seed, consoleInterface);

        warGame.playGame();
    }
}