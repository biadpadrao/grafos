/*------------------------------------------------------------------------
 Aluna: Beatriz Demetrio Ribeiro Padrão
 Matrícula: 762626
 
 Teoria dos Grafos e Computabilidade - Ciência da Computação PUC Minas

 Referências para a execução do código:
 1. https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
    Copyright © 2000–2022, Robert Sedgewick and Kevin Wayne.

 Estrutura utilizada: Lista de Adjacência. Foram feitas por duas ArrayList,
 que armazenam os predecessores e sucessores dos vértices.
 --------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;

public class Digrafo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        // recebe do usuário o nome do arquivo (enunciado)
        System.out.print("Escreva o nome do arquivo que contem as informações do grafo: ");
        String filename = sc.next();

        File file = new File(filename);
        FileInputStream arqTeste = new FileInputStream(file);
        sc = new Scanner(new BufferedInputStream(arqTeste));

        try {
            int V = sc.nextInt(); // leitura do número total de vértices 
            int E = sc.nextInt(); // leitura do número total de arestas

            if (V < 0 || E < 0)
            throw new IllegalArgumentException("O numero de vertices e arestas nao pode ser negativo!");

            ArrayList<Integer>[] vPredecessor = new ArrayList[V]; // lista de adjacência de predecessores
            ArrayList<Integer>[] vSucessor = new ArrayList[V]; // lista de adjacência de sucessores

            // criação das listas de adjacência 
            for (int v = 0; v < V; v++) {
                vPredecessor[v] = new ArrayList<>();
                vSucessor[v] = new ArrayList<>();
            }

            int[] grauSaida = new int[V];
            int[] grauEntrada = new int[V];

            // preenchimento das listas de adjacência 
            for (int i = 0; i < E; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();  // (v, w)
                vSucessor[v - 1].add(w);
                vPredecessor[w - 1].add(v);
                grauSaida[v - 1]++;
                grauEntrada[w - 1]++;
            }

            /* impressão das listas de adjacência
            for (int v = 0; v < V; v++) {
                int temp = v + 1;
                System.out.println("Vértice " + temp);
                System.out.println("Predecessores:" + vPredecessor[v] + " " + grauEntrada[v]);
                System.out.println("Sucessores: "+ vSucessor[v] + " " + grauSaida[v]);
                System.out.println(" ");
            } */

            // i) grau de saída e conjunto de sucessores para o vértice de maior valor de grau de saída
            int maiorGrauSaida = 0;
            int tempS = 0;
            for (int i = 0; i < V; i++) {
                if (grauSaida[i] > maiorGrauSaida) {
                    maiorGrauSaida = grauSaida[i];
                    tempS = i;
                }
            }
            System.out.println("\n" + "Vértice " + (tempS + 1) + " é o maior em grau de saída: " + maiorGrauSaida);
            System.out.println("Sucessores: " + vSucessor[tempS] + "\n");

            // ii) grau de entrada e conjunto de predecessores para o vértice de maior valor de grau de entrada
            int maiorGrauEntrada = 0;
            int tempE = 0;
            for (int i = 0; i < V; i++) {
                if (grauEntrada[i] > maiorGrauEntrada) {
                    maiorGrauEntrada = grauEntrada[i];
                    tempE = i;
                }
            }
            System.out.println("Vértice " + (tempE + 1) + " é o maior em grau de entrada: " + maiorGrauEntrada);
            System.out.println("Predecessores: " + vPredecessor[tempE]);


        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Formato inválido", e);
        }

        sc.close();
    }
}
