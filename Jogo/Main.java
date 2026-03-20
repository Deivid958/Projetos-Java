public class Main{
   public static void main(String[] args) {        
        JogoDaVelha p = new JogoDaVelha();
        p.jogo = new char[3][3];
        int jogador = 2;

        
        while(p.procurarGanhador() == 0){
            p.mostrarJogo();
            jogador = (jogador == 2) ? 1:2;        
            p.adicionar(jogador);
        }
        p.mostrarJogo();
        if(p.procurarGanhador() == 1){
            System.out.println("Jogador " + jogador + " ganhou");
        } else {
            System.out.println("Empate");
        }
    }    
}