// Matriz.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitura {
    private List<List<Double>> data;

    public Leitura(String filePath) throws IOException {
        data = new ArrayList<>();
        carregarDados(filePath);
    }

    private void carregarDados(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] valores = line.split(",");
            List<Double> linha = new ArrayList<>();
            for (String valor : valores) {
                if (valor.equals("nan")) {
                    linha.add(0.0);
                } else {
                    linha.add(Double.parseDouble(valor));
                }
            }
            data.add(linha);
        }
        reader.close();
    }

    public void processarDados() {
        calcularMediaLinhas();
        calcularMediaColunas();
        calcularMediaMatriz();
    }

    private void calcularMediaLinhas() {
        System.out.println("Médias das linhas:");
        for (List<Double> linha : data) {
            double soma = 0;
            for (double valor : linha) {
                soma += valor;
            }
            double media = soma / linha.size();
            System.out.println(media);
        }
    }

    private void calcularMediaColunas() {
        System.out.println("Médias das colunas:");
        int numeroColunas = data.get(0).size();
        for (int i = 0; i < numeroColunas; i++) {
            double soma = 0;
            for (List<Double> linha : data) {
                soma += linha.get(i);
            }
            double media = soma / data.size();
            System.out.println(media);
        }
    }

    private void calcularMediaMatriz() {
        System.out.println("Média da matriz:");
        double somaTotal = 0;
        int contador = 0;
        for (List<Double> linha : data) {
            for (double valor : linha) {
                somaTotal += valor;
                contador++;
            }
        }
        double mediaTotal = somaTotal / contador;
        System.out.println(mediaTotal);
    }
}