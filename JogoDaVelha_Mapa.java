public class JogoDaVelha_Mapa {

    private final char[][] mapa = new char[3][3];

    public int sortear (int inicio, int fim){
        // método sortear feito pelo GPT, conforme dito no pdf que poderia pesquisar.
        long tempoAtual = System.currentTimeMillis();
        int seed = (int) (tempoAtual % Integer.MAX_VALUE);

        long multiplicador = 48271;
        long modulo = 2147483647;
        long offset = 0;
        long numeroSorteado;

        seed = (int) ((multiplicador * seed + offset) % modulo);

        numeroSorteado = inicio + (seed % (fim - inicio + 1));

        return (int) numeroSorteado;
    }

    public void limpaMapa(){
        for(int i=0; i< mapa.length; i++){
            for(int j=0; j< mapa[i].length; j++){
                mapa[i][j] = ' ';
            }
        }
    }

    public void desenha(int jogada){

        for (int i=0; i<3; i++) {
            if(i == 0){
                System.out.println("------------- .. jogada: " + jogada);
            } else {
                System.out.println("-------------");
            }
            System.out.print("| ");
            for (char Char : mapa[i]) {
                System.out.print(Char + " | ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public boolean jogar(int l, int c, char jogador){
        if(mapa[l][c] == ' '){
            mapa[l][c] = jogador;
            return true;
        }
        if(jogador == 'X') {
            System.out.println("Esta casa já se encontra ocupada!");
        }
        return false;
    }

    public boolean ganhou(char jogador){
        boolean retorno = false;

        for(int i=0; i<3; i++) {
            if ((mapa[i][0] == jogador && mapa[i][1] == jogador && mapa[i][2] == jogador) || (mapa[0][i] == jogador && mapa[1][i] == jogador && mapa[2][i] == jogador)) {
                retorno = true;
                break;
            }
        }

        if ((mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) || (mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador)){
            retorno = true;
        }

        if(retorno){
            if(jogador == 'O'){
                System.out.println("... PC GANHOU!");
            } else {
                System.out.println("... JOGADOR GANHOU!");
            }
            return retorno;
        }

        for (char[] chars : mapa) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    retorno = true;
                    break;
                }
            }
        }

        if(!retorno){
            System.out.println("... EMPATOU!");
        }

        return !retorno;
    }

}
