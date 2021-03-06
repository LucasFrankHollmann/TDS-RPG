/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPersonagem;
import javax.swing.JFrame;

/**
 *
 * @author Megatron
 */
public class MenuSelecaoDePersonagem extends javax.swing.JFrame {

    ControllerPersonagem controlPerso;
    JFrame pai;
    
    public MenuSelecaoDePersonagem(ControllerPersonagem ctrlp, JFrame parent) {
        initComponents();
        controlPerso=ctrlp;
        pai=parent;
        
        setSelection();
        
        
    }

    void setSelection()
    {
        if(controlPerso.getBDName(1).equals("unused"))
        {
            lbTexto.setText("Vazio");
            lbLvl.setText("");
            btSelect.setVisible(false);
            btExcluir.setVisible(false);
        }
        else
        {
            lbTexto.setText(controlPerso.getBDName(1));
            lbLvl.setText("Nível "+controlPerso.getBDLvl(1));
            btSelect.setVisible(true);
            btExcluir.setVisible(true);
        }
        
        if(controlPerso.getBDName(2).equals("unused"))
        {
            lbTexto1.setText("Vazio");
            lbLvl1.setText("");
            btSelect1.setVisible(false);
            btExcluir1.setVisible(false);
        }
        else
        {
            lbTexto1.setText(controlPerso.getBDName(2));
            lbLvl1.setText("Nível "+controlPerso.getBDLvl(2));
            btSelect1.setVisible(true);
            btExcluir1.setVisible(true);
        }
        
        if(controlPerso.getBDName(3).equals("unused"))
        {
            lbTexto2.setText("Vazio");
            lbLvl2.setText("");
            btSelect2.setVisible(false);
            btExcluir2.setVisible(false);
        }
        else
        {
            lbTexto2.setText(controlPerso.getBDName(3));
            lbLvl2.setText("Nível "+controlPerso.getBDLvl(3));
            btSelect2.setVisible(true);
            btExcluir2.setVisible(true);
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

        MainMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        personagem1 = new javax.swing.JPanel();
        lbLvl = new javax.swing.JLabel();
        lbTexto = new javax.swing.JLabel();
        btSelect = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        personagem2 = new javax.swing.JPanel();
        lbLvl1 = new javax.swing.JLabel();
        lbTexto1 = new javax.swing.JLabel();
        btSelect1 = new javax.swing.JButton();
        btExcluir1 = new javax.swing.JButton();
        personagem3 = new javax.swing.JPanel();
        lbLvl2 = new javax.swing.JLabel();
        lbTexto2 = new javax.swing.JLabel();
        btSelect2 = new javax.swing.JButton();
        btExcluir2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1282, 747));
        setResizable(false);
        setSize(new java.awt.Dimension(1282, 747));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        MainMenu.setMaximumSize(new java.awt.Dimension(1280, 720));
        MainMenu.setMinimumSize(new java.awt.Dimension(1280, 720));
        MainMenu.setPreferredSize(new java.awt.Dimension(1280, 720));
        MainMenu.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(110, 110, 110));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        jPanel1.setLayout(new java.awt.GridLayout(3, 0));

        personagem1.setBackground(new java.awt.Color(50, 50, 50));
        personagem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        personagem1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLvl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLvl.setForeground(new java.awt.Color(255, 255, 255));
        lbLvl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLvl.setText("LVL");
        personagem1.add(lbLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 80));

        lbTexto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTexto.setForeground(new java.awt.Color(255, 255, 255));
        lbTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTexto.setText("NOME");
        personagem1.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -10, 320, 100));

        btSelect.setBackground(new java.awt.Color(50, 50, 50));
        btSelect.setForeground(new java.awt.Color(255, 255, 255));
        btSelect.setText("Selecionar");
        btSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSelectMouseClicked(evt);
            }
        });
        personagem1.add(btSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, 60));

        btExcluir.setBackground(new java.awt.Color(50, 50, 50));
        btExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btExcluir.setText("Excluir");
        btExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btExcluirMouseClicked(evt);
            }
        });
        personagem1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 80, 60));

        jPanel1.add(personagem1);

        personagem2.setBackground(new java.awt.Color(30, 30, 30));
        personagem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        personagem2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLvl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLvl1.setForeground(new java.awt.Color(255, 255, 255));
        lbLvl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLvl1.setText("LVL");
        personagem2.add(lbLvl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 80));

        lbTexto1.setBackground(new java.awt.Color(71, 20, 173));
        lbTexto1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTexto1.setForeground(new java.awt.Color(255, 255, 255));
        lbTexto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTexto1.setText("NOME");
        personagem2.add(lbTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -10, 320, 100));

        btSelect1.setBackground(new java.awt.Color(50, 50, 50));
        btSelect1.setForeground(new java.awt.Color(255, 255, 255));
        btSelect1.setText("Selecionar");
        btSelect1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSelect1MouseClicked(evt);
            }
        });
        personagem2.add(btSelect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, 60));

        btExcluir1.setBackground(new java.awt.Color(50, 50, 50));
        btExcluir1.setForeground(new java.awt.Color(255, 255, 255));
        btExcluir1.setText("Excluir");
        btExcluir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btExcluir1MouseClicked(evt);
            }
        });
        personagem2.add(btExcluir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 80, 60));

        jPanel1.add(personagem2);

        personagem3.setBackground(new java.awt.Color(50, 50, 50));
        personagem3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        personagem3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLvl2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLvl2.setForeground(new java.awt.Color(255, 255, 255));
        lbLvl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLvl2.setText("LVL");
        personagem3.add(lbLvl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 80));

        lbTexto2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTexto2.setForeground(new java.awt.Color(255, 255, 255));
        lbTexto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTexto2.setText("NOME");
        personagem3.add(lbTexto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -10, 320, 100));

        btSelect2.setBackground(new java.awt.Color(50, 50, 50));
        btSelect2.setForeground(new java.awt.Color(255, 255, 255));
        btSelect2.setText("Selecionar");
        btSelect2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSelect2MouseClicked(evt);
            }
        });
        personagem3.add(btSelect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, 60));

        btExcluir2.setBackground(new java.awt.Color(50, 50, 50));
        btExcluir2.setForeground(new java.awt.Color(255, 255, 255));
        btExcluir2.setText("Excluir");
        btExcluir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btExcluir2MouseClicked(evt);
            }
        });
        personagem3.add(btExcluir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 80, 60));

        jPanel1.add(personagem3);

        MainMenu.add(jPanel1);
        jPanel1.setBounds(260, 440, 770, 250);

        jButton1.setBackground(new java.awt.Color(50, 50, 50));
        jButton1.setText("Voltar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        MainMenu.add(jButton1);
        jButton1.setBounds(60, 650, 100, 40);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Menu_selecao.png"))); // NOI18N
        MainMenu.add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 721);

        getContentPane().add(MainMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirMouseClicked
        controlPerso.deletePersoBD(1);
        setSelection();
    }//GEN-LAST:event_btExcluirMouseClicked

    private void btExcluir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluir1MouseClicked
        controlPerso.deletePersoBD(2);
        setSelection();
    }//GEN-LAST:event_btExcluir1MouseClicked

    private void btExcluir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluir2MouseClicked
        controlPerso.deletePersoBD(3);
        setSelection();
    }//GEN-LAST:event_btExcluir2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        pai.setVisible(true);
        pai.setLocation(getX(),getY());
        
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void btSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSelectMouseClicked
        controlPerso.loadPerso(1);
        
        Mapa1RPG map = new Mapa1RPG(controlPerso, pai);
        map.setLocation(getX(),getY());
        map.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSelectMouseClicked

    private void btSelect1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSelect1MouseClicked
        controlPerso.loadPerso(2);
        
        Mapa1RPG map = new Mapa1RPG(controlPerso, pai);
        map.setLocation(getX(),getY());
        map.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSelect1MouseClicked

    private void btSelect2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSelect2MouseClicked
        controlPerso.loadPerso(3);
        
        Mapa1RPG map = new Mapa1RPG(controlPerso, pai);
        map.setLocation(getX(),getY());
        map.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSelect2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainMenu;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btExcluir1;
    private javax.swing.JButton btExcluir2;
    private javax.swing.JButton btSelect;
    private javax.swing.JButton btSelect1;
    private javax.swing.JButton btSelect2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbLvl;
    private javax.swing.JLabel lbLvl1;
    private javax.swing.JLabel lbLvl2;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JLabel lbTexto1;
    private javax.swing.JLabel lbTexto2;
    private javax.swing.JPanel personagem1;
    private javax.swing.JPanel personagem2;
    private javax.swing.JPanel personagem3;
    // End of variables declaration//GEN-END:variables
}
