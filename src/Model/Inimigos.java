
package Model;

import javax.swing.ImageIcon;


public abstract class Inimigos extends Personagem{

    public Inimigos(String name, String d, String a1, String a2, String a3, String a4, String a5, String p, int t1, int t2, int t3, int t4, int t5, int tp)
    {
        super(name);
        idle = new ImageIcon(getClass().getResource(d));
        anim1 = new ImageIcon(getClass().getResource(a1));
        anim2 = new ImageIcon(getClass().getResource(a2));
        anim3 = new ImageIcon(getClass().getResource(a3));
        anim4 = new ImageIcon(getClass().getResource(a4));
        anim5 = new ImageIcon(getClass().getResource(a5));
        projetil = new ImageIcon(getClass().getResource(p));
        timeAnim1 = t1;
        timeAnim2 = t2;
        timeAnim3 = t3;
        timeAnim4 = t4;
        timeAnim5 = t5;
        timeProjetil = tp;
    }
    public abstract void SkillBoss(Personagem P);

    public String getNome() {
        return nome;
    }
}
