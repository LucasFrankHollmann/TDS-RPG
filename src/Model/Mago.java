package Model;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Mago extends PersonagemJogavel {
    
    
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
    
    /**
     *
     * Construtor da classe Mago para recuperação do banco de dados.
     * 
     */
    public Mago(String nome, int lvl, int xp,int gold,int fe,int intelb,int strb,int dexb,int luck,int resist,int critc,int hp,int hpatual,int attrpts,int mapnodeatual,int mapaatual,Const racac,Item[] bag, Item[] equips)
    {
      super(nome,lvl,xp,gold,fe,intelb,strb,dexb,luck,resist,critc,hp,hpatual,attrpts,mapnodeatual,mapaatual,racac,bag,equips);  
      
        raca = racac;
        classe = Const.MAGO;
        nomePas="Correntes de Vinhas";
        nomeSk1="Bola de Fogo";
        nomeSk2="Fúria dos Ventos";
        nomeUlt="Ice Barrage";
        descrPas="O mago elemental utiliza seu poder \nsobre a natureza para enraizar e \nanular um dos dados inimigos";
        descrSk1="O mago elemental conjura seu famoso \nfeitiço de chamas para queimar seu \nopontente, causando dano  a ele";
        descrSk2="O mago elemental faz uso do seu domínio \npara criar ventos fortes, rolando \nnovamente os dados \ninimigos com valor total menor que o atual";
        descrUlt="O mago elemental usa sua habilidade \nsuprema para causar um dano e congelar \no inimigo, que não poderá realizar nenhum \nmovimento por um turno";
        
        timeAnim1=500;
        timeAnim2=0;
        timeAnim3=0;
        timeAnim4=0;
        timeAnim5=0;
        timeProjetil=300;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/CajadoPadrao.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc1mão2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
                
        attrPrincipal = intel;
        attrSecundario = intel;
    }

    /**
     *
     * Construtor da classe Mago para criar um personagem jogável.
     * 
     */
    public Mago(String name, Const r, CodeGen coder) throws Exception {
        super(name);
        raca = r;
        classe = Const.MAGO;
        nomePas="Correntes de Vinhas";
        nomeSk1="Bola de Fogo";
        nomeSk2="Fúria dos Ventos";
        nomeUlt="Ice Barrage";
        descrPas="O mago elemental utiliza seu poder \nsobre a natureza para enraizar e \nanular um dos dados inimigos";
        descrSk1="O mago elemental conjura seu famoso \nfeitiço de chamas para queimar seu \nopontente, causando dano  a ele";
        descrSk2="O mago elemental faz uso do seu domínio \npara criar ventos fortes, rolando \nnovamente os dados \ninimigos com valor total menor que o atual";
        descrUlt="O mago elemental usa sua habilidade \nsuprema para causar um dano e congelar \no inimigo, que não poderá realizar nenhum \nmovimento por um turno";
        
        timeAnim1=500;
        timeAnim2=0;
        timeAnim3=0;
        timeAnim4=0;
        timeAnim5=0;
        timeProjetil=300;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/CajadoPadrao.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc1mão2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
                
        fe = new Atributo(5);
        intel = new Atributo(16);
        str = new Atributo(8);
        dex = new Atributo(10);
        luck = new Atributo(11);
        resist = new Atributo(8);
        critC = new Atributo(13);
        HP = new Vida(90);
        attrPrincipal = intel;
        attrSecundario = intel;
        
        
        Item temp = new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png");
        
        addToBag(temp);
        addToBag(temp);
        addToBag(temp);
        addToBag(temp);
        

        addToBag(new Item(Const.EQUIPAMENTO, Const.WEAPON, 1, 0, 0.1, 0, 0, 0, 0, 0, 0, "Cajado", 5, 50, "/Resources/WeaponSlot_Int.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.TORSO, 1, 0, 0.15, 0, 0, 0, 0.07, 0, 5, "Túnica", 6, 50, "/Resources/ArmorSlot_Int.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.PERNAS, 1, 0, 0.1, 0, 0, 0, 0.06, 0, 5, "Calças de mago", 7, 50, "/Resources/LegSlot_Int.png"));
        usaItem(1);
    }   
    
    /**
     *
     * Construtor da classe Mago para obter informações sobre a classe.
     * 
     */
    public Mago(String name, Const r) throws Exception {
        super(name);
        raca = r;
        classe = Const.MAGO;
        nomePas="Correntes de Vinhas";
        nomeSk1="Bola de Fogo";
        nomeSk2="Fúria dos Ventos";
        nomeUlt="Ice Barrage";
        descrPas="O mago elemental utiliza seu poder \nsobre a natureza para enraizar e \nanular um dos dados inimigos";
        descrSk1="O mago elemental conjura seu famoso \nfeitiço de chamas para queimar seu \nopontente, causando dano  a ele";
        descrSk2="O mago elemental faz uso do seu domínio \npara criar ventos fortes, rolando \nnovamente os dados \ninimigos com valor total menor que o atual";
        descrUlt="O mago elemental usa sua habilidade \nsuprema para causar um dano e congelar \no inimigo, que não poderá realizar nenhum \nmovimento por um turno";
        
        timeAnim1=500;
        timeAnim2=0;
        timeAnim3=0;
        timeAnim4=0;
        timeAnim5=0;
        timeProjetil=300;
        
        
        
        armaIdle = new ImageIcon(getClass().getResource("/Resources/CajadoPadrao.png"));
        arma1 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma2 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma3 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma4 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        arma5 = new ImageIcon(getClass().getResource("/Resources/Cajado1.png"));
        
        if(raca == Const.HUMANO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Humano1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Humano2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.ELFO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Elfo1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Elfo2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.FADA)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Fada1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Fada2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.DEMONIO)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Demonio1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Demonio2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.ORC)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Orc1mão2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Orc2mão1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
        else if(raca == Const.CIBORGUE)
        {
            idle = new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png"));
            anim1 = new ImageIcon(getClass().getResource("/Resources/Ciborgue1mao2.png"));
            anim2 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim3 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim4 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            anim5 = new ImageIcon(getClass().getResource("/Resources/Ciborgue2mao1.png"));
            projetil = new ImageIcon(getClass().getResource("/Resources/Magia.png"));
        }
                
        fe = new Atributo(5);
        intel = new Atributo(16);
        str = new Atributo(8);
        dex = new Atributo(10);
        luck = new Atributo(11);
        resist = new Atributo(8);
        critC = new Atributo(13);
        HP = new Vida(90);
        attrPrincipal = str;
        attrSecundario = str;
        
        
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, "Poção de vida", 1, 10, "/Resources/Pot_HP.png"));
        addToBag(new Item(Const.EQUIPAMENTO, Const.WEAPON, 1, 0, 0.1, 0, 0, 0, 0, 0, 0, "Cajado", 8, 50, "/Resources/WeaponSlot_Int.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.TORSO, 1, 0, 0.15, 0, 0, 0, 0.07, 0, 5, "Túnica", 9, 50, "/Resources/ArmorSlot_Int.png"));
        usaItem(1);
        addToBag(new Item(Const.EQUIPAMENTO, Const.PERNAS, 1, 0, 0.1, 0, 0, 0, 0.06, 0, 5, "Calças de mago", 10, 50, "/Resources/LegSlot_Int.png"));
        usaItem(1);
    }
    
    @Override
    public void passiva(Personagem ini) throws Exception
    {   
        ini.prendeDado();
    }
   
    @Override
    public void skill1(Personagem ini) throws Exception{
        int multiplicador = getSomaDados()/6;
        if(multiplicador==0)
        {
            multiplicador=1;
        }
        ini.dano((intel.getEfetiva())*multiplicador);
        skill1CD = 2;
    }

    @Override
    public void skill2(Personagem ini) throws Exception{
        int d = ini.getSomaDados();
        
        while(d<=ini.getSomaDados())
        {
            ini.jogarDados();
        }
        
        skill2CD = 5;
    }

    @Override
    public void ult(Personagem ini) throws Exception{
        int multiplicador = getSomaDados()/6;
        if(multiplicador==0)
        {
            multiplicador=1;
        }
        ini.dano((intel.getEfetiva())*multiplicador);
        ultCD=0;
    }

    
    
    

    
}
