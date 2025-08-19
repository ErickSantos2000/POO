import java.util.*;
import java.io.*;

public class Jogador implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nome;
    private List<Peca> pecas;

    public Jogador(String nome){
        this.nome = nome;
        pecas = new ArrayList<>();
    }

    // metodos
    public void addPeca(Peca p) {
        pecas.add(p);
    }

    public void removerPeca(Peca p) {
        pecas.remove(p);
    }

    // gets
    public String getNome() {
        return nome;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    // sets
    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
