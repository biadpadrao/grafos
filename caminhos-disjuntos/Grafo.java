/*----------------------------------------------------------------------
 Aluna: Beatriz Demetrio Ribeiro Padrão
 Matrícula: 762626
 
 Teoria dos Grafos e Computabilidade - Ciência da Computação PUC Minas

 Referências para a execução do código:
 1. https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
    Copyright © 2000–2022, Robert Sedgewick and Kevin Wayne.

 2. https://www.geeksforgeeks.org/find-edge-disjoint-paths-two-vertices/
    Copyright © 2023, PrinciRaj1992 - "Find maximum number of edge disjoint paths between two vertices"

 3. https://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/
    Copyright © 2023, PrinciRaj1992 - "Ford-Fulkerson Algorithm for Maximum Flow Problem"
 
 4. Pseudos-códigos fornecidos pelo professor da disciplina em sala de aula
 ----------------------------------------------------------------------*/
import java.io.*;
import java.util.*;

public class Grafo {
    public static ArrayList<Integer>[] adjPredecessor;
    public static ArrayList<Integer>[] adjSucessor;
    public static int V, E, source, terminal;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);

        // recebe do usuário o nome do arquivo
        System.out.println("Digite o número do arquivo do grafo: \n 1) teste.txt \n 2) grafo-completo-4.txt");
        int filename = scanner.nextInt();

        scanner.close();
        File file;

        if (filename == 1)
            file = new File("testes/teste.txt");
        else if (filename == 2)
            file = new File("testes/grafo-completo-4.txt"); // altere aqui o nome do arquivo
        else
            throw new FileNotFoundException("Arquivo não existe");

        Scanner sc = new Scanner(file);

        V = sc.nextInt(); // leitura do número total de vértices
        E = sc.nextInt(); // leitura do número total de arestas

        source = sc.nextInt(); // vértice inicial do caminho
        terminal = sc.nextInt(); // vértice final do caminho

        adjSucessor = new ArrayList[V]; // lista de adjacência de sucessores

        // criação das listas de adjacência 
        for (int v = 0; v < V; v++) {
            adjSucessor[v] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt(); // (v, w)
            adjSucessor[v].add(w);
        }

        DisjointPath disjointPath = new DisjointPath();
        disjointPath.findPaths(V, source, terminal);

        long end = System.currentTimeMillis();
        long execution = end - start;

        System.out.println("TEMPO DE EXECUÇÃO: " + execution + " MILISSEGUNDOS");
        sc.close();
    }
}