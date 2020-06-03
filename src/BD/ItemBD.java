package BD;

import Model.Const;
import Model.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ItemBD {
    
    /**
     * Cria a tabela de itens na Base de dados, com suas respectivas colunas referente à seus atributos
     */
    public void createTable()
    {
        String newTb = "create table Item("+
    
                "typ int,"+
                "typEq int,"+
                "qtd int,"+
                "qm int,"+
                "fe float(10),"+
                "intel float(10),"+
                "str float(10),"+
                "dex float(10),"+
                "luck float(10),"+
                "resist float(10),"+
                "critC float(10),"+
                "hp int,"+
                "name varchar(200),"+
                "cod int primary key,"+
                "prec int,"+
                "im varchar(200)"+
        ")";
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(newTb);
            st.executeQuery();
        } catch(SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }

    public void insertItem(Item item)
    {
        String insert = "insert into Item (typ, typEq, qtd, qm, fe, intel, str, dex, luck, resist, critC, hp, name, cod, prec, im) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(insert);
            
            //////////////////////////////////////////////
            if(item.getType()==Const.CONSUMIVEL)
            {
                st.setInt(1, 1);
            }
            else
            {
                st.setInt(1, 2);
            }
            //////////////////////////////////////////////
            if(item.getTipoEquip()==Const.PERNAS)
            {
                st.setInt(2, 1);
            }
            else if(item.getTipoEquip()==Const.TORSO)
            {
                st.setInt(2, 2);
            }
            else if(item.getTipoEquip()==Const.WEAPON)
            {
                st.setInt(2, 3);
            }
            else if(item.getTipoEquip()==Const.CONSUMIVEL)
            {
                st.setInt(2, 4);
            }
            //////////////////////////////////////////////
            
                st.setInt(3, item.getQtd());
            
            //////////////////////////////////////////////
            
                st.setInt(4, item.getQtdMax());
                
            //////////////////////////////////////////////
                
                st.setDouble(5, item.getPfe());
                
            //////////////////////////////////////////////
                
                st.setDouble(6, item.getPintel());
                
            //////////////////////////////////////////////
                
                st.setDouble(7, item.getPstr());
                
            //////////////////////////////////////////////
                
                st.setDouble(8, item.getPdex());
                
            //////////////////////////////////////////////
                
                st.setDouble(9, item.getPluck());
                
            //////////////////////////////////////////////
                
                st.setDouble(10, item.getPresist());
                
            //////////////////////////////////////////////
                
                st.setDouble(11, item.getPcritC());
                
            //////////////////////////////////////////////
                
                st.setInt(12, item.getChp());
                
            //////////////////////////////////////////////
                
                st.setString(13, item.getNome());
                
            //////////////////////////////////////////////
                
                st.setInt(14, item.getCode());

            //////////////////////////////////////////////
                
                st.setInt(15, item.getPreco());
                
            //////////////////////////////////////////////
                
                st.setString(16, item.getIm());
                
            //////////////////////////////////////////////
            
                
                
                
            st.executeUpdate();
        } catch(SQLException ex) {
            if(ex.getMessage().equals("ERROR: relation \"item\" does not exist\n  Posição: 13"))
            {
                createTable();
                insertItem(item);
            }
            
        }
    }
    
    public void updateItem(Item item)
    {
        String update = "update Item set typ=? , typEq=? , qtd=? , qm = ? , fe = ? , intel = ? , str = ? , dex = ? , luck = ? , resist = ? , critC = ? , hp = ? , name = ? , prec = ? , im = ? where cod = "+item.getCode();
        
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(update);
            
            //////////////////////////////////////////////
            if(item.getType()==Const.CONSUMIVEL)
            {
                st.setInt(1, 1);
            }
            else
            {
                st.setInt(1, 2);
            }
            //////////////////////////////////////////////
            if(item.getTipoEquip()==Const.PERNAS)
            {
                st.setInt(2, 1);
            }
            else if(item.getTipoEquip()==Const.TORSO)
            {
                st.setInt(2, 2);
            }
            else if(item.getTipoEquip()==Const.WEAPON)
            {
                st.setInt(2, 3);
            }
            //////////////////////////////////////////////
            
                st.setInt(3, item.getQtd());
            
            //////////////////////////////////////////////
            
                st.setInt(4, item.getQtdMax());
                
            //////////////////////////////////////////////
                
                st.setDouble(5, item.getPfe());
                
            //////////////////////////////////////////////
                
                st.setDouble(6, item.getPintel());
                
            //////////////////////////////////////////////
                
                st.setDouble(7, item.getPstr());
                
            //////////////////////////////////////////////
                
                st.setDouble(8, item.getPdex());
                
            //////////////////////////////////////////////
                
                st.setDouble(9, item.getPluck());
                
            //////////////////////////////////////////////
                
                st.setDouble(10, item.getPresist());
                
            //////////////////////////////////////////////
                
                st.setDouble(11, item.getPcritC());
                
            //////////////////////////////////////////////
                
                st.setInt(12, item.getChp());
                
            //////////////////////////////////////////////
                
                st.setString(13, item.getNome());

            //////////////////////////////////////////////
                
                st.setInt(14, item.getPreco());
                
            //////////////////////////////////////////////
                
                st.setString(15, item.getIm());
                
            //////////////////////////////////////////////
            
                
                
                
            st.executeUpdate();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Item retrieveItem(int code)
    {
        String retrieve = "select * from Item where cod= "+code;
        Item item = null;
        if(code == -1)
        {
            return null;
        }
        else
        {
            try {
                PreparedStatement st = Conexao.getConnection().prepareStatement(retrieve);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {

                    int tipo = rs.getInt("typ");
                    int tipoEq = rs.getInt("typeq");
                    int qtd = rs.getInt("qtd");
                    int qm = rs.getInt("qm"); 
                    double fe = rs.getDouble("fe");
                    double intel = rs.getDouble("intel");
                    double str = rs.getDouble("str");
                    double dex = rs.getDouble("dex");
                    double luck = rs.getDouble("luck");
                    double resist = rs.getDouble("resist");
                    double critC = rs.getDouble("critc");
                    int hp = rs.getInt("hp");
                    String name = rs.getString("name");
                    int codigo = rs.getInt("cod");
                    int preco = rs.getInt("prec");
                    String im = rs.getString("im");

                    Const tipoEquip;
                    Const type;

                    if(tipo==1)
                    {
                        type = Const.CONSUMIVEL;
                    }
                    else
                    {
                        type = Const.EQUIPAMENTO;
                    }

                    if(tipoEq==1)
                    {
                        tipoEquip = Const.PERNAS;
                    }
                    else if(tipoEq==2)
                    {
                        tipoEquip = Const.TORSO;
                    }
                    else if(tipoEq==3)
                    {
                        tipoEquip = Const.WEAPON;
                    }
                    else
                    {
                        tipoEquip = Const.CONSUMIVEL;
                    }

                    item = new Item(type, tipoEquip, qm, fe, intel, str, dex, luck, resist, critC, hp, name, code, preco, im);
                    item.setQtd(qtd);
                }
            } catch(SQLException ex) {
                //System.out.println(ex.getMessage());
            }
        }
        
        return item;
    }
    
}
