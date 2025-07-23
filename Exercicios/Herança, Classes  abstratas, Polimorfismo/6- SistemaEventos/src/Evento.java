import java.time.LocalDate;
import java.util.*;

public class Evento {
    private String nome;
    private LocalDate data;
    private Set<Participante> participantes;
    private int capacidadeMaxima;

    public Evento(String nome, LocalDate data, int capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
        this.data = data;
        this.nome = nome;
        participantes = new HashSet<>();
    }

    public boolean adicionarParticipante(Participante p){
        if(participantes.size() < capacidadeMaxima){
            participantes.add(p);
            return true;
        }
        return true;
    }

    List<Participante> listarParticipantePorNome(){
        List<Participante> lista = new ArrayList<>(participantes);
        Collections.sort(lista);
        return lista;
    }

    Set<Participante> buscarParticipantesPorInicial(char letra){
       Set<Participante> nomesComInicial = new HashSet<>();

       for(Participante p : participantes){
           if(p.getNome().toLowerCase().charAt(0) == Character.toLowerCase(letra)){
               nomesComInicial.add(p);
           }
       }
       return nomesComInicial;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }
}

