package Model;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Cavaleiro extends PersonagemJogavel {
    
    
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
    
    /**
     *
     * Construtor da classe Cavaleiro para recuperação do banco de dados.
     * 
     */
    public Cavaleiro(String nome, int lvl, int xp,int gold,int fe,int intel,int strb,int dexb,int luck,int resist,int critc,int hp,int hpatual,int attrpts,int mapnodeatual,int mapaatual,Const racac,Item[] bag, Item[] equips)
    {
        super(nome,lvl,xp,gold,fe,intel,strb,dexb,luck,resist,critc,hp,hpatual,attrpts,mapnodeatual,mapaatual,racac,bag,equips);
        
        raca = racac;
        classe = Const.CAVALEIRO;
        nomePas="Escudo de Espinhos";
        nomeSk1="Uma espadada mais forte";
        nomeSk2="Grito de Guerra";
        nomeUlt="Armadura dos Deuses";
        descrPas="Devido à sua armadura especial,\no cavalheiro é capaz de devolver parte \ndo dano recebido de ataques inimigos";
        descrSk1="O cavalheiro realiza um golpe rápido \ne potente, causando dano ao inimigo";
        descrSk2="O cavalheiro dá um rugido feroz, \ndiminuindo os atributos \nprincipais do inimigo";
        descrUlt="Sendo sua armadura forjada pelos\npróprios Deuses, o cavaleiro pode\nganhar mais resistência pelo resto\ndo combate";
        
        timeAnim1=150;
        timeAnim2=250;
        timeAnim3=200;
        timeAnim4=0;
        timeAnim5=0;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/espadaPadrão.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/Espada 2.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/Espada 2.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc2mão2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
                
        attrPrincipal = str;
        attrSecundario = str;
    }
    
    /**
     *
     * Construtor da classe Cavaleiro para criar um personagem jogável.
     * 
     */
    public Cavaleiro(String name, Const r, CodeGen coder) throws Exception {
        super(name);
        raca = r;
        classe = Const.CAVALEIRO;
        nomePas="Escudo de Espinhos";
        nomeSk1="Uma espadada mais forte";
        nomeSk2="Grito de Guerra";
        nomeUlt="Armadura dos Deuses";
        descrPas="Devido à sua armadura especial,\no cavalheiro é capaz de devolver parte \ndo dano recebido de ataques inimigos";
        descrSk1="O cavalheiro realiza um golpe rápido \ne potente, causando dano ao inimigo";
        descrSk2="O cavalheiro dá um rugido feroz, \ndiminuindo os atributos \nprincipais do inimigo";
        descrUlt="Sendo sua armadura forjada pelos\npróprios Deuses, o cavaleiro pode\nganhar mais resistência pelo resto\ndo combate";
        
        timeAnim1=150;
        timeAnim2=250;
        timeAnim3=200;
        timeAnim4=0;
        timeAnim5=0;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/espadaPadrão.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/Espada 2.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/Espada 2.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc2mão2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
                
        fe = new Atributo(8);
        intel = new Atributo(9);
        str = new Atributo(10);
        dex = new Atributo(10);
        luck = new Atributo(11);
        resist = new Atributo(15);
        critC = new Atributo(6);
        HP = new Vida(120);
        attrPrincipal = str;
        attrSecundario = str;
        
        
        Item temp = new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png");
        
        addToBag(temp);
        addToBag(temp);
        addToBag(temp);
        addToBag(temp);
        
        
        addToBag(new Item(Const.EQUIPAMENTO, Const.WEAPON, 1, 0, 0, 0.07, 0.02, 0, 0, 0, 0, "Espada", 8, 50, "/Resources/WeaponSlot_Str.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.TORSO, 1, 0, 0, 0.02, 0, 0, 0.11, 0, 15, "Armadura de Cavaleiro", 9, 50, "/Resources/ArmorSlot_Str.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.PERNAS, 1, 0, 0, 0.01, 0, 0, 0.11, 0, 10, "Calças de Cavaleiro", 10, 50, "/Resources/LegSlot_Str.png"));
        usaItem(1);
    }
    
    /**
     *
     * Construtor da classe Cavaleiro para obter informações sobre a classe.
     * 
     */
    public Cavaleiro(String name, Const r) throws Exception {
        super(name);
        raca = r;
        classe = Const.CAVALEIRO;
        nomePas="Escudo de Espinhos";
        nomeSk1="Uma espadada mais forte";
        nomeSk2="Grito de Guerra";
        nomeUlt="Armadura dos Deuses";
        descrPas="Devido à sua armadura especial,\no cavalheiro é capaz de devolver parte \ndo dano recebido de ataques inimigos";
        descrSk1="O cavalheiro realiza um golpe rápido \ne potente, causando dano ao inimigo";
        descrSk2="O cavalheiro dá um rugido feroz, \ndiminuindo os atributos \nprincipais do inimigo";
        descrUlt="Sendo sua armadura forjada pelos\npróprios Deuses, o cavaleiro pode\nganhar mais resistência pelo resto\ndo combate";
        
        timeAnim1=150;
        timeAnim2=250;
        timeAnim3=200;
        timeAnim4=0;
        timeAnim5=0;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/espadaPadrão.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/Espada 2.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/Espada 2.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/Espada 1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc2mão2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao2.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/felcha.png"));
        }
                
        fe = new Atributo(8);
        intel = new Atributo(7);
        str = new Atributo(13);
        dex = new Atributo(10);
        luck = new Atributo(10);
        resist = new Atributo(15);
        critC = new Atributo(5);
        HP = new Vida(120);
        attrPrincipal = str;
        attrSecundario = str;
        
        
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.EQUIPAMENTO, Const.WEAPON, 1, 0, 0, 0.07, 0.02, 0, 0, 0, 0, "Espada", 5, 50, "/Resources/WeaponSlot_Str.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.TORSO, 1, 0, 0, 0.02, 0, 0, 0.11, 0, 15, "Armadura de Cavaleiro", 6, 50, "/Resources/ArmorSlot_Str.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.PERNAS, 1, 0, 0, 0.01, 0, 0, 0.11, 0, 10, "Calças de Cavaleiro", 7, 50, "/Resources/LegSlot_Str.png"));
        usaItem(1);
    }

    @Override
    public void passiva(Personagem ini) throws Exception
    {   
        passivaAt=true;
    }

    @Override
    public void skill1(Personagem ini) throws Exception{
        int multiplicador = getSomaDados()/6;
        if(multiplicador==0)
        {
            multiplicador=1;
        }
        ini.dano(((str.getEfetiva()*75+str.getEfetiva()*25)/100)*multiplicador);
        skill1CD = 2;
    }

    @Override
    public void skill2(Personagem ini) throws Exception{
        double debuff = 0.2;
        ini.attrPrincipal.setDebuff(debuff);
        skill2CD = 3;
    }

    @Override
    public void ult(Personagem ini) throws Exception{
        resist.setBuff(1);
        ultCD=0;
    }

    
    
    

    
}
