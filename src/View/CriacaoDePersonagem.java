package View;

import Controller.ControllerPersonagem;
import Model.Const;
import Model.Item;
import java.awt.Color;
import java.awt.MouseInfo;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Megatron
 */
public class CriacaoDePersonagem extends javax.swing.JFrame {

    Semaphore sem = new Semaphore(1);
    Item[] bag = new Item[12];
    Item[] equip = new Item[3];
    ControllerPersonagem controlPerso;
    Const Classe;
    Const Raca;
    JFrame pai;
    
    int racaNum, classeNum;
    
    /**
     * Creates new form CriacaoDePersonagem
     */
    public CriacaoDePersonagem(ControllerPersonagem ctrlperso, JFrame parent) {
        initComponents();
        
        controlPerso=ctrlperso;
        itemDescript.setVisible(false);
        SkillDesc.setVisible(false);
        Classe = Const.ARQUEIRO;
        MainPanel.setLocation(getX(),getY());
        
        
        racaNum=1;
        classeNum=1;
        updateHUD();
        
        pai = parent;
    }
    
    public void updateHUD()
    {
        if(classeNum==1)
        {
            lbArma.setIcon(new ImageIcon(getClass().getResource("/Resources/ArcoPadrao.png")));
            Classe = Const.ARQUEIRO;
            lbClasse.setText("Arqueiro");
        }
        else if(classeNum==2)
        {
            lbArma.setIcon(new ImageIcon(getClass().getResource("/Resources/CajadoPadrao.png")));
            Classe = Const.MAGO;
            lbClasse.setText("Mago");
        }
        else if(classeNum==3)
        {
            lbArma.setIcon(new ImageIcon(getClass().getResource("/Resources/espadaPadrão.png")));
            Classe = Const.CAVALEIRO;
            lbClasse.setText("Cavaleiro");
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if(racaNum==1)
        {
            lbPerso.setIcon(new ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png")));
            lbRaca.setText("Humano");
            Raca = Const.HUMANO;
        }
        else if(racaNum==2)
        {
            lbPerso.setIcon(new ImageIcon(getClass().getResource("/Resources/ElfoPadrão.png")));
            lbRaca.setText("Elfo");
            Raca = Const.ELFO;
        }
        else if(racaNum==3)
        {
            lbPerso.setIcon(new ImageIcon(getClass().getResource("/Resources/OrcPadrão.png")));
            lbRaca.setText("Orc");
            Raca = Const.ORC;
        }
        else if(racaNum==4)
        {
            lbPerso.setIcon(new ImageIcon(getClass().getResource("/Resources/DemonioPadrao.png")));
            lbRaca.setText("Demônio");
            Raca = Const.DEMONIO;
        }
        else if(racaNum==5)
        {
            lbPerso.setIcon(new ImageIcon(getClass().getResource("/Resources/CiborguePadrão.png")));
            lbRaca.setText("Ciborgue");
            Raca = Const.CIBORGUE;
        }
        else if(racaNum==6)
        {
            lbPerso.setIcon(new ImageIcon(getClass().getResource("/Resources/FadaPadrão.png")));
            lbRaca.setText("Fada");
            Raca = Const.FADA;
        }
        
        lbHP.setText("    HP: "+controlPerso.getVidaCP(Classe)+"/"+controlPerso.getVidaMaxCP(Classe));
        lbFe.setText("    Fé: "+controlPerso.getFeCP(Classe));
        lbInt.setText("    Inteligência: "+controlPerso.getIntCP(Classe));
        lbStr.setText("    Força: "+controlPerso.getStrCP(Classe));
        lbDex.setText("    Destreza: "+controlPerso.getDexCP(Classe));
        lbLuck.setText("    Sorte: "+controlPerso.getLuckCP(Classe));
        lbResist.setText("    Resistência: "+controlPerso.getResistCP(Classe));
        lbCrit.setText("    Chance de Crítico: "+controlPerso.getCritCP(Classe));
        
        
        
        
        setBag();
    }
    
    public void setBag()
    {
        try {
            bag = controlPerso.getItensIniciais(Classe);
            equip = controlPerso.getEquipsIniciais(Classe);
        } catch (Exception ex) {
            Logger.getLogger(CriacaoDePersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(bag[0]==null)
        {
            lbItem0.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem0.setIcon(bag[0].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[1]==null)
        {
            lbItem1.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem1.setIcon(bag[1].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[2]==null)
        {
            lbItem2.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem2.setIcon(bag[2].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[3]==null)
        {
            lbItem3.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem3.setIcon(bag[3].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[4]==null)
        {
            lbItem4.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem4.setIcon(bag[4].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[5]==null)
        {
            lbItem5.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem5.setIcon(bag[5].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[6]==null)
        {
            lbItem6.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem6.setIcon(bag[6].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[7]==null)
        {
            lbItem7.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem7.setIcon(bag[7].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[8]==null)
        {
            lbItem8.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem8.setIcon(bag[8].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[9]==null)
        {
            lbItem9.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem9.setIcon(bag[9].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[10]==null)
        {
            lbItem10.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem10.setIcon(bag[10].getImg());
            
        }
        ///////////////////////////////////////////////////////////////
        if(bag[11]==null)
        {
            lbItem11.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            lbItem11.setIcon(bag[11].getImg());
            
        }
        
        
        
        setEquip();

    }
    
    public void setEquip()
    {
        if(equip[0]==null)
        {
            lbLegEquiped.setIcon(new ImageIcon(getClass().getResource("/Resources/LegSlot_Empty.png")));
        }
        else
        {
            lbLegEquiped.setIcon(equip[0].getImg());
        }
        if(equip[1]==null)
        {
            lbArmorEquiped.setIcon(new ImageIcon(getClass().getResource("/Resources/ArmorSlot_Empty.png")));
        }
        else
        {
            lbArmorEquiped.setIcon(equip[1].getImg());
        }
        if(equip[2]==null)
        {
            lbWeaponEquiped.setIcon(new ImageIcon(getClass().getResource("/Resources/WeaponSlot_Empty.png")));
        }
        else
        {
            lbWeaponEquiped.setIcon(equip[2].getImg());
        }
    }
    
    public void showItemDesc(Item i)
    {
        ShowItemDesc a = new ShowItemDesc(i,this);
        a.start();
    }
    
    public void removeItemDesc()
    {
        RemoveItemDesc a = new RemoveItemDesc();
        a.start();  
    }
    
    public void showSkillDesc(String nome, String desc, int cd, int passUlt)
    {
        new ShowSkillDesc(nome,desc,cd,this, passUlt).start();
    }
    
    public void removeSkillDesc()
    {
        new RemoveSkillDesc().start();  
    }        
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JLayeredPane();
        Equip = new javax.swing.JPanel();
        SubEquip = new javax.swing.JPanel();
        lbWeaponEquiped = new javax.swing.JLabel();
        lbArmorEquiped = new javax.swing.JLabel();
        lbLegEquiped = new javax.swing.JLabel();
        EquipTitle = new javax.swing.JPanel();
        lbEquipTitle = new javax.swing.JLabel();
        Bag = new javax.swing.JPanel();
        Itens = new javax.swing.JPanel();
        lbItem0 = new javax.swing.JLabel();
        lbItem1 = new javax.swing.JLabel();
        lbItem2 = new javax.swing.JLabel();
        lbItem3 = new javax.swing.JLabel();
        lbItem4 = new javax.swing.JLabel();
        lbItem5 = new javax.swing.JLabel();
        lbItem6 = new javax.swing.JLabel();
        lbItem7 = new javax.swing.JLabel();
        lbItem8 = new javax.swing.JLabel();
        lbItem9 = new javax.swing.JLabel();
        lbItem10 = new javax.swing.JLabel();
        lbItem11 = new javax.swing.JLabel();
        lbBagTitle = new javax.swing.JLabel();
        lbGold = new javax.swing.JLabel();
        itemDescript = new javax.swing.JPanel();
        lbItemDescNome = new javax.swing.JLabel();
        lbItemDescHP = new javax.swing.JLabel();
        lbItemDescFe = new javax.swing.JLabel();
        lbItemDescInt = new javax.swing.JLabel();
        lbItemDescStr = new javax.swing.JLabel();
        lbItemDescDex = new javax.swing.JLabel();
        lbItemDescResist = new javax.swing.JLabel();
        lbItemDescLuck = new javax.swing.JLabel();
        lbItemDescCrit = new javax.swing.JLabel();
        lbItemDescQtd = new javax.swing.JLabel();
        lbItemDescPreco = new javax.swing.JLabel();
        SkillDesc = new javax.swing.JPanel();
        lbSkillDescNome = new javax.swing.JLabel();
        taSkillDescription = new javax.swing.JTextArea();
        lbCdSkill = new javax.swing.JLabel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        lbPassivaSkills = new javax.swing.JLabel();
        btSkill1 = new javax.swing.JButton();
        btSkill2 = new javax.swing.JButton();
        btSkillUlt = new javax.swing.JButton();
        MainPanel = new javax.swing.JLayeredPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lbArma = new javax.swing.JLabel();
        lbPerso = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PersoOptions1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbHP = new javax.swing.JLabel();
        lbLvl = new javax.swing.JLabel();
        lbFe = new javax.swing.JLabel();
        lbInt = new javax.swing.JLabel();
        lbStr = new javax.swing.JLabel();
        lbDex = new javax.swing.JLabel();
        lbLuck = new javax.swing.JLabel();
        lbCrit = new javax.swing.JLabel();
        lbResist = new javax.swing.JLabel();
        lbXP = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        tfPersoNome = new javax.swing.JTextField();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(20, 20), new java.awt.Dimension(0, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        lbClasse = new javax.swing.JLabel();
        btClasse1 = new javax.swing.JButton();
        btClasse2 = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        lbRaca = new javax.swing.JLabel();
        btRaca2 = new javax.swing.JButton();
        btRaca1 = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        btFinaliza = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1282, 747));
        setMinimumSize(new java.awt.Dimension(1282, 747));
        setPreferredSize(new java.awt.Dimension(1282, 747));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        Main.setMaximumSize(new java.awt.Dimension(1280, 720));
        Main.setMinimumSize(new java.awt.Dimension(1280, 720));

        Equip.setBackground(new Color(110,110,110));
        Equip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Equip.setLayout(new java.awt.BorderLayout());

        SubEquip.setBackground(new java.awt.Color(130, 130, 130));
        SubEquip.setLayout(new java.awt.GridLayout(1, 0));

        lbWeaponEquiped.setBackground(new java.awt.Color(100, 100, 100));
        lbWeaponEquiped.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbWeaponEquiped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/WeaponSlot_Empty.png"))); // NOI18N
        lbWeaponEquiped.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbWeaponEquiped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbWeaponEquipedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbWeaponEquipedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbWeaponEquipedMouseExited(evt);
            }
        });
        SubEquip.add(lbWeaponEquiped);

        lbArmorEquiped.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbArmorEquiped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ArmorSlot_Empty.png"))); // NOI18N
        lbArmorEquiped.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbArmorEquiped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbArmorEquipedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbArmorEquipedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbArmorEquipedMouseExited(evt);
            }
        });
        SubEquip.add(lbArmorEquiped);

        lbLegEquiped.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLegEquiped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LegSlot_Empty.png"))); // NOI18N
        lbLegEquiped.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbLegEquiped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLegEquipedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLegEquipedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLegEquipedMouseExited(evt);
            }
        });
        SubEquip.add(lbLegEquiped);

        Equip.add(SubEquip, java.awt.BorderLayout.CENTER);

        EquipTitle.setBackground(new java.awt.Color(100, 100, 100));
        EquipTitle.setPreferredSize(new java.awt.Dimension(232, 18));
        EquipTitle.setLayout(new java.awt.CardLayout());

        lbEquipTitle.setBackground(new java.awt.Color(255, 255, 102));
        lbEquipTitle.setForeground(new java.awt.Color(255, 255, 102));
        lbEquipTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEquipTitle.setText("Equipamentos iniciais");
        EquipTitle.add(lbEquipTitle, "card2");

        Equip.add(EquipTitle, java.awt.BorderLayout.NORTH);

        Bag.setBackground(new java.awt.Color(100, 100, 100));
        Bag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Bag.setMaximumSize(new java.awt.Dimension(380, 225));
        Bag.setMinimumSize(new java.awt.Dimension(380, 225));
        Bag.setPreferredSize(new java.awt.Dimension(380, 225));
        Bag.setLayout(new java.awt.BorderLayout());

        Itens.setBackground(new java.awt.Color(110, 110, 110));
        Itens.setLayout(new java.awt.GridLayout(3, 4));

        lbItem0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem0.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem0.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem0.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem0.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem0MouseDragged(evt);
            }
        });
        lbItem0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem0MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem0MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem0MouseExited(evt);
            }
        });
        Itens.add(lbItem0);

        lbItem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem1.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem1.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem1.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem1MouseDragged(evt);
            }
        });
        lbItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem1MouseExited(evt);
            }
        });
        Itens.add(lbItem1);

        lbItem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem2.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem2.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem2.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem2MouseDragged(evt);
            }
        });
        lbItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem2MouseExited(evt);
            }
        });
        Itens.add(lbItem2);

        lbItem3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem3.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem3.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem3.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem3MouseDragged(evt);
            }
        });
        lbItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem3MouseExited(evt);
            }
        });
        Itens.add(lbItem3);

        lbItem4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem4.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem4.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem4.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem4MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbItem4MouseMoved(evt);
            }
        });
        lbItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem4MouseExited(evt);
            }
        });
        Itens.add(lbItem4);

        lbItem5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem5.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem5.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem5.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem5MouseDragged(evt);
            }
        });
        lbItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem5MouseExited(evt);
            }
        });
        Itens.add(lbItem5);

        lbItem6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem6.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem6.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem6.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem6MouseDragged(evt);
            }
        });
        lbItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem6MouseExited(evt);
            }
        });
        Itens.add(lbItem6);

        lbItem7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem7.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem7.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem7.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem7MouseDragged(evt);
            }
        });
        lbItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem7MouseExited(evt);
            }
        });
        Itens.add(lbItem7);

        lbItem8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem8.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem8.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem8.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem8MouseDragged(evt);
            }
        });
        lbItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem8MouseExited(evt);
            }
        });
        Itens.add(lbItem8);

        lbItem9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem9.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem9.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem9.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem9MouseDragged(evt);
            }
        });
        lbItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem9MouseExited(evt);
            }
        });
        Itens.add(lbItem9);

        lbItem10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem10.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem10.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem10.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem10MouseDragged(evt);
            }
        });
        lbItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem10MouseExited(evt);
            }
        });
        Itens.add(lbItem10);

        lbItem11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem11.setMaximumSize(new java.awt.Dimension(20, 20));
        lbItem11.setMinimumSize(new java.awt.Dimension(20, 20));
        lbItem11.setPreferredSize(new java.awt.Dimension(20, 20));
        lbItem11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbItem11MouseDragged(evt);
            }
        });
        lbItem11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbItem11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbItem11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbItem11MouseExited(evt);
            }
        });
        Itens.add(lbItem11);

        Bag.add(Itens, java.awt.BorderLayout.CENTER);

        lbBagTitle.setForeground(new java.awt.Color(255, 255, 102));
        lbBagTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBagTitle.setText("Itens iniciais");
        lbBagTitle.setMinimumSize(new java.awt.Dimension(58, 20));
        lbBagTitle.setPreferredSize(new java.awt.Dimension(58, 20));
        Bag.add(lbBagTitle, java.awt.BorderLayout.PAGE_START);

        lbGold.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbGold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Gold.png"))); // NOI18N
        lbGold.setText("100");
        Bag.add(lbGold, java.awt.BorderLayout.PAGE_END);

        itemDescript.setBackground(new java.awt.Color(100, 100, 100));
        itemDescript.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        itemDescript.setLayout(new java.awt.GridLayout(11, 1));

        lbItemDescNome.setBackground(new java.awt.Color(102, 51, 0));
        lbItemDescNome.setForeground(new java.awt.Color(255, 255, 102));
        lbItemDescNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItemDescNome.setText(" ");
        itemDescript.add(lbItemDescNome);

        lbItemDescHP.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescHP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescHP);

        lbItemDescFe.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescFe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescFe);

        lbItemDescInt.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescInt);

        lbItemDescStr.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescStr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescStr);

        lbItemDescDex.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescDex);

        lbItemDescResist.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescResist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescResist);

        lbItemDescLuck.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescLuck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescLuck);

        lbItemDescCrit.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescCrit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescCrit);

        lbItemDescQtd.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescQtd);

        lbItemDescPreco.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemDescript.add(lbItemDescPreco);

        SkillDesc.setBackground(new java.awt.Color(100, 100, 100));
        SkillDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        SkillDesc.setMaximumSize(new java.awt.Dimension(250, 100));
        SkillDesc.setMinimumSize(new java.awt.Dimension(250, 100));
        SkillDesc.setPreferredSize(new java.awt.Dimension(250, 100));
        SkillDesc.setLayout(new java.awt.BorderLayout());

        lbSkillDescNome.setBackground(new java.awt.Color(102, 51, 0));
        lbSkillDescNome.setForeground(new java.awt.Color(255, 255, 102));
        lbSkillDescNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSkillDescNome.setText(" ");
        SkillDesc.add(lbSkillDescNome, java.awt.BorderLayout.NORTH);

        taSkillDescription.setEditable(false);
        taSkillDescription.setBackground(new java.awt.Color(130, 130, 130));
        taSkillDescription.setColumns(20);
        taSkillDescription.setRows(5);
        SkillDesc.add(taSkillDescription, java.awt.BorderLayout.PAGE_END);
        SkillDesc.add(lbCdSkill, java.awt.BorderLayout.PAGE_END);

        jLayeredPane8.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Skills da classe");
        jLabel4.setPreferredSize(new java.awt.Dimension(34, 20));
        jLayeredPane8.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jLayeredPane9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 255), 3));
        jLayeredPane9.setLayout(new java.awt.GridLayout(2, 2));

        lbPassivaSkills.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPassivaSkills.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Skill 3.png"))); // NOI18N
        lbPassivaSkills.setMaximumSize(new java.awt.Dimension(45, 45));
        lbPassivaSkills.setMinimumSize(new java.awt.Dimension(45, 45));
        lbPassivaSkills.setPreferredSize(new java.awt.Dimension(45, 45));
        lbPassivaSkills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbPassivaSkillsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbPassivaSkillsMouseExited(evt);
            }
        });
        jLayeredPane9.add(lbPassivaSkills);

        btSkill1.setBackground(new Color(0,0,0,0)
        );
        btSkill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Skill 1.png"))); // NOI18N
        btSkill1.setMinimumSize(new java.awt.Dimension(65, 58));
        btSkill1.setPreferredSize(new java.awt.Dimension(65, 58));
        btSkill1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSkill1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSkill1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSkill1MouseExited(evt);
            }
        });
        btSkill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSkill1ActionPerformed(evt);
            }
        });
        jLayeredPane9.add(btSkill1);

        btSkill2.setBackground(new Color(0,0,0,0)
        );
        btSkill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Skill 4.png"))); // NOI18N
        btSkill2.setMinimumSize(new java.awt.Dimension(65, 58));
        btSkill2.setPreferredSize(new java.awt.Dimension(65, 58));
        btSkill2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSkill2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSkill2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSkill2MouseExited(evt);
            }
        });
        btSkill2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSkill2ActionPerformed(evt);
            }
        });
        jLayeredPane9.add(btSkill2);

        btSkillUlt.setBackground(new Color(0,0,0,0)
        );
        btSkillUlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Skill 2.png"))); // NOI18N
        btSkillUlt.setMinimumSize(new java.awt.Dimension(65, 58));
        btSkillUlt.setPreferredSize(new java.awt.Dimension(65, 58));
        btSkillUlt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSkillUltMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSkillUltMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSkillUltMouseExited(evt);
            }
        });
        btSkillUlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSkillUltActionPerformed(evt);
            }
        });
        jLayeredPane9.add(btSkillUlt);

        jLayeredPane8.add(jLayeredPane9, java.awt.BorderLayout.CENTER);

        MainPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        MainPanel.setMinimumSize(new java.awt.Dimension(1280, 720));
        MainPanel.setLayout(new java.awt.BorderLayout());

        jLayeredPane1.setLayout(new java.awt.GridBagLayout());

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLayeredPane2.setLayout(new javax.swing.OverlayLayout(jLayeredPane2));

        lbArma.setBackground(new Color(130,60,160,100));
        lbArma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbArma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CajadoPadrao.png"))); // NOI18N
        jLayeredPane2.add(lbArma);

        lbPerso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPerso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"))); // NOI18N
        jLayeredPane2.add(lbPerso);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/AlphaBG.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(255, 255));
        jLayeredPane2.add(jLabel2);

        jLayeredPane1.add(jLayeredPane2, new java.awt.GridBagConstraints());

        MainPanel.add(jLayeredPane1, java.awt.BorderLayout.CENTER);

        PersoOptions1.setBackground(new Color(130,60,160,100)
        );
        PersoOptions1.setPreferredSize(new java.awt.Dimension(400, 720));

        jPanel3.setBackground(new java.awt.Color(110, 110, 110));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Atributos iniciais");
        jLabel5.setPreferredSize(new java.awt.Dimension(34, 20));
        jPanel3.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(130, 130, 130));
        jPanel5.setLayout(new java.awt.GridLayout(5, 2));

        lbHP.setText("HP");
        jPanel5.add(lbHP);

        lbLvl.setText("    Nível: 1");
        jPanel5.add(lbLvl);

        lbFe.setText("Fé");
        jPanel5.add(lbFe);

        lbInt.setText("Inteligência");
        jPanel5.add(lbInt);

        lbStr.setText("Força");
        jPanel5.add(lbStr);

        lbDex.setText("Destreza");
        jPanel5.add(lbDex);

        lbLuck.setText("Sorte");
        jPanel5.add(lbLuck);

        lbCrit.setText("Chance de crítico");
        jPanel5.add(lbCrit);

        lbResist.setText("Resistência");
        jPanel5.add(lbResist);

        lbXP.setText("    XP: 0/50");
        jPanel5.add(lbXP);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout PersoOptions1Layout = new javax.swing.GroupLayout(PersoOptions1);
        PersoOptions1.setLayout(PersoOptions1Layout);
        PersoOptions1Layout.setHorizontalGroup(
            PersoOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(PersoOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PersoOptions1Layout.createSequentialGroup()
                    .addContainerGap(55, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );
        PersoOptions1Layout.setVerticalGroup(
            PersoOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(PersoOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PersoOptions1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(450, Short.MAX_VALUE)))
        );

        MainPanel.add(PersoOptions1, java.awt.BorderLayout.EAST);

        jLayeredPane3.setPreferredSize(new java.awt.Dimension(400, 720));
        jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane4.setLayout(new java.awt.GridLayout(8, 0));
        jLayeredPane4.add(filler1);

        jLayeredPane6.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(130, 130, 130));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome:");
        jLabel1.setMaximumSize(new java.awt.Dimension(60, 17));
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 14));
        jLayeredPane6.add(jLabel1, java.awt.BorderLayout.WEST);

        tfPersoNome.setBackground(new java.awt.Color(153, 102, 255));
        tfPersoNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfPersoNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPersoNome.setMaximumSize(new java.awt.Dimension(200, 2147483647));
        jLayeredPane6.add(tfPersoNome, java.awt.BorderLayout.CENTER);
        jLayeredPane6.add(filler4, java.awt.BorderLayout.EAST);

        jLayeredPane4.add(jLayeredPane6);
        jLayeredPane4.add(filler2);

        jLayeredPane7.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(77, 34, 163));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        lbClasse.setBackground(new Color(153,102,255,100));
        lbClasse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbClasse.setForeground(new java.awt.Color(204, 204, 204));
        lbClasse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClasse.setText("Mago");
        jPanel1.add(lbClasse);

        jLayeredPane7.add(jPanel1, java.awt.BorderLayout.CENTER);

        btClasse1.setBackground(new Color(0,0,0,0));
        btClasse1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SetaDir.png"))); // NOI18N
        btClasse1.setPreferredSize(new java.awt.Dimension(120, 45));
        btClasse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClasse1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btClasse1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btClasse1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btClasse1MouseReleased(evt);
            }
        });
        btClasse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClasse1ActionPerformed(evt);
            }
        });
        jLayeredPane7.add(btClasse1, java.awt.BorderLayout.LINE_END);

        btClasse2.setBackground(new Color(0,0,0,0));
        btClasse2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SetaEsq.png"))); // NOI18N
        btClasse2.setMaximumSize(new java.awt.Dimension(45, 45));
        btClasse2.setMinimumSize(new java.awt.Dimension(45, 45));
        btClasse2.setPreferredSize(new java.awt.Dimension(120, 45));
        btClasse2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClasse2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btClasse2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btClasse2MouseExited(evt);
            }
        });
        jLayeredPane7.add(btClasse2, java.awt.BorderLayout.LINE_START);

        jLayeredPane4.add(jLayeredPane7);
        jLayeredPane4.add(filler3);

        jLayeredPane5.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(77, 34, 163));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lbRaca.setBackground(new java.awt.Color(255, 51, 51));
        lbRaca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbRaca.setForeground(new java.awt.Color(204, 204, 204));
        lbRaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRaca.setText("Humano");
        jPanel2.add(lbRaca);

        jLayeredPane5.add(jPanel2, java.awt.BorderLayout.CENTER);

        btRaca2.setBackground(new Color(0,0,0,0));
        btRaca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SetaDir.png"))); // NOI18N
        btRaca2.setPreferredSize(new java.awt.Dimension(120, 45));
        btRaca2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btRaca2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btRaca2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btRaca2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btRaca2MouseReleased(evt);
            }
        });
        btRaca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRaca2ActionPerformed(evt);
            }
        });
        jLayeredPane5.add(btRaca2, java.awt.BorderLayout.LINE_END);

        btRaca1.setBackground(new Color(0,0,0,0));
        btRaca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SetaEsq.png"))); // NOI18N
        btRaca1.setMaximumSize(new java.awt.Dimension(45, 45));
        btRaca1.setMinimumSize(new java.awt.Dimension(45, 45));
        btRaca1.setPreferredSize(new java.awt.Dimension(120, 45));
        btRaca1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btRaca1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btRaca1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btRaca1MouseExited(evt);
            }
        });
        jLayeredPane5.add(btRaca1, java.awt.BorderLayout.LINE_START);

        jLayeredPane4.add(jLayeredPane5);
        jLayeredPane4.add(filler5);

        jLayeredPane3.add(jLayeredPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));

        btFinaliza.setBackground(new java.awt.Color(153, 102, 255));
        btFinaliza.setText("Finalizar");
        btFinaliza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btFinalizaMouseClicked(evt);
            }
        });
        btFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizaActionPerformed(evt);
            }
        });
        jLayeredPane3.add(btFinaliza, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 300, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/AlphaBG.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(12, 720));
        jLayeredPane3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 430, -1));

        MainPanel.add(jLayeredPane3, java.awt.BorderLayout.WEST);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fundoCP.png"))); // NOI18N

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainLayout.createSequentialGroup()
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                    .addContainerGap(1105, Short.MAX_VALUE)
                    .addComponent(itemDescript, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                    .addContainerGap(905, Short.MAX_VALUE)
                    .addComponent(Bag, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainLayout.createSequentialGroup()
                    .addComponent(BG, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainLayout.createSequentialGroup()
                    .addGap(905, 905, 905)
                    .addComponent(Equip, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                    .addContainerGap(73, Short.MAX_VALUE)
                    .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(967, 967, 967)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                    .addContainerGap(376, Short.MAX_VALUE)
                    .addComponent(SkillDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(615, Short.MAX_VALUE)))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                    .addContainerGap(122, Short.MAX_VALUE)
                    .addComponent(itemDescript, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(368, Short.MAX_VALUE)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                    .addContainerGap(402, Short.MAX_VALUE)
                    .addComponent(Bag, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainLayout.createSequentialGroup()
                    .addComponent(BG, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainLayout.createSequentialGroup()
                    .addGap(290, 290, 290)
                    .addComponent(Equip, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(333, Short.MAX_VALUE)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainLayout.createSequentialGroup()
                    .addGap(328, 328, 328)
                    .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)))
            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                    .addContainerGap(542, Short.MAX_VALUE)
                    .addComponent(SkillDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );
        Main.setLayer(Equip, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Main.setLayer(Bag, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Main.setLayer(itemDescript, javax.swing.JLayeredPane.MODAL_LAYER);
        Main.setLayer(SkillDesc, javax.swing.JLayeredPane.MODAL_LAYER);
        Main.setLayer(jLayeredPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Main.setLayer(MainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Main.setLayer(BG, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(Main);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbItem0MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseDragged

    }//GEN-LAST:event_lbItem0MouseDragged

    private void lbItem0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseClicked
        
    }//GEN-LAST:event_lbItem0MouseClicked

    private void lbItem0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseEntered
        if(bag[0]!=null)
        {
            showItemDesc(bag[0]);
        }
    }//GEN-LAST:event_lbItem0MouseEntered

    private void lbItem0MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem0MouseExited

    private void lbItem1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseDragged
        
    }//GEN-LAST:event_lbItem1MouseDragged

    private void lbItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseClicked
        
    }//GEN-LAST:event_lbItem1MouseClicked

    private void lbItem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseEntered
        if(bag[1]!=null)
        {
            showItemDesc(bag[1]);
        }
    }//GEN-LAST:event_lbItem1MouseEntered

    private void lbItem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseExited
        if(bag[1]!=null)
        {
            removeItemDesc();
        }
    }//GEN-LAST:event_lbItem1MouseExited

    private void lbItem2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseDragged
        
    }//GEN-LAST:event_lbItem2MouseDragged

    private void lbItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseClicked
        
    }//GEN-LAST:event_lbItem2MouseClicked

    private void lbItem2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseEntered
        if(bag[2]!=null)
        {
            showItemDesc(bag[2]);
        }
    }//GEN-LAST:event_lbItem2MouseEntered

    private void lbItem2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem2MouseExited

    private void lbItem3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseDragged
        
    }//GEN-LAST:event_lbItem3MouseDragged

    private void lbItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseClicked
        
    }//GEN-LAST:event_lbItem3MouseClicked

    private void lbItem3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseEntered
        if(bag[3]!=null)
        {
            showItemDesc(bag[3]);
        }
    }//GEN-LAST:event_lbItem3MouseEntered

    private void lbItem3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem3MouseExited

    private void lbItem4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseDragged
        
    }//GEN-LAST:event_lbItem4MouseDragged

    private void lbItem4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbItem4MouseMoved

    private void lbItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseClicked
        
    }//GEN-LAST:event_lbItem4MouseClicked

    private void lbItem4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseEntered
        if(bag[4]!=null)
        {
            showItemDesc(bag[4]);
        }
    }//GEN-LAST:event_lbItem4MouseEntered

    private void lbItem4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem4MouseExited

    private void lbItem5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseDragged
        
    }//GEN-LAST:event_lbItem5MouseDragged

    private void lbItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseClicked
        
    }//GEN-LAST:event_lbItem5MouseClicked

    private void lbItem5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseEntered
        if(bag[5]!=null)
        {
            showItemDesc(bag[5]);
        }
    }//GEN-LAST:event_lbItem5MouseEntered

    private void lbItem5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem5MouseExited

    private void lbItem6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseDragged
       
    }//GEN-LAST:event_lbItem6MouseDragged

    private void lbItem6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseClicked
        
    }//GEN-LAST:event_lbItem6MouseClicked

    private void lbItem6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseEntered
        if(bag[6]!=null)
        {
            showItemDesc(bag[6]);
        }
    }//GEN-LAST:event_lbItem6MouseEntered

    private void lbItem6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem6MouseExited

    private void lbItem7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseDragged
        
    }//GEN-LAST:event_lbItem7MouseDragged

    private void lbItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseClicked
        
    }//GEN-LAST:event_lbItem7MouseClicked

    private void lbItem7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseEntered
        if(bag[7]!=null)
        {
            showItemDesc(bag[7]);
        }
    }//GEN-LAST:event_lbItem7MouseEntered

    private void lbItem7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem7MouseExited

    private void lbItem8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseDragged
        
    }//GEN-LAST:event_lbItem8MouseDragged

    private void lbItem8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseClicked
        
    }//GEN-LAST:event_lbItem8MouseClicked

    private void lbItem8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseEntered
        if(bag[8]!=null)
        {
            showItemDesc(bag[8]);
        }
    }//GEN-LAST:event_lbItem8MouseEntered

    private void lbItem8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem8MouseExited

    private void lbItem9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseDragged
        
    }//GEN-LAST:event_lbItem9MouseDragged

    private void lbItem9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseClicked
        
    }//GEN-LAST:event_lbItem9MouseClicked

    private void lbItem9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseEntered
        if(bag[9]!=null)
        {
            showItemDesc(bag[9]);
        }
    }//GEN-LAST:event_lbItem9MouseEntered

    private void lbItem9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem9MouseExited

    private void lbItem10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseDragged
        
    }//GEN-LAST:event_lbItem10MouseDragged

    private void lbItem10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseClicked
        
    }//GEN-LAST:event_lbItem10MouseClicked

    private void lbItem10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseEntered
        if(bag[10]!=null)
        {
            showItemDesc(bag[10]);
        }
    }//GEN-LAST:event_lbItem10MouseEntered

    private void lbItem10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem10MouseExited

    private void lbItem11MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseDragged
        
    }//GEN-LAST:event_lbItem11MouseDragged

    private void lbItem11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseClicked
        
    }//GEN-LAST:event_lbItem11MouseClicked

    private void lbItem11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseEntered
        if(bag[11]!=null)
        {
            showItemDesc(bag[11]);
        }
    }//GEN-LAST:event_lbItem11MouseEntered

    private void lbItem11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem11MouseExited

    private void btClasse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClasse1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btClasse1ActionPerformed

    private void btClasse2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClasse2MouseEntered
       
    }//GEN-LAST:event_btClasse2MouseEntered

    private void btClasse2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClasse2MouseClicked
        if(classeNum==1)
        {
            classeNum=3;
        }
        else
        {
            classeNum--;
        }
        
        updateHUD();
    }//GEN-LAST:event_btClasse2MouseClicked

    private void btClasse1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClasse1MouseEntered
        
    }//GEN-LAST:event_btClasse1MouseEntered

    private void btClasse1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClasse1MouseClicked
        if(classeNum==3)
        {
            classeNum=1;
        }
        else
        {
            classeNum++;
        }
        
        updateHUD();
    }//GEN-LAST:event_btClasse1MouseClicked

    private void btClasse1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClasse1MouseExited
       
    }//GEN-LAST:event_btClasse1MouseExited

    private void btClasse1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClasse1MouseReleased
       
    }//GEN-LAST:event_btClasse1MouseReleased

    private void btClasse2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClasse2MouseExited
        
    }//GEN-LAST:event_btClasse2MouseExited

    private void btRaca2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRaca2MouseClicked
        if(racaNum==6)
        {
            racaNum=1;
        }
        else
        {
            racaNum++;
        }
        
        updateHUD();
    }//GEN-LAST:event_btRaca2MouseClicked

    private void btRaca2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRaca2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btRaca2MouseEntered

    private void btRaca2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRaca2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btRaca2MouseExited

    private void btRaca2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRaca2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btRaca2MouseReleased

    private void btRaca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRaca2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRaca2ActionPerformed

    private void btRaca1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRaca1MouseClicked
        if(racaNum==1)
        {
            racaNum=6;
        }
        else
        {
            racaNum--;
        }
        
        updateHUD();
    }//GEN-LAST:event_btRaca1MouseClicked

    private void btRaca1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRaca1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btRaca1MouseEntered

    private void btRaca1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRaca1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btRaca1MouseExited

    private void lbWeaponEquipedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbWeaponEquipedMouseClicked
        
    }//GEN-LAST:event_lbWeaponEquipedMouseClicked

    private void lbWeaponEquipedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbWeaponEquipedMouseEntered
        if(equip[2]!=null)
        {
            showItemDesc(equip[2]);
        }
    }//GEN-LAST:event_lbWeaponEquipedMouseEntered

    private void lbWeaponEquipedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbWeaponEquipedMouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbWeaponEquipedMouseExited

    private void lbArmorEquipedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbArmorEquipedMouseClicked
        
    }//GEN-LAST:event_lbArmorEquipedMouseClicked

    private void lbArmorEquipedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbArmorEquipedMouseEntered
        if(equip[1]!=null)
        {
            showItemDesc(equip[1]);
        }
    }//GEN-LAST:event_lbArmorEquipedMouseEntered

    private void lbArmorEquipedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbArmorEquipedMouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbArmorEquipedMouseExited

    private void lbLegEquipedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLegEquipedMouseClicked
        
    }//GEN-LAST:event_lbLegEquipedMouseClicked

    private void lbLegEquipedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLegEquipedMouseEntered
        if(equip[0]!=null)
        {
            showItemDesc(equip[0]);
        }
    }//GEN-LAST:event_lbLegEquipedMouseEntered

    private void lbLegEquipedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLegEquipedMouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbLegEquipedMouseExited

    private void lbPassivaSkillsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPassivaSkillsMouseEntered

        showSkillDesc(controlPerso.getPassNomeCP(Classe), controlPerso.getPassDescCP(Classe), 0,2);

    }//GEN-LAST:event_lbPassivaSkillsMouseEntered

    private void lbPassivaSkillsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPassivaSkillsMouseExited
        removeSkillDesc();
    }//GEN-LAST:event_lbPassivaSkillsMouseExited

    private void btSkill1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill1MouseClicked

        
    }//GEN-LAST:event_btSkill1MouseClicked

    private void btSkill1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill1MouseEntered

        showSkillDesc(controlPerso.getSkill1NomeCP(Classe), controlPerso.getSkill1DescCP(Classe), controlPerso.getSkill1CDCP(Classe),0);

    }//GEN-LAST:event_btSkill1MouseEntered

    private void btSkill1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill1MouseExited
        removeSkillDesc();
    }//GEN-LAST:event_btSkill1MouseExited

    private void btSkill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSkill1ActionPerformed

    }//GEN-LAST:event_btSkill1ActionPerformed

    private void btSkill2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill2MouseClicked

       
    }//GEN-LAST:event_btSkill2MouseClicked

    private void btSkill2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill2MouseEntered

        showSkillDesc(controlPerso.getSkill2NomeCP(Classe), controlPerso.getSkill2DescCP(Classe), controlPerso.getSkill2CDCP(Classe),0);

    }//GEN-LAST:event_btSkill2MouseEntered

    private void btSkill2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill2MouseExited
        removeSkillDesc();
    }//GEN-LAST:event_btSkill2MouseExited

    private void btSkill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSkill2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSkill2ActionPerformed

    private void btSkillUltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkillUltMouseClicked

        
    }//GEN-LAST:event_btSkillUltMouseClicked

    private void btSkillUltMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkillUltMouseEntered

        showSkillDesc(controlPerso.getUltNomeCP(Classe), controlPerso.getUltDescCP(Classe), controlPerso.getUltCDCP(Classe),1);

    }//GEN-LAST:event_btSkillUltMouseEntered

    private void btSkillUltMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkillUltMouseExited
        removeSkillDesc();
    }//GEN-LAST:event_btSkillUltMouseExited

    private void btSkillUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSkillUltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSkillUltActionPerformed

    private void btFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btFinalizaActionPerformed

    private void btFinalizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFinalizaMouseClicked
        if(tfPersoNome.getText().equals("unused"))
        {
            tfPersoNome.setText("Nome inválido!");
        }
        else
        {
            try {
            controlPerso.criaPerso(Classe, tfPersoNome.getText(), Raca);
            } catch (Exception ex) {
                Logger.getLogger(CriacaoDePersonagem.class.getName()).log(Level.SEVERE, null, ex);
            }


            Mapa1RPG map = new Mapa1RPG(controlPerso,pai);

            map.setVisible(true);
            map.setLocation(getX(),getY());

            this.dispose();
        }
    }//GEN-LAST:event_btFinalizaMouseClicked
    
    class ShowItemDesc extends Thread
    {
        private Item itemDesc;
        private JFrame mainframe;
        
        public ShowItemDesc(Item i, JFrame  t)
        {
            itemDesc = i;
            mainframe = t;
        }
        
        @Override
        public void run()
        {
            
            if(sem.availablePermits()<=0)
            {
                
            }
            else
            {
                try {
                    sem.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }


                lbItemDescNome.setText(itemDesc.getNome());
                lbItemDescHP.setText("HP: "+itemDesc.getChp());
                lbItemDescFe.setText("Fé: "+itemDesc.getPfe());
                lbItemDescInt.setText("Inteligência: "+itemDesc.getPintel());
                lbItemDescStr.setText("Força: "+itemDesc.getPstr());
                lbItemDescDex.setText("Destreza: "+itemDesc.getPdex());
                lbItemDescLuck.setText("Sorte: "+itemDesc.getPluck());
                lbItemDescResist.setText("Resistência: "+itemDesc.getPresist());
                lbItemDescCrit.setText("Chance de crítico: "+itemDesc.getPcritC());
                lbItemDescQtd.setText("Quantidade: "+itemDesc.getQtd()+"/"+itemDesc.getQtdMax());
                lbItemDescPreco.setText("Preço: "+itemDesc.getPreco());
                itemDescript.setVisible(true);
                
                try {
                    sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                itemDescript.setSize(175, 230);
                itemDescript.setLocation(MouseInfo.getPointerInfo().getLocation().x-175 - mainframe.getX()  ,MouseInfo.getPointerInfo().getLocation().y-245 - mainframe.getY());
                //itemDescript.setBounds(MouseInfo.getPointerInfo().getLocation().x-175 - mainframe.getX(), MouseInfo.getPointerInfo().getLocation().y-245 - mainframe.getY(), MouseInfo.getPointerInfo().getLocation().x - mainframe.getX(), MouseInfo.getPointerInfo().getLocation().y-245 - mainframe.getY()+230);
                sem.release();
            }
      
            
        }
    }
    
    class RemoveItemDesc extends Thread
    {
        @Override
        public void run()
        {
            itemDescript.setVisible(false);

        }
    }
    
    class ShowSkillDesc extends Thread
    {
        private String nome;
        private String desc;
        private int cd;
        private JFrame mainframe;
        private int ultPass;
        
        public ShowSkillDesc(String SkillName, String SkillDesc, int c,JFrame m, int isPassUlt)
        {
            nome = SkillName;
            desc = SkillDesc;
            cd = c;
            mainframe = m;
            ultPass = isPassUlt;        
        }
        
        @Override
        public void run()
        {
            
            if(sem.availablePermits()<=0)
            {
                
            }
            else
            {
                try {
                    sem.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }

                SkillDesc.setVisible(true);
                lbSkillDescNome.setText(nome);
                taSkillDescription.setText(desc);
                if(ultPass==0)
                {
                    lbCdSkill.setText("Tempo de recarga: "+cd+".");
                }
                else if(ultPass==1)
                {
                    lbCdSkill.setText("Carga necessária: "+cd+".");
                }
                else
                {
                    lbCdSkill.setText("Sem tempo de recarga.");
                }
                
                try {
                    sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                SkillDesc.setSize(250, 120);
                lbSkillDescNome.setSize(250, 20);
                lbSkillDescNome.setLocation(2, 2);
                
                lbCdSkill.setLocation(10, 97);
                lbCdSkill.setSize(246, 20);
                taSkillDescription.setLocation(2,20);
                taSkillDescription.setSize(246,80);
                
                SkillDesc.setLocation(MouseInfo.getPointerInfo().getLocation().x - mainframe.getX()  ,MouseInfo.getPointerInfo().getLocation().y - mainframe.getY()-20);
                
                
                


                sem.release();
            }
      
            
        }
    }
    
    class RemoveSkillDesc extends Thread
    {
        @Override
        public void run()
        {
            SkillDesc.setVisible(false);

        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JPanel Bag;
    private javax.swing.JPanel Equip;
    private javax.swing.JPanel EquipTitle;
    private javax.swing.JPanel Itens;
    private javax.swing.JLayeredPane Main;
    private javax.swing.JLayeredPane MainPanel;
    private javax.swing.JPanel PersoOptions1;
    private javax.swing.JPanel SkillDesc;
    private javax.swing.JPanel SubEquip;
    private javax.swing.JButton btClasse1;
    private javax.swing.JButton btClasse2;
    private javax.swing.JButton btFinaliza;
    private javax.swing.JButton btRaca1;
    private javax.swing.JButton btRaca2;
    private javax.swing.JButton btSkill1;
    private javax.swing.JButton btSkill2;
    private javax.swing.JButton btSkillUlt;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JPanel itemDescript;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbArma;
    private javax.swing.JLabel lbArmorEquiped;
    private javax.swing.JLabel lbBagTitle;
    private javax.swing.JLabel lbCdSkill;
    private javax.swing.JLabel lbClasse;
    private javax.swing.JLabel lbCrit;
    private javax.swing.JLabel lbDex;
    private javax.swing.JLabel lbEquipTitle;
    private javax.swing.JLabel lbFe;
    private javax.swing.JLabel lbGold;
    private javax.swing.JLabel lbHP;
    private javax.swing.JLabel lbInt;
    private javax.swing.JLabel lbItem0;
    private javax.swing.JLabel lbItem1;
    private javax.swing.JLabel lbItem10;
    private javax.swing.JLabel lbItem11;
    private javax.swing.JLabel lbItem2;
    private javax.swing.JLabel lbItem3;
    private javax.swing.JLabel lbItem4;
    private javax.swing.JLabel lbItem5;
    private javax.swing.JLabel lbItem6;
    private javax.swing.JLabel lbItem7;
    private javax.swing.JLabel lbItem8;
    private javax.swing.JLabel lbItem9;
    private javax.swing.JLabel lbItemDescCrit;
    private javax.swing.JLabel lbItemDescDex;
    private javax.swing.JLabel lbItemDescFe;
    private javax.swing.JLabel lbItemDescHP;
    private javax.swing.JLabel lbItemDescInt;
    private javax.swing.JLabel lbItemDescLuck;
    private javax.swing.JLabel lbItemDescNome;
    private javax.swing.JLabel lbItemDescPreco;
    private javax.swing.JLabel lbItemDescQtd;
    private javax.swing.JLabel lbItemDescResist;
    private javax.swing.JLabel lbItemDescStr;
    private javax.swing.JLabel lbLegEquiped;
    private javax.swing.JLabel lbLuck;
    private javax.swing.JLabel lbLvl;
    private javax.swing.JLabel lbPassivaSkills;
    private javax.swing.JLabel lbPerso;
    private javax.swing.JLabel lbRaca;
    private javax.swing.JLabel lbResist;
    private javax.swing.JLabel lbSkillDescNome;
    private javax.swing.JLabel lbStr;
    private javax.swing.JLabel lbWeaponEquiped;
    private javax.swing.JLabel lbXP;
    private javax.swing.JTextArea taSkillDescription;
    private javax.swing.JTextField tfPersoNome;
    // End of variables declaration//GEN-END:variables
}
