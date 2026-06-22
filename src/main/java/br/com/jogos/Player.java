package br.com.jogos;

public class Player {
    private Game game;
    private String name;
    private int playerNumber;
    private int globalNumber;
    private int point;
    private int line;
    private int column;

    public Player(String name) {
        this.name = name;
        globalNumber++;
        playerNumber = globalNumber;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
        game.addPlayer(this);
        line = game.getLengthSize();
        column = game.getHeigthSize();
    }

   public void play() {
      
    }
}
