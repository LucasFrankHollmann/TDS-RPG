package Model;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Mercador {
    
    private Item[] estoque = new Item[6];
    
    /**
     *
     * @param i0 um item do estoque do Mercador
     * @param i1 um item do estoque do Mercador
     * @param i2 um item do estoque do Mercador
     * @param i3 um item do estoque do Mercador
     * @param i4 um item do estoque do Mercador
     * @param i5 um item do estoque do Mercador
     */
    public Mercador(Item i0, Item i1, Item i2, Item i3, Item i4, Item i5)
    {
        estoque[0] = i0;
        estoque[1] = i1;
        estoque[2] = i2;
        estoque[3] = i3;
        estoque[4] = i4;
        estoque[5] = i5;
    }

    /**
     *
     * @param jog o personagem que comprará o item
     * @param i posição do item no estoque
     * 
     * Vende um item para um personagem.
     */
    public void vender(PersonagemJogavel jog, int i)
    {
        if(jog.getGold()>=estoque[i].getPreco())
        {
            try
            {
                jog.addToBag(estoque[i]);
                jog.setGold(jog.getGold()-estoque[i].getPreco());
                
                estoque[i]=null;
            }catch(Exception ex)
            {
                try {
                    throw new Exception("FullInventory");
                } catch (Exception ex1) {
                    Logger.getLogger(Mercador.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        else
        {
            
        }
    }

    
    /**
     *
     * @return O estoque do mercador.
     */
    public Item[] getBag() {
        return estoque;
    }
    
}
