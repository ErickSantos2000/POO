
public class Arqueiro extends Peca {

    public Arqueiro(int x, int y, int jogador){
        super("Arqueiro", "\uD83C\uDFF9", x, y, jogador);
    }

    @Override
    public boolean podeMoverPara(int novoY, int novoX) {
        int dx = novoX - getX(); // 3 - 4 = -1  1
        int dy = novoY - getY(); // 5 - 4 =  1 -1

        // verifica se o movimento é na diagonal
        if (dx == dy || dx == -dy){
            // verifica se diferença é de ate 2 movimentos
            if(dx >= -2 && dx <= 2){
                return true;
            }

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
