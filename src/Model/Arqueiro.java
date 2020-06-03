package Model;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Arqueiro extends PersonagemJogavel {
    
    
    Random rand = new Random();
    
    /**
     *
     * Construtor da classe Arqueiro para recuperação do banco de dados.
     * 
     */
    public Arqueiro(String nome, int lvl, int xp,int gold,int fe,int intel,int strb,int dexb,int luck,int resist,int critc,int hp,int hpatual,int attrpts,int mapnodeatual,int mapaatual,Const racac,Item[] bag, Item[] equips)
    {
        super(nome,lvl,xp,gold,fe,intel,strb,dexb,luck,resist,critc,hp,hpatual,attrpts,mapnodeatual,mapaatual,racac,bag,equips);
        attrPrincipal = dex;
        attrSecundario = str;
        raca = racac;
        classe = Const.ARQUEIRO;
        nomePas="Visão Dupla";
        nomeSk1="Na Mosca";
        nomeSk2="Flechada no joelho";
        nomeUlt="Chuva de flechas";
        descrPas="Quando ativada, arqueiro pode realizar \nduas ações no mesmo turno";
        descrSk1="Causa dano baseado nos dados e \nnos atributos principais do personagem";
        descrSk2="Atinge o alvo adversário no joelho, \ndiminuindo seu atributo de ataque de \nmaior valor";
        descrUlt="Causa dano massivo ao alvo atingido";
        
        
        
        timeAnim1=500;
        timeAnim2=0;
        timeAnim3=0;
        timeAnim4=0;
        timeAnim5=0;
        timeProjetil=50;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/ArcoPadrao.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
    }
            
    /**
     *
     * Construtor da classe Arqueiro para criar um personagem jogável.
     * 
     */
    public Arqueiro(String name, Const r, CodeGen coder) throws Exception {
        super(name);
        raca = r;
        classe = Const.ARQUEIRO;
        nomePas="Visão Dupla";
        nomeSk1="Na Mosca";
        nomeSk2="Flechada no joelho";
        nomeUlt="Chuva de flechas";
        descrPas="Quando ativada, arqueiro pode realizar \nduas ações no mesmo turno";
        descrSk1="Causa dano baseado nos dados e \nnos atributos principais do personagem";
        descrSk2="Atinge o alvo adversário no joelho, \ndiminuindo seu atributo de ataque de \nmaior valor";
        descrUlt="Causa dano massivo ao alvo atingido";
        
        
        
        timeAnim1=500;
        timeAnim2=0;
        timeAnim3=0;
        timeAnim4=0;
        timeAnim5=0;
        timeProjetil=50;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/ArcoPadrao.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
                
        fe = new Atributo(5);
        intel = new Atributo(11);
        str = new Atributo(8);
        dex = new Atributo(14);
        luck = new Atributo(11);
        resist = new Atributo(8);
        critC = new Atributo(13);
        HP = new Vida(100);
        attrPrincipal = dex;
        attrSecundario = str;

        Item temp = new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png");
        
        addToBag(temp);
        addToBag(temp);
        addToBag(temp);
        addToBag(temp);
        
        addToBag(new Item(Const.EQUIPAMENTO, Const.WEAPON, 1, 0, 0, 0, 0.1, 0, 0, 0, 0, "Arco", 2, 50, "/Resources/WeaponSlot_Dex.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.TORSO, 1, 0, 0, 0, 0.05, 0, 0.1, 0, 10, "Couraça de arqueiro", 3, 50, "/Resources/ArmorSlot_Dex.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.PERNAS, 1, 0, 0, 0, 0.03, 0, 0.1, 0, 10, "Calças de arqueiro", 4, 50, "/Resources/LegSlot_Dex.png"));
        usaItem(1);
    }
    
    /**
     *
     * Construtor da classe Mago para obter informações sobre a classe.
     * 
     */
    public Arqueiro(String name, Const r) throws Exception {
        super(name);
        raca = r;
        classe = Const.ARQUEIRO;
        nomePas="Visão Dupla";
        nomeSk1="Na Mosca";
        nomeSk2="Flechada no joelho";
        nomeUlt="Chuva de flechas";
        descrPas="Quando ativada, arqueiro pode realizar \nduas ações no mesmo turno";
        descrSk1="Causa dano baseado nos dados e \nnos atributos principais do personagem";
        descrSk2="Atinge o alvo adversário no joelho, \ndiminuindo seu atributo de ataque de \nmaior valor";
        descrUlt="Causa dano massivo ao alvo atingido";
        
        
        
        timeAnim1=500;
        timeAnim2=0;
        timeAnim3=0;
        timeAnim4=0;
        timeAnim5=0;
        timeProjetil=50;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/ArcoPadrao.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/ArcoAtk1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
                
        fe = new Atributo(5);
        intel = new Atributo(11);
        str = new Atributo(8);
        dex = new Atributo(14);
        luck = new Atributo(11);
        resist = new Atributo(8);
        critC = new Atributo(13);
        HP = new Vida(100);
        attrPrincipal = dex;
        attrSecundario = str;

        
        
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.EQUIPAMENTO, Const.WEAPON, 1, 0, 0, 0, 0.1, 0, 0, 0, 0, "Arco", 2, 50, "/Resources/WeaponSlot_Dex.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.TORSO, 1, 0, 0, 0, 0.05, 0, 0.1, 0, 10, "Couraça de arqueiro", 3, 50, "/Resources/ArmorSlot_Dex.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.PERNAS, 1, 0, 0, 0, 0.03, 0, 0.1, 0, 10, "Calças de arqueiro", 4, 50, "/Resources/LegSlot_Dex.png"));
        usaItem(1);
    }
    
    
    
    @Override
    public void passiva(Personagem ini) throws Exception
    {   
        passivaAt=true;
        jogarDados();
    }

    @Override
    public void skill1(Personagem ini) throws Exception{
        int multiplicador = getSomaDados()/6;
        if(multiplicador==0)
        {
            multiplicador=1;
        }
        ini.dano(((dex.getEfetiva()*75+str.getEfetiva()*25)/100)*multiplicador);
        skill1CD = 2;
    }

    @Override
    public void skill2(Personagem ini) throws Exception{
        double FnJDebuff = 0.2;
        ini.attrPrincipal.setDebuff(FnJDebuff);
        atk(ini);
        skill2CD = 3;
    }

    @Override
    public void ult(Personagem ini) throws Exception{
        int multiplicador = getSomaDados()/3;
        if(multiplicador==0)
        {
            multiplicador=1;
        }
        ini.dano(((dex.getEfetiva()*75+str.getEfetiva()*25)/100)*multiplicador);
        ultCD=0;
    }

    
    
    

    
}
