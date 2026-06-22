package br.com.jogos;

/**
  Practicing bidirectional association
 */
public class App {
    public static void main(String[] args) {        
        Game match1 = new Game(3, 3);
        Player player1 = new Player("Matheus");
        Player player2 = new Player("Ana");

        player1.setGame(match1);
        player2.setGame(match1);
        match1.listPlayers();
        player1.play();
    }
}
