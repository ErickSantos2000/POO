public class Vazio extends ElementoTabuleiro {
    public void interagir(Jogador jogador) {
        jogador.atualizarPontos(0);
    }
    public String simbolo() { return "⬜"; }
}


