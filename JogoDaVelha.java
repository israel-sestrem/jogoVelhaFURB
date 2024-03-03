import java.util.Scanner;

public class JogoDaVelha {

    private static JogoDaVelha_Mapa jogoMapa;
    private static JogoDaVelha_PC jogoPC;
    private static JogoDaVelha_Jogador jogoJogador;

    private static void jogar(Scanner teclado){
        jogoMapa.limpaMapa();

        int numeroSorteado = jogoMapa.sortear(0,1);

        boolean vezJogador = numeroSorteado == 0;
        int numeroJogadas = 0;
        boolean ganhouOuEmpatou;

        jogoMapa.desenha(numeroJogadas);

        for(int i=0; i<9; i++){
            numeroJogadas++;
            if(vezJogador) {
                ganhouOuEmpatou = jogoJogador.joga(teclado);
                jogoMapa.desenha(numeroJogadas);
            } else {
                ganhouOuEmpatou = jogoPC.joga();
                jogoMapa.desenha(numeroJogadas);
            }

            if(ganhouOuEmpatou){
                break;
            }

            vezJogador = !vezJogador;
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        jogoMapa = new JogoDaVelha_Mapa();
        jogoPC = new JogoDaVelha_PC(jogoMapa);
        jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

        String resposta;

        do {
            jogar(teclado);

            System.out.println();
            System.out.println("________________________");
            System.out.println("Deseja jogar novamente (s/n)?");
            resposta = teclado.nextLine();

            while(!resposta.equals("s") && !resposta.equals("n")){
                System.out.println("As opções válidas são 's' ou 'n'");
                resposta = teclado.nextLine();
            }
        } while(resposta.equals("s"));

        System.out.println("--- FIM ---");
    }

}
