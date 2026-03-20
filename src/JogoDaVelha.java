import java.util.Scanner;
public class JogoDaVelha {
    char[][] jogo;
    private Scanner scan = new Scanner(System.in);
    private int count;
    private int linha;
    private int coluna;

    private void inicalizarValores(){
        for(int i = 0;i < jogo.length;i++){
            for(int j = 0;j < jogo[i].length;j++){
                jogo[i][j] = ' ';
            }
        }
    }

    public void mostrarJogo(){
        for(int i = 0;i < jogo.length;i++){
            System.out.print("\t\t" + (i+1) );
        }
        System.out.print("\n\n");
        for(int i = 0;i < jogo.length;i++){
            System.out.print((i+1) + "\t");
            for(int j = 0;j < jogo[i].length;j++){
                System.out.print("\t" + jogo[i][j] + "\t");
                if(j+1 != jogo.length){
                    System.out.print("|");
                }
            }
            System.out.println("");
            if(i+1 < jogo.length){
                System.out.print("\t");
                for(int j = 0;j < jogo.length*16;j++){
                    System.out.print("_");
                }
            }
            System.out.print("\n\n");
        }
    }

    public void adicionar(int jogador){
        System.out.println("Jogador " + jogador + ":");
        linha = testarTipoInt();
        coluna = testarTipoInt();
        linha--;
        coluna--;
        testarPosicao();
        testarAdicionar();
        System.out.println("");
        if(jogador == 1){
            jogo[linha][coluna] = 'X';
        } else {
            jogo[linha][coluna] = 'O';
        }
    }

    public int procurarGanhador(){
        //0 sem resultado| 1 ganha | 2 empata
        int i = 0;
        int j = 0;
        boolean empate = true;
        int resultado = 0;

        if(count == 0){
            count++;
            inicalizarValores();
        }

        if (jogo[0][0] == jogo[1][1] && jogo[0][0] == jogo[2][2] && jogo[0][0] != ' '){
            empate = false;
            resultado = 1;
        }
        else if (jogo[0][2] == jogo[1][1] && jogo[1][j] ==jogo[2][0] && jogo[0][2] != ' '){
            empate = false;
            resultado = 1;
        }
        else {
            for(i = 0;i < jogo.length; i++){
                if (jogo[i][j] == ' ' || jogo[i][j+1] == ' ' || jogo[i][j+2] == ' '){
                    empate = false;
                }
                if (jogo[i][j] == jogo[i][j+1] && jogo[i][j] ==jogo[i][j+2] && jogo[i][j] != ' '){
                    resultado = 1;
                    break;
                }
                else if (jogo[j][i] == jogo[j+1][i] && jogo[j][i] == jogo[j+2][i] && jogo[j][i] != ' '){                    
                    resultado = 1;
                    break;
                }
            }
        }

        if (resultado != 1){
            if (empate){
                fecharScan();
                return 2;
            }
            else {
                return 0;
            }
        }
        else {
            fecharScan();
            return 1;
        }
    }

    private void testarAdicionar(){
        while(jogo[linha][coluna] != ' '){
            System.out.println("Essa posição já foi escolhida");
            mostrarJogo();
            linha = testarTipoInt();
            coluna = testarTipoInt();
            linha--;
            coluna--;
            testarPosicao();
        }
    }

    private void testarPosicao(){
        while((linha < 0 || linha >= jogo.length) || (coluna < 0 || coluna >= jogo.length)){
            System.out.println("Essa posição é invalida");
            mostrarJogo();
            linha = testarTipoInt();
            coluna = testarTipoInt();
            linha--;
            coluna--;
        }
    }

    private int testarTipoInt(){
        while(!scan.hasNextInt()){
            System.out.println("Digite um número");
            scan.next();
        }
        return scan.nextInt();
    }

    private void fecharScan(){
        scan.close();
    }
}
