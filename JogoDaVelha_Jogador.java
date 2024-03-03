import java.util.Scanner;

public class JogoDaVelha_Jogador {

    private final JogoDaVelha_Mapa mapa;
    private final char letra;

    public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
        this.letra = 'X';
    }

    public boolean joga (Scanner teclado){
        String linha;
        String coluna;
        boolean jogou;

        do{
            System.out.println("Jogador ..");

            System.out.println("  linha: ");
            linha = teclado.nextLine();

            while(!linha.equals("0") && !linha.equals("1") && !linha.equals("2")){
                System.out.println("  As opções válidas são: 0, 1 e 2");
                linha = teclado.nextLine();
            }

            System.out.println("  coluna: ");
            coluna = teclado.nextLine();

            while(!coluna.equals("0") && !coluna.equals("1") && !coluna.equals("2")){
                System.out.println("  As opções válidas são: 0, 1 e 2");
                coluna = teclado.nextLine();
            }

            jogou = mapa.jogar(Integer.parseInt(linha), Integer.parseInt(coluna), letra);
        } while (!jogou);

        return mapa.ganhou(letra);
    }

}
