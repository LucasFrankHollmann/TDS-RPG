package Model;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public abstract class PersonagemJogavel extends Personagem {
    
    protected Const classe;
    
    int ID;
    protected Item[] equips = new Item[3];
    protected Item[] bag = new Item[12];
    protected int skill1CD, skill2CD, ultCD;
    protected Const raca;
    protected String nomePas, nomeSk1, nomeSk2, nomeUlt;
    protected String descrPas, descrSk1, descrSk2, descrUlt; 
    protected int XpLvlUp;
    protected boolean passivaAt=false;
    protected ImageIcon armaIdle, arma1, arma2, arma3, arma4, arma5;
    protected int MapNodeAtual, MapaAtual;
    protected CodeGen codeGen;
    protected int attrPts;

    /**
     * Construtor da classe PersonagemJogavel
     * @param nome Nome do personagem
     * @param lvlb Level do personagem
     * @param xpb Experiência atual
     * @param goldb Dinheiro que o personagem possui
     * @param feb atributo fé
     * @param intelb atributo inteligencia
     * @param strb atributo força
     * @param dexb atributo destreza
     * @param luckb atributo sorte
     * @param resistb atributo resistência
     * @param critcb atributo crítico
     * @param hpb quantidade de vida total do personagem
     * @param hpatual quantidade de vida atual do personagem
     * @param attrpts pontos disponíveis para uppar um dos atributos
     * @param mapnodeatual nó atual que o personagem se encontra
     * @param mapaatual mapa que o personagem está
     * @param racac raça do personagem
     * @param bag inventário do personagem
     * @param equips equipamentos do personagem
     * Neste contrutor também é feito a verificação se o inventário está cheio e se o personagem passou de nível
     */
    public PersonagemJogavel(String nome, int lvlb, int xpb,int goldb,int feb,int intelb,int strb,int dexb,int luckb,int resistb,int critcb,int hpb,int hpatual,int attrpts,int mapnodeatual,int mapaatual,Const racac,Item[] bag, Item[] equips)
    {
        super(nome);
        fe = new Atributo(feb);
        intel = new Atributo(intelb);
        str = new Atributo(strb);
        dex = new Atributo(dexb);
        luck = new Atributo(luckb);
        resist = new Atributo(resistb);
        critC = new Atributo(critcb);
        HP = new Vida(hpb);
        
        for(int i=0;i<3;i++)
        {
            if(equips[i]!=null)
            {
                try {
                    addToBag(equips[i]);
                    usaItem(0);
                } catch (Exception ex) {
                    Logger.getLogger(PersonagemJogavel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        for(int i=0;i<12;i++)
        {
            if(bag[i]!=null)
            {
                try {
                    addToBag(bag[i]);
                } catch (Exception ex) {
                    Logger.getLogger(PersonagemJogavel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        HP.setAtual(hpatual);
        
        lvl = lvlb;
        
        xp = xpb;
        
        gold = goldb;
        
        attrPts = attrpts;
        
        MapNodeAtual = mapnodeatual;
        
        MapaAtual = mapaatual;
        
        skill1CD = 0;
        skill2CD = 0;
        ultCD = 0;
        d1 = new Dado(6);
        d2 = new Dado(6);
        d3 = new Dado(6);
        
        XpLvlUp = calculaXpLvlUp(lvl);
        setPassivaAt();
    }
    
    /**
     * Construtor para inserir os valores padrões iniciais para o personagem
     * @param name nome do personagem
     */  
    public PersonagemJogavel(String name)
    {
        super(name);
        MapaAtual = 0;
        MapNodeAtual = -1;
        XpLvlUp = 50;
        skill1CD = 0;
        skill2CD = 0;
        ultCD = 0;
        attrPts=0;
        d1 = new Dado(6);
        d2 = new Dado(6);
        d3 = new Dado(6);
        
        gold = 100;
        lvl = 1;
        xp = 0;
        bag = new Item[12];

    }
    
    /**
     * Calcula a quantidade para necessária para subir para o próximo nivel
     * @param lvl nível atual do personagem
     * @return 
     */
    public int calculaXpLvlUp(int lvl)
    {
        if(lvl!=0)
        {
            return calculaXpLvlUp(lvl-1)+50*lvl;
        }
        else
        {
            return 0;
        }
    }
    
    public int getAttrPts()
    {
        return attrPts;
    }
    
    public void decAttrPts()
    {
        attrPts--;
    }
    
    public ImageIcon getArmaIdle() {
        return armaIdle;
    }

    public ImageIcon getArma1() {
        return arma1;
    }

    public ImageIcon getArma2() {
        return arma2;
    }

    public ImageIcon getArma3() {
        return arma3;
    }

    public ImageIcon getArma4() {
        return arma4;
    }

    public ImageIcon getArma5() {
        return arma5;
    }
    
    
    
    
    
    public boolean passivaAtiva()
    {
        return passivaAt;
    }
    
    public void setPassivaAt()
    {
        passivaAt = false;
    }
    
    public Item[] getEquips() {
        return equips;
    }

    public Item[] getBag() {
        return bag;
    }
    
    public void setEquips(Item[] equips) {
        this.equips = equips;
    }

    public void setBag(Item[] bag) {
        this.bag = bag;
    }


    public int getXpLvlUp() {
        return XpLvlUp;
    }
    
    public int getXp() {
        return xp;
    }
    
    
    
    public int getSkill1CD() {
        return skill1CD;
    }
    public int getSkill2CD() {
        return skill2CD;
    }
    public int getUltCD() {
        return ultCD;
    }
       
    public void incXP(int x)
    {
        xp += x;
        
        lvlUp();
    }
    
    /**
     * Função para incrementar o valor de algum atributo escolhido pelo player
     * @param e qual atributo será incrementado
     */
    public void incAttr(int e){
       
        switch(e)
        {
            case 1:
                fe.setBase(fe.getBase()+1);
                break;
            case 2:
                intel.setBase(intel.getBase()+1);
                break;
            case 3:
                str.setBase(str.getBase()+1);
                break;
            case 4:
                dex.setBase(dex.getBase()+1);
                break;
            case 5:
                luck.setBase(luck.getBase()+1);
                break;
            case 6:
                critC.setBase(critC.getBase()+1);
                break;
            case 7:
                resist.setBase(resist.getBase()+1);
                break;
            case 8:
                HP.setBase(HP.getBase()+10);
                break;

        }

            
    }
    
    /**
     * Função para o personagem poder utilizar um item e receber os atributos respectivos
     * @param i item escolhido
     * @throws Exception 
     */
    public void usaItem(int i) throws Exception
    {
        if(bag[i]!=null){
            if(bag[i].getType()==Const.CONSUMIVEL)
            {
                    fe.setBuff(fe.getBuffPercent() + bag[i].getPfe());
                    intel.setBuff(intel.getBuffPercent() + bag[i].getPintel());
                    str.setBuff(str.getBuffPercent() + bag[i].getPstr());
                    dex.setBuff(dex.getBuffPercent() + bag[i].getPdex());
                    luck.setBuff(luck.getBuffPercent() + bag[i].getPluck());
                    resist.setBuff(resist.getBuffPercent() + bag[i].getPresist());
                    critC.setBuff(critC.getBuffPercent() + bag[i].getPcritC());
                    
                    cura(bag[i].getChp());

                    bag[i].setQtd(bag[i].getQtd()-1);
                    if(bag[i].getQtd()==0)
                    {
                        bag[i] = null;
                    }
            }
            else if(bag[i].getType()==Const.EQUIPAMENTO )
            {

                int j=0;
                switch(bag[i].getTipoEquip())
                {
                    case PERNAS:
                        j=0;
                        break;
                    case TORSO:
                        j=1;
                        break;
                    case WEAPON:
                        j=2;
                        break;
                    

                }
                if(equips[j]==null)
                {
                    Item tmp = equips[j];

                    equips[j]=bag[i];

                    fe.setEqPercent(fe.getEqPercent() + equips[j].getPfe());
                    intel.setEqPercent(intel.getEqPercent() + equips[j].getPintel());
                    str.setEqPercent(str.getEqPercent() + equips[j].getPstr());
                    dex.setEqPercent(dex.getEqPercent() + equips[j].getPdex());
                    luck.setEqPercent(luck.getEqPercent() + equips[j].getPluck());
                    resist.setEqPercent(resist.getEqPercent() + equips[j].getPresist());
                    critC.setEqPercent(critC.getEqPercent() + equips[j].getPcritC());

                    HP.setEqPercent(HP.getEqPercent()+equips[j].getChp());


                    bag[i]=tmp;
                }
            }
                
        }
    } 
           
    public void printBag()
    {
        for(int i = 0;i<10;i++)
        {
            if(bag[i]==null)
                System.out.print("null 0 || ");
            else
                System.out.print(bag[i].getNome() + " " + bag[i].getQtd()+" || ");
        }
        System.out.println("");
    }
    
    public void printAttr()
    {
        System.out.println("fe -> " + fe.getBase() +" - " + fe.getAtual() + " - " + fe.getEfetiva());
        System.out.println("intel -> " + intel.getBase() +" - " + intel.getAtual() + " - " + intel.getEfetiva());
        System.out.println("str -> " + str.getBase() +" - " + str.getAtual() + " - " + str.getEfetiva());
        System.out.println("dex -> " + dex.getBase() +" - " + dex.getAtual() + " - " + dex.getEfetiva());
        System.out.println("luck -> " + luck.getBase() +" - " + luck.getAtual() + " - " + luck.getEfetiva());
        System.out.println("resist -> " + resist.getBase() +" - " + resist.getAtual() + " - " + resist.getEfetiva());
        System.out.println("ctriC -> " + critC.getBase() +" - " + critC.getAtual() + " - " + critC.getEfetiva());
        System.out.println("HP -> "+ HP.getMax() + " " + HP.getAtual());
        
    }
    
    /**
     * Solta o item escolhido
     * @param i item
     */
    public void dropItem(int i)
    {
        if(bag[i]!=null)
        {
            bag[i]=null;
            
        }
    }
    
    /**
     * Adiciona na mochila o item escolhido, caso o espaço não esteja cheio
     * @param I item
     * @throws Exception 
     */
    public void addToBag(Item I) throws Exception
    {
        
        for(int i = 0;i<12;i++)
        {
            if(bag[i]!=null)
                if(bag[i].getCode() == I.getCode())
                {
                    if(bag[i].getQtd()<bag[i].getQtdMax())
                    {
                    bag[i].setQtd(bag[i].getQtd()+1);
                    return;
                    }
                    else
                    {
                        //throw new Exception("FullInventory");
                    }
                }
        }
        
        for(int i = 0;i<12;i++)
        {
            if(bag[i]==null)
            {
                bag[i]=I;
                return;
            }
        }

        
        throw new Exception("FullInventory");
        
    }
    
    /**
     * Remoção do equipamento utilizado pelo personagem (e, consequentemente, os atributos providos)
     * @param i item
     */
    public void removeEquip(int i)
    {
        
        
        if(equips[i]!=null)
        {
            
            
            try {
                
                fe.setEqPercent(fe.getEqPercent() - equips[i].getPfe());
                intel.setEqPercent(intel.getEqPercent() - equips[i].getPintel());
                str.setEqPercent(str.getEqPercent() - equips[i].getPstr());
                dex.setEqPercent(dex.getEqPercent() - equips[i].getPdex());
                luck.setEqPercent(luck.getEqPercent() - equips[i].getPluck());
                resist.setEqPercent(resist.getEqPercent() - equips[i].getPresist());
                critC.setEqPercent(critC.getEqPercent() - equips[i].getPcritC());

                HP.setEqPercent(HP.getEqPercent()- equips[i].getChp());
                HP.heal(0);
                addToBag(equips[i]);
                equips[i]=null;
                
            } catch (Exception ex) {
                
            }
            
            
            
            
        }
    }
    
    
    /**
     * Função para quando o player sobe de nível. Modifica os valores para subir novamente de nível, os pontos para
     * os atributos
     */
    private void lvlUp() {
        if(xp>=XpLvlUp)
        {
            xp = xp - XpLvlUp;
            lvl++;
            XpLvlUp = XpLvlUp + 50*lvl;

            attrPts+=5; 
                   
            
        }
    }

    public void decSkill1CD() {
        if(skill1CD>0)
            skill1CD--;
    }

    public void decSkill2CD() {
        if(skill2CD>0)
            skill2CD--;
    }

    public void incUltCD() {
        if(ultCD<45)
            ultCD+=somaDados;
        if(ultCD>45)
            ultCD=45;
    }

    public Const getClasse() {
        return classe;
    }
    
    public Const getRaça() {
        return raca;
    }
    
    public String getNome() {
        return nome;
    }
    
     public String getNomePas() {
        return nomePas;
    }

    public void setNomePas(String nomePas) {
        this.nomePas = nomePas;
    }

    public String getNomeSk1() {
        return nomeSk1;
    }

    public void setNomeSk1(String nomeSk1) {
        this.nomeSk1 = nomeSk1;
    }

    public String getNomeSk2() {
        return nomeSk2;
    }

    public void setNomeSk2(String nomeSk2) {
        this.nomeSk2 = nomeSk2;
    }

    public String getNomeUlt() {
        return nomeUlt;
    }

    public void setNomeUlt(String nomeUlt) {
        this.nomeUlt = nomeUlt;
    }

    public String getDescrPas() {
        return descrPas;
    }

    public void setDescrPas(String descrPas) {
        this.descrPas = descrPas;
    }

    public String getDescrSk1() {
        return descrSk1;
    }

    public void setDescrSk1(String descrSk1) {
        this.descrSk1 = descrSk1;
    }

    public String getDescrSk2() {
        return descrSk2;
    }

    public void setDescrSk2(String descrSk2) {
        this.descrSk2 = descrSk2;
    }

    public String getDescrUlt() {
        return descrUlt;
    }

    public void setDescrUlt(String descrUlt) {
        this.descrUlt = descrUlt;
    }
    
    public void endTurno()
    {
        if(getSkill1CD()>0)
         decSkill1CD();

        if(getSkill2CD()>0)
         decSkill2CD();

        if(getUltCD()<45)
         incUltCD();

    }
    
    public int getMapaAtual() {
        return MapaAtual;
    }

    public int getMapNodeAtual() {
        return MapNodeAtual;
    }
    
    public abstract void passiva(Personagem ini) throws Exception;
    public abstract void skill1(Personagem ini) throws Exception;
    public abstract void skill2(Personagem ini) throws Exception;
    public abstract void ult(Personagem ini) throws Exception;

    public void setNode(int n) {
        MapNodeAtual = n;
    }

    public int getFeB()
    {
        return fe.getBase();
    }
    
    public int getIntB()
    {
        return intel.getBase();
    }
    
    public int getStrB()
    {
        return str.getBase();
    }
    
    public int getDexB()
    {
        return dex.getBase();
    }
    
    public int getLuckB()
    {
        return luck.getBase();
    }
    
    public int getResistB()
    {
        return resist.getBase();
    }
    
    public int getCritB()
    {
        return critC.getBase();
    } 

    public int getID() {
        return ID;
    }
    
    public void setID(int id)
    {
        ID=id;
    }
}