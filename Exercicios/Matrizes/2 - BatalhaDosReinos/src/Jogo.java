import java.util.*;

public class Jogo {
    private List<Jogador> jogadores;
    private Peca[][] tabuleiro;
    private Scanner scanner;
    private int indiceJogador;

    public Jogo() {
        tabuleiro = new Peca[8][8];
        jogadores = new ArrayList<>();
        scanner = new Scanner(System.in);
        indiceJogador = 0;
    }

    public void iniciarTabuleiro() {
        Jogador j1 = new Jogador("Jogador 1");
        Jogador j2 = new Jogador("Jogador 2");

        jogadores.add(j1);
        jogadores.add(j2);

        j1.addPeca(new Guerreiro(2, 0, 1));
        j1.addPeca(new Arqueiro(3, 0, 1));
        j1.addPeca(new Cavaleiro(4, 0, 1));

        j2.addPeca(new Guerreiro(2, 7, 2));
        j2.addPeca(new Arqueiro(3, 7,2));
        j2.addPeca(new Cavaleiro(4, 7, 2));

        // posiciona as peças no tabuleiro
        for (Jogador jogador : jogadores) {
            for (Peca p : jogador.getPecas()) {
                tabuleiro[p.getY()][p.getX()] = p;
            }
        }
    }

    public void turno(){
        imprimirTabuleiro();

        // pega o jogador atual
        Jogador jogadorAtual = jogadores.get(indiceJogador);

        // pega o jogador adversario
        Jogador adversario = jogadores.get((indiceJogador == 0) ? 1 : 0);
        
        System.out.println("\nVez do jogador ("+ jogadorAtual.getNome() + ")");
        System.out.println("\nEscolha a peça que deseja mover pelo indice:");

        //imprime as peça de cada jogador
        imprimirPeca(indiceJogador);
        System.out.println("Opção:");
        int EscolhaPeca = scanner.nextInt();

        if(EscolhaPeca >= jogadorAtual.getPecas().size() || EscolhaPeca < 0){
            System.out.println("Escolha de peça invalida!");
            return;
        }

        // pega a peça atual de acordo com a escolha do jogador
        Peca pecaAtual = jogadores.get(indiceJogador).getPecas().get(EscolhaPeca);

        System.out.println("Você escolheu " + pecaAtual.getNome() + " " + pecaAtual.getSimbolo());

        // pede as posições para movimentar a peça
        System.out.println("Faça o movimento " );
        System.out.print("Y: ");
        int novoY = scanner.nextInt();
        System.out.print("X: ");
        int novoX = scanner.nextInt();

        // checa se o movimento esta fora dos limites
        if (novoY < 0 || novoY >= 8 || novoX < 0 || novoX >= 8) {
            System.out.println("Posição inválida.");
            return;
        }

        //  checa se o movimento é valido de acordo com as regras de cada peças
        if (!pecaAtual.podeMoverPara(novoY, novoX) ) { // polimorfismo
            System.out.println("Movimento inválido.");
            return;
        }

        boolean destino = tabuleiro[novoY][novoX] != null;

        // checa se a peça é jogador atual
        if (destino && jogadorAtual.getPecas().contains(tabuleiro[novoY][novoX])) {
            System.out.println("Você não pode capturar sua própria peça!");
            return;
        }

        // checa se peça é do jogador adversario
        if (destino && adversario.getPecas().contains(tabuleiro[novoY][novoX])) {
            adversario.removerPeca(tabuleiro[novoY][novoX]);
        }

        // atualiza a posição anterior da atual peça para null 
        tabuleiro[pecaAtual.getY()][pecaAtual.getX()] = null;

        // move a peça atual
        pecaAtual.moverPara(novoY, novoX); // polimorfismo

        // atualiza o tabuleiro
        tabuleiro[novoY][novoX] = pecaAtual;

    }

    // INICIALIZA O JOGO
    public void jogar() {
    iniciarTabuleiro();

    while (!taVazio()) {
        // alterna jogador
        indiceJogador = (indiceJogador == 0) ? 1 : 0;
        turno();
    }

    System.out.println("Fim de jogo!");
    if (jogadores.get(0).getPecas().size() == 0) {
        System.out.println("Jogador 2 venceu!");
    } else {
        System.out.println("Jogador 1 venceu!");
    }
    }

    public boolean taVazio(){
        for(int i = 0; i < jogadores.size(); i++){
            Jogador jogador = jogadores.get(i);
            if(jogador.getPecas().size() == 0){
                return true;
            }
        }
        return false;
    }

    public void imprimirPeca(int indiceJogador){
    int cont = 0;
    for (Peca p : jogadores.get(indiceJogador).getPecas()) {
        System.out.println(cont + ") " + p.getNome() + " " + p.getSimbolo());
        cont++;
        }
    }

    public void imprimirTabuleiro() {
        System.out.println("   0 1 2 3 4 5 6 7 ← X)");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] != null) {
                    System.out.print(tabuleiro[i][j].getSimbolo());
                } else {
                    System.out.print("🔵");
                    // System.out.print("🟦");
                }
            }
            System.out.println();
        }
        System.out.println("↑");
        System.out.println("Y)");
    }
}
