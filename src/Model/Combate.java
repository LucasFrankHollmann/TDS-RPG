package Model;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe que gerencia os combates do jogo.
 * @author Megatron
 */
public class Combate{
    
    PersonagemJogavel jog;
    Inimigos ini;
    Random rand = new Random();
    
    /**
     *
     * @param j personagem jogável que está sendo utilizado
     * @param i inimigo que está sendo enfrentado
     * 
     * Construtor da classe Combate.
     */
    public Combate(PersonagemJogavel j, Inimigos i)
    {
        jog = j;
        ini = i;
    }
    
    /**
     * método Joga, na qual todo combate ocorrerá
     * @param vez int que define quem irá começar aquele turno 0- inimigo 1-player
     * @param e habilidade que o player escolheu para utilizar durante o combate
     * Quando o player tiver que escolher qual habilidade irá usar, é analisado se a habilidade
     * está em tempo de recarga e se o número que ele tirou na rolagem de dados é igual ou maior
     * ao que é necessário para usá-la
     * Por fim é analisado se o inimigo ou o player morreram
     */
    public int joga(int vez, int e) throws Exception
    {
        if(vez == 0) // inimigo joga
        {
            
            if(jog.passivaAtiva() && jog.getClasse()==Const.CAVALEIRO)
            {
                ini.dano(ini.atk(jog)/2);
            }
            else if(rand.nextInt(100)<=10)
            {
                ini.SkillBoss(jog);
                
            }
            else
            {
                ini.atk(jog);
                
            }
            jog.setPassivaAt();
            
        }
        else //player joga
        {
            
            
            if(jog.getSomaDados()>=15)
            {
                jog.passiva(ini);
            }
            
            if(ini.isDead())
            {
               jog.setGold(jog.getGold()+ini.getDropG());
               jog.incXP(ini.getDropXP());
               jog.removeItemFX();
               return 1;
            }
            
            
            int flag = 0;
            while(flag == 0)
            {
                /*System.out.println("Escolha uma opção:\n 1 - Usar item\n 2 - Skill 1\n 3 - Skill 2\n 4 - Skill Ultimate\n 5 - ataque basico");*/
                switch(e)
                {
                    case 1:
                        //System.out.println("Selecione um item!");
                    case 2:
                        if(jog.getSkill1CD()==0)
                        {
                            jog.skill1(ini);
                            flag = 1;
                        }
                        else
                        {
                        //System.out.println("Skill indisponível!");
                        }
                        break;
                    case 3:
                        if(jog.getSkill2CD()==0)
                        {
                            jog.skill2(ini);
                            flag = 1;
                        }
                        else
                        {
                        //System.out.println("Skill indisponível!");
                        }
                        break;
                    case 4:
                        if(jog.getUltCD()>=45)
                        {
                            jog.ult(ini);
                            flag = 1;
                        }
                        else
                        {
                            //System.out.println("Skill indisponível!");
                        }
                        break;
                    case 5:
                        jog.atk(ini);
                        flag=1;
                        break;
                }
            }
        }
        
        if(jog.isDead())
        {
            //ini wins
            jog.removeItemFX();
            return 0;
        }
        else if(ini.isDead())
        {
            jog.setGold(jog.getGold()+ini.getDropG());
            jog.incXP(ini.getDropXP());
            jog.removeItemFX();
            return 1;
        }
        return -1;
    }
    
    /**
     * Classe turno que prepara os personagens para um novo round, rolando seus dados e sorteando quem irá começar 
     * os ataques
     * @return retorna que irá começar
     * @throws Exception 
     */
    public int turno() throws Exception
    {
        jog.jogarDados();
        ini.jogarDados();
        int vez = rand.nextInt(2);
        
        
        return vez;
    }

}
