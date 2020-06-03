package Model;

import java.util.Random;
import javax.swing.ImageIcon;


public abstract class Personagem{


    
    protected Vida HP;
    protected Atributo fe, intel, str, dex, luck, resist, critC;
    protected Atributo attrPrincipal, attrSecundario; //ponteiro pra classe (?)
    protected int lvl, xp, gold;
    protected Dado d1, d2, d3;
    protected String nome;
    protected int somaDados;
    protected int dropG, dropXP;
    protected ImageIcon idle, anim1, anim2, anim3, anim4, anim5, projetil;
    protected int timeAnim1, timeAnim2, timeAnim3, timeAnim4, timeAnim5, timeProjetil;
    
    public Personagem(String name)
    {
        nome = name;
        
    }
    
    public int getFe()
    {
        return fe.getAtual();
    }
    public int getInt()
    {
        return intel.getAtual();
    }
    public int getStr()
    {
        return str.getAtual();
    }
    public int getDex()
    {
        return dex.getAtual();
    }
    public int getLuck()
    {
        return luck.getAtual();
    }
    public int getResist()
    {
        return resist.getAtual();
    }
    public int getCrit()
    {
        return critC.getAtual();
    }
    
    public int getTimeAnim1() {
        return timeAnim1;
    }
    
    public int getTimeAnim2() {
        return timeAnim2;
    }

    public int getTimeAnim3() {
        return timeAnim3;
    }

    public int getTimeAnim4() {
        return timeAnim4;
    }

    public int getTimeAnim5() {
        return timeAnim5;
    }

    public int getTimeProjetil() {
        return timeProjetil;
    }

    public ImageIcon getProjetil() {
        
        return projetil;
        
    }

    public ImageIcon getIdle() {
        return idle;
    }

    public ImageIcon getAnim1() {
        return anim1;
    }

    public ImageIcon getAnim2() {
        return anim2;
    }

    public ImageIcon getAnim3() {
        return anim3;
    }

    public ImageIcon getAnim4() {
        return anim4;
    }

    public ImageIcon getAnim5() {
        return anim5;
    }
    
    
    
    public int getLvl() {
        return lvl;
    }
    public int getDropG()
    {
        return dropG;
    }
    public int getDropXP()
    {
        return dropXP;
    }
    public void setGold(int g)
    {
        gold = g;
    }
    
    public int getGold()
    {
        return gold;
    }
    
   
    public int getHPB()
    {
        return HP.getBase();
    }
    
    
    public int getHP() 
    {
        return HP.getAtual();
        
    }
    public int getMaxHP() 
    {
        return HP.getMax();
        
    }
    
    public void jogarDados()
    {
        somaDados = d1.rolagem() + d2.rolagem() + d3.rolagem();
    }
    
    public int getSomaDados()
    {
        return somaDados;
    }
    
    public void Death(){};
    
    public int atk(Personagem P)
    {
        Random rand = new Random();
        int dano = (attrPrincipal.getEfetiva()*75 + attrSecundario.getEfetiva()*25)/100;
        if(rand.nextInt(100) < critC.getEfetiva() && P!=null)
        {
            P.dano((int)((double)dano*1.5));
        }
        else if(P!=null){
            P.dano(dano);
        }
        
        return dano;
        
    }
    
    public void removeItemFX() {
        fe.setBuff(0);
        fe.setDebuff(0);
        intel.setBuff(0);
        intel.setDebuff(0);
        dex.setBuff(0);
        dex.setDebuff(0);
        str.setBuff(0);
        str.setDebuff(0);
        resist.setBuff(0);
        resist.setDebuff(0);
        luck.setBuff(0);
        luck.setDebuff(0);
        critC.setBuff(0);
        critC.setDebuff(0);
        
    }
    
    public void cura(int c){
        this.HP.heal(c);
    }
    
    public void dano(int d){
        d-=(d*resist.getEfetiva())/100;
        this.HP.damage(d);
    }
    
    public boolean isDead()
    {
        return HP.isDead();
    }

    void prendeDado() {
        d1.prende();
    }
    
   

}
