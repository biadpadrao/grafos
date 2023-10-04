
/*----------------------------------------------------------------------
 Aluna: Beatriz Demetrio Ribeiro Padrão
 Matrícula: 762626
 
 Teoria dos Grafos e Computabilidade - Ciência da Computação PUC Minas

 Referências para a execução do código em Grafo.java
 ----------------------------------------------------------------------*/
class Vertice {
    private int TD = 0;
    private int TT = 0;
    private int pai = 0;

    public Vertice() {

    }

    public void setTD(int TD) {
        this.TD = TD;
    }

    public int getTD() {
        return TD;
    }

    public void setTT(int TT) {
        this.TT = TT;
    }

    public int getTT() {
        return TT;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public int getPai() {
        return pai;
    }
}