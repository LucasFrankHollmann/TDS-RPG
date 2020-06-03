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
public class CombateRPG extends javax.swing.JFrame{
    
    int tempI;
    int iniJogou;
    Semaphore sem = new Semaphore(1);
    ControllerPersonagem controlPerso;
    
    Mapa1RPG pai;
            
    Item[] bag = new Item[12];
    Item[] equip = new Item[3];
   
    
    public CombateRPG(ControllerPersonagem controlPersonagem, Mapa1RPG parent) {
        initComponents();
        //setPersoInvisible();
        //lbHumanoPadrão1h.setVisible(true);
            controlPerso = controlPersonagem;
        new BGAnim().start();
        removeItemDesc();
        removeSkillDesc();
        DropConfirm.setVisible(false);
        lbProjetil.setVisible(false);
        
        WinPanel.setVisible(false);
        WinPanel1.setVisible(false);
        pai = parent;
        lbGold.setText(""+controlPerso.getGold());
        bag = controlPerso.getBag();
        setBag();
        
        lbLvl.setText("Lv: "+controlPerso.getLvl());
        lbNomePerso.setText(controlPerso.getNome());
        new SetHP(controlPerso.getHP()).start();
        new SetIniHP(controlPerso.getIniHP()).start();
        lbGoldAdquirido.setText(""+controlPerso.getDropGold());
        lbXpAdquirido.setText(""+controlPerso.getDropXP());
                
        try {
            controlPerso.iniciaCombate();
        } catch (Exception ex) {
            Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        setHUDEnabled(false);
        
        try {
            controlPerso.iniciaCombate();
        } catch (Exception ex) {
            Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbPerso.setIcon(controlPerso.getIdle());
        lbIni.setIcon(controlPerso.getIniIdle());
        lbArmaPerso.setIcon(controlPerso.getArmaIdle());
        novoTurno();
        BG.setIcon(controlPerso.getBG());
    }

    public void setBag()
    {
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
    public void showSkillDesc(String nome, String desc, int cd, int passUlt)
    {
        new ShowSkillDesc(nome,desc,cd,this, passUlt).start();
    }
    
    public void removeSkillDesc()
    {
        new RemoveSkillDesc().start();  
    }
    
    private void novoTurno() {
        if(controlPerso.isDead())
        {
            WinPanel1.setVisible(false);
        }
        if(controlPerso.isIniDead())
        {
            Personagem1.setVisible(false);
            Dados.setVisible(false);
            Dados1.setVisible(false);
            IniHP.setVisible(false);
            setHUDEnabled(false);
            
            WinPanel.setVisible(true);
            WinPanel.setLocation(WIDTH/2, HEIGHT/2);
            
            
            
        }
        else
        {
        
            try {  
                    iniJogou=0;
                    if(controlPerso.setTurno()==0)
                    {

                        new IniAction().start();
                        iniJogou = 1;
                    }
                    else
                    {
                        setHUDEnabled(true);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            lbDados.setText(""+controlPerso.getDados());
            lbDados1.setText(""+controlPerso.getIniDados());
            if(controlPerso.getSkill1CD()!=0)
            {
                btSkill1.setIcon(new ImageIcon(getClass().getResource("/Resources/CD1.png")));
                btSkill1.setEnabled(false);
            }
            else
            {
                btSkill1.setIcon(new ImageIcon(getClass().getResource("/Resources/Skill 1.png")));
                btSkill1.setEnabled(true);
            }
            if(controlPerso.getSkill2CD()!=0)
            {
                btSkill2.setIcon(new ImageIcon(getClass().getResource("/Resources/CD4.png")));
                btSkill2.setEnabled(false);
            }
            else
            {
                btSkill2.setIcon(new ImageIcon(getClass().getResource("/Resources/Skill 4.png")));
                btSkill2.setEnabled(true);
            }
            if(controlPerso.getUltCD()<45)
            {
                btSkillUlt.setIcon(new ImageIcon(getClass().getResource("/Resources/CD2.png")));
                btSkillUlt.setEnabled(false);
            }
            else
            {
                btSkillUlt.setIcon(new ImageIcon(getClass().getResource("/Resources/Skill 2.png")));
                btSkillUlt.setEnabled(true);
            }
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
        lbProjetil = new javax.swing.JLabel();
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
        Personagem1 = new javax.swing.JLayeredPane();
        lbIni = new javax.swing.JLabel();
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
        Skills = new javax.swing.JPanel();
        lbPassivaSkills = new javax.swing.JLabel();
        btAtkBasico = new javax.swing.JButton();
        btSkill1 = new javax.swing.JButton();
        btSkill2 = new javax.swing.JButton();
        btSkillUlt = new javax.swing.JButton();
        SkillDesc = new javax.swing.JPanel();
        lbSkillDescNome = new javax.swing.JLabel();
        taSkillDescription = new javax.swing.JTextArea();
        lbCdSkill = new javax.swing.JLabel();
        IniHP = new javax.swing.JPanel();
        HpBarIni = new javax.swing.JPanel();
        lbHPnumber1 = new javax.swing.JLabel();
        lbHPBorder1 = new javax.swing.JLabel();
        IniHPFull = new javax.swing.JProgressBar();
        lbLvl1 = new javax.swing.JLabel();
        lbNomeIni = new javax.swing.JLabel();
        Dados1 = new javax.swing.JPanel();
        lbDados1 = new javax.swing.JLabel();
        Dados = new javax.swing.JPanel();
        lbDados = new javax.swing.JLabel();
        WinPanel1 = new javax.swing.JPanel();
        lbVitória1 = new javax.swing.JLabel();
        DropButtons2 = new javax.swing.JPanel();
        btVitoria1 = new javax.swing.JButton();
        WinPanel = new javax.swing.JPanel();
        lbVitória = new javax.swing.JLabel();
        DropButtons1 = new javax.swing.JPanel();
        btVitoria = new javax.swing.JButton();
        GoldXP = new javax.swing.JPanel();
        lbGoldAdquirido = new javax.swing.JLabel();
        lbXpAdquirido = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1282, 747));
        setMinimumSize(new java.awt.Dimension(1282, 747));
        setPreferredSize(new java.awt.Dimension(1282, 747));
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

        lbDragItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbProjetil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProjetil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/felcha.png"))); // NOI18N

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

        Personagem.setLayout(new javax.swing.OverlayLayout(Personagem));

        lbArmaPerso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbArmaPerso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ArcoPadrao.png"))); // NOI18N
        Personagem.add(lbArmaPerso);

        lbPerso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPerso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"))); // NOI18N
        lbPerso.setToolTipText("");
        Personagem.add(lbPerso);

        Personagem1.setLayout(new java.awt.CardLayout());

        lbIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/HumanoPadrão.png"))); // NOI18N
        lbIni.setToolTipText("");
        lbIni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIniMouseClicked(evt);
            }
        });
        Personagem1.add(lbIni, "card2");

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

        Skills.setBackground(new java.awt.Color(130, 130, 130));
        Skills.setMaximumSize(new java.awt.Dimension(240, 60));
        Skills.setMinimumSize(new java.awt.Dimension(240, 67));
        Skills.setPreferredSize(new java.awt.Dimension(138, 60));
        Skills.setLayout(new java.awt.GridBagLayout());

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
        Skills.add(lbPassivaSkills, new java.awt.GridBagConstraints());
        lbPassivaSkills.getAccessibleContext().setAccessibleDescription("");

        btAtkBasico.setBackground(new Color(0,0,0,0)
        );
        btAtkBasico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/AtkBasico.png"))); // NOI18N
        btAtkBasico.setMinimumSize(new java.awt.Dimension(65, 58));
        btAtkBasico.setPreferredSize(new java.awt.Dimension(65, 58));
        btAtkBasico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAtkBasicoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAtkBasicoMouseExited(evt);
            }
        });
        btAtkBasico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtkBasicoActionPerformed(evt);
            }
        });
        Skills.add(btAtkBasico, new java.awt.GridBagConstraints());

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
        Skills.add(btSkill1, new java.awt.GridBagConstraints());

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
        Skills.add(btSkill2, new java.awt.GridBagConstraints());

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
        Skills.add(btSkillUlt, new java.awt.GridBagConstraints());

        AllyInfo.add(Skills);

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
        taSkillDescription.getAccessibleContext().setAccessibleParent(taSkillDescription);

        SkillDesc.add(lbCdSkill, java.awt.BorderLayout.PAGE_END);

        IniHP.setBackground(new java.awt.Color(130, 130, 130));
        IniHP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        IniHP.setMinimumSize(new java.awt.Dimension(290, 55));
        IniHP.setPreferredSize(new java.awt.Dimension(315, 55));
        IniHP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HpBarIni.setMinimumSize(new java.awt.Dimension(250, 30));
        HpBarIni.setPreferredSize(new java.awt.Dimension(300, 40));
        HpBarIni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbHPnumber1.setBackground(new java.awt.Color(255, 255, 255));
        lbHPnumber1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HpBarIni.add(lbHPnumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 70, 20));

        lbHPBorder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHPBorder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/emptyHPBar.png"))); // NOI18N
        HpBarIni.add(lbHPBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-16, -28, 290, 90));

        IniHPFull.setForeground(new java.awt.Color(255, 255, 255));
        IniHPFull.setToolTipText("");
        IniHPFull.setValue(50);
        IniHPFull.setPreferredSize(new java.awt.Dimension(225, 2000));
        IniHPFull.setStringPainted(true);
        UIManager.put("ProgressBar.selectionForeground", Color.blue);
        HpBarIni.add(IniHPFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -12, 260, 100));

        IniHP.add(HpBarIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 256, -1));

        lbLvl1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbLvl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLvl1.setText("Lv:111");
        lbLvl1.setMaximumSize(new java.awt.Dimension(50, 40));
        lbLvl1.setMinimumSize(new java.awt.Dimension(40, 40));
        lbLvl1.setPreferredSize(new java.awt.Dimension(50, 40));
        IniHP.add(lbLvl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        lbNomeIni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNomeIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNomeIni.setMinimumSize(new java.awt.Dimension(0, 15));
        lbNomeIni.setPreferredSize(new java.awt.Dimension(0, 20));
        IniHP.add(lbNomeIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 306, -1));

        Dados1.setBackground(new java.awt.Color(130, 130, 130));
        Dados1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Dados1.setLayout(new java.awt.GridLayout(1, 0));

        lbDados1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbDados1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/DadoIni.png"))); // NOI18N
        lbDados1.setText("0");
        Dados1.add(lbDados1);

        Dados.setBackground(new java.awt.Color(130, 130, 130));
        Dados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Dados.setLayout(new java.awt.GridLayout(1, 0));

        lbDados.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dado.png"))); // NOI18N
        lbDados.setText("0");
        Dados.add(lbDados);

        WinPanel1.setBackground(new java.awt.Color(110, 110, 110));
        WinPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        WinPanel1.setLayout(new java.awt.BorderLayout());

        lbVitória1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVitória1.setText("Você morreu!");
        lbVitória1.setMinimumSize(new java.awt.Dimension(34, 20));
        lbVitória1.setPreferredSize(new java.awt.Dimension(34, 20));
        WinPanel1.add(lbVitória1, java.awt.BorderLayout.NORTH);

        DropButtons2.setBackground(new java.awt.Color(110, 110, 110));
        DropButtons2.setLayout(new java.awt.GridLayout());

        btVitoria1.setBackground(new java.awt.Color(120, 120, 120));
        btVitoria1.setText("Sair");
        btVitoria1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVitoria1MouseClicked(evt);
            }
        });
        DropButtons2.add(btVitoria1);

        WinPanel1.add(DropButtons2, java.awt.BorderLayout.CENTER);

        WinPanel.setBackground(new java.awt.Color(110, 110, 110));
        WinPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        WinPanel.setLayout(new java.awt.BorderLayout());

        lbVitória.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVitória.setText("Você venceu!");
        lbVitória.setMinimumSize(new java.awt.Dimension(34, 20));
        lbVitória.setPreferredSize(new java.awt.Dimension(34, 20));
        WinPanel.add(lbVitória, java.awt.BorderLayout.NORTH);

        DropButtons1.setBackground(new java.awt.Color(110, 110, 110));
        DropButtons1.setLayout(new java.awt.GridLayout(1, 0));

        btVitoria.setBackground(new java.awt.Color(120, 120, 120));
        btVitoria.setText("Avançar");
        btVitoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVitoriaMouseClicked(evt);
            }
        });
        DropButtons1.add(btVitoria);

        WinPanel.add(DropButtons1, java.awt.BorderLayout.CENTER);

        GoldXP.setBackground(new java.awt.Color(100, 100, 100));
        GoldXP.setPreferredSize(new java.awt.Dimension(222, 20));
        GoldXP.setLayout(new java.awt.GridLayout(1, 0));

        lbGoldAdquirido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbGoldAdquirido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGoldAdquirido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Gold.png"))); // NOI18N
        lbGoldAdquirido.setText("+50");
        GoldXP.add(lbGoldAdquirido);

        lbXpAdquirido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbXpAdquirido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbXpAdquirido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/XP.png"))); // NOI18N
        lbXpAdquirido.setText("+50");
        GoldXP.add(lbXpAdquirido);

        WinPanel.add(GoldXP, java.awt.BorderLayout.PAGE_END);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/BGxD.png"))); // NOI18N
        BG.setLabelFor(BG);

        javax.swing.GroupLayout pnMainCbtLayout = new javax.swing.GroupLayout(pnMainCbt);
        pnMainCbt.setLayout(pnMainCbtLayout);
        pnMainCbtLayout.setHorizontalGroup(
            pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(871, Short.MAX_VALUE)
                    .addComponent(ItemDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(254, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(1029, Short.MAX_VALUE)
                    .addComponent(Bag, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(Personagem, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(886, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(622, Short.MAX_VALUE)
                    .addComponent(Personagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(384, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(1036, Short.MAX_VALUE)
                    .addComponent(Equip, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(564, Short.MAX_VALUE)
                    .addComponent(DropConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(572, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainCbtLayout.createSequentialGroup()
                    .addGap(0, 589, Short.MAX_VALUE)
                    .addComponent(lbDragItem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 589, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AllyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(661, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(349, Short.MAX_VALUE)
                    .addComponent(SkillDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(602, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(663, Short.MAX_VALUE)
                    .addComponent(IniHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(302, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(lbProjetil)
                    .addContainerGap(974, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Dados, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1161, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(533, Short.MAX_VALUE)
                    .addComponent(WinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(548, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainCbtLayout.createSequentialGroup()
                    .addGap(1151, 1151, 1151)
                    .addComponent(Dados1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(532, Short.MAX_VALUE)
                    .addComponent(WinPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(549, 549, 549)))
        );
        pnMainCbtLayout.setVerticalGroup(
            pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(323, Short.MAX_VALUE)
                    .addComponent(ItemDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(403, Short.MAX_VALUE)
                    .addComponent(Bag, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(310, Short.MAX_VALUE)
                    .addComponent(Personagem, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(330, Short.MAX_VALUE)
                    .addComponent(Personagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(298, Short.MAX_VALUE)
                    .addComponent(Equip, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(325, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(298, Short.MAX_VALUE)
                    .addComponent(DropConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(373, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainCbtLayout.createSequentialGroup()
                    .addGap(0, 360, Short.MAX_VALUE)
                    .addComponent(lbDragItem)
                    .addGap(0, 360, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(621, Short.MAX_VALUE)
                    .addComponent(AllyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(503, Short.MAX_VALUE)
                    .addComponent(SkillDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(622, Short.MAX_VALUE)
                    .addComponent(IniHP, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(362, Short.MAX_VALUE)
                    .addComponent(lbProjetil)
                    .addContainerGap(103, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Dados, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(658, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap(253, Short.MAX_VALUE)
                    .addComponent(WinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(367, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainCbtLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Dados1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(656, Short.MAX_VALUE)))
            .addGroup(pnMainCbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainCbtLayout.createSequentialGroup()
                    .addGap(275, 275, 275)
                    .addComponent(WinPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(369, Short.MAX_VALUE)))
        );
        pnMainCbt.setLayer(ItemDesc, javax.swing.JLayeredPane.MODAL_LAYER);
        pnMainCbt.setLayer(lbDragItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(lbProjetil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(Bag, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(Personagem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(Personagem1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(Equip, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(DropConfirm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(AllyInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(SkillDesc, javax.swing.JLayeredPane.MODAL_LAYER);
        pnMainCbt.setLayer(IniHP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(Dados1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(Dados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(WinPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(WinPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnMainCbt.setLayer(BG, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

    private void btSkill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSkill1ActionPerformed
        
    }//GEN-LAST:event_btSkill1ActionPerformed

    private void btSkill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSkill2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSkill2ActionPerformed

    private void btSkillUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSkillUltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSkillUltActionPerformed

    private void btSkill1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill1MouseClicked
        
        
        if(btSkill1.isEnabled())
        {
            btSkill1.setIcon(new ImageIcon(getClass().getResource("/Resources/CD1.png")));
            btSkill1.setEnabled(false);
            if(controlPerso.getClasse()==Const.ARQUEIRO)
            {
                new AnimAtkRanged().start();
            }
            else if(controlPerso.getClasse()==Const.CAVALEIRO)
            {
                new AnimAtkMeele().start();
            }
            else if(controlPerso.getClasse()==Const.MAGO)
            {
                new AnimAtkBolaDeFogo().start();
            }
            try {
                controlPerso.turnoCbt(1, 2);
            } catch (Exception ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!(controlPerso.passivaAtiva() && controlPerso.getClasse()==Const.ARQUEIRO) || controlPerso.isIniDead() || controlPerso.isDead()) 
            {
                if(iniJogou==0 && !controlPerso.isDead() && !controlPerso.isIniDead())
                {
                    new IniAction().start();
                }

                
                novoTurno();
                
            }
            else if(!controlPerso.isDead() && !controlPerso.isIniDead())
            {

                lbDados.setText(""+controlPerso.getDados());
                controlPerso.setPassivaAt();

            }
            
        }
    }//GEN-LAST:event_btSkill1MouseClicked

    private void btAtkBasicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtkBasicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAtkBasicoActionPerformed

    private void btAtkBasicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtkBasicoMouseClicked
        if(btAtkBasico.isEnabled())
        {
            if(controlPerso.getClasse()==Const.ARQUEIRO || controlPerso.getClasse()==Const.MAGO)
            {
                new AnimAtkRanged().start();
            }
            if(controlPerso.getClasse()==Const.CAVALEIRO)
            {
                new AnimAtkMeele().start();
            }
            try {
                controlPerso.turnoCbt(1, 5);
            } catch (Exception ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!(controlPerso.passivaAtiva() && controlPerso.getClasse()==Const.ARQUEIRO) || controlPerso.isIniDead() || controlPerso.isDead()) 
            {
                if(iniJogou==0 && !controlPerso.isDead() && !controlPerso.isIniDead())
                {
                    new IniAction().start();
                }

                

                novoTurno();
                
            }
            else if(!controlPerso.isDead() && !controlPerso.isIniDead())
            {
                lbDados.setText(""+controlPerso.getDados());
                controlPerso.setPassivaAt();

            }
        }
    }//GEN-LAST:event_btAtkBasicoMouseClicked

    private void lbPassivaSkillsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPassivaSkillsMouseEntered
        
        showSkillDesc(controlPerso.getPassivaNome(), controlPerso.getPassivaDesc(), 0,2);
        
    }//GEN-LAST:event_lbPassivaSkillsMouseEntered

    private void lbPassivaSkillsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPassivaSkillsMouseExited
        removeSkillDesc();
    }//GEN-LAST:event_lbPassivaSkillsMouseExited

    private void btSkill1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill1MouseEntered
        
        showSkillDesc(controlPerso.getSkill1Nome(), controlPerso.getSkill1Desc(), controlPerso.getSkill1CD(),0);
        
    }//GEN-LAST:event_btSkill1MouseEntered

    private void btSkill2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill2MouseEntered
        
        showSkillDesc(controlPerso.getSkill2Nome(), controlPerso.getSkill2Desc(), controlPerso.getSkill2CD(),0);
        
    }//GEN-LAST:event_btSkill2MouseEntered

    private void btSkillUltMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkillUltMouseEntered
        
        showSkillDesc(controlPerso.getUltNome(), controlPerso.getUltDesc(), controlPerso.getUltCD(),1);
        
    }//GEN-LAST:event_btSkillUltMouseEntered

    private void btAtkBasicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtkBasicoMouseExited
       
    }//GEN-LAST:event_btAtkBasicoMouseExited

    private void btSkill2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill2MouseExited
        removeSkillDesc();
    }//GEN-LAST:event_btSkill2MouseExited

    private void btSkill1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill1MouseExited
        removeSkillDesc();
    }//GEN-LAST:event_btSkill1MouseExited

    private void btSkillUltMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkillUltMouseExited
        removeSkillDesc();
    }//GEN-LAST:event_btSkillUltMouseExited

    private void btSkill2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkill2MouseClicked

        if(btSkill2.isEnabled())
        {
            btSkill2.setIcon(new ImageIcon(getClass().getResource("/Resources/CD4.png")));
            btSkill2.setEnabled(false);
            if(controlPerso.getClasse()==Const.ARQUEIRO)
            {
                new AnimAtkRanged().start();
                try {
                controlPerso.turnoCbt(1, 3);
                } catch (Exception ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if((!controlPerso.passivaAtiva() && controlPerso.getClasse()==Const.ARQUEIRO) || controlPerso.isIniDead() || controlPerso.isDead()) 
                {
                    if(iniJogou==0 && iniJogou==0 && !controlPerso.isDead() && !controlPerso.isIniDead())
                    {
                        new IniAction().start();
                    }

                    novoTurno();

                }
                
                else if(!controlPerso.isDead() && !controlPerso.isIniDead())
                {

                    lbDados.setText(""+controlPerso.getDados());
                    controlPerso.setPassivaAt();
                }
            }
            else if(controlPerso.getClasse()==Const.CAVALEIRO)
            {
                new AnimWarCry().start();
                
                try {
                controlPerso.turnoCbt(1, 3);
                } catch (Exception ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(iniJogou==0 && !controlPerso.isDead() && !controlPerso.isIniDead())
                {
                    new IniAction().start();
                }

                novoTurno();
            }
            else if(controlPerso.getClasse()==Const.MAGO)
            {
                new AnimAtkFuriaDosVentos().start();
                
                try {
                controlPerso.turnoCbt(1, 3);
                } catch (Exception ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            
            
        }
    }//GEN-LAST:event_btSkill2MouseClicked

    private void btSkillUltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSkillUltMouseClicked
        
        
        if(btSkillUlt.isEnabled())
        {
            btSkillUlt.setIcon(new ImageIcon(getClass().getResource("/Resources/CD2.png")));
            btSkillUlt.setEnabled(false);
            if(controlPerso.getClasse()==Const.ARQUEIRO)
            {
                new AnimAtkRanged().start();
                
                
                try {
                controlPerso.turnoCbt(1, 4);
                } catch (Exception ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                if((!controlPerso.passivaAtiva() && controlPerso.getClasse()==Const.ARQUEIRO) || controlPerso.isIniDead() || controlPerso.isDead())  
                {
                    if(iniJogou==0 && iniJogou==0 && !controlPerso.isDead() && !controlPerso.isIniDead())
                    {
                        new IniAction().start();
                    }



                    novoTurno();

                }
                else if(!controlPerso.isDead() && !controlPerso.isIniDead())
                {

                    lbDados.setText(""+controlPerso.getDados());
                    controlPerso.setPassivaAt();
                }
            }
            
            else if(controlPerso.getClasse()==Const.MAGO)
            {
                new AnimAtkIceBarrage().start();
                
                
                try {
                controlPerso.turnoCbt(1, 4);
                } catch (Exception ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(controlPerso.isDead() || controlPerso.isIniDead())
                {
                    novoTurno();
                }
                
            }
            else if(controlPerso.getClasse()==Const.CAVALEIRO)
            {
                new AnimWarCry().start();
                
                try {
                controlPerso.turnoCbt(1, 4);
                } catch (Exception ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                if(iniJogou==0 && !controlPerso.isDead() && !controlPerso.isIniDead())
                {
                    new IniAction().start();
                }

                

                novoTurno();
                
            
           
            } 
                    
            
            
        }
    }//GEN-LAST:event_btSkillUltMouseClicked

    private void lbIniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIniMouseClicked
        
        
        if(SwingUtilities.isRightMouseButton(evt) && lbIni.isEnabled())
        {
            
            
            
        }
    }//GEN-LAST:event_lbIniMouseClicked

    private void btVitoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVitoriaMouseClicked
        pai.setVisible(true);
        pai.setLocation(getX(),getY());
        
        dispose();
    }//GEN-LAST:event_btVitoriaMouseClicked

    private void btVitoria1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVitoria1MouseClicked
        controlPerso.deletePersoBD(controlPerso.getPersoID());
        pai.getPai().setLocation(getX(),getY());
        pai.getPai().setVisible(true);
        
        dispose();
    }//GEN-LAST:event_btVitoria1MouseClicked

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
        
        //skills
        lbPassivaSkills.setEnabled(b);
        btAtkBasico.setEnabled(b);
        
        if(controlPerso.getSkill1CD()==0 || b==false)
            btSkill1.setEnabled(b);
        if(controlPerso.getSkill2CD()==0 || b==false)
            btSkill2.setEnabled(b);
        if(controlPerso.getUltCD()==45 || b==false)
            btSkillUlt.setEnabled(b);
        
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
                     Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             while(hp<AllyHPFull.getValue())
             {
                 AllyHPFull.setValue(AllyHPFull.getValue()-1);
                 try {
                    sleep(5);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             lbHPnumber.setText(controlPerso.getHPatual()+"/"+controlPerso.getHPmax());
        }
    }

    /**
     * Classe para criar uma animação na barra de vida do inimigo.
     */        
    class SetIniHP extends Thread
    {
        private double hp;

        public SetIniHP(double nhp)
        {
            hp = nhp;
        }

        @Override
        public void run()
        {
             while(hp>IniHPFull.getValue())
             {
                 IniHPFull.setValue(IniHPFull.getValue()+1);
                 try {
                    sleep(5);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             while(hp<IniHPFull.getValue())
             {
                 IniHPFull.setValue(IniHPFull.getValue()-1);
                 try {
                    sleep(5);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             lbNomeIni.setText(controlPerso.getIniNome());
             lbLvl1.setText("Lv: "+controlPerso.getIniLvl());
             lbHPnumber1.setText(controlPerso.getIniHPatual()+"/"+controlPerso.getIniHPmax());
        }
    }
   
    /**
    * Classe para criar a animação de ataque.
    */
    class AnimAtkMeele extends Thread
    {
        
       
        
        @Override
        public void run()
        {
            try {
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            setHUDEnabled(false);

                



            



            
            

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            try {
                sleep(controlPerso.getTempAnim1());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim2());
            lbArmaPerso.setIcon(controlPerso.getArma2());
            
            Personagem.setLocation(Personagem.getX()+500, Personagem.getY());
            try {
                sleep(controlPerso.getTempAnim2());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim3());
            lbArmaPerso.setIcon(controlPerso.getArma3());
            
            
            try {
                sleep(controlPerso.getTempAnim3());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim4());
            lbArmaPerso.setIcon(controlPerso.getArma4());
            
            try {
                sleep(controlPerso.getTempAnim4());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim5());
            lbArmaPerso.setIcon(controlPerso.getArma5());
            
            try {


                sleep(controlPerso.getTempAnim5());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            lbPerso.setIcon(controlPerso.getIdle());
            lbArmaPerso.setIcon(controlPerso.getArmaIdle());
            
            setHUDEnabled(true);
            new SetIniHP(controlPerso.getIniHP()).start();
            sem.release();
            
            
            
        }

        
        
        
    }
    
    /**
    * Classe para criar a animação da bola de fogo.
    */
    class AnimAtkBolaDeFogo extends Thread
    {

        @Override
        public void run()
        {
            try {
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
            setHUDEnabled(false);




            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());




            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            try {
                sleep(controlPerso.getTempAnim1());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim2());
            lbArmaPerso.setIcon(controlPerso.getArma2());
            
            try {
                sleep(controlPerso.getTempAnim2());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim3());
            lbArmaPerso.setIcon(controlPerso.getArma3());
            
            
            try {
                sleep(controlPerso.getTempAnim3());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim4());
            lbArmaPerso.setIcon(controlPerso.getArma4());
            
            try {
                sleep(controlPerso.getTempAnim4());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim5());
            lbArmaPerso.setIcon(controlPerso.getArma5());
            
            try {


                sleep(controlPerso.getTempAnim5());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            lbProjetil.setVisible(true);

            lbPerso.setIcon(controlPerso.getIdle());
            lbArmaPerso.setIcon(controlPerso.getArmaIdle());
            lbProjetil.setIcon(new ImageIcon(getClass().getResource("/Resources/Bola de Fogo.png")));


            for(int i=0;i<10;i++)
            {
                try {
                sleep(controlPerso.getTempoProjetil()/10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                lbProjetil.setLocation(lbProjetil.getLocation().x+56, lbProjetil.getLocation().y);
            }



            lbProjetil.setVisible(false);

            setHUDEnabled(true);
            new SetIniHP(controlPerso.getIniHP()).start();
            
            sem.release();



            

        }
    }
    
    /**
    * Classe para criar a animação da fúria dos ventos
    */
    class AnimAtkFuriaDosVentos extends Thread
    {

        @Override
        public void run()
        {
            try {
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
            setHUDEnabled(false);




            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());




            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            try {
                sleep(controlPerso.getTempAnim1());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim2());
            lbArmaPerso.setIcon(controlPerso.getArma2());
            
            try {
                sleep(controlPerso.getTempAnim2());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim3());
            lbArmaPerso.setIcon(controlPerso.getArma3());
            
            
            try {
                sleep(controlPerso.getTempAnim3());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim4());
            lbArmaPerso.setIcon(controlPerso.getArma4());
            
            try {
                sleep(controlPerso.getTempAnim4());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim5());
            lbArmaPerso.setIcon(controlPerso.getArma5());
            
            try {


                sleep(controlPerso.getTempAnim5());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            

            lbPerso.setIcon(controlPerso.getIdle());
            lbArmaPerso.setIcon(controlPerso.getArmaIdle());
            lbProjetil.setVisible(true);
            lbProjetil.setIcon(new ImageIcon(getClass().getResource("/Resources/Furacao.png")));
            
            
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            lbProjetil.setLocation(lbProjetil.getLocation().x+520, lbProjetil.getLocation().y);
            
            
            
            for(int i=0;i<10;i++)
            {
                try {
                sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                lbProjetil.setLocation(lbProjetil.getLocation().x+20, lbProjetil.getLocation().y);
            }
            
            lbProjetil.setVisible(false);


            lbDados1.setText(""+controlPerso.getIniDados());

            setHUDEnabled(true);
            new SetIniHP(controlPerso.getIniHP()).start();
            
            sem.release();



            

        }
    }
    
    /**
    * Classe para criar a animação da Ice Barrage.
    */
    class AnimAtkIceBarrage extends Thread
    {

        @Override
        public void run()
        {
            try {
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
            setHUDEnabled(false);




            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());




            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            try {
                sleep(controlPerso.getTempAnim1());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim2());
            lbArmaPerso.setIcon(controlPerso.getArma2());
            
            try {
                sleep(controlPerso.getTempAnim2());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim3());
            lbArmaPerso.setIcon(controlPerso.getArma3());
            
            
            try {
                sleep(controlPerso.getTempAnim3());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim4());
            lbArmaPerso.setIcon(controlPerso.getArma4());
            
            try {
                sleep(controlPerso.getTempAnim4());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim5());
            lbArmaPerso.setIcon(controlPerso.getArma5());
            
            try {


                sleep(controlPerso.getTempAnim5());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            

            lbPerso.setIcon(controlPerso.getIdle());
            lbArmaPerso.setIcon(controlPerso.getArmaIdle());



            lbProjetil.setVisible(true);
            
            
            lbProjetil.setIcon(new ImageIcon(getClass().getResource("/Resources/Gelao.png")));
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            lbProjetil.setLocation(lbProjetil.getLocation().x+580, lbProjetil.getLocation().y);
            
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            


            lbProjetil.setVisible(false);
            lbDados1.setText(""+controlPerso.getIniDados());

            setHUDEnabled(true);
            new SetIniHP(controlPerso.getIniHP()).start();
            
            sem.release();



            

        }
    }
   
    /**
    * Classe para criar a animação de ataque á distância.
    */
    class AnimAtkRanged extends Thread
    {

        @Override
        public void run()
        {
            try {
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
            setHUDEnabled(false);




            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());




            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());

            
            try {
                sleep(controlPerso.getTempAnim1());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim2());
            lbArmaPerso.setIcon(controlPerso.getArma2());
            
            try {
                sleep(controlPerso.getTempAnim2());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim3());
            lbArmaPerso.setIcon(controlPerso.getArma3());
            
            
            try {
                sleep(controlPerso.getTempAnim3());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim4());
            lbArmaPerso.setIcon(controlPerso.getArma4());
            
            try {
                sleep(controlPerso.getTempAnim4());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //cl.show(Personagem, "card3");
            //Personagem.setLocation(Personagem.getX()+500, Personagem.getY());

            lbPerso.setIcon(controlPerso.getAnim5());
            lbArmaPerso.setIcon(controlPerso.getArma5());
            
            try {


                sleep(controlPerso.getTempAnim5());
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }

            lbProjetil.setVisible(true);

            lbPerso.setIcon(controlPerso.getIdle());
            lbArmaPerso.setIcon(controlPerso.getArmaIdle());
            lbProjetil.setIcon(controlPerso.getProjetil());


            for(int i=0;i<10;i++)
            {
                try {
                sleep(controlPerso.getTempoProjetil()/10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                lbProjetil.setLocation(lbProjetil.getLocation().x+56, lbProjetil.getLocation().y);
            }



            lbProjetil.setVisible(false);

            setHUDEnabled(true);
            new SetIniHP(controlPerso.getIniHP()).start();
            
            sem.release();



            

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
    * Classe para exibir a descrição das habilidades.
    */
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
                    lbCdSkill.setText(cd+" turnos para recarregar.");
                }
                else if(ultPass==1)
                {
                    lbCdSkill.setText("Carregado: "+cd+"/45.");
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
                
                SkillDesc.setLocation(MouseInfo.getPointerInfo().getLocation().x - mainframe.getX()  ,MouseInfo.getPointerInfo().getLocation().y-125 - mainframe.getY());
                
                
                


                sem.release();
            }
      
            
        }
    }
    
    /**
    * Classe para ocultar a descrição das habilidades.
    */
    class RemoveSkillDesc extends Thread
    {
        @Override
        public void run()
        {
            SkillDesc.setVisible(false);

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
    
    /**
    * Classe para criar a animação do inimigo.
    */
    class IniAction extends Thread
    {
        @Override
        public void run()
        {
            try {
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            setHUDEnabled(false);
            try {
                sleep(500);
                controlPerso.turnoCbt(0, 0);
            } catch (Exception ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(controlPerso.getIniTempoProjetil()==0)
            {
                
                
                
                lbIni.setIcon(controlPerso.iniGetAnim1());
                
                try {
                    sleep(controlPerso.getIniTempAnim1());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                Personagem1.setLocation(Personagem1.getX()-500, Personagem1.getY());
                lbIni.setIcon(controlPerso.iniGetAnim2());
                
                try {
                    sleep(controlPerso.getIniTempAnim2());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                lbIni.setIcon(controlPerso.iniGetAnim3());
                
                try {
                    sleep(controlPerso.getIniTempAnim3());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                lbIni.setIcon(controlPerso.iniGetAnim4());
                
                try {
                    sleep(controlPerso.getIniTempAnim4());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                lbIni.setIcon(controlPerso.iniGetAnim5());
                
                try {
                    sleep(controlPerso.getIniTempAnim5());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                Personagem1.setLocation(Personagem1.getX()+500, Personagem1.getY());
            }
            else if(controlPerso.getIniTempoProjetil()==-1)
            {
                
                
                
                lbIni.setIcon(controlPerso.iniGetAnim1());
                
                try {
                    sleep(controlPerso.getIniTempAnim1());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                lbIni.setIcon(controlPerso.iniGetAnim2());
                
                try {
                    sleep(controlPerso.getIniTempAnim2());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                Personagem1.setLocation(Personagem1.getX()-650, Personagem1.getY()-30);
                
                lbIni.setIcon(controlPerso.iniGetAnim3());
                
                try {
                    sleep(controlPerso.getIniTempAnim3());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                lbIni.setIcon(controlPerso.iniGetAnim4());
                
                try {
                    sleep(controlPerso.getIniTempAnim4());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                lbIni.setIcon(controlPerso.iniGetAnim5());
                
                try {
                    sleep(controlPerso.getIniTempAnim5());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                Personagem1.setLocation(Personagem1.getX()+650, Personagem1.getY()+30);
            }
            else
            {
                lbIni.setIcon(controlPerso.iniGetAnim1());
                
                try {
                    sleep(controlPerso.getIniTempAnim1());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                lbIni.setIcon(controlPerso.iniGetAnim1());
                
                try {
                    sleep(controlPerso.getIniTempAnim1());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                lbIni.setIcon(controlPerso.iniGetAnim2());
                
                try {
                    sleep(controlPerso.getIniTempAnim2());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                lbIni.setIcon(controlPerso.iniGetAnim3());
                
                try {
                    sleep(controlPerso.getIniTempAnim3());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                lbProjetil.setIcon(controlPerso.iniGetProjetil());
                lbProjetil.setVisible(true);
                try {
                    sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                lbProjetil.setLocation(lbProjetil.getLocation().x+540, lbProjetil.getLocation().y-35);
                for(int i=0;i<10;i++)
                {
                    try {
                    sleep(controlPerso.getIniTempoProjetil()/10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lbProjetil.setLocation(lbProjetil.getLocation().x-56, lbProjetil.getLocation().y);
                }
                
                lbIni.setIcon(controlPerso.iniGetAnim4());
                
                try {
                    sleep(controlPerso.getIniTempAnim4());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                lbIni.setIcon(controlPerso.iniGetAnim5());
                
                try {
                    sleep(controlPerso.getIniTempAnim5());
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                lbProjetil.setVisible(false);
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            lbIni.setIcon(controlPerso.getIniIdle());
            new SetHP(controlPerso.getHP()).start();
            new SetIniHP(controlPerso.getIniHP()).start();
            setHUDEnabled(true);
            if(controlPerso.isDead())
            {
                Personagem.setVisible(false);
                WinPanel1.setVisible(true);
            }
            
            sem.release();
        }
    }
  
    /**
    * Classe para cria a animação da imagem de fundo.
    */
    class BGAnim extends Thread
    {
        
        
        
        @Override
        public void run()
        {
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            while(isVisible())
            {
                BG.setIcon(controlPerso.getBG());

                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }

                BG.setIcon(controlPerso.getBG2());

                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
    * Classe para criar a animação do grito de guerra e da armadura dos deuses.
    */
    class AnimWarCry extends Thread
    {
        @Override
        public void run()
        {
            lbPerso.setIcon(controlPerso.getAnim1());
            lbArmaPerso.setIcon(controlPerso.getArma1());
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CombateRPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            lbPerso.setIcon(controlPerso.getIdle());
            lbArmaPerso.setIcon(controlPerso.getArmaIdle());
        }
    }
 //////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AllyHP;
    private javax.swing.JProgressBar AllyHPFull;
    private javax.swing.JPanel AllyInfo;
    private javax.swing.JLabel BG;
    private javax.swing.JPanel Bag;
    private javax.swing.JPanel Dados;
    private javax.swing.JPanel Dados1;
    private javax.swing.JPanel DropButtons;
    private javax.swing.JPanel DropButtons1;
    private javax.swing.JPanel DropButtons2;
    private javax.swing.JPanel DropConfirm;
    private javax.swing.JPanel Equip;
    private javax.swing.JPanel EquipTitle;
    private javax.swing.JPanel GoldXP;
    private javax.swing.JPanel HpBarAlly;
    private javax.swing.JPanel HpBarIni;
    private javax.swing.JPanel IniHP;
    private javax.swing.JProgressBar IniHPFull;
    private javax.swing.JPanel ItemDesc;
    private javax.swing.JPanel Itens;
    private javax.swing.JLayeredPane Personagem;
    private javax.swing.JLayeredPane Personagem1;
    private javax.swing.JPanel SkillDesc;
    private javax.swing.JPanel Skills;
    private javax.swing.JPanel SubEquip;
    private javax.swing.JPanel WinPanel;
    private javax.swing.JPanel WinPanel1;
    private javax.swing.JButton btAtkBasico;
    private javax.swing.JButton btDrop;
    private javax.swing.JButton btNDrop;
    private javax.swing.JButton btSkill1;
    private javax.swing.JButton btSkill2;
    private javax.swing.JButton btSkillUlt;
    private javax.swing.JButton btVitoria;
    private javax.swing.JButton btVitoria1;
    private javax.swing.JLabel lbArmaPerso;
    private javax.swing.JLabel lbArmorEquiped;
    private javax.swing.JLabel lbBagTitle;
    private javax.swing.JLabel lbCdSkill;
    private javax.swing.JLabel lbDados;
    private javax.swing.JLabel lbDados1;
    private javax.swing.JLabel lbDragItem;
    private javax.swing.JLabel lbDropMessage;
    private javax.swing.JLabel lbEquipTitle;
    private javax.swing.JLabel lbGold;
    private javax.swing.JLabel lbGoldAdquirido;
    private javax.swing.JLabel lbHPBorder;
    private javax.swing.JLabel lbHPBorder1;
    private javax.swing.JLabel lbHPnumber;
    private javax.swing.JLabel lbHPnumber1;
    private javax.swing.JLabel lbIni;
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
    private javax.swing.JLabel lbLvl1;
    private javax.swing.JLabel lbNomeIni;
    private javax.swing.JLabel lbNomePerso;
    private javax.swing.JLabel lbPassivaSkills;
    private javax.swing.JLabel lbPerso;
    private javax.swing.JLabel lbProjetil;
    private javax.swing.JLabel lbSkillDescNome;
    private javax.swing.JLabel lbVitória;
    private javax.swing.JLabel lbVitória1;
    private javax.swing.JLabel lbWeaponEquiped;
    private javax.swing.JLabel lbXpAdquirido;
    private javax.swing.JLayeredPane pnMainCbt;
    private javax.swing.JTextArea taSkillDescription;
    // End of variables declaration//GEN-END:variables
    }