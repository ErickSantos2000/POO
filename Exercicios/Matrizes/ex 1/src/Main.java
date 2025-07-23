/*
1. Crie uma matriz 3x3 de inteiros.
2. Peça ao usuário para digitar 9 números.
3. Armazene os números na matriz.
4. Ao final, exiba a matriz formatada.
*/
import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        int matriz[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);

        for(int j = 0; j < matriz.length; j++){
            for(int i = 0; i < matriz[j].length; i++){
                System.out.println((i+1) +" - Digite um numero:");
                int numero = sc.nextInt();

                matriz[j][i] = numero;

            }
        }

        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print("[" + valor + "] ");
            }
            System.out.println();  // pula para a próxima linha só depois de imprimir toda a linha
        }

    }
}