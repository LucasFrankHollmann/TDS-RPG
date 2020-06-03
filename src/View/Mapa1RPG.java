/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPersonagem;
import Model.Item;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Mapa1RPG extends javax.swing.JFrame {
    
    boolean fim=false;
    Semaphore sem = new Semaphore(1);
    Item[] bag = new Item[12];
    Item[] equip = new Item[3];
    int  nodeAtual;
    int tempI;
    JFrame pai;
    ControllerPersonagem controlPerso;
    /**
     * Creates new form MapaRPG
     */
    public Mapa1RPG(ControllerPersonagem ctrlPerso, JFrame parent) {
        initComponents();
        //nodeAtual=ctrlPerso.getNodeAtual();
        controlPerso=ctrlPerso;
        updateMap();
        DropConfirm.setVisible(false);
        ItemDesc.setVisible(false);
        Bag.setVisible(false);
        Equip.setVisible(false);
        PersoInfo.setVisible(false);
        setBag();
        pai = parent;
        
    }

    
    public JFrame getPai()
    {
        return pai;
    }
    
    public void setPersoInfo()
    {
        if(controlPerso.getMelhorias()==0)
        {
            btUpHP.setVisible(false);
            btUpHP1.setVisible(false);
            btUpHP2.setVisible(false);
            btUpHP3.setVisible(false);
            btUpHP4.setVisible(false);
            btUpHP5.setVisible(false);
            btUpHP6.setVisible(false);
            btUpHP7.setVisible(false);
        }
        
        else
        {
            btUpHP.setVisible(true);
            btUpHP1.setVisible(true);
            btUpHP2.setVisible(true);
            btUpHP3.setVisible(true);
            btUpHP4.setVisible(true);
            btUpHP5.setVisible(true);
            btUpHP6.setVisible(true);
            btUpHP7.setVisible(true);
        }
        lbHP1.setText("HP: "+controlPerso.getHPatual()+"/"+controlPerso.getHPmax()+"  ");
        lbLvl1.setText("Nível: "+controlPerso.getLvl()+"  ");
        lbFe1.setText("Fé: "+controlPerso.getFe()+"  ");
        lbInt1.setText("Inteligência: "+controlPerso.getInt()+"  ");
        lbStr1.setText("Força: "+controlPerso.getStr()+"  ");
        lbDex1.setText("Destreza: "+controlPerso.getDex()+"  ");
        lbLuck1.setText("Sorte: "+controlPerso.getLuck()+"  ");
        lbResist1.setText("Resistência: "+controlPerso.getResist()+"  ");
        lbCrit1.setText("Chance de Crítico: "+controlPerso.getCrit()+"%"+"  ");
        lbXP1.setText("XP: "+controlPerso.getXPAtual()+"/"+controlPerso.getXPLvlUp()+"  ");
        jLabel1.setText("Melhorias de habilidades: "+controlPerso.getMelhorias());
    }
    
    public void setBag()
    {
        bag = controlPerso.getBag();
        equip = controlPerso.getEquips();
        
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
        lbGold.setText(""+controlPerso.getGold()+"  ");
        
        
        setEquip();
        setPersoInfo();

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
    
    void updateMap()
    {
        nodeAtual = controlPerso.getNodeAtual();
        
        btNode0.setEnabled(false);
        btNode1.setEnabled(false);
        btNode2.setEnabled(false);
        btNode3.setEnabled(false);
        btNode4.setEnabled(false);
        btNode5.setEnabled(false);
        btNode6.setEnabled(false);
        btNode7.setEnabled(false);
        
        if(nodeAtual==-1)
        {
            btNode0.setEnabled(true);
        }
        else if(nodeAtual==0)
        {
            btNode1.setEnabled(true);
        }
        else if(nodeAtual==1)
        {
            btNode2.setEnabled(true);
        }
        else if(nodeAtual==2)
        {
            btNode3.setEnabled(true);
        }
        else if(nodeAtual==3)
        {
            btNode4.setEnabled(true);
        }
        else if(nodeAtual==4)
        {
            btNode5.setEnabled(true);
        }
        else if(nodeAtual==5)
        {
            btNode6.setEnabled(true);
            btNode7.setEnabled(true);
        }
        else if(nodeAtual==6)
        {
            btNode7.setEnabled(true);
        }
        else if(nodeAtual==7)
        {
            fim = true;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btAbrirBag = new javax.swing.JButton();
        btAbrirStatus = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();
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
        PersoInfo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pn = new javax.swing.JPanel();
        lbHP1 = new javax.swing.JLabel();
        btUpHP = new javax.swing.JButton();
        pn1 = new javax.swing.JPanel();
        lbLvl1 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        lbFe1 = new javax.swing.JLabel();
        btUpHP1 = new javax.swing.JButton();
        pn3 = new javax.swing.JPanel();
        lbInt1 = new javax.swing.JLabel();
        btUpHP2 = new javax.swing.JButton();
        pn4 = new javax.swing.JPanel();
        lbStr1 = new javax.swing.JLabel();
        btUpHP3 = new javax.swing.JButton();
        pn5 = new javax.swing.JPanel();
        lbDex1 = new javax.swing.JLabel();
        btUpHP4 = new javax.swing.JButton();
        pn6 = new javax.swing.JPanel();
        lbLuck1 = new javax.swing.JLabel();
        btUpHP5 = new javax.swing.JButton();
        pn7 = new javax.swing.JPanel();
        lbCrit1 = new javax.swing.JLabel();
        btUpHP6 = new javax.swing.JButton();
        pn8 = new javax.swing.JPanel();
        lbResist1 = new javax.swing.JLabel();
        btUpHP7 = new javax.swing.JButton();
        pn9 = new javax.swing.JPanel();
        lbXP1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btNode0 = new javax.swing.JButton();
        btNode1 = new javax.swing.JButton();
        btNode2 = new javax.swing.JButton();
        btNode3 = new javax.swing.JButton();
        btNode4 = new javax.swing.JButton();
        btNode5 = new javax.swing.JButton();
        btNode6 = new javax.swing.JButton();
        btNode7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbDragItem1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1282, 747));
        setMinimumSize(new java.awt.Dimension(1282, 747));
        setPreferredSize(new java.awt.Dimension(1282, 747));
        setResizable(false);
        setSize(new java.awt.Dimension(1282, 747));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jLayeredPane2.setMaximumSize(new java.awt.Dimension(1280, 720));
        jLayeredPane2.setMinimumSize(new java.awt.Dimension(1280, 720));
        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(1280, 720));

        btAbrirBag.setBackground(new java.awt.Color(110, 110, 110));
        btAbrirBag.setText("Abrir Inventário");
        btAbrirBag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAbrirBagMouseClicked(evt);
            }
        });

        btAbrirStatus.setBackground(new java.awt.Color(110, 110, 110));
        btAbrirStatus.setText("Mostrar informações do personagem");
        btAbrirStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAbrirStatusMouseClicked(evt);
            }
        });

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

        lbDragItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Equip.setBackground(new java.awt.Color(130, 130, 130));
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

        jButton1.setBackground(new java.awt.Color(110, 110, 110));
        jButton1.setText("Voltar ao menu principal");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

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
        lbBagTitle.setText("Inventário");
        Bag.add(lbBagTitle, java.awt.BorderLayout.PAGE_START);

        lbGold.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbGold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Gold.png"))); // NOI18N
        Bag.add(lbGold, java.awt.BorderLayout.PAGE_END);

        PersoInfo.setBackground(new java.awt.Color(110, 110, 110));
        PersoInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PersoInfo.setLayout(new java.awt.BorderLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Atributos");
        jLabel6.setPreferredSize(new java.awt.Dimension(34, 20));
        PersoInfo.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(130, 130, 130));
        jPanel6.setLayout(new java.awt.GridLayout(5, 2));

        pn.setBackground(new java.awt.Color(130, 130, 130));
        pn.setLayout(new java.awt.GridBagLayout());

        lbHP1.setText("HP");
        pn.add(lbHP1, new java.awt.GridBagConstraints());

        btUpHP.setBackground(new Color(0,0,0,0));
        btUpHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mais.png"))); // NOI18N
        btUpHP.setPreferredSize(new java.awt.Dimension(20, 20));
        btUpHP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpHPMouseClicked(evt);
            }
        });
        pn.add(btUpHP, new java.awt.GridBagConstraints());

        jPanel6.add(pn);

        pn1.setBackground(new java.awt.Color(130, 130, 130));
        pn1.setLayout(new java.awt.GridBagLayout());

        lbLvl1.setText("    Nível: 1");
        pn1.add(lbLvl1, new java.awt.GridBagConstraints());

        jPanel6.add(pn1);

        pn2.setBackground(new java.awt.Color(130, 130, 130));
        pn2.setLayout(new java.awt.GridBagLayout());

        lbFe1.setText("Fé");
        pn2.add(lbFe1, new java.awt.GridBagConstraints());

        btUpHP1.setBackground(new Color(0,0,0,0));
        btUpHP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mais.png"))); // NOI18N
        btUpHP1.setPreferredSize(new java.awt.Dimension(20, 20));
        btUpHP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpHP1MouseClicked(evt);
            }
        });
        pn2.add(btUpHP1, new java.awt.GridBagConstraints());

        jPanel6.add(pn2);

        pn3.setBackground(new java.awt.Color(130, 130, 130));
        pn3.setLayout(new java.awt.GridBagLayout());

        lbInt1.setText("Inteligência");
        pn3.add(lbInt1, new java.awt.GridBagConstraints());

        btUpHP2.setBackground(new Color(0,0,0,0));
        btUpHP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mais.png"))); // NOI18N
        btUpHP2.setPreferredSize(new java.awt.Dimension(20, 20));
        btUpHP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpHP2MouseClicked(evt);
            }
        });
        pn3.add(btUpHP2, new java.awt.GridBagConstraints());

        jPanel6.add(pn3);

        pn4.setBackground(new java.awt.Color(130, 130, 130));
        pn4.setLayout(new java.awt.GridBagLayout());

        lbStr1.setText("Força");
        pn4.add(lbStr1, new java.awt.GridBagConstraints());

        btUpHP3.setBackground(new Color(0,0,0,0));
        btUpHP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mais.png"))); // NOI18N
        btUpHP3.setPreferredSize(new java.awt.Dimension(20, 20));
        btUpHP3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpHP3MouseClicked(evt);
            }
        });
        pn4.add(btUpHP3, new java.awt.GridBagConstraints());

        jPanel6.add(pn4);

        pn5.setBackground(new java.awt.Color(130, 130, 130));
        pn5.setLayout(new java.awt.GridBagLayout());

        lbDex1.setText("Destreza");
        pn5.add(lbDex1, new java.awt.GridBagConstraints());

        btUpHP4.setBackground(new Color(0,0,0,0));
        btUpHP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mais.png"))); // NOI18N
        btUpHP4.setPreferredSize(new java.awt.Dimension(20, 20));
        btUpHP4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpHP4MouseClicked(evt);
            }
        });
        pn5.add(btUpHP4, new java.awt.GridBagConstraints());

        jPanel6.add(pn5);

        pn6.setBackground(new java.awt.Color(130, 130, 130));
        pn6.setLayout(new java.awt.GridBagLayout());

        lbLuck1.setText("Sorte");
        pn6.add(lbLuck1, new java.awt.GridBagConstraints());

        btUpHP5.setBackground(new Color(0,0,0,0));
        btUpHP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mais.png"))); // NOI18N
        btUpHP5.setPreferredSize(new java.awt.Dimension(20, 20));
        btUpHP5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpHP5MouseClicked(evt);
            }
        });
        pn6.add(btUpHP5, new java.awt.GridBagConstraints());

        jPanel6.add(pn6);

        pn7.setBackground(new java.awt.Color(130, 130, 130));
        pn7.setLayout(new java.awt.GridBagLayout());

        lbCrit1.setText("Chance de crítico");
        pn7.add(lbCrit1, new java.awt.GridBagConstraints());

        btUpHP6.setBackground(new Color(0,0,0,0));
        btUpHP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mais.png"))); // NOI18N
        btUpHP6.setPreferredSize(new java.awt.Dimension(20, 20));
        btUpHP6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpHP6MouseClicked(evt);
            }
        });
        pn7.add(btUpHP6, new java.awt.GridBagConstraints());

        jPanel6.add(pn7);

        pn8.setBackground(new java.awt.Color(130, 130, 130));
        pn8.setLayout(new java.awt.GridBagLayout());

        lbResist1.setText("Resistência");
        pn8.add(lbResist1, new java.awt.GridBagConstraints());

        btUpHP7.setBackground(new Color(0,0,0,0));
        btUpHP7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mais.png"))); // NOI18N
        btUpHP7.setPreferredSize(new java.awt.Dimension(20, 20));
        btUpHP7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpHP7MouseClicked(evt);
            }
        });
        pn8.add(btUpHP7, new java.awt.GridBagConstraints());

        jPanel6.add(pn8);

        pn9.setBackground(new java.awt.Color(130, 130, 130));
        pn9.setLayout(new java.awt.GridBagLayout());

        lbXP1.setText("    XP: 0/50");
        pn9.add(lbXP1, new java.awt.GridBagConstraints());

        jPanel6.add(pn9);

        PersoInfo.add(jPanel6, java.awt.BorderLayout.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Melhorias de habilidade: 0");
        jLabel1.setPreferredSize(new java.awt.Dimension(124, 20));
        PersoInfo.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        btNode0.setBackground(new Color(0,0,0,0));
        btNode0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/estrelinhaAmarela.png"))); // NOI18N
        btNode0.setMaximumSize(new java.awt.Dimension(70, 70));
        btNode0.setMinimumSize(new java.awt.Dimension(70, 70));
        btNode0.setPreferredSize(new java.awt.Dimension(70, 70));
        btNode0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNode0MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNode0MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNode0MouseExited(evt);
            }
        });

        btNode1.setBackground(new Color(0,0,0,0));
        btNode1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/estrelinhaAmarela.png"))); // NOI18N
        btNode1.setMaximumSize(new java.awt.Dimension(70, 70));
        btNode1.setMinimumSize(new java.awt.Dimension(83, 83));
        btNode1.setPreferredSize(new java.awt.Dimension(83, 83));
        btNode1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNode1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNode1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNode1MouseExited(evt);
            }
        });

        btNode2.setBackground(new Color(0,0,0,0));
        btNode2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/estrelinhaBranca.png"))); // NOI18N
        btNode2.setPreferredSize(new java.awt.Dimension(83, 83));
        btNode2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNode2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNode2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNode2MouseExited(evt);
            }
        });

        btNode3.setBackground(new Color(0,0,0,0));
        btNode3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/estrelinhaAmarela.png"))); // NOI18N
        btNode3.setPreferredSize(new java.awt.Dimension(83, 83));
        btNode3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNode3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNode3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNode3MouseExited(evt);
            }
        });
        btNode3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNode3ActionPerformed(evt);
            }
        });

        btNode4.setBackground(new Color(0,0,0,0));
        btNode4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/estrelinhaAmarela.png"))); // NOI18N
        btNode4.setPreferredSize(new java.awt.Dimension(83, 83));
        btNode4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNode4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNode4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNode4MouseExited(evt);
            }
        });

        btNode5.setBackground(new Color(0,0,0,0));
        btNode5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/estrelinhaAmarela.png"))); // NOI18N
        btNode5.setPreferredSize(new java.awt.Dimension(83, 83));
        btNode5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNode5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNode5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNode5MouseExited(evt);
            }
        });
        btNode5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNode5ActionPerformed(evt);
            }
        });

        btNode6.setBackground(new Color(0,0,0,0));
        btNode6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/estrelinhaBranca.png"))); // NOI18N
        btNode6.setPreferredSize(new java.awt.Dimension(83, 83));
        btNode6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNode6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNode6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNode6MouseExited(evt);
            }
        });

        btNode7.setBackground(new Color(0,0,0,0));
        btNode7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/estrelinhaRoxa.png"))); // NOI18N
        btNode7.setPreferredSize(new java.awt.Dimension(83, 83));
        btNode7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNode7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNode7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNode7MouseExited(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Mapas.png"))); // NOI18N

        lbDragItem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(385, Short.MAX_VALUE)
                    .addComponent(btNode2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(800, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(972, Short.MAX_VALUE)
                    .addComponent(btNode5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(198, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(1076, Short.MAX_VALUE)
                    .addComponent(btNode7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(104, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(977, Short.MAX_VALUE)
                    .addComponent(btNode4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(206, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(699, Short.MAX_VALUE)
                    .addComponent(btNode6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(480, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(111, Short.MAX_VALUE)
                    .addComponent(btNode0, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1076, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(152, Short.MAX_VALUE)
                    .addComponent(btNode1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1025, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(609, Short.MAX_VALUE)
                    .addComponent(btNode3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(549, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(832, Short.MAX_VALUE)
                    .addComponent(ItemDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(276, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbDragItem)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(1020, Short.MAX_VALUE)
                    .addComponent(Equip, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(568, Short.MAX_VALUE)
                    .addComponent(DropConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(568, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(1005, Short.MAX_VALUE)
                    .addComponent(Bag, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(1003, Short.MAX_VALUE)
                    .addComponent(btAbrirBag, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(650, Short.MAX_VALUE)
                    .addComponent(lbDragItem1)
                    .addGap(630, 630, 630)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btAbrirStatus)
                    .addContainerGap(1063, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PersoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(943, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1089, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(315, Short.MAX_VALUE)
                    .addComponent(btNode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(322, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(110, Short.MAX_VALUE)
                    .addComponent(btNode5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(495, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(btNode7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(542, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(333, Short.MAX_VALUE)
                    .addComponent(btNode4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(284, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(61, Short.MAX_VALUE)
                    .addComponent(btNode6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(576, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(553, Short.MAX_VALUE)
                    .addComponent(btNode0, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(379, Short.MAX_VALUE)
                    .addComponent(btNode1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(266, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(173, Short.MAX_VALUE)
                    .addComponent(btNode3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(455, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(280, Short.MAX_VALUE)
                    .addComponent(ItemDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(215, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 360, Short.MAX_VALUE)
                    .addComponent(lbDragItem)
                    .addGap(0, 360, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(258, Short.MAX_VALUE)
                    .addComponent(Equip, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(371, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(335, Short.MAX_VALUE)
                    .addComponent(DropConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(336, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(357, Short.MAX_VALUE)
                    .addComponent(Bag, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(656, Short.MAX_VALUE)
                    .addComponent(btAbrirBag, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(370, Short.MAX_VALUE)
                    .addComponent(lbDragItem1)
                    .addGap(350, 350, 350)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btAbrirStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(667, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(57, Short.MAX_VALUE)
                    .addComponent(PersoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(413, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(659, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jLayeredPane1.setLayer(btAbrirBag, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btAbrirStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ItemDesc, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(lbDragItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Equip, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(DropConfirm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Bag, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(PersoInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btNode0, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btNode1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btNode2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btNode3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btNode4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btNode5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btNode6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btNode7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbDragItem1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jLayeredPane2);
        jLayeredPane2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNode3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNode3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btNode3ActionPerformed

    private void btNode0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode0MouseClicked
        if(btNode0.isEnabled())
        {
            btNode0.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
            controlPerso.setNodeAtualPerso(0);
            

            CombateRPG cbt = new CombateRPG(controlPerso, this);
            cbt.setLocation(getX(),getY());
            cbt.setVisible(true);


            updateMap();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btNode0MouseClicked

    private void lbItem0MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseDragged

        if(lbItem0.isEnabled())
        {
            if(bag[0]!=null)
            {
                new DragItem(bag[0], this, 0).start();
            }
        }
    }//GEN-LAST:event_lbItem0MouseDragged

    private void lbItem0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem0MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[0]!=null){
                    controlPerso.usaItem(0);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }

        }
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
        if(lbItem1.isEnabled())
        {
            if(bag[1]!=null)
            {
                new DragItem(bag[1], this, 1).start();
            }
        }
    }//GEN-LAST:event_lbItem1MouseDragged

    private void lbItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[1]!=null){
                    controlPerso.usaItem(1);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_lbItem1MouseClicked

    private void lbItem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseEntered
        if(bag[1]!=null)
        {
            showItemDesc(bag[1]);
        }
    }//GEN-LAST:event_lbItem1MouseEntered

    private void lbItem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem1MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem1MouseExited

    private void lbItem2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseDragged
        if(lbItem2.isEnabled())
        {
            if(bag[2]!=null)
            {
                new DragItem(bag[2], this, 2).start();
            }
        }
    }//GEN-LAST:event_lbItem2MouseDragged

    private void lbItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem2MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[2]!=null){
                    controlPerso.usaItem(2);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbItem3.isEnabled())
        {
            if(bag[3]!=null)
            {
                new DragItem(bag[3], this, 3).start();
            }
        }
    }//GEN-LAST:event_lbItem3MouseDragged

    private void lbItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem3MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[3]!=null){
                    controlPerso.usaItem(3);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbItem4.isEnabled())
        {
            if(bag[4]!=null)
            {
                new DragItem(bag[4], this, 4).start();
            }
        }
    }//GEN-LAST:event_lbItem4MouseDragged

    private void lbItem4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbItem4MouseMoved

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

    private void lbItem4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem4MouseExited
        removeItemDesc();
    }//GEN-LAST:event_lbItem4MouseExited

    private void lbItem5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseDragged
        if(lbItem5.isEnabled())
        {
            if(bag[5]!=null)
            {
                new DragItem(bag[5], this, 5).start();
            }
        }
    }//GEN-LAST:event_lbItem5MouseDragged

    private void lbItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem5MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[5]!=null){
                    controlPerso.usaItem(5);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbItem6.isEnabled())
        {
            if(bag[6]!=null)
            {
                new DragItem(bag[6], this, 6).start();
            }
        }
    }//GEN-LAST:event_lbItem6MouseDragged

    private void lbItem6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem6MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[6]!=null){
                    controlPerso.usaItem(6);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbItem7.isEnabled())
        {
            if(bag[7]!=null)
            {
                new DragItem(bag[7], this, 7).start();
            }
        }
    }//GEN-LAST:event_lbItem7MouseDragged

    private void lbItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem7MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[7]!=null){
                    controlPerso.usaItem(7);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbItem8.isEnabled())
        {
            if(bag[8]!=null)
            {
                new DragItem(bag[8], this, 8).start();
            }
        }
    }//GEN-LAST:event_lbItem8MouseDragged

    private void lbItem8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem8MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[8]!=null){
                    controlPerso.usaItem(8);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbItem9.isEnabled())
        {
            if(bag[9]!=null)
            {
                new DragItem(bag[9], this, 9).start();
            }
        }
    }//GEN-LAST:event_lbItem9MouseDragged

    private void lbItem9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem9MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[9]!=null){
                    controlPerso.usaItem(9);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbItem10.isEnabled())
        {
            if(bag[10]!=null)
            {
                new DragItem(bag[10], this, 10).start();
            }
        }
    }//GEN-LAST:event_lbItem10MouseDragged

    private void lbItem10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem10MouseClicked
        if(SwingUtilities.isRightMouseButton(evt)  && lbItem11.isEnabled())
        {
            try {
                if(bag[10]!=null){
                    controlPerso.usaItem(10);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbItem11.isEnabled())
        {
            if(bag[11]!=null)
            {
                new DragItem(bag[11], this, 11).start();
            }
        }
    }//GEN-LAST:event_lbItem11MouseDragged

    private void lbItem11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbItem11MouseClicked
        if(SwingUtilities.isRightMouseButton(evt) && lbItem11.isEnabled())
        {
            try {
                if(bag[11]!=null){
                    controlPerso.usaItem(11);
                    setBag();
                    removeItemDesc();
                }

            } catch (Exception ex) {

            }
        }
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
        if(lbArmorEquiped.isEnabled())
        {
            if(SwingUtilities.isRightMouseButton(evt))
            {
                controlPerso.removeEquip(1);
                setBag();
            }
        }
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
        if(lbLegEquiped.isEnabled())
        {
            if(SwingUtilities.isRightMouseButton(evt))
            {
                controlPerso.removeEquip(0);
                setBag();
            }
        }
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

    private void btDropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDropMouseClicked
        controlPerso.dropItem(tempI);
        setBag();
        DropConfirm.setVisible(false);
    }//GEN-LAST:event_btDropMouseClicked

    private void btNDropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNDropMouseClicked

        DropConfirm.setVisible(false);
    }//GEN-LAST:event_btNDropMouseClicked

    private void btAbrirBagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAbrirBagMouseClicked
        if(Bag.isVisible())
        {
            Bag.setVisible(false);
            Equip.setVisible(false);
            btAbrirBag.setText("Abrir Invantário");
        }
        else
        {
            Bag.setVisible(true);
            Equip.setVisible(true);
            btAbrirBag.setText("Fechar Invantário");
        }
    }//GEN-LAST:event_btAbrirBagMouseClicked

    private void btAbrirStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAbrirStatusMouseClicked
        if(PersoInfo.isVisible())
        {
            PersoInfo.setVisible(false);
            btAbrirStatus.setText("Mostrar informações do personagem");
        }
        else
        {
            PersoInfo.setVisible(true);
            btAbrirStatus.setText("Ocultar informações do personagem");
        }
    }//GEN-LAST:event_btAbrirStatusMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        pai.setLocation(getX(),getY());
        pai.setVisible(true);
        
        controlPerso.salvarJogo();
        
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void btNode1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode1MouseClicked
        if(btNode1.isEnabled())
        {
            btNode1.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
            controlPerso.setNodeAtualPerso(1);
            controlPerso.setNodeAtual();

            CombateRPG cbt = new CombateRPG(controlPerso, this);
            cbt.setLocation(getX(),getY());
            cbt.setVisible(true);


            updateMap();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btNode1MouseClicked

    private void btUpHPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpHPMouseClicked
        controlPerso.melhorarAttr(8);
        setPersoInfo();
    }//GEN-LAST:event_btUpHPMouseClicked

    private void btUpHP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpHP1MouseClicked
        controlPerso.melhorarAttr(1);
        setPersoInfo();
    }//GEN-LAST:event_btUpHP1MouseClicked

    private void btUpHP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpHP2MouseClicked
        controlPerso.melhorarAttr(2);
        setPersoInfo();
    }//GEN-LAST:event_btUpHP2MouseClicked

    private void btUpHP3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpHP3MouseClicked
        controlPerso.melhorarAttr(3);
        setPersoInfo();
    }//GEN-LAST:event_btUpHP3MouseClicked

    private void btUpHP4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpHP4MouseClicked
        controlPerso.melhorarAttr(4);
        setPersoInfo();
    }//GEN-LAST:event_btUpHP4MouseClicked

    private void btUpHP5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpHP5MouseClicked
        controlPerso.melhorarAttr(5);
        setPersoInfo();
    }//GEN-LAST:event_btUpHP5MouseClicked

    private void btUpHP6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpHP6MouseClicked
        controlPerso.melhorarAttr(6);
        setPersoInfo();
    }//GEN-LAST:event_btUpHP6MouseClicked

    private void btUpHP7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpHP7MouseClicked
        controlPerso.melhorarAttr(7);
        setPersoInfo();
    }//GEN-LAST:event_btUpHP7MouseClicked

    private void btNode0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode0MouseEntered
        if(btNode0.isEnabled()){
            btNode0.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelaAmarela.png")));
        }
    }//GEN-LAST:event_btNode0MouseEntered

    private void btNode0MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode0MouseExited
        if(btNode0.isEnabled()){
            btNode0.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
        }
    }//GEN-LAST:event_btNode0MouseExited

    private void btNode1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode1MouseEntered
        if(btNode1.isEnabled()){
            btNode1.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelaAmarela.png")));
        }
    }//GEN-LAST:event_btNode1MouseEntered

    private void btNode1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode1MouseExited
        if(btNode1.isEnabled()){
            btNode1.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
        }
    }//GEN-LAST:event_btNode1MouseExited

    private void btNode2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode2MouseEntered
        if(btNode2.isEnabled()){
            btNode2.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelaBranca.png")));
        }
    }//GEN-LAST:event_btNode2MouseEntered

    private void btNode2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode2MouseExited
        if(btNode2.isEnabled()){
            btNode2.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaBranca.png")));
        }
    }//GEN-LAST:event_btNode2MouseExited

    private void btNode5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNode5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btNode5ActionPerformed

    private void btNode2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode2MouseClicked
        if(btNode2.isEnabled())
        {
            btNode2.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaBranca.png")));
            controlPerso.setNodeAtualPerso(2);
            controlPerso.setNodeAtual();
            
            
            ComercianteRPG cbt = new ComercianteRPG(controlPerso, this);
            cbt.setLocation(getX(),getY());
            cbt.setVisible(true);


            updateMap();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btNode2MouseClicked

    private void btNode3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode3MouseClicked
        if(btNode3.isEnabled())
        {
            btNode3.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
            controlPerso.setNodeAtualPerso(3);
            controlPerso.setNodeAtual();
            
            
            CombateRPG cbt = new CombateRPG(controlPerso, this);
            cbt.setLocation(getX(),getY());
            cbt.setVisible(true);


            updateMap();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btNode3MouseClicked

    private void btNode4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode4MouseClicked
        if(btNode4.isEnabled())
        {
            btNode4.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
            controlPerso.setNodeAtualPerso(4);
            controlPerso.setNodeAtual();
            
            
            CombateRPG cbt = new CombateRPG(controlPerso, this);
            cbt.setLocation(getX(),getY());
            cbt.setVisible(true);


            updateMap();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btNode4MouseClicked

    private void btNode5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode5MouseClicked
        if(btNode5.isEnabled())
        {
            btNode5.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
            controlPerso.setNodeAtualPerso(5);
            controlPerso.setNodeAtual();
            
            
            CombateRPG cbt = new CombateRPG(controlPerso, this);
            cbt.setLocation(getX(),getY());
            cbt.setVisible(true);


            updateMap();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btNode5MouseClicked

    private void btNode7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode7MouseClicked
        if(btNode7.isEnabled())
        {
            btNode7.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
            controlPerso.setNodeAtualPerso(7);
            controlPerso.setNodeAtual();
            
            
            CombateRPG cbt = new CombateRPG(controlPerso, this);
            cbt.setLocation(getX(),getY());
            cbt.setVisible(true);


            updateMap();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btNode7MouseClicked

    private void btNode6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode6MouseClicked
        if(btNode6.isEnabled())
        {
            btNode6.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaBranca.png")));
            controlPerso.setNodeAtualPerso(6);
            controlPerso.setNodeAtual();
            
            
            ComercianteRPG cbt = new ComercianteRPG(controlPerso, this);
            cbt.setLocation(getX(),getY());
            cbt.setVisible(true);


            updateMap();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btNode6MouseClicked

    private void btNode3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode3MouseEntered
        btNode3.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelaAmarela.png")));
    }//GEN-LAST:event_btNode3MouseEntered

    private void btNode5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode5MouseEntered
        btNode5.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelaAmarela.png")));
    }//GEN-LAST:event_btNode5MouseEntered

    private void btNode4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode4MouseEntered
        btNode4.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelaAmarela.png")));
    }//GEN-LAST:event_btNode4MouseEntered

    private void btNode3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode3MouseExited
        btNode3.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
    }//GEN-LAST:event_btNode3MouseExited

    private void btNode4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode4MouseExited
        btNode4.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
    }//GEN-LAST:event_btNode4MouseExited

    private void btNode5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode5MouseExited
        btNode5.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaAmarela.png")));
    }//GEN-LAST:event_btNode5MouseExited

    private void btNode6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode6MouseEntered
        btNode6.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelaBranca.png")));
    }//GEN-LAST:event_btNode6MouseEntered

    private void btNode6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode6MouseExited
        btNode6.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaBranca.png")));
    }//GEN-LAST:event_btNode6MouseExited

    private void btNode7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode7MouseEntered
        btNode7.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelaRoxa.png")));
    }//GEN-LAST:event_btNode7MouseEntered

    private void btNode7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNode7MouseExited
        btNode7.setIcon(new ImageIcon(getClass().getResource("/Resources/EstrelinhaRoxa.png")));
    }//GEN-LAST:event_btNode7MouseExited
    
        
    
    
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        setBag();
        
        if(fim && b)
        {
            Creditos cd = new Creditos(new MenuPrincipalRPG());
            cd.setLocation(getX(),getY());
            controlPerso.deletePersoBD(controlPerso.getPersoID());
            cd.setVisible(true);
            dispose();
        }
    }

    
    
    
    
    
    
    
    
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
                ItemDesc.setVisible(true);

                try {
                    sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                ItemDesc.setSize(175, 230);
                ItemDesc.setLocation(MouseInfo.getPointerInfo().getLocation().x-175 - mainframe.getX()  ,MouseInfo.getPointerInfo().getLocation().y-245 - mainframe.getY());

                


                sem.release();
            }
      
            
        }
    }
    
    class RemoveItemDesc extends Thread
    {
        @Override
        public void run()
        {
            ItemDesc.setVisible(false);

        }
    }
    
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bag;
    private javax.swing.JPanel DropButtons;
    private javax.swing.JPanel DropConfirm;
    private javax.swing.JPanel Equip;
    private javax.swing.JPanel EquipTitle;
    private javax.swing.JPanel ItemDesc;
    private javax.swing.JPanel Itens;
    private javax.swing.JPanel PersoInfo;
    private javax.swing.JPanel SubEquip;
    private javax.swing.JButton btAbrirBag;
    private javax.swing.JButton btAbrirStatus;
    private javax.swing.JButton btDrop;
    private javax.swing.JButton btNDrop;
    private javax.swing.JButton btNode0;
    private javax.swing.JButton btNode1;
    private javax.swing.JButton btNode2;
    private javax.swing.JButton btNode3;
    private javax.swing.JButton btNode4;
    private javax.swing.JButton btNode5;
    private javax.swing.JButton btNode6;
    private javax.swing.JButton btNode7;
    private javax.swing.JButton btUpHP;
    private javax.swing.JButton btUpHP1;
    private javax.swing.JButton btUpHP2;
    private javax.swing.JButton btUpHP3;
    private javax.swing.JButton btUpHP4;
    private javax.swing.JButton btUpHP5;
    private javax.swing.JButton btUpHP6;
    private javax.swing.JButton btUpHP7;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbArmorEquiped;
    private javax.swing.JLabel lbBagTitle;
    private javax.swing.JLabel lbCrit1;
    private javax.swing.JLabel lbDex1;
    private javax.swing.JLabel lbDragItem;
    private javax.swing.JLabel lbDragItem1;
    private javax.swing.JLabel lbDropMessage;
    private javax.swing.JLabel lbEquipTitle;
    private javax.swing.JLabel lbFe1;
    private javax.swing.JLabel lbGold;
    private javax.swing.JLabel lbHP1;
    private javax.swing.JLabel lbInt1;
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
    private javax.swing.JLabel lbLuck1;
    private javax.swing.JLabel lbLvl1;
    private javax.swing.JLabel lbResist1;
    private javax.swing.JLabel lbStr1;
    private javax.swing.JLabel lbWeaponEquiped;
    private javax.swing.JLabel lbXP1;
    private javax.swing.JPanel pn;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn3;
    private javax.swing.JPanel pn4;
    private javax.swing.JPanel pn5;
    private javax.swing.JPanel pn6;
    private javax.swing.JPanel pn7;
    private javax.swing.JPanel pn8;
    private javax.swing.JPanel pn9;
    // End of variables declaration//GEN-END:variables
}
