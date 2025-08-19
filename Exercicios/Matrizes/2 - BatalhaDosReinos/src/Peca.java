import java.io.*;

public abstract class Peca implements Serializable {
    private String nome;
    private String simbolo;
    private int y;
    private int x;
    private static final long serialVersionUID = 1L;


    public Peca(String nome, String simbolo, int y, int x){
        this.nome = nome;
        this.simbolo = simbolo;
        this.y = y;
        this.x = x;
    }

    public abstract boolean podeMoverPara(int novoY, int novoX);

    public void moverPara(int novoY, int novoX) {
        this.x = novoX;
        this.y = novoY;
    }

    public String getNome() {
        return nome;
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

