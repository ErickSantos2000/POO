public class Cavaleiro extends Peca{


        public Cavaleiro(int x, int y, int jogador){
            super("Cavaleiro", "\uD83D\uDC34", x, y, jogador);
        }

        @Override
        
        public boolean podeMoverPara(int novoY, int novoX) {
            int dx = novoX - getX();
            int dy = novoY - getY();

            // checa todas as posições em L
            if ((dx == 1 || dx == -1) && (dy == 2 || dy == -2)) {
                return true;
            }
            if ((dx == 2 || dx == -2) && (dy == 1 || dy == -1)) {
                return true;
            }

            return false;
        }

        public void moverPara(int novoY, int novoX) {
            super.moverPara(novoY, novoX);
        }

        public String getNome() {
            return super.getNome();
        }
}