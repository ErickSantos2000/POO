import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class SistemaEvento {
    private Map<String, Evento> eventos;

    public SistemaEvento() {
        eventos = new HashMap<>();
    }

    public void adicionaEvento(Evento evento) {
        eventos.put(evento.getNome(), evento);
    }

    public Evento buscarEvento(String nome) {
        return eventos.get(nome);
    }

    public List<Evento> listarEventos() {
        List<Evento> lista = new ArrayList<>(eventos.values());
        lista.sort(Comparator.comparing(Evento::getData));
        return lista;
    }
}
