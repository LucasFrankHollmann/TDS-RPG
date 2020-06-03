package Model;

import javax.swing.ImageIcon;



public class Mapa1 extends Mapa{
    
    
    
    public Mapa1(CodeGen codeGen) {
        node[0] = new MapNodeInimigo(new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")),new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")), 1, -1, 
        new Inimigo("Rodolph",'s' , 'd', 0, 0, 10, 5, 0, 13, 0, 100, 1,
        "/Resources/Inimigo1-1.png","/Resources/Inimigo1-1.png",
        "/Resources/Inimigo1-2.png","/Resources/Inimigo1-3.png",
        "/Resources/Inimigo1-1.png","/Resources/Inimigo1-1.png",
        "/Resources/IniAtaque1.png",100,500,700,0,100,200),null);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////
        
        node[1] = new MapNodeInimigo(new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")),new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")), 1, -1, 
        new Inimigo("Metamorfo Galvânico",'s' , 's', 0, 0, 11, 5, 0, 13, 0, 110, 1,
        "/Resources/UltraTPadrao.png","/Resources/UltraTAtk1.png",
        "/Resources/UltraTAtk2.png","/Resources/UltraTAtk3.png",
        "/Resources/UltraTAtk2.png","/Resources/UltraTAtk1.png",
        "",300,200,300,0,0,0),null);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////
        
        node[2] = new MapNodeMercador(new ImageIcon(getClass().getResource
        ("/Resources/MapaAnao.png")), new ImageIcon(getClass().getResource
        ("/Resources/MapaAnao.png")), 0, 0, null, 
        new Mercador(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, 
        "Poção de vida", 1, 10, "/Resources/Pot_HP.png"), 
        new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, 
        "Poção de vida", 1, 10, "/Resources/Pot_HP.png"),
        new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0, 0, 0, 0, 0, 0, 0, 50, 
        "Poção de vida", 1, 10, "/Resources/Pot_HP.png"),
        new Item(Const.EQUIPAMENTO, Const.WEAPON, 1, 0, 0.30, 0.20, 0.25, 0, 0, 0, 0, 
        "Instrumento de guerra", 30, 30, "/Resources/WeaponSlot_Crit.png"), 
        new Item(Const.EQUIPAMENTO, Const.TORSO, 1, 0, 0.25, 0.17, 0.23, 0, 0.2, 0, 30, 
        "Peitoral", 31, 30, "/Resources/ArmorSlot_Crit.png"), 
        new Item(Const.EQUIPAMENTO, Const.PERNAS, 1, 0, 0.23, 0.15, 0.18, 0, 0.2, 0, 15, 
        "Perneiras", 32, 30, "/Resources/LegSlot_Crit.png")));
        
        ///////////////////////////////////////////////////////////////////////////////////////////////
        
        node[3] = new MapNodeInimigo(new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")),new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")), 1, -1, 
        new Inimigo("Ludwig",'s' , 's', 0, 0, 11, 5, 0, 13, 0, 150, 2,
        "/Resources/Inimigo2-1.png","/Resources/Inimigo2-2.png",
        "/Resources/Inimigo2-3.png","/Resources/Inimigo2-4.png", 
        "/Resources/Inimigo2-4.png","/Resources/Inimigo2-4.png",
        "",300,200,300,0,0,0),null);
       
        ///////////////////////////////////////////////////////////////////////////////////////////////
        
        node[4] = new MapNodeInimigo(new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")),new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")), 1, -1, 
        new Inimigo("Fury",'s' , 's', 0, 0, 15, 5, 0, 13, 0, 120, 2,
        "/Resources/Inimigo3-1.png","/Resources/Inimigo3-1.png",
        "/Resources/Inimigo3-1.png","/Resources/Inimigo3-1.png",
        "/Resources/Inimigo3-1.png","/Resources/Inimigo3-1.png",
        "/Resources/Ataque3.png",0,0,0,0,0,300),null);
       
        ///////////////////////////////////////////////////////////////////////////////////////////////

        node[5] = new MapNodeInimigo(new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")),new ImageIcon(getClass().getResource
        ("/Resources/CombateMapa.png")), 1, -1, 
        new Inimigo("Galo de combate",'s' , 's', 0, 0, 10, 5, 0, 13, 0, 170, 2,
        "/Resources/galo1.png","/Resources/galo2.png",
        "/Resources/galo3.png","/Resources/galo2.png",
        "/Resources/galo1.png","/Resources/galo1.png",
        "/Resources/galop.png",100,200,10,10,0,300),null);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////

        node[6] = new MapNodeMercador(new ImageIcon(getClass().getResource
        ("/Resources/MapaAnao.png")), new ImageIcon(getClass().getResource
        ("/Resources/MapaAnao.png")), 0, 0, null, 
        new Mercador(new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 50, 
        "Overload", 500, 30, "/Resources/Pot_resist.png"),
        new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 50, 
        "Overload", 500, 30, "/Resources/Pot_resist.png"),
        new Item(Const.CONSUMIVEL, Const.CONSUMIVEL, 64, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 50, 
        "Overload", 500, 30, "/Resources/Pot_resist.png"),
        new Item(Const.EQUIPAMENTO, Const.WEAPON, 1, 0, 0.50, 0.40, 0.45, 0, 0, 0, 0, 
        "Instrumento de guerra melhorado", 33, 50, "/Resources/WeaponSlot_Fe.png"), 
        new Item(Const.EQUIPAMENTO, Const.TORSO, 1, 0, 0.45, 0.35, 0.40, 0, 0.3, 0, 50, 
        "Peitoral melhorado", 34, 50, "/Resources/ArmorSlot_Fe.png"), 
        new Item(Const.EQUIPAMENTO, Const.PERNAS, 1, 0, 0.40, 0.30, 0.35, 0, 0.3, 0, 30, 
        "Perneiras melhoradas", 35, 50, "/Resources/LegSlot_Fe.png")));
       
        ///////////////////////////////////////////////////////////////////////////////////////////////
        
        node[7] = new MapNodeInimigo(new ImageIcon(getClass().getResource
        ("/Resources/MapaBoss.png")),new ImageIcon(getClass().getResource
        ("/Resources/MapaBoss 2.png")), 1, -1, 
        new Inimigo("Boss",'s' , 's', 0, 0, 20, 5, 0, 13, 0, 300, 3,
        "/Resources/Boss 1.png","/Resources/Boss 2.png",
        "/Resources/Boss 3.png","/Resources/Boss4.png",
        "/Resources/Boss 2.png","/Resources/Boss 1.png",
        "",300,300,300,200,200,-1),null);
    
    }
    
    
    
    
    
    
    
    
}
