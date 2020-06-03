    package Model;

import javax.swing.ImageIcon;


public class MapNode {
    
    protected ImageIcon BG, BG2;
    protected Const tipo;
    protected Mercador merch;
    protected Inimigos ini;
    protected int prox1, prox2;
    
    /**
     * Construtor para criação de cada nó do mapa
     * @param t define qual será o conteudo do nó (inimigo, boss ou mercador)
     * @param nBG imagem de fundo 1
     * @param nBG2 imagem de fundo 2 (para gerar uma animação)
     * @param p1 próximo possível nó 1
     * @param p2 próximo possível nó 2
     */
    public MapNode(Const t, ImageIcon nBG, ImageIcon nBG2, int p1, int p2)
    {
        BG = nBG;
        BG2= nBG2;
        tipo = t;
        prox1 = p1;
        prox2 = p2;
    }
    
    public Const getTipo()
    {
        return tipo;
    }
    
    public ImageIcon getBG()
    {
        return BG;
    }
    
    public ImageIcon getBG2()
    {
        return BG2;
    }

    public Mercador getMerch() {
        return merch;
    }
    
    public Inimigos getInimigos()
    {
        return ini;
    }

    public int getProx1() {
        return prox1;
    }
    
    public int getProx2() {
        return prox2;
    }
    
}
