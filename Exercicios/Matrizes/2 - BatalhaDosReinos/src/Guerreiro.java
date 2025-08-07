
public class Guerreiro extends Peca{
    public Guerreiro(int x, int y){
        super("Guerreiro", "🔪", x, y);
    }

    @Override
    public boolean podeMoverPara(int novoY, int novoX) {
        int dx = novoX - getX();
        int dy = novoY - getY();

        // verifaca se a diferença no movimento é de ate 3 para x e y
        if (dx == 0 && (dy >= -3 && dy <= 3)) {
            return true; // movimento vertical
        }
        if (dy == 0 && (dx >= -3 && dx <= 3)) {
            return true; // movimento horizontal
        }
        return false;
    }

    // gets
    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getSimbolo() {
        return super.getSimbolo();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    
    // sets
    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setSimbolo(String simbolo) {
        super.setSimbolo(simbolo);
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }
}
