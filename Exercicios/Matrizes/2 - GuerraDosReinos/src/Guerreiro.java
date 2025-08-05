
public class Guerreiro extends Peca{
    public Guerreiro(int x, int y, int jogador){
        super("Guerreiro", "🔪", x, y, jogador);
    }

    @Override
    public boolean podeMoverPara(int novoY, int novoX) {
        int dx = novoX - getX();
        int dy = novoY - getY();

        // verifaca se a diferença no movimento é de ate para x e y
        if (dx == 0 && (dy >= -3 && dy <= 3)) {
            return true; // movimento vertical
        }
        if (dy == 0 && (dx >= -3 && dx <= 3)) {
            return true; // movimento horizontal
        }
        return false;
    }


    public void moverPara(int novoY, int novoX) {
        super.moverPara(novoY, novoX);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }
}
