public class JogoDaVelha_PC {

    private final JogoDaVelha_Mapa mapa;
    private final char letra;

    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
        this.letra = 'O';
    }

    public boolean joga (){
        int linha;
        int coluna;
        boolean jogou;

        do{
            linha = mapa.sortear(0,2);
            coluna = mapa.sortear(0,2);

            jogou = mapa.jogar(linha, coluna, letra);
        } while (!jogou);

        System.out.println("PC[" + linha + "," + coluna + "]");

        return mapa.ganhou(letra);
    }

}
