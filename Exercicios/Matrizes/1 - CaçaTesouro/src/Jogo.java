import jdk.jshell.Snippet;

import java.util.*;
import java.io.*;

public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    private ElementoTabuleiro[][] tabuleiro;
    private Set<String> elementosVisitados;
    private Jogador jogador;
    private transient Scanner sc;

    public Jogo() {
        tabuleiro = new ElementoTabuleiro[6][6];
        tabuleiro[0][0] = new Vazio();
        elementosVisitados = new HashSet<>();
        elementosVisitados.add("0,0");
        jogador = new Jogador();
        sc = new Scanner(System.in);
    }

    private void inicializarTabuleiro() {
        Random rand = new Random();

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



        Jogo salvoJogo = (Jogo) SavePoint.carregar();
        if(salvoJogo != null){
            this.jogador = salvoJogo.jogador;
            this.tabuleiro = salvoJogo.tabuleiro;
            this.elementosVisitados = salvoJogo.elementosVisitados;
            this.sc = new Scanner(System.in);
        } else {
            inicializarTabuleiro();
        }

        while (jogador.getMovimentos() < 10 && jogador.getTesouro() < 3) {

            mostrarTabuleiro();

            System.out.println("======================");
            System.out.println("Numero de movimentos: " + jogador.getMovimentos());
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

            // pega a posição atual do tabuleiro
            String posicao = linhaTeste + "," + colunaTeste;

            // verifica se posição atual ja foi visitado
            if(elementosVisitados.contains(posicao)){
                System.out.println("Vc ja visitou essa posiçao. Jogada perdida");
                continue;
            }

            // incia o movimento
            jogador.mover(movimento);

            int linha = jogador.getLinha();
            int coluna = jogador.getColuna();

            // marca como visitado
            elementosVisitados.add(linha + "," + coluna);

            tabuleiro[linha][coluna].interagir(jogador); // POLIMORFISMO
            
            System.out.println("vc encontrou: " + tabuleiro[linha][coluna].simbolo()); // POLIMORFISMO

            SavePoint.salvar(this);
        }

        System.out.println("=========FINAL=========");
        System.out.println("Pontuação final: " + jogador.getPontos());
        System.out.println("Tesouros encontrados: " + jogador.getTesouro());
        mostrarTabuleiroFinal();
        System.out.println("=======================");

        SavePoint.deletarSave();
    }

    // imprimir
    private void mostrarTabuleiro() {
        System.out.println("\nTabela:");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {

                // aqui é controla onde o jogador esta
                if (i == jogador.getLinha() && j == jogador.getColuna()) { 
                        System.out.print(tabuleiro[i][j].simboloComJogador()); // POLIMORFISMO
                    }
                else if (elementosVisitados.contains(i + "," + j)) {
                    System.out.print(tabuleiro[i][j].simbolo()); // POLIMORFISMO
                } 
                
                else {
                    System.out.print("🟥");
                }
                }
                System.out.println();
            }
            
        }
    
    // mostrar tabela apos o termino do jogo
    public void mostrarTabuleiroFinal() {
        System.out.println("\nTabela Final:");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j].simbolo());
            }
            System.out.println();
        }
    }

    // gets
    public ElementoTabuleiro[][] getTabuleiro() {
        return tabuleiro;
    }

    public Set<String> getElementosVisitados() {
        return elementosVisitados;
    }

    public Jogador getJogador() {
        return jogador;
    }

    // sets
    public void setElementosVisitados(Set<String> filtro) {
        this.elementosVisitados = filtro;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setTabuleiro(ElementoTabuleiro[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
