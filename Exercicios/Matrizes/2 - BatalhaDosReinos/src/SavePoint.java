
import java.io.*;

public class SavePoint {
    private static final String saveJogo = "Jogo.bin";

    public static void salvar(Object obj){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveJogo))){
            out.writeObject(obj);
            System.out.println("Jogo foi salvo com sucesso!");
        } catch(IOException e){
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
    public static Object carregar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(saveJogo))) {
            Object obj = in.readObject();
            System.out.println("Jogo carregado com sucesso!");
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Não foi possível carregar o jogo: " + e.getMessage());
            return null;
        }
    }

    // Deleta o arquivo de save
    public static void deletarSave() {
        File file = new File(saveJogo);
        if (file.exists()) file.delete();
    }
}
