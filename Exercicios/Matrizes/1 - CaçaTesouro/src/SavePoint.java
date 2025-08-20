import java.io.*; // lib de entrada e saida do java que inclui classe para manipulação de arquivos

public class SavePoint {
    private static final String jogoSalvo = "jogo.bin";

    // metodo para salvar o obj serializavel
    public static void salvar(Object obj){
        // crio uma variável temporária para gerenciar o fluxo de escrita em arquivo
        // objectOutputStream é a classe que, atraves do metodo writeObject(obj) converte os objetos Java em bytes (serialização)
        // FileOutputStream é responsável por escrever esses bytes no arquivo
        try(ObjectOutputStream outFluxo = new ObjectOutputStream(new FileOutputStream(jogoSalvo))) {
            // nesse trecho o obj é serializado, e salvo no arquivo jogo.bin
            outFluxo.writeObject(obj);
            System.out.println("Jogo salvo!");
        } catch (IOException e){
            System.out.println("Erro ao salvar" + e.getMessage());
        }
    }

    public static Object carregar(){
        try(ObjectInputStream inFluxo = new ObjectInputStream(new FileInputStream(jogoSalvo))){
            // le o obj do arquivo, salva na variavel para retorna o obj
            Object obj = inFluxo.readObject();
            System.out.println("Jogo carregado");
            return obj;
        } catch (IOException e) {
            System.out.println("Não foi possível carregar: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Classe do objeto não encontrada: " + e.getMessage());
            return null;
        }
    }

     public static void deletarSave() {
        File file = new File(jogoSalvo);
        if (file.exists()) {
            file.delete();
            System.out.println("Save deletado.");
        }
    }
}
