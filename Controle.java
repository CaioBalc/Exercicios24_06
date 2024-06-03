// Controle.java
import java.io.IOException;

public class Controle {
    public static void main(String[] args) {
        try {
            Leitura matriz = new Leitura("data.txt");
            matriz.processarDados();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}