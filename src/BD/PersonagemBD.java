package BD;

import Model.Arqueiro;
import Model.Cavaleiro;
import Model.PersonagemJogavel;
import Model.Const;
import Model.Item;
import Model.Mago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonagemBD {
    
    /**
     * Cria a tabela de Personagem na base de dados, com as colunas referentes à atributos, level,
     * experiencia, dinheiro, itens que possui e seu equipamento
     */
    public void createTable()
    {
        String newTb = "create table Personagem("+
                
                "id serial primary key,"+
                "nome varchar(200),"+
                "lvl int,"+
                "xp int,"+
                "gold int,"+
                "fe int,"+
                "intel int,"+
                "str int,"+
                "dex int,"+
                "luck int,"+
                "resist int,"+
                "critC int,"+
                "hp int,"+  
                "hpatual int,"+
                "attrpts int,"+
                "mapnodeatual int,"+
                "mapaatual int,"+
                "raca int,"+
                "classe int,"+  
                "item1 int,"+
                "item2 int,"+
                "item3 int,"+
                "item4 int,"+
                "item5 int,"+
                "item6 int,"+
                "item7 int,"+
                "item8 int,"+
                "item9 int,"+
                "item10 int,"+
                "item11 int,"+
                "item12 int,"+
                "item1qtd int,"+
                "item2qtd int,"+
                "item3qtd int,"+
                "item4qtd int,"+
                "item5qtd int,"+
                "item6qtd int,"+
                "item7qtd int,"+
                "item8qtd int,"+
                "item9qtd int,"+
                "item10qtd int,"+
                "item11qtd int,"+
                "item12qtd int,"+
                "equip1 int,"+
                "equip2 int,"+
                "equip3 int"+
        ")";
        





    
    
        
        
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(newTb);
            st.executeQuery();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void insertPersonagem(PersonagemJogavel perso)
    {
        for(int i = 0;i<12;i++)
        {
            if(perso.getBag()[i]!=null)
            {
                new ItemBD().insertItem(perso.getBag()[i]);
            }
        }
        for(int i = 0;i<3;i++)
        {
            if(perso.getEquips()[i]!=null)
            {
                new ItemBD().insertItem(perso.getEquips()[i]);
            }
        }
        
        
        
        String insert = "insert into personagem (nome, lvl, xp, gold, fe, intel,"
                + " str, dex, luck, resist, critc, hp, hpatual, attrpts, mapnodeatual,"
                + " mapaatual, raca, classe, item1, item2, item3, item4, item5,"
                + " item6, item7, item8, item9, item10, item11, item12, item1qtd, "
                + "item2qtd, item3qtd, item4qtd, item5qtd, item6qtd, item7qtd, "
                + "item8qtd, item9qtd, item10qtd, item11qtd, item12qtd, equip1,"
                + " equip2, equip3) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(insert);
            
            ////////////////////////////////////////////////////////////////////////
            st.setString(1, perso.getNome());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(2, perso.getLvl());
            ///////////////////////////////////////////////////////////////////////
            st.setInt(3, perso.getXp());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(4, perso.getGold());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(5, perso.getFeB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(6, perso.getIntB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(7, perso.getStrB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(8, perso.getDexB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(9, perso.getLuckB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(10, perso.getResistB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(11, perso.getCritB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(12, perso.getHPB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(13, perso.getHP());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(14, perso.getAttrPts());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(15, perso.getMapNodeAtual());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(16, perso.getMapaAtual());
            ////////////////////////////////////////////////////////////////////////
            if(perso.getRaça()==Const.HUMANO)
            {
                st.setInt(17, 1);
            }
            else if(perso.getRaça()==Const.ELFO)
            {
                st.setInt(17, 2);
            }
            else if(perso.getRaça()==Const.ORC)
            {
                st.setInt(17, 3);
            }
            else if(perso.getRaça()==Const.FADA)
            {
                st.setInt(17, 4);
            }
            else if(perso.getRaça()==Const.DEMONIO)
            {
                st.setInt(17, 5);
            }
            else if(perso.getRaça()==Const.CIBORGUE)
            {
                st.setInt(17, 6);
            }
            
            ////////////////////////////////////////////////////////////////////////
            if(perso.getClasse()==Const.ARQUEIRO)
            {
                st.setInt(18, 1);
            }
            else if(perso.getClasse()==Const.MAGO)
            {
                st.setInt(18, 2);
            }
            else if(perso.getClasse()==Const.CAVALEIRO)
            {
                st.setInt(18, 3);
            }
            ////////////////////////////////////////////////////////////////////////
            for(int i =0;i<12;i++)
            {
                if(perso.getBag()[i]!=null)
                {
                    st.setInt((19+i), perso.getBag()[i].getCode());
                }
                else
                {
                    st.setInt((19+i), -1);
                }
            }
            ////////////////////////////////////////////////////////////////////////
            for(int i =0;i<12;i++)
            {
                if(perso.getBag()[i]!=null)
                {
                    st.setInt((31+i), perso.getBag()[i].getQtd());
                }
                else
                {
                    st.setInt((31+i), -1);
                }
            }
            ////////////////////////////////////////////////////////////////////////
            for(int i =0;i<3;i++)
            {
                if(perso.getEquips()!=null)
                {
                st.setInt((43+i), perso.getEquips()[i].getCode());
                }
                else
                {
                    st.setInt((43+i), -1);
                }
            }
            ////////////////////////////////////////////////////////////////////////
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            if(ex.getMessage().equals("ERROR: relation \"personagem\" does not exist\n  Posição: 13"))
            {
                createTable();
                insertPersonagem(perso);
            }
        }
    }
    
    public void updatePersonagem(PersonagemJogavel perso)
    {
        for(int i = 0;i<12;i++)
        {
            if(perso.getBag()[i]!=null)
            {
                new ItemBD().insertItem(perso.getBag()[i]);
            }
        }
        for(int i = 0;i<3;i++)
        {
            if(perso.getEquips()[i]!=null)
            {
                new ItemBD().insertItem(perso.getEquips()[i]);
            }
        }
        
        
        
        String insert = "update personagem set lvl=?, xp=?, gold=?, fe=?, intel=?,"
                + " str=?, dex=?, luck=?, resist=?, critc=?, hp=?, hpatual=?, attrpts=?, mapnodeatual=?,"
                + " mapaatual=?, raca=?, classe=?, item1=?, item2=?, item3=?, item4=?, item5=?,"
                + " item6=?, item7=?, item8=?, item9=?, item10=?, item11=?, item12=?, item1qtd=?, "
                + "item2qtd=?, item3qtd=?, item4qtd=?, item5qtd=?, item6qtd=?, item7qtd=?, "
                + "item8qtd=?, item9qtd=?, item10qtd=?, item11qtd=?, item12qtd=?, equip1=?,"
                + " equip2=?, equip3=?, nome=? where id = "+perso.getID();
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(insert);
            
            
            ///////////////////////////////////////////////////////////////////////
            st.setInt(1, perso.getLvl());
            ///////////////////////////////////////////////////////////////////////
            st.setInt(2, perso.getXp());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(3, perso.getGold());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(4, perso.getFeB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(5, perso.getIntB());
            ///////////////////////////////////////////////////////////////////////
            st.setInt(6, perso.getStrB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(7, perso.getDexB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(8, perso.getLuckB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(9, perso.getResistB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(10, perso.getCritB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(11, perso.getHPB());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(12, perso.getHP());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(13, perso.getAttrPts());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(14, perso.getMapNodeAtual());
            ////////////////////////////////////////////////////////////////////////
            st.setInt(15, perso.getMapaAtual());
            ////////////////////////////////////////////////////////////////////////
            if(perso.getRaça()==Const.HUMANO)
            {
                st.setInt(16, 1);
            }
            else if(perso.getRaça()==Const.ELFO)
            {
                st.setInt(16, 2);
            }
            else if(perso.getRaça()==Const.ORC)
            {
                st.setInt(16, 3);
            }
            else if(perso.getRaça()==Const.FADA)
            {
                st.setInt(16, 4);
            }
            else if(perso.getRaça()==Const.DEMONIO)
            {
                st.setInt(16, 5);
            }
            else if(perso.getRaça()==Const.CIBORGUE)
            {
                st.setInt(16, 6);
            }
            
            ////////////////////////////////////////////////////////////////////////
            if(perso.getClasse()==Const.ARQUEIRO)
            {
                st.setInt(17, 1);
            }
            else if(perso.getClasse()==Const.MAGO)
            {
                st.setInt(17, 2);
            }
            else if(perso.getClasse()==Const.CAVALEIRO)
            {
                st.setInt(17, 3);
            }
            ////////////////////////////////////////////////////////////////////////
            for(int i =0;i<12;i++)
            {
                if(perso.getBag()[i]!=null)
                {
                    st.setInt((18+i), perso.getBag()[i].getCode());
                }
                else
                {
                    st.setInt((18+i), -1);
                }
            }
            ////////////////////////////////////////////////////////////////////////
            for(int i =0;i<12;i++)
            {
                if(perso.getBag()[i]!=null)
                {
                    st.setInt((30+i), perso.getBag()[i].getQtd());
                }
                else
                {
                    st.setInt((30+i), -1);
                }
            }
            ////////////////////////////////////////////////////////////////////////
            for(int i =0;i<3;i++)
            {
                if(perso.getEquips()[i]!=null)
                {
                    st.setInt((42+i), perso.getEquips()[i].getCode());
                }
                else
                {
                    st.setInt((42+i), -1);
                }
            }
            ////////////////////////////////////////////////////////////////////////
            st.setString(45, perso.getNome());
            ////////////////////////////////////////////////////////////////////////
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public PersonagemJogavel retrievePersonagem(int ide)
    {
        String retrieve = "select * from personagem where id= "+ide;
        PersonagemJogavel perso = null;
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(retrieve);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                
                ////////////////////////////////////////////////////
                String nome = rs.getString("nome");
                ////////////////////////////////////////////////////
                int lvl = rs.getInt("lvl");
                ////////////////////////////////////////////////////
                int xp = rs.getInt("xp");
                ////////////////////////////////////////////////////
                int gold = rs.getInt("gold");
                ////////////////////////////////////////////////////
                int fe = rs.getInt("fe");
                ////////////////////////////////////////////////////
                int intel = rs.getInt("intel");
                ////////////////////////////////////////////////////
                int str = rs.getInt("str");
                ////////////////////////////////////////////////////
                int dex = rs.getInt("dex");
                ////////////////////////////////////////////////////
                int luck = rs.getInt("luck");
                ////////////////////////////////////////////////////
                int resist = rs.getInt("resist");
                ////////////////////////////////////////////////////
                int critc = rs.getInt("critc");
                ////////////////////////////////////////////////////
                int hp = rs.getInt("hp");
                ////////////////////////////////////////////////////
                int hpatual = rs.getInt("hpatual");
                ////////////////////////////////////////////////////
                int attrpts = rs.getInt("attrpts");
                ////////////////////////////////////////////////////
                int mapnodeatual = rs.getInt("mapnodeatual");
                ////////////////////////////////////////////////////
                int mapaatual = rs.getInt("mapaatual");
                ////////////////////////////////////////////////////
                int raca = rs.getInt("raca");
                ////////////////////////////////////////////////////
                int classe = rs.getInt("classe");
                ////////////////////////////////////////////////////
                Item[] bag = new Item[12];
                for(int i = 0;i<12;i++)
                {
                    bag[i] = new ItemBD().retrieveItem(rs.getInt("item"+(i+1)));
                }
                ////////////////////////////////////////////////////
                for(int i = 0;i<12;i++)
                {
                    if(bag[i]!=null)
                    {
                        bag[i].setQtd(rs.getInt("item"+(i+1)+"qtd"));
                    }
                }
                ////////////////////////////////////////////////////
                Item[] equips = new Item[12];
                for(int i = 0;i<3;i++)
                {
                    equips[i] = new ItemBD().retrieveItem(rs.getInt("equip"+(i+1)));
                }
                ////////////////////////////////////////////////////
                int id = rs.getInt("id");
                ////////////////////////////////////////////////////
                
                
                Const racac;
                
                if(raca == 1)
                {
                    racac = Const.HUMANO;
                }
                else if(raca == 2)
                {
                    racac = Const.ELFO;
                }
                else if(raca == 3)
                {
                    racac = Const.ORC;
                }
                else if(raca == 4)
                {
                    racac = Const.FADA;
                }
                else if(raca == 5)
                {
                    racac = Const.DEMONIO;
                }
                else
                {
                    racac = Const.CIBORGUE;
                }
                
                if(classe == 1)
                {
                    perso = new Arqueiro(nome,lvl,xp,gold,fe,intel,str,dex,luck,resist,critc,hp,hpatual,attrpts,mapnodeatual,mapaatual,racac,bag,equips);
                }
                else if(classe == 2)
                {
                    perso = new Mago(nome,lvl,xp,gold,fe,intel,str,dex,luck,resist,critc,hp,hpatual,attrpts,mapnodeatual,mapaatual,racac,bag,equips);
                }
                else
                {
                    perso = new Cavaleiro(nome,lvl,xp,gold,fe,intel,str,dex,luck,resist,critc,hp,hpatual,attrpts,mapnodeatual,mapaatual,racac,bag,equips);
                }
                perso.setID(id);
                
            }
            else
            {
               
            }
            
            
            
            
            
            
            
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        
        
        return perso;    
    }

    public boolean isPersonagemListEmpty()
    {
        String retrieve = "select * from personagem where id= "+1;
        
        PreparedStatement st;
        try {
            st = Conexao.getConnection().prepareStatement(retrieve);
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                return false;
            }
            else
            {
                return true;
            }
        } catch (SQLException ex) {
            if(ex.getMessage().equals("ERROR: relation \"personagem\" does not exist\n  Posição: 15"))
            {
                createTable();
                return true;
            }
        }
        return false;
    }
    
    public void removePersonagem(int id)
    {
        String remove = "update personagem set nome = 'unused' where id = "+id;
        
        PreparedStatement st;
        try {
            st = Conexao.getConnection().prepareStatement(remove);
            st.executeUpdate();
        }catch(SQLException ex){
            
        }
        
    }

    public int getPosicao()
    {
        String retrieve = "select * from personagem where id= "+1;
        
        PreparedStatement st;
        try {
            st = Conexao.getConnection().prepareStatement(retrieve);
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                if((rs.getString("nome").equals("unused")))
                {
                    return 1;
                }
            }
            
        } catch (SQLException ex) {
            if(ex.getMessage().equals("ERROR: relation \"personagem\" does not exist\n  Posição: 15"))
            {
                createTable();
                return 1;
            }
        }
        
        retrieve = "select * from personagem where id= "+2;
        
        try {
            st = Conexao.getConnection().prepareStatement(retrieve);
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                if((rs.getString("nome").equals("unused")))
                {
                    return 2;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonagemBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        retrieve = "select * from personagem where id= "+3;
        
        try {
            st = Conexao.getConnection().prepareStatement(retrieve);
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                if((rs.getString("nome").equals("unused")))
                {
                    return 3;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonagemBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 4;
    }

    public String getNome(int i)
    {
        String retrieve = "select nome from personagem where id= "+i;
        String nome = null;
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(retrieve);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                nome = rs.getString("nome");
            }
        }catch(SQLException ex){
            
        }
        
        return nome;
    }
    
    public int getLvl(int i)
    {
        String retrieve = "select lvl from personagem where id= "+i;
        int lvl = 0;
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(retrieve);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                lvl = rs.getInt("lvl");
            }
        }catch(SQLException ex){
            
        }
        
        return lvl;
    }
}