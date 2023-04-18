package war;

import java.io.PrintStream;

public class ConsoleInterface {
    private PrintStream output;
    public ConsoleInterface(java.io.PrintStream outputPrinter){
        output = outputPrinter;
    }

    public void newGame(){
        output.println("A new game has started");
    }
    public void displayPostBattleScores(int player1Score, int player2Score){
        output.println("Scores => P1: "+player1Score+"\tP2: "+player2Score);
    }

    public void displaySingleCardBattle(Card p1Card, Card p2Card){
        output.println(p1Card+"\t"+p2Card);
    }

    public void displayWar(int p1CardsPlayed, Card p1FaceUp, int p2CardsPlayed, Card p2FaceUp){
        for(int i=0; i< p1CardsPlayed;++i) {
            output.println("X\tX");
        }
        output.println(p1FaceUp+"\t"+p2FaceUp);
    }

    public void displayGameOver(int player1Score, int player2Score){
        output.println("Game Over!!!");
        output.println("Scores => P1: "+player1Score+"\tP2: "+player2Score);
    }
}
