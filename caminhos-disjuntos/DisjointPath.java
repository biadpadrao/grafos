/*----------------------------------------------------------------------
 Aluna: Beatriz Demetrio Ribeiro Padrão
 Matrícula: 762626
 
 Teoria dos Grafos e Computabilidade - Ciência da Computação PUC Minas

 Todas as referências para a execução do código estão em Grafo.java
 ----------------------------------------------------------------------*/
import java.util.*;

public class DisjointPath {
    private static Grafo G;

    public void findPaths(int V, int source, int terminal) {
        ArrayList<Integer>[] copySucess = new ArrayList[V]; // cópia da lista de sucessores
        for (int v = 0; v < V; v++) {
            copySucess[v] = G.adjSucessor[v];
        }

        int[] parent = new int[V]; // pai de cada vértice
        int maxPath = 0; // quantidade máxima de caminhos disjuntos

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        while (bfs(V, source, terminal, parent)) {
            ArrayList<Integer> reversedPath = new ArrayList<>();
            int w;

            // inverte todos os caminhos já achados, assim garantindo que não haverá repetição de aresta
            for (w = terminal; w != source; w = parent[w]) {
                int v = parent[w];
                reversedPath.add(w);
                copySucess[v].remove(Integer.valueOf(w));
                copySucess[w].add(v);
            }            

            reversedPath.add(source);
            ArrayList<Integer> path = new ArrayList<>();

            // "desinverte" os caminhos para realizar a impressão de forma correta
            for (int i = reversedPath.size() - 1; i >= 0; i--) {
                path.add(reversedPath.get(i));
            }
            maxPath++;
            paths.add(path);
        }
        System.out.println("QUANTIDADE MÁXIMA DE CAMINHOS DISJUNTOS: " + maxPath);
        System.out.println("CAMINHOS: " + paths);
    }

    // busca por largura: retorna 'true' se há caminho do source ao terminal
    public boolean bfs(int V, int s, int t, int[] parent) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) 
            visited[i] = false; // todos os vértices são iniciados como não visitados

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int v = q.peek(); // fila característica da bfs
            q.remove();

            for (int w : G.adjSucessor[v]) {
                if (!visited[w]) {
                    q.add(w);
                    parent[w] = v;
                    visited[w] = true;
                }
            }
        }
        return (visited[t] == true);
    }
}
