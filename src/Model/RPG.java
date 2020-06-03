package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import BD.*;

public class RPG {
    
    private PersonagemJogavel perso;
    private Mapa[] map = new Mapa[2];
    private int mapaAtual;
    CodeGen codeGen = new CodeGen();
    
    /**
     * Construtor criado do inicio da execução do jogo, criando os três slots para criação de personagem
     */
    public RPG()
    {
        map[0] = new Mapa1(codeGen);
        if(new PersonagemBD().isPersonagemListEmpty())
        {
            try {
                new PersonagemBD().insertPersonagem(new Arqueiro("unused", Const.ORC));
                new PersonagemBD().insertPersonagem(new Arqueiro("unused", Const.ORC));
                new PersonagemBD().insertPersonagem(new Arqueiro("unused", Const.ORC));
            } catch (Exception ex) {
                Logger.getLogger(RPG.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public MapNode getNodeAtual()
    {
        
        if(perso.getMapNodeAtual()>=-1)
        {
            
            return map[perso.getMapaAtual()].getNodeAtual(perso.getMapNodeAtual());
        }
        else
        {
            
            return null;
        }
    }
    
    public PersonagemJogavel getPersonagem() throws Exception
    {
        
        return perso;
    }

    public void criaPerso(Const classe, String nome, Const raca) throws Exception {
        
        if(nome.equals("unused"))
        {
            System.exit(0); //nome proibido, easter egg de crashar o jogo.
        }
            
        if(classe == Const.ARQUEIRO)
        {
            perso = new Arqueiro(nome, raca, codeGen);
        }
        else if(classe == Const.MAGO)
        {
            perso = new Mago(nome, raca, codeGen);
        }
        if(classe == Const.CAVALEIRO)
        {
            perso = new Cavaleiro(nome, raca, codeGen);
        }
        perso.setID(new PersonagemBD().getPosicao());
        
        new PersonagemBD().updatePersonagem(perso);
        
        
    }
    
    /**
     * Verifica se há slots disponíveis para criação de personagem
     * @return verdadeiro caso não haja mais posições disponíveis
     */
    public boolean bdIsFull()
    {
        if(new PersonagemBD().getPosicao()==4)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Carrega para jogar um personagem anteriormente criado
     * @param i slot do personagem
     */
    public void loadPersonagem(int i)
    {
        perso = new PersonagemBD().retrievePersonagem(i);
    }
}
