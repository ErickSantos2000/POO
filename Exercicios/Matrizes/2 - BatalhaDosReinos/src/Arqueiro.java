
public class Arqueiro extends Peca {

    public Arqueiro(int x, int y){
        super("Arqueiro", "\uD83C\uDFF9", x, y);
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
