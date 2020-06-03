package Controller;

import BD.PersonagemBD;
import Model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * classe controladora do personagem.
 * @author Megatron
 */
public class ControllerPersonagem{
    
    private RPG rpg = new RPG();
    private Combate combate;
    private PersonagemJogavel perso;
    private Inimigos I;
    private Mercador merch;
    private MapNode nodeAtual;
    
    public ControllerPersonagem()
    {
        //RPG rpg 
    }
    
    public void criaPerso(Const classe, String nome, Const raca) throws Exception
    {
        rpg.criaPerso(classe,nome,raca); 
        
        try{
            perso = rpg.getPersonagem();
        }catch(Exception ex)
        {
        }
        setNodeAtual();
    }

    public void setNodeAtual() {
        if(perso.getMapNodeAtual()>=0)
        {
            nodeAtual = rpg.getNodeAtual();
            if(nodeAtual.getTipo()==Const.INIMIGO)
            {
                I = nodeAtual.getInimigos();
                merch = null;
            }
            else if(nodeAtual.getTipo()==Const.MERCADOR)
            {
                I = null;
                merch = nodeAtual.getMerch();
            }
        }
    }
    
    public int getNodeAtual()
    {
        return perso.getMapNodeAtual();
    }
    
    public void setNodeAtualPerso(int n)
    {
        perso.setNode(n);
        setNodeAtual();
    }
    
    
    public void addToBag(Item i) throws Exception
    {
        
        perso.addToBag(i);
        
    }
    
    public void usaItem(int i) throws Exception
    {
        perso.usaItem(i);
    }
    
    public Item[] getEquips()
    {
        Item[] copiaEquips = new Item[3];
        
        for(int i=0;i<3;i++)
        {
            if(perso.getEquips()[i]!=null){
                copiaEquips[i]=new Item(perso.getEquips()[i]);
            }
        }
        
        return copiaEquips;
    }
    
    public void removeEquip(int i)
    {
        perso.removeEquip(i);
    }
    
    public Item[] getBag()
    {
        Item[] copiaBag = new Item[12];
        
        
        for(int i=0;i<12;i++)
        {
            
            if(perso.getBag()[i]!=null){
                copiaBag[i]=new Item(perso.getBag()[i]);
            }
        }
        
        return copiaBag;
    }
   
    public void dropItem(int i)
    {
        perso.dropItem(i);
    }
    
    public Const getClasse()
    {
        return perso.getClasse();
    }

    public Const getRaça() {
        return perso.getRaça();
    }

    public double getHP() {
        return (((double)perso.getHP()/(double)perso.getMaxHP()))*100;
    }

    public int getLvl() {
        return perso.getLvl();
    }

    public String getNome() {
        return perso.getNome();
    }

    public int getHPatual() {
        return perso.getHP();
        
    }
    
    public int getHPmax() {
        return perso.getMaxHP();
    }
    
    public String getPassivaNome()
    {
        return perso.getNomePas();
    }
    
    public String getPassivaDesc()
    {
        return perso.getDescrPas();
    }

    public String getSkill1Nome()
    {
        return perso.getNomeSk1();
    }
    
    public String getSkill1Desc()
    {
        return perso.getDescrSk1();
    }
    
    public int getSkill1CD()
    {
        return perso.getSkill1CD();
    }
    
    public String getSkill2Nome()
    {
        return perso.getNomeSk2();
    }
    
    public String getSkill2Desc()
    {
        return perso.getDescrSk2();
    }
    
    public int getSkill2CD()
    {
        return perso.getSkill2CD();
    }
    
    public String getUltNome()
    {
        return perso.getNomeUlt();
    }
    
    public String getUltDesc()
    {
        return perso.getDescrUlt();
    }
    
    public int getUltCD()
    {
        return perso.getUltCD();
    }
    
    public void iniciaCombate() throws Exception
    {
        combate = new Combate(perso, I);
    }
    
    public int setTurno() throws Exception
    {
        perso.endTurno();
        return combate.turno();
    }
    
    public int turnoCbt(int vez, int e) throws Exception
    {
        return combate.joga(vez, e);
        
    }
    
    public double getIniHP() {
        return (((double)I.getHP()/(double)I.getMaxHP()))*100;
    }

    public int getIniLvl() {
        return I.getLvl();
    }

    public String getIniNome() {
        return I.getNome();
    }

    public int getIniHPatual() {
        return I.getHP();
        
    }
    
    public int getIniHPmax() {
        return I.getMaxHP();
    }
    
    public boolean passivaAtiva()
    {
        return perso.passivaAtiva();
    }
    
