/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Model.*;
import Controller.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import static java.lang.Math.sqrt;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.time.Clock;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.Utilities;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

/**
 *
 * @author Megatron
 */
public class ComercianteRPG extends javax.swing.JFrame{
    
    int tempI;
    int iniJogou;
    Semaphore sem = new Semaphore(1);
    ControllerPersonagem controlPerso;
    
    Mapa1RPG pai;
    
    Item[] estoque = new Item[6];
    Item[] bag = new Item[12];
    Item[] equip = new Item[3];
   
    
    public ComercianteRPG(ControllerPersonagem controlPersonagem, Mapa1RPG parent) {
        initComponents();
        controlPerso = controlPersonagem;
        DropConfirm.setVisible(false);
        new AnaoAnim().start();
        pai = parent;
        lbGold.setText(""+controlPerso.getGold());
        bag = controlPerso.getBag();
        setBag();
        ItemDesc.setVisible(false);
        lbLvl.setText("Lv: "+controlPerso.getLvl());
        lbNomePerso.setText(controlPerso.getNome());
        new SetHP(controlPerso.getHP()).start();
        jLayeredPane1.setVisible(false);
                
        try {
            controlPerso.iniciaCombate();
        } catch (Exception ex) {
            Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        setHUDEnabled(false);
        
        try {
            controlPerso.iniciaCombate();
        } catch (Exception ex) {
            Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbPerso.setIcon(controlPerso.getIdle());
        lbArmaPerso.setIcon(controlPerso.getArmaIdle());
        BG.setIcon(controlPerso.getBG());
        setEstoque();
    }

    public void setEstoque()
    {
        estoque = controlPerso.getAvenda();
        if(estoque[0]==null)
        {
            jLabel2.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            jLabel2.setIcon(estoque[0].getImg());
            
        }
        
        if(estoque[1]==null)
        {
            jLabel4.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            jLabel4.setIcon(estoque[1].getImg());
            
        }
        
        if(estoque[2]==null)
        {
            jLabel5.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            jLabel5.setIcon(estoque[2].getImg());
            
        }
        
        if(estoque[3]==null)
        {
            jLabel6.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            jLabel6.setIcon(estoque[3].getImg());
            
        }
        
        if(estoque[4]==null)
        {
            jLabel7.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            jLabel7.setIcon(estoque[4].getImg());
            
        }
        
        if(estoque[5]==null)
        {
            jLabel8.setIcon(new ImageIcon(getClass().getResource("/Resources/ItemSlot.png")));
        }
        else
        {
            jLabel8.setIcon(estoque[5].getImg());
            
        }
    }
    
    public void setBag()
    {
        lbGold.setText(""+controlPerso.getGold());
        bag = controlPerso.getBag();
        equip = controlPerso.getEquips();
        new SetHP(controlPerso.getHP()).start();
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMainCbt = new javax.swing.JLayeredPane();
        ItemDesc = new javax.swing.JPanel();
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
        lbDragItem = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        Personagem = new javax.swing.JLayeredPane();
        lbArmaPerso = new javax.swing.JLabel();
        lbPerso = new javax.swing.JLabel();
        Equip = new javax.swing.JPanel();
        SubEquip = new javax.swing.JPanel();
        lbWeaponEquiped = new javax.swing.JLabel();
        lbArmorEquiped = new javax.swing.JLabel();
        lbLegEquiped = new javax.swing.JLabel();
        EquipTitle = new javax.swing.JPanel();
        lbEquipTitle = new javax.swing.JLabel();
        DropConfirm = new javax.swing.JPanel();
        lbDropMessage = new javax.swing.JLabel();
        DropButtons = new javax.swing.JPanel();
        btDrop = new javax.swing.JButton();
        btNDrop = new javax.swing.JButton();
        AllyInfo = new javax.swing.JPanel();
        AllyHP = new javax.swing.JPanel();
        HpBarAlly = new javax.swing.JPanel();
        lbHPnumber = new javax.swing.JLabel();
        lbHPBorder = new javax.swing.JLabel();
        AllyHPFull = new javax.swing.JProgressBar();
        lbLvl = new javax.swing.JLabel();
        lbNomePerso = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1282, 747));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pnMainCbt.setLocation(50,50);

        ItemDesc.setBackground(new java.awt.Color(100, 100, 100));
        ItemDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ItemDesc.setLayout(new java.awt.GridLayout(11, 1));

        lbItemDescNome.setBackground(new java.awt.Color(102, 51, 0));
        lbItemDescNome.setForeground(new java.awt.Color(255, 255, 102));
        lbItemDescNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItemDescNome.setText(" ");
        ItemDesc.add(lbItemDescNome);

        lbItemDescHP.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescHP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescHP);

