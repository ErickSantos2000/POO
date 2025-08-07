public class Cavaleiro extends Peca{


        public Cavaleiro(int x, int y){
            super("Cavaleiro", "\uD83D\uDC34", x, y);
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