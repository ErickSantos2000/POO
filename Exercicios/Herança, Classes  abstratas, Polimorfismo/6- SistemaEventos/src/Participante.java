public class Participante implements Comparable<Participante> {
    private String nome;
    private String email;
    private String telefone;

    public Participante(String nome, String email, String telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public boolean equals(Object obj){
        // verifica se o endereço de memoria é o msm
        if(this == obj) return true;

        // verifica se o objeto a ser comparado é null
        if(obj == null) return false;

        // verifica se a instancia de ambos são a msm
        if(this.getClass() != obj.getClass()) return false;

        // converte para aluno
        Participante outro = (Participante) obj;

        // compara a matricula de ambos
        return this.email.equals(outro.email);
    }

    public int hashCode() {
       int resultado = 17;

       if (email != null) {
           resultado = 31 * resultado + email.hashCode();
       } else {
           resultado = 31 * resultado + 0; 
       }

       return resultado;
   }


   
    public int compareTo(Participante outro) {
        return this.email.compareTo(outro.email); 
    }

    public String toString() {
        return"Nome:" +  nome + " Email: " + email + " Telefone: " + telefone;
    }

    public String getNome() {
        return nome;
    }
}