        lbItemDescFe.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescFe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescFe);

        lbItemDescInt.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescInt);

        lbItemDescStr.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescStr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescStr);

        lbItemDescDex.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescDex);

        lbItemDescResist.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescResist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescResist);

        lbItemDescLuck.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescLuck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescLuck);

        lbItemDescCrit.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescCrit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescCrit);

        lbItemDescQtd.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescQtd);

        lbItemDescPreco.setForeground(new java.awt.Color(204, 204, 204));
        lbItemDescPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemDesc.add(lbItemDescPreco);

        pnMainCbt.add(ItemDesc);
        ItemDesc.setBounds(874, 325, 155, 222);
        pnMainCbt.setLayer(ItemDesc, javax.swing.JLayeredPane.MODAL_LAYER);

        lbDragItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnMainCbt.add(lbDragItem);
        lbDragItem.setBounds(592, 362, 102, 0);

        jButton2.setBackground(new java.awt.Color(50, 50, 50));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Voltar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        pnMainCbt.add(jButton2);
        jButton2.setBounds(10, 10, 100, 30);

        jLayeredPane2.setLayout(new java.awt.GridLayout(2, 3));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jLayeredPane2.add(jLabel2);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jLayeredPane2.add(jLabel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jLayeredPane2.add(jLabel5);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jLayeredPane2.add(jLabel6);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jLayeredPane2.add(jLabel7);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jLayeredPane2.add(jLabel8);

        jLayeredPane1.add(jLayeredPane2);
        jLayeredPane2.setBounds(70, 110, 360, 140);

        jButton1.setBackground(new java.awt.Color(50, 50, 50));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Fechar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jLayeredPane1.add(jButton1);
        jButton1.setBounds(477, 2, 70, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Tela_mercador.png"))); // NOI18N
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(0, 0, 550, 310);

        pnMainCbt.add(jLayeredPane1);
        jLayeredPane1.setBounds(507, 194, 556, 352);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/AnaoPadrao.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        pnMainCbt.add(jLabel1);
        jLabel1.setBounds(417, 325, 127, 144);

        Bag.setBackground(new java.awt.Color(100, 100, 100));
        Bag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Bag.setMaximumSize(new java.awt.Dimension(320, 225));
        Bag.setMinimumSize(new java.awt.Dimension(150, 220));
        Bag.setPreferredSize(new java.awt.Dimension(320, 225));
        Bag.setLayout(new java.awt.BorderLayout());

        Itens.setBackground(new java.awt.Color(110, 110, 110));
        Itens.setLayout(new java.awt.GridLayout(4, 3));

        lbItem0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItem0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ItemSlot.png"))); // NOI18N
        lbItem0.setLabelFor(Bag);
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
        lbItem1.setLabelFor(Bag);
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
        lbItem2.setLabelFor(Bag);
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
        lbItem3.setLabelFor(Bag);
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
        lbItem4.setLabelFor(Bag);
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
        lbItem5.setLabelFor(Bag);
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
        lbItem6.setLabelFor(Bag);
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
        lbItem7.setLabelFor(Bag);
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
        lbItem8.setLabelFor(Bag);
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
        lbItem9.setLabelFor(Bag);
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
        lbItem10.setLabelFor(Bag);
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
        lbItem11.setLabelFor(Bag);
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
        lbBagTitle.setText("Inventário");
        Bag.add(lbBagTitle, java.awt.BorderLayout.PAGE_START);

        lbGold.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbGold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Gold.png"))); // NOI18N
        Bag.add(lbGold, java.awt.BorderLayout.PAGE_END);

        pnMainCbt.add(Bag);
        Bag.setBounds(1036, 408, 228, 296);

        Personagem.setLayout(new javax.swing.OverlayLayout(Personagem));

        lbArmaPerso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbArmaPerso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ArcoPadrao.png"))); // NOI18N
        Personagem.add(lbArmaPerso);

        lbPerso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPerso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"))); // NOI18N
        lbPerso.setToolTipText("");
        Personagem.add(lbPerso);

        pnMainCbt.add(Personagem);
        Personagem.setBounds(34, 312, 364, 370);

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
        lbEquipTitle.setText("Equipamentos");
        EquipTitle.add(lbEquipTitle, "card2");

        Equip.add(EquipTitle, java.awt.BorderLayout.NORTH);

        pnMainCbt.add(Equip);
        Equip.setBounds(1039, 301, 208, 97);

        DropConfirm.setBackground(new java.awt.Color(100, 100, 100));
        DropConfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        DropConfirm.setLayout(new java.awt.BorderLayout());

        lbDropMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDropMessage.setText("Deseja destruir o item?");
        lbDropMessage.setMinimumSize(new java.awt.Dimension(34, 20));
        lbDropMessage.setPreferredSize(new java.awt.Dimension(34, 20));
        DropConfirm.add(lbDropMessage, java.awt.BorderLayout.NORTH);

        DropButtons.setBackground(new java.awt.Color(110, 110, 110));
        DropButtons.setLayout(new java.awt.GridLayout(1, 0));

        btDrop.setBackground(new java.awt.Color(120, 120, 120));
        btDrop.setText("Sim");
        btDrop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDropMouseClicked(evt);
            }
        });
        DropButtons.add(btDrop);

        btNDrop.setBackground(new java.awt.Color(120, 120, 120));
        btNDrop.setText("Não");
        btNDrop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNDropMouseClicked(evt);
            }
        });
        DropButtons.add(btNDrop);

        DropConfirm.add(DropButtons, java.awt.BorderLayout.CENTER);

        pnMainCbt.add(DropConfirm);
        DropConfirm.setBounds(568, 301, 144, 49);

        AllyInfo.setBackground(new java.awt.Color(130, 130, 130));
        AllyInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        AllyInfo.setToolTipText("");
        AllyInfo.setLayout(new java.awt.GridLayout(1, 0));

        AllyHP.setBackground(new java.awt.Color(130, 130, 130));
        AllyHP.setMinimumSize(new java.awt.Dimension(290, 55));
        AllyHP.setPreferredSize(new java.awt.Dimension(315, 55));
        AllyHP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HpBarAlly.setMinimumSize(new java.awt.Dimension(250, 30));
        HpBarAlly.setPreferredSize(new java.awt.Dimension(300, 40));
        HpBarAlly.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbHPnumber.setBackground(new java.awt.Color(255, 255, 255));
        lbHPnumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HpBarAlly.add(lbHPnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 70, 20));

        lbHPBorder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHPBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/emptyHPBar.png"))); // NOI18N
        HpBarAlly.add(lbHPBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(-16, -28, 290, 90));

        AllyHPFull.setForeground(new java.awt.Color(255, 255, 255));
        AllyHPFull.setToolTipText("");
        AllyHPFull.setValue(50);
        AllyHPFull.setPreferredSize(new java.awt.Dimension(225, 2000));
        AllyHPFull.setStringPainted(true);
        UIManager.put("ProgressBar.selectionForeground", Color.blue);
        HpBarAlly.add(AllyHPFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -12, 260, 100));

        AllyHP.add(HpBarAlly, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 256, -1));

        lbLvl.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbLvl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLvl.setText("Lv:111");
        lbLvl.setMaximumSize(new java.awt.Dimension(50, 40));
        lbLvl.setMinimumSize(new java.awt.Dimension(40, 40));
        lbLvl.setPreferredSize(new java.awt.Dimension(50, 40));
        AllyHP.add(lbLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        lbNomePerso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNomePerso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNomePerso.setMinimumSize(new java.awt.Dimension(0, 15));
        lbNomePerso.setPreferredSize(new java.awt.Dimension(0, 20));
        AllyHP.add(lbNomePerso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 306, -1));

        AllyInfo.add(AllyHP);

        pnMainCbt.add(AllyInfo);
        AllyInfo.setBounds(10, 626, 319, 78);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MapaAnao.png"))); // NOI18N
        BG.setLabelFor(BG);
        pnMainCbt.add(BG);
        BG.setBounds(0, 0, 1290, 725);

        getContentPane().add(pnMainCbt);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        
    }//GEN-LAST:event_formMouseEntered

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        
            
            
            
        
        
    }//GEN-LAST:event_formMouseClicked

    private void lbItem0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseEntered
        if(bag[0]!=null)
        {
            showItemDesc(bag[0]);
        }
    }//GEN-LAST:event_lbItem0MouseEntered

  
    
    private void lbItem0MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem0MouseExited

    private void lbItem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseEntered
        if(bag[1]!=null)
        {
            showItemDesc(bag[1]);
        }
    }//GEN-LAST:event_lbItem1MouseEntered

    private void lbItem2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseEntered
        if(bag[2]!=null)
        {
            showItemDesc(bag[2]);
        }
    }//GEN-LAST:event_lbItem2MouseEntered

    private void lbItem3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseEntered
        if(bag[3]!=null)
        {
            showItemDesc(bag[3]);
        }
    }//GEN-LAST:event_lbItem3MouseEntered

    private void lbItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseClicked
        if(SwingUtilities.isRightMouseButton(evt))
        {
            try {
                if(bag[4]!=null){
                    controlPerso.usaItem(4);
                    setBag();
                    removeItemDesc();
                }
                
            } catch (Exception ex) {
                
            }
        }
    }//GEN-LAST:event_lbItem4MouseClicked

    private void lbItem4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseEntered
        if(bag[4]!=null)
        {
            showItemDesc(bag[4]);
        }
    }//GEN-LAST:event_lbItem4MouseEntered

    private void lbItem5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseEntered
        if(bag[5]!=null)
        {
            showItemDesc(bag[5]);
        }
    }//GEN-LAST:event_lbItem5MouseEntered

    private void lbItem6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseEntered
        if(bag[6]!=null)
        {
            showItemDesc(bag[6]);
        }
    }//GEN-LAST:event_lbItem6MouseEntered

    private void lbItem7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseEntered
        if(bag[7]!=null)
        {
            showItemDesc(bag[7]);
        }
    }//GEN-LAST:event_lbItem7MouseEntered

    private void lbItem8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseEntered
        if(bag[8]!=null)
        {
            showItemDesc(bag[8]);
        }
    }//GEN-LAST:event_lbItem8MouseEntered

    private void lbItem9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseEntered
        if(bag[9]!=null)
        {
            showItemDesc(bag[9]);
        }
    }//GEN-LAST:event_lbItem9MouseEntered

    private void lbItem10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseEntered
        if(bag[10]!=null)
        {
            showItemDesc(bag[10]);
        }
    }//GEN-LAST:event_lbItem10MouseEntered

    private void lbItem11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseEntered
        if(bag[11]!=null)
        {
            showItemDesc(bag[11]);
        }
    }//GEN-LAST:event_lbItem11MouseEntered

    private void lbItem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem1MouseExited

    private void lbItem2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem2MouseExited

    private void lbItem3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem3MouseExited

    private void lbItem4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem4MouseExited

    private void lbItem5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem5MouseExited

    private void lbItem6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem6MouseExited

    private void lbItem7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem7MouseExited

    private void lbItem8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem8MouseExited

    private void lbItem9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem9MouseExited

    private void lbItem10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem10MouseExited

    private void lbItem11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem11MouseExited

    private void lbItem0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseClicked
         
    }//GEN-LAST:event_lbItem0MouseClicked

    private void lbItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseClicked
        
    }//GEN-LAST:event_lbItem1MouseClicked

    private void lbItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseClicked
        
    }//GEN-LAST:event_lbItem2MouseClicked

    private void lbItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseClicked
        
    }//GEN-LAST:event_lbItem3MouseClicked

    private void lbItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseClicked
       
    }//GEN-LAST:event_lbItem5MouseClicked

    private void lbItem6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseClicked
        
    }//GEN-LAST:event_lbItem6MouseClicked

    private void lbItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseClicked
        
    }//GEN-LAST:event_lbItem7MouseClicked

    private void lbItem8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseClicked
        
    }//GEN-LAST:event_lbItem8MouseClicked

    private void lbItem9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseClicked
        
    }//GEN-LAST:event_lbItem9MouseClicked

    private void lbItem10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseClicked
        
        
    }//GEN-LAST:event_lbItem10MouseClicked

    private void lbItem11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseClicked
      
    }//GEN-LAST:event_lbItem11MouseClicked

    private void lbLegEquipedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLegEquipedMouseEntered
        if(equip[0]!=null)
        {
            showItemDesc(equip[0]);
        }
    }//GEN-LAST:event_lbLegEquipedMouseEntered

    private void lbArmorEquipedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbArmorEquipedMouseEntered
        if(equip[1]!=null)
        {
            showItemDesc(equip[1]);
        }
    }//GEN-LAST:event_lbArmorEquipedMouseEntered

    private void lbWeaponEquipedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbWeaponEquipedMouseEntered
        if(equip[2]!=null)
        {
            showItemDesc(equip[2]);
        }
    }//GEN-LAST:event_lbWeaponEquipedMouseEntered

    private void lbWeaponEquipedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbWeaponEquipedMouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbWeaponEquipedMouseExited

    private void lbArmorEquipedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbArmorEquipedMouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbArmorEquipedMouseExited

    private void lbLegEquipedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLegEquipedMouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbLegEquipedMouseExited

    private void lbWeaponEquipedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbWeaponEquipedMouseClicked
        if(lbWeaponEquiped.isEnabled())
        {
            if(SwingUtilities.isRightMouseButton(evt))
            {
                controlPerso.removeEquip(2);
                setBag();
            }
        }
    }//GEN-LAST:event_lbWeaponEquipedMouseClicked

    private void lbArmorEquipedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbArmorEquipedMouseClicked
        if(lbArmorEquiped.isEnabled())
        {
            if(SwingUtilities.isRightMouseButton(evt))
            {
                controlPerso.removeEquip(1);
                setBag();
            }
        }
    }//GEN-LAST:event_lbArmorEquipedMouseClicked

    private void lbLegEquipedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLegEquipedMouseClicked
        if(lbLegEquiped.isEnabled())
        {
            if(SwingUtilities.isRightMouseButton(evt))
            {
                controlPerso.removeEquip(0);
                setBag();
            }
        }
    }//GEN-LAST:event_lbLegEquipedMouseClicked

    private void lbItem0MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseDragged
        
        
        if(lbItem0.isEnabled())
        {
            if(bag[0]!=null)
            {
                new DragItem(bag[0], this, 0).start();
            }
        }
    }//GEN-LAST:event_lbItem0MouseDragged

    
    
    
    private void btDropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDropMouseClicked
        controlPerso.dropItem(tempI);
        setBag();
        DropConfirm.setVisible(false);
    }//GEN-LAST:event_btDropMouseClicked

    private void btNDropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNDropMouseClicked
        
        DropConfirm.setVisible(false);
    }//GEN-LAST:event_btNDropMouseClicked

    private void lbItem1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseDragged
        if(lbItem1.isEnabled())
        {
            if(bag[1]!=null)
            {
                new DragItem(bag[1], this, 1).start();
            }
        }
    }//GEN-LAST:event_lbItem1MouseDragged

    private void lbItem2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseDragged
        if(lbItem2.isEnabled())
        {
            if(bag[2]!=null)
            {
                new DragItem(bag[2], this, 2).start();
            }
        }
    }//GEN-LAST:event_lbItem2MouseDragged

    private void lbItem3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseDragged
        if(lbItem3.isEnabled())
        {
            if(bag[3]!=null)
            {
                new DragItem(bag[3], this, 3).start();
            }
        }
    }//GEN-LAST:event_lbItem3MouseDragged

    private void lbItem4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbItem4MouseMoved

    private void lbItem4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseDragged
        if(lbItem4.isEnabled())
        {
            if(bag[4]!=null)
            {
                new DragItem(bag[4], this, 4).start();
            }
        }
    }//GEN-LAST:event_lbItem4MouseDragged

    private void lbItem5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseDragged
        if(lbItem5.isEnabled())
        {
            if(bag[5]!=null)
            {
                new DragItem(bag[5], this, 5).start();
            }
        }
    }//GEN-LAST:event_lbItem5MouseDragged

    private void lbItem6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseDragged
        if(lbItem6.isEnabled())
        {
            if(bag[6]!=null)
            {
                new DragItem(bag[6], this, 6).start();
            }
        }
    }//GEN-LAST:event_lbItem6MouseDragged

    private void lbItem7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseDragged
        if(lbItem7.isEnabled())
        {
            if(bag[7]!=null)
            {
                new DragItem(bag[7], this, 7).start();
            }
        }
    }//GEN-LAST:event_lbItem7MouseDragged

    private void lbItem8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseDragged
        if(lbItem8.isEnabled())
        {
            if(bag[8]!=null)
            {
                new DragItem(bag[8], this, 8).start();
            }
        }
    }//GEN-LAST:event_lbItem8MouseDragged

    private void lbItem9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseDragged
        if(lbItem9.isEnabled())
        {
            if(bag[9]!=null)
            {
                new DragItem(bag[9], this, 9).start();
            }
        }
    }//GEN-LAST:event_lbItem9MouseDragged

    private void lbItem10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseDragged
        if(lbItem10.isEnabled())
        {
            if(bag[10]!=null)
            {
                new DragItem(bag[10], this, 10).start();
            }
        }
    }//GEN-LAST:event_lbItem10MouseDragged

    private void lbItem11MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseDragged
        if(lbItem11.isEnabled())
        {
            if(bag[11]!=null)
            {
                new DragItem(bag[11], this, 11).start();
            }
        }
    }//GEN-LAST:event_lbItem11MouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        jLayeredPane1.setVisible(true);
        setHUDEnabled(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        jLayeredPane1.setVisible(false);
        setHUDEnabled(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        showItemDesc(estoque[0]);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        showItemDesc(estoque[1]);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        showItemDesc(estoque[2]);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        showItemDesc(estoque[3]);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        showItemDesc(estoque[4]);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        showItemDesc(estoque[5]);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        removeItemDesc();
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        removeItemDesc();
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        removeItemDesc();
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        removeItemDesc();
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        removeItemDesc();
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        removeItemDesc();
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        controlPerso.comprarItem(0);
        setBag();
        setEstoque();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        controlPerso.comprarItem(1);
        setBag();
        setEstoque();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        controlPerso.comprarItem(2);
        setBag();
        setEstoque();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        controlPerso.comprarItem(3);
        setBag();
        setEstoque();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        controlPerso.comprarItem(4);
        setBag();
        setEstoque();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        controlPerso.comprarItem(5);
        setBag();
        setEstoque();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        pai.setLocation(getX(),getY());
        pai.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

   private void setHUDEnabled(boolean b) {
        
        //bag
        lbItem0.setEnabled(b);
        lbItem1.setEnabled(b);
        lbItem2.setEnabled(b);
        lbItem3.setEnabled(b);
        lbItem4.setEnabled(b);
        lbItem5.setEnabled(b);
        lbItem6.setEnabled(b);
        lbItem7.setEnabled(b);
        lbItem8.setEnabled(b);
        lbItem9.setEnabled(b);
        lbItem10.setEnabled(b);
        lbItem11.setEnabled(b);
        
        //equipamentos
        lbLegEquiped.setEnabled(b);
        lbArmorEquiped.setEnabled(b);
        lbWeaponEquiped.setEnabled(b);
        
        
        
   }
   
   
   
    /**
     * Classe para criar uma animação na barra de vida do personagem.
     */
    class SetHP extends Thread
    {
        private double hp;

        public SetHP(double nhp)
        {
            hp = nhp;
        }

        @Override
        public void run()
        {
             while(hp>AllyHPFull.getValue())
             {
                 AllyHPFull.setValue(AllyHPFull.getValue()+1);
                 try {
                    sleep(5);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             while(hp<AllyHPFull.getValue())
             {
                 AllyHPFull.setValue(AllyHPFull.getValue()-1);
                 try {
                    sleep(5);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             lbHPnumber.setText(controlPerso.getHPatual()+"/"+controlPerso.getHPmax());
        }
    }
   
    /**
    * Classe para exibir a descrição dos itens.
    */
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
                    Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
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
                ItemDesc.setVisible(true);

                try {
                    sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                ItemDesc.setSize(175, 230);
                ItemDesc.setLocation(MouseInfo.getPointerInfo().getLocation().x-175 - mainframe.getX()  ,MouseInfo.getPointerInfo().getLocation().y-245 - mainframe.getY());

                


                sem.release();
            }
      
            
        }
    }
    
    /**
    * Classe para remover a descrição dos itens.
    */
    class RemoveItemDesc extends Thread
    {
        @Override
        public void run()
        {
            ItemDesc.setVisible(false);

        }
    }
    

    /**
    * Classe para criar a animação de arrastar itens.
    */
    class DragItem extends Thread
    {
        class myMouseListener implements MouseListener
        {

            @Override
            public void mouseClicked(MouseEvent e) {
                clicked=false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        }
        
        myMouseListener mml = new myMouseListener();
        
        Item i;
        JFrame mainframe;
        boolean clicked = true;
        
        public DragItem(Item j, JFrame t, int n)
        {
            i=j;
            mainframe = t;
            tempI = n;
        }
        
        
        
        
        
        @Override
        public void run()
        {
            lbDragItem.setIcon(i.getImg());
            lbDragItem.setVisible(true);
            lbDragItem.setSize(70,70);
            lbDragItem.addMouseListener(mml);
            while(clicked)
            {

                lbDragItem.setLocation(MouseInfo.getPointerInfo().getLocation().x-50 - mainframe.getX()  ,MouseInfo.getPointerInfo().getLocation().y-50 - mainframe.getY());
            }
            lbDragItem.setVisible(false);
            clicked = true;
            

                
            DropConfirm.setVisible(true);
            DropButtons.addMouseListener(mml);
            

            
            
            
                
            
            
            
        }
    }
    
    class AnaoAnim extends Thread
    {
        @Override
        public void run()
        {
            try {
                sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(isVisible())
            {
                for(int i =0;i<10;i++)
                {
                    jLabel1.setLocation(jLabel1.getX(), jLabel1.getY()+1);
                    try {
                        sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int i =0;i<10;i++)
                {
                    jLabel1.setLocation(jLabel1.getX(), jLabel1.getY()-1);
                    try {
                        sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ComercianteRPG.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
 //////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AllyHP;
    private javax.swing.JProgressBar AllyHPFull;
    private javax.swing.JPanel AllyInfo;
    private javax.swing.JLabel BG;
    private javax.swing.JPanel Bag;
    private javax.swing.JPanel DropButtons;
    private javax.swing.JPanel DropConfirm;
    private javax.swing.JPanel Equip;
    private javax.swing.JPanel EquipTitle;
    private javax.swing.JPanel HpBarAlly;
    private javax.swing.JPanel ItemDesc;
    private javax.swing.JPanel Itens;
    private javax.swing.JLayeredPane Personagem;
    private javax.swing.JPanel SubEquip;
    private javax.swing.JButton btDrop;
    private javax.swing.JButton btNDrop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLabel lbArmaPerso;
    private javax.swing.JLabel lbArmorEquiped;
    private javax.swing.JLabel lbBagTitle;
    private javax.swing.JLabel lbDragItem;
    private javax.swing.JLabel lbDropMessage;
    private javax.swing.JLabel lbEquipTitle;
    private javax.swing.JLabel lbGold;
    private javax.swing.JLabel lbHPBorder;
    private javax.swing.JLabel lbHPnumber;
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
    private javax.swing.JLabel lbLvl;
    private javax.swing.JLabel lbNomePerso;
    private javax.swing.JLabel lbPerso;
    private javax.swing.JLabel lbWeaponEquiped;
    private javax.swing.JLayeredPane pnMainCbt;
    // End of variables declaration//GEN-END:variables
    }