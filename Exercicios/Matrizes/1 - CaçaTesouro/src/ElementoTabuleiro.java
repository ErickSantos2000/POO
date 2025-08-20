import java.io.*;

public abstract class ElementoTabuleiro implements Serializable{
    private static final long serialVersionUID = 1L;
    public abstract void interagir(Jogador jogador);
    public abstract String simbolo();
    public abstract String simboloComJogador();
}