    public void setPassivaAt()
    {
        perso.setPassivaAt();
    }
    
    public int getDados()
    {
        return perso.getSomaDados();
    }
    
    public boolean isDead()
    {
        return perso.isDead();
    }
    
    public boolean isIniDead()    {
        return I.isDead();
    }
    
    public ImageIcon getProjetil() {
        
        return perso.getProjetil();
        
    }

    public ImageIcon getIdle() {
        return perso.getIdle();
    }

    public ImageIcon getAnim1() {
        return perso.getAnim1();
    }

    public ImageIcon getAnim2() {
        return perso.getAnim2();
    }

    public ImageIcon getAnim3() {
        return perso.getAnim3();
    }

    public ImageIcon getAnim4() {
        return perso.getAnim4();
    }

    public ImageIcon getAnim5() {
        return perso.getAnim5();
    }
    
    public ImageIcon iniGetProjetil() {
        
        return I.getProjetil();
        
    }

    public ImageIcon iniGetIdle() {
        return I.getIdle();
    }

    public ImageIcon iniGetAnim1() {
        return I.getAnim1();
    }

    public ImageIcon iniGetAnim2() {
        return I.getAnim2();
    }

    public ImageIcon iniGetAnim3() {
        return I.getAnim3();
    }

    public ImageIcon iniGetAnim4() {
        return I.getAnim4();
    }

    public ImageIcon iniGetAnim5() {
        return I.getAnim5();
    }
    
    public int getIniTempAnim1() {
        return I.getTimeAnim1();
    }
    
    public int getIniTempAnim2() {
        return I.getTimeAnim2();
    }
    
    public int getIniTempAnim3() {
        return I.getTimeAnim3();
    }
    
    public int getIniTempAnim4() {
        return I.getTimeAnim4();
    }
    
    public int getIniTempAnim5() {
        return I.getTimeAnim5();
    }
    
    public ImageIcon getIniIdle()
    {
        return I.getIdle();
    }  
          
    
    public int getIniTempoProjetil()
    {
        return I.getTimeProjetil();
    }
    
    public ImageIcon getArmaIdle() {
        return perso.getArmaIdle();
    }

    public ImageIcon getArma1() {
        return perso.getArma1();
    }

    public ImageIcon getArma2() {
        return perso.getArma2();
    }

    public ImageIcon getArma3() {
        return perso.getArma3();
    }

    public ImageIcon getArma4() {
        return perso.getArma4();
    }

    public ImageIcon getArma5() {
        return perso.getArma5();
    }
    
    public int getTempAnim1() {
        return perso.getTimeAnim1();
    }
    
    public int getTempAnim2() {
        return perso.getTimeAnim2();
    }
    
    public int getTempAnim3() {
        return perso.getTimeAnim3();
    }
    
    public int getTempAnim4() {
        return perso.getTimeAnim4();
    }
    
    public int getTempAnim5() {
        return perso.getTimeAnim5();
    }
    
    public int getTempoProjetil()
    {
        return perso.getTimeProjetil();
    }
            
    public int getGold()
    {
        return perso.getGold();
    }
    
    public int getDropGold()
    {
        return I.getDropG();
    }

    public int getDropXP()
    {
        return I.getDropXP();
    }
    
    public Item[] getItensIniciais(Const classe) throws Exception
    {
        Item[] temp=new Item[12], copia = new Item[12];
        
        if(classe == Const.ARQUEIRO)
        {
            temp = new Arqueiro("",Const.HUMANO).getBag();
            
        }
        else if(classe == Const.MAGO)
        {
            temp = new Mago("",Const.HUMANO).getBag();
            
        }
        else if(classe == Const.CAVALEIRO)
        {
            temp = new Cavaleiro("",Const.HUMANO).getBag();
            
        }
        
        for(int i = 0;i<12;i++)
        {
            if(temp[i]!=null)
            {
                copia[i] = new Item(temp[i]);
            }
        }
        return copia;
    }

    public Item[] getEquipsIniciais(Const classe) throws Exception 
    {
        Item[] temp= new Item[3], copia = new Item[3];
        
        if(classe == Const.ARQUEIRO)
        {
            temp = new Arqueiro("",Const.HUMANO).getEquips();
            
        }
        else if(classe == Const.MAGO)
        {
            temp = new Mago("",Const.HUMANO).getEquips();
            
        }
        else if(classe == Const.CAVALEIRO)
        {
            temp = new Cavaleiro("",Const.HUMANO).getEquips();
            
        }
        
        for(int i = 0;i<3;i++)
        {
            if(temp[i]!=null)
            {
                copia[i] = new Item(temp[i]);
            }
        }
        return copia;
    }
    
