/*----------------------------------------------------------------------
 Aluna: Beatriz Demetrio Ribeiro Padrão
 Matrícula: 762626
 
 Teoria dos Grafos e Computabilidade - Ciência da Computação PUC Minas

 Referências para a execução do código em Grafo.java
 ----------------------------------------------------------------------*/
import java.util.*;

public class DFS {
    private int count = 0;
    private static Grafo G;
    private static Vertice[] propVertice;
    private static ArrayList<String> arvore; 
    private static ArrayList<String> retorno; 
    private static ArrayList<String> avanco; 
    private static ArrayList<String> cruzamento; 
    private static ArrayList<String> allArvore; 

    public void propVertice(int V, int numVertice) {
        propVertice = new Vertice[V];
        for (int i = 0; i < V; i++) {
            propVertice[i] = new Vertice();
        }

        allArvore = new ArrayList<String>(); // todas as arestas de árvore do grafo

        // arestas específicas do vértice escolhido
        arvore = new ArrayList<String>(); 
        retorno = new ArrayList<String>(); 
        avanco = new ArrayList<String>(); 
        cruzamento = new ArrayList<String>(); 

        int v = 0;
        while (v < V && propVertice[v].getTD() == 0) { 
            buscaProfundidade(v, numVertice);
        }

        System.out.println("\nTODAS AS ARESTAS DE ÁRVORE: \n" + allArvore);
        System.out.println("\nARESTAS DO VÉRTICE ESCOLHIDO: \n ÁRVORE: " + arvore + "\n RETORNO: " + retorno + "\n CRUZAMENTO: " + cruzamento + "\n AVANÇO: " + avanco);
    }

    // MÉTODO BASEADO NO PSEUDO-CÓDIGO VISTO EM SALA 
    public void buscaProfundidade(int v, int numVertice) {
        count++;
        propVertice[v].setTD(count); // marca tempo de descoberta do vértice

        String aresta;
        int tamanho = G.destino[v].size();

        int tempV = v + 1;
        for (int i = 0; i < tamanho; i++) {
            int w = G.destino[v].get(i);            
            int tempW = w - 1;
            if (propVertice[tempW].getTD() == 0) {  // arestas de árvore
                aresta = String.valueOf(tempV) + " --> " + String.valueOf(w);
                allArvore.add(aresta);
                if (tempV == numVertice) {
                    arvore.add(aresta);
                }
                propVertice[tempW].setPai(v);
                buscaProfundidade(tempW, numVertice); 
            } else {
                if (propVertice[tempW].getTT() == 0) { // arestas de retorno
                    aresta = String.valueOf(tempV) + " --> " + String.valueOf(w); 
                    if (tempV == numVertice) {
                        retorno.add(aresta);
                    }
                } else if (propVertice[v].getTD() < propVertice[tempW].getTD()) { // arestas de avanço
                    aresta = String.valueOf(tempV) + " --> " + String.valueOf(w); 
                    if (tempV == numVertice) {
                        avanco.add(aresta);
                    }
                } else { // arestas de cruzamento
                    aresta = String.valueOf(tempV) + " --> " + String.valueOf(w); 
                    if (tempV == numVertice) {
                        cruzamento.add(aresta);
                    }
                }
            }
        }
        count++;
        propVertice[v].setTT(count); // marca tempo de término do vértice
    }
}
