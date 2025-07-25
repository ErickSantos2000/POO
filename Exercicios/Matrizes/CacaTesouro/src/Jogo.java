import java.util.*;

public class Jogo {
    private ElementoTabuleiro[][] tabuleiro;

    private Set<String> filtro;
    private Jogador jogador;
    private int movimentosRestantes;

    public Jogo() {
        tabuleiro = new ElementoTabuleiro[6][6];
        filtro = new HashSet<>();
        filtro.add("0,0");
        jogador = new Jogador();


        movimentosRestantes = 10;
    }

    private void inicializarTabuleiro() {
        Random rand = new Random();

        // inicializa
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                tabuleiro[i][j] = null;
            }
        }

        // preenche o restante com tesouro
        int tesourosColocados = 0;
        while (tesourosColocados < 3) {
            int i = rand.nextInt(6);
            int j = rand.nextInt(6);
            if (tabuleiro[i][j] == null) {
                tabuleiro[i][j] = new Tesouro();
                tesourosColocados++;
            }
        }

        // preenche o restante com armadilhas
        int armadilhasColocadas = 0;
        while (armadilhasColocadas < 3) {
            int linha = rand.nextInt(6);
            int coluna = rand.nextInt(6);
            if (tabuleiro[linha][coluna] == null) {
                tabuleiro[linha][coluna] = new Armadilha();
                armadilhasColocadas++;
            }
        }

        // preenche o restante com vazio
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (tabuleiro[i][j] == null) {
                    tabuleiro[i][j] = new Vazio();
                }
            }
        }
    }


    public void jogar() {
        inicializarTabuleiro();
        Scanner sc = new Scanner(System.in);

        while (jogador.getMovimentos() < 10 && jogador.getTesouro() < 3) {

            mostrarTabuleiro();

            System.out.println("======================");
            System.out.println("Movimento restantes: " + movimentosRestantes);
            System.out.println("Ponto:" + jogador.getPontos());
            System.out.println("Tesouros encontrados: " + jogador.getTesouro());
            System.out.println("======================");


            System.out.print("Movimento \nW - cima\nS - baixo\nA - esquerda\nD - direita\n");
            char movimento = sc.next().charAt(0);



            int linhaTeste = jogador.getLinha();
            int colunaTeste = jogador.getColuna();

            switch(Character.toUpperCase(movimento)){
                case 'A': colunaTeste--; break;
                case 'W': linhaTeste--; break;
                case 'D': colunaTeste++; break;
                case 'S': linhaTeste++; break;
                default:
                    System.out.println("movimento invalido, apenas permitido usar: W, A, S ou D.");
                    continue;
            }

            if (linhaTeste < 0 || linhaTeste >= 6 || colunaTeste < 0 || colunaTeste >= 6) {
                System.out.println("Jogada invalida.");
                continue;
            }

            String pos = linhaTeste + "," + colunaTeste;

            if(filtro.contains(pos)){
                System.out.println("Vc ja visitou essa posiçao. Jogada perdida");
                continue;
            }


            // incia o movimento
            jogador.mover(movimento);
            movimentosRestantes--;

            int linha = jogador.getLinha();
            int coluna = jogador.getColuna();

            // marca como visitado
            filtro.add(linha + "," + coluna);

            tabuleiro[linha][coluna].interagir(jogador);


            System.out.println("vc encontrou: " + tabuleiro[linha][coluna].simbolo());
        }

        System.out.println("=========FINAL=========");
        System.out.println("Pontuação final:" + jogador.getPontos());
        System.out.println("Tesouros encontrados: " + jogador.getTesouro());
        System.out.println("=======================");
    }

    // imprimir
    private void mostrarTabuleiro() {
        System.out.println("\nTabela:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == jogador.getLinha() && j == jogador.getColuna()) {
                    System.out.print(" 🧍 ");
                } else if (filtro.contains(i + "," + j)) {
                    System.out.print(" " + tabuleiro[i][j].simbolo() + " ");
                } else {
                    System.out.print(" 🟥 ");
                }
            }
            System.out.println();
        }
    }
}