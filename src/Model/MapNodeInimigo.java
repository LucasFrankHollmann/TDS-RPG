package Model;

import javax.swing.ImageIcon;


public class MapNodeInimigo extends MapNode {

    public MapNodeInimigo(ImageIcon nBG, ImageIcon nBG2, int p1, int p2, Inimigos inimigo, Mercador merc) {
        super(Const.INIMIGO, nBG, nBG2, p1, p2);
        ini = inimigo;
        merch = merc;
    }
    
    
    
}
