/*----------------------------------------------------------------------
 Aluna: Beatriz Demetrio Ribeiro Padrão
 Matrícula: 762626
 
 Teoria dos Grafos e Computabilidade - Ciência da Computação PUC Minas

 Referências para a execução do código:
 1. https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
    Copyright © 2000–2022, Robert Sedgewick and Kevin Wayne.

 2. https://algs4.cs.princeton.edu/42digraph/DirectedDFS.java.html
    Copyright © 2000–2022, Robert Sedgewick and Kevin Wayne.

 3. Pseudo-código apresentado em sala pelo professor da disciplina
 ----------------------------------------------------------------------*/
import java.io.*;
import java.util.*;

public class Grafo {
    public static ArrayList<Integer>[] destino;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // recebe do usuário o nome do arquivo
        System.out.println("Digite o número do arquivo do grafo: \n 1) graph-test-100.txt \n 2) graph-test-50000.txt");
        int filename = scanner.nextInt();

        // recebe o número de um dos vértices do grafo descrito no arquivo
        System.out.println("\nDigite o número do vértice escolhido: ");
        int numVertice = scanner.nextInt();

        scanner.close();
        File file;

        if (filename == 1) {
            file = new File("graph-test-100.txt");
            if (numVertice < 0 || numVertice > 100)
            System.out.println("Inválido");

        } else if (filename == 2) {
            file = new File("graph-test-50000.txt");
            if (numVertice < 0 || numVertice > 50000)
            System.out.println("Inválido");

        } else {
            throw new FileNotFoundException("Arquivo não existe");
        }

        Scanner sc = new Scanner(file);

        int V = sc.nextInt(); // leitura do número total de vértices
        int E = sc.nextInt(); // leitura do número total de arestas

        destino = new ArrayList[V]; // lista dos sucessores de cada v

        for (int v = 0; v < V; v++) {
            destino[v] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();  // (v, w)
            destino[v-1].add(w);
        }

        // ordena lista de sucessores de cada vértice
        for (ArrayList<Integer> ordenado : destino) {
            Collections.sort(ordenado);
        }

        DFS dfs = new DFS(); // início da busca por profundidade 
        dfs.propVertice(V, numVertice); 

        sc.close();
    }
}
