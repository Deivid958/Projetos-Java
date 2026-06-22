package br.com.jogos;
import java.util.Vector;
public class Game {
    private  Vector<Player> players = new Vector<>();
    private int lengthSize;
    private int heigthSize;
    private char[][] table;

    public Game( int lengthSize, int heigthSize) {
        table = new char[heigthSize][lengthSize];
        for(int i = 0;i < table.length;i++){
            for(int j = 0;j < table[i].length;j++){
                table[i][j] = ' ';
            }
        }
    }

    public char[][] getTable() {
        return table;
    }
    
    public void setTable(int line, int column, char simbol) {
        table[line][column] = simbol;
    }
    public int getHeigthSize() {
        return heigthSize;
    }
    public int getLengthSize() {
        return lengthSize;
    }
    public void setHeigthSize(int heigthSize) {
        this.heigthSize = heigthSize;
    }
    public void setLengthSize(int lengthSize) {
        this.lengthSize = lengthSize;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void listPlayers() {
        for(int i = 0;i < players.size();i++){
            System.out.println(players.elementAt(i).getName());
        }
    }   
}
