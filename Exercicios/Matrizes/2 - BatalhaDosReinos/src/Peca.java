public abstract class Peca {
    private String nome;
    private String simbolo;
    private int y;
    private int x;
    private int jogador;

    public Peca(String nome, String simbolo, int y, int x, int jogador){
        this.nome = nome;
        this.simbolo = simbolo;
        this.y = y;
        this.x = x;
        this.jogador = jogador;
    }

    public abstract boolean podeMoverPara(int novoY, int novoX);

    public void moverPara(int novoY, int novoX) {
        this.x = novoX;
        this.y = novoY;
    }

    public String getNome() {
        return nome;
    }

    public int getJogador() {
        return jogador;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public String getSimbolo() {
        return simbolo;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

