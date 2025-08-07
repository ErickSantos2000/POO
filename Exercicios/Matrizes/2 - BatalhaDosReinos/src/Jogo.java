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

        j1.addPeca(new Guerreiro(2, 0));
        j1.addPeca(new Arqueiro(3, 0));
        j1.addPeca(new Cavaleiro(4, 0));

        j2.addPeca(new Guerreiro(2, 7));
        j2.addPeca(new Arqueiro(3, 7));
        j2.addPeca(new Cavaleiro(4, 7));

        // posiciona as peças no tabuleiro
        for (Jogador jogador : jogadores) {
            for (Peca p : jogador.getPecas()) {
                tabuleiro[p.getY()][p.getX()] = p;
            }
        }
    }

    public boolean turno(){
        imprimirTabuleiro();

        // pega o jogador atual
        Jogador jogadorAtual = jogadores.get(indiceJogador);

        // pega o jogador adversario
        Jogador adversario = jogadores.get((indiceJogador == 0) ? 1 : 0);
        
        System.out.println("\nVez do jogador ("+ jogadorAtual.getNome() + ")");
        System.out.println("\nEscolha a peça que deseja mover pelo indice:");

        imprimirPeca(indiceJogador);
        System.out.println("Opção:");
        int EscolhaPeca = scanner.nextInt();

        if(EscolhaPeca >= jogadorAtual.getPecas().size() || EscolhaPeca < 0){
            System.out.println("Escolha de peça invalida!");
            return false;
        }


        Peca pecaAtual = jogadores.get(indiceJogador).getPecas().get(EscolhaPeca);

        System.out.println("Você escolheu " + pecaAtual.getNome() + " " + pecaAtual.getSimbolo());

        System.out.println("Faça o movimento " );
        System.out.print("Y: ");
        int novoY = scanner.nextInt();
        System.out.print("X: ");
        int novoX = scanner.nextInt();

        // checa se o movimento esta fora dos limites
        if (novoY < 0 || novoY >= 8 || novoX < 0 || novoX >= 8) {
            System.out.println("Posição inválida.");
            return false;
        }

        //  checa se o movimento é valido de acordo com as regras de cada peças
        if (!pecaAtual.podeMoverPara(novoY, novoX) ) { // polimorfismo
            System.out.println("Movimento inválido.");
            return false;
        }

        boolean destino = tabuleiro[novoY][novoX] != null;
        
        if(destino){
            // checa se a peça é jogador atual
            if (jogadorAtual.getPecas().contains(tabuleiro[novoY][novoX])) {
            System.out.println("Você não pode capturar sua própria peça!");
                return false;
            }
            // checa se peça é do jogador adversario
            else if (adversario.getPecas().contains(tabuleiro[novoY][novoX])) {
                adversario.removerPeca(tabuleiro[novoY][novoX]);
            }

        }
        
        // atualiza a posição anterior da atual peça para null 
        tabuleiro[pecaAtual.getY()][pecaAtual.getX()] = null;

     
        pecaAtual.moverPara(novoY, novoX); // polimorfismo

     
        tabuleiro[novoY][novoX] = pecaAtual;

        return true;

    }

    // INICIALIZA O JOGO
    public void jogar() {
    iniciarTabuleiro();

    while (!taVazio()) {
       
        if(turno()){
            // alterna jogador
            indiceJogador = (indiceJogador == 0) ? 1 : 0;
        }
        
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
