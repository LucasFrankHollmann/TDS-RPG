package Model;

import java.util.Random;


public class Boss extends Inimigos {
    
    private Random r = new Random();
    
    /**
     *
     * Construtor da classe Boss, com seus respectivos ataques
     */
    public Boss(String Nome, char at1, char at2, int ffe,int iintel,int sstr,int ddex,int lluck,int rresist,int ccritC, int hhp, int llvl, String d, String a1, String a2, String a3, String a4, String a5, String p, int t1, int t2, int t3, int t4, int t5, int tp)
    {
       super(Nome,d,a1,a2,a3,a4,a5,p,t1,t2,t3,t4,t5,tp);
       lvl = llvl;
       dropG = 101+r.nextInt(100)*lvl;
       dropXP = 100*lvl;
       d1 = new Dado(10);
       d2 = new Dado(10);
       d3 = new Dado(10); 
       fe = new Atributo(ffe);
       intel = new Atributo(iintel);
       str = new Atributo(sstr);
       dex = new Atributo(ddex);
       luck = new Atributo(lluck);
       HP = new Vida(hhp);
       resist = new Atributo(rresist);
       critC = new Atributo(ccritC);
      
       
       switch(at1)
       {
           case 'f':
               attrPrincipal = fe;
               break;
           case 'i':
               attrPrincipal = intel;
               break;
           case 's':
               attrPrincipal = str;
               break;
           case 'd':
               attrPrincipal = dex;
               break;
       }
       
       switch(at2)
       {
           case 'f':
               attrSecundario = fe;
               break;
           case 'i':
               attrSecundario = intel;
               break;
           case 's':
               attrSecundario = str;
               break;
           case 'd':
               attrSecundario = dex;
               break;
   
       }
       
    }

    
    @Override
    public void SkillBoss(Personagem P)
    {
        P.dano(3*(attrPrincipal.getEfetiva()*75 + attrSecundario.getEfetiva()*25)/100);
    }


}