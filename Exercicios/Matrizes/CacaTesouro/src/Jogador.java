public class Jogador {
    private int linha, coluna;
    private int pontos;
    private int movimentos;

    public Jogador() {
        this.linha = 0;
        this.coluna = 0;
        this.pontos = 0;
        this.movimentos = 0;
    }

    public int getLinha() { return linha; }
    public int getColuna() { return coluna; }
    public int getPontos() { return pontos; }
    public int getMovimentos() { return movimentos; }

    public void mover(char direcao) {
        switch (Character.toUpperCase(direcao)) {
            case 'W': if (linha > 0) linha--; break;
            case 'S': if (linha < 5) linha++; break;
            case 'A': if (coluna > 0) coluna--; break;
            case 'D': if (coluna < 5) coluna++; break;
        }
        movimentos++;
    }

    public void atualizarPontos(int valor) {
        pontos += valor;
    }
}
