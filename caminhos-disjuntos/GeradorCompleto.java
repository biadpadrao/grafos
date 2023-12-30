/*----------------------------------------------------------------------
 Aluna: Beatriz Demetrio Ribeiro Padrão
 Matrícula: 762626
 
 Teoria dos Grafos e Computabilidade - Ciência da Computação PUC Minas

 Todas as referências para a execução do código estão em Grafo.java
 ----------------------------------------------------------------------*/
import java.io.*;
import java.util.*;

public class GeradorCompleto {
    public static void main(String[] args) {
        int numVertices = 5000;

        int numEdges = numVertices * (numVertices - 1);

        String fileName = "tests/grafo-completo-" + numVertices + ".txt"; // Nome do arquivo de saída

        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            vertices.add(i);
        }

        int source = 0;
        int terminal = numVertices - 1;

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(numVertices + " " + numEdges);
            writer.println(source + " " + terminal);

            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (i != j)
                    writer.println("    " + i + " " + j);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Grafo completo gerado com sucesso!");
    }
}