    public String getSkill1DescCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getDescrSk1();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getDescrSk1();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getDescrSk1();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return null;
    }
    
    public String getSkill2DescCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getDescrSk2();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getDescrSk2();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getDescrSk2();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return null;
    }
    
    public String getUltDescCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getDescrUlt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getDescrUlt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getDescrUlt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return null;
    }

    public String getPassDescCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getDescrPas();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getDescrPas();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getDescrPas();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return null;
    }
    
    public String getSkill1NomeCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getNomeSk1();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getNomeSk1();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getNomeSk1();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return null;
    }
    
    public String getSkill2NomeCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getNomeSk2();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getNomeSk2();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getNomeSk2();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return null;
    }
    
    public String getUltNomeCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getNomeUlt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getNomeUlt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getNomeUlt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return null;
    }

    public String getPassNomeCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getNomePas();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getNomePas();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe == Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getNomePas();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return null;
    }
    
    public int getSkill1CDCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            return 2;
        }
        else if(classe == Const.MAGO)
        {
            return 2;
        }
        else if(classe == Const.CAVALEIRO)
        {
            return 2;
        }
        
        
        
        
        return 0;
    }
    
    public int getSkill2CDCP(Const classe)
    {
        if(classe == Const.ARQUEIRO)
        {
            return 3;
        }
        else if(classe == Const.MAGO)
        {
            return 5;
        }
        else if(classe == Const.CAVALEIRO)
        {
            return 5;
        }
        
        
        
        return 0;
    }
   
    public int getUltCDCP(Const classe) 
    {
        return 45;
    }
    
    public int getVidaCP(Const classe) 
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getHP();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getHP();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getHP();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public int getVidaMaxCP(Const classe) 
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getMaxHP();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getMaxHP();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getMaxHP();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }
    
    public int getFeCP(Const classe) 
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getFe();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getFe();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getFe();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public int getIntCP(Const classe) 
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getInt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getInt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getInt();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public int getStrCP(Const classe) 
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getStr();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getStr();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getStr();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public int getDexCP(Const classe) 
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getDex();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getDex();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getDex();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public int getLuckCP(Const classe) 
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getLuck();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getLuck();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getLuck();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public int getResistCP(Const classe)
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getResist();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getResist();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getResist();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public int getCritCP(Const classe)
    {
        if(classe==Const.ARQUEIRO)
        {
            try {
                return new Arqueiro("", Const.HUMANO).getCrit();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.MAGO)
        {
            try {
                return new Mago("", Const.HUMANO).getCrit();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(classe==Const.CAVALEIRO)
        {
            try {
                return new Cavaleiro("", Const.HUMANO).getCrit();
            } catch (Exception ex) {
                Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public int getFe() {
        return perso.getFe();
    }

    public int getInt() {
        return perso.getInt();
    }

    public int getStr() {
        return perso.getStr();
    }

    public int getCrit() {
        return perso.getCrit();
    }

    public int getResist() {
        return perso.getResist();
    }

    public int getLuck() {
        return perso.getLuck();
    }

    public int getDex() {
        return perso.getDex();
    }
    
    
    public ImageIcon getBG()
    {
        return nodeAtual.getBG();
    }
    
    public ImageIcon getBG2()
    {
        return nodeAtual.getBG2();
    }


    public int getIniDados() {
        return I.getSomaDados();
    }

    public int getXPAtual() {
        return perso.getXp();
    }

    public int getXPLvlUp() {
        return perso.getXpLvlUp();
    }

    public int getMelhorias() {
        return perso.getAttrPts();
    }
    
    public void melhorarAttr(int e)
    {
        perso.incAttr(e);
        perso.decAttrPts();
    }
    
    public void salvarJogo()
    {
        new PersonagemBD().updatePersonagem(perso);
    }

    public boolean bdIsFull()
    {
        return rpg.bdIsFull();
    }

    public String getBDName(int i) {
        PersonagemBD temp = new PersonagemBD();
        return temp.getNome(i);
    }

    public int getBDLvl(int i) {
        PersonagemBD temp = new PersonagemBD();
        return temp.getLvl(i);
    }

    public void deletePersoBD(int i) {
        new PersonagemBD().removePersonagem(i);
    }
    
    public void loadPerso(int i)
    {
        rpg.loadPersonagem(i);
        try {
            perso=rpg.getPersonagem();
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Item[] getAvenda() {
        return merch.getBag();
    }

    public void comprarItem(int i) {
        merch.vender(perso, i);
    }

    public int getPersoID() {
        return perso.getID();
    }
}
