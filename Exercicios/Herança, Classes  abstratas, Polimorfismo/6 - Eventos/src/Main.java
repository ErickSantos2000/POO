import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        
        SistemaEvento sistema = new SistemaEvento();

        Evento evento1 = new Evento("Java Arraia", LocalDate.of(2025, 9, 20), 3);
        Evento evento2 = new Evento("Expotec", LocalDate.of(2025, 12, 30), 3);

        sistema.adicionaEvento(evento1);
        sistema.adicionaEvento(evento2);

        evento1.adicionarParticipante(new Participante("ana", "ana@email.com", "1111-1111"));
        evento1.adicionarParticipante(new Participante("amanda", "amanda@email.com", "3333-3333"));
        evento1.adicionarParticipante(new Participante("bruno", "bruno@email.com", "4444-4444")); 

        evento2.adicionarParticipante(new Participante("ana", "ana@email.com", "1111-1111"));
        evento2.adicionarParticipante(new Participante("bento", "amanda@email.com", "3333-3333"));
        evento2.adicionarParticipante(new Participante("bruno", "bruno@email.com", "4444-4444")); 
       
  
        System.out.println("Lista de eventos");
        for (Evento e : sistema.listarEventos()) {
            System.out.println("- " + e.getNome() + " | " + e.getData());
        }

    System.out.println("\nArraia");
        List<Participante> participantesArria = evento1.listarParticipantePorNome();
        for (Participante p : participantesArria) {
            System.out.println(p);
        }

    System.out.println("\nExpotec");
        List<Participante> participantesExpotec = evento2.listarParticipantePorNome();
        for (Participante p : participantesExpotec) {
            System.out.println(p);
        }

       System.out.println("\nLetra A:");
        Set<Participante> com1 = evento1.buscarParticipantesPorInicial('A');
        for (Participante p : com1) {
            System.out.println(p);
        }

        System.out.println("\nLetra B:");
        Set<Participante> com2 = evento2.buscarParticipantesPorInicial('B');
        for (Participante p : com2) {
            System.out.println(p);
        }
    }
}