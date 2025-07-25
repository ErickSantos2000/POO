public class Armadilha extends ElementoTabuleiro {
    public void interagir(Jogador jogador) {
        jogador.atualizarPontos(-2);
        
    }
    public String simbolo() { return "💣"; }
}

