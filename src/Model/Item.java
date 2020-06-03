package Model;

import javax.swing.ImageIcon;

public class Item {

        
    private double pfe, pintel, pstr, pdex, pluck, presist, pcritC;
    private int qtd, qtdMax;
    
    private int code;
    
    private int chp;
    private String nome; 
    private int preco;
    private Const tipoEquip;
    private Const type;
    private ImageIcon img;
    private String imm;
   
    /**
     * Construtor Item para cópia dos mesmos 
     * @param i item a ser utilizado
     */
    public Item(Item i) //Contrudor de cópia.
    {
        if(i!=null)
        {
            imm = i.getIm();
            pfe = i.getPfe();
            pintel = i.getPintel();
            pstr = i.getPstr();
            pdex = i.getPdex();
            pluck = i.getPluck();
            presist = i.getPresist();
            pcritC = i.getPcritC();

            qtd = i.getQtd();
            qtdMax = i.getQtdMax();
            code = i.getCode();

            chp = i.getChp();

            nome = i.getNome();
            preco = i.getPreco();
            tipoEquip = i.getTipoEquip();
            type = i.getType();
            img = i.getImg();
            
        }
               
    }
    
    /**
     * Construtor para criação dos itens
     * @param typ tipo 
     * @param typEq tipo do equipamento
     * @param qm quantidade máxima
     * @param fe quantidade do atributo fé que ele possui
     * @param intel quantidade do atributo inteligente que ele possui
     * @param str quantidade do atributo força que ele possui
     * @param dex quantidade do atributo fé que ele possui
     * @param luck quantidade do atributo sorte que ele possui
     * @param resist quantidade do atributo resistencia que ele possui
     * @param critC quantidade do atributo Critico que ele possui
     * @param hp quantidade do atributo vida que ele possui
     * @param name nome do item
     * @param cod identificador
     * @param prec preco do item
     * @param im icone do item 
     */
    public Item(Const typ, Const typEq, int qm, double fe, double intel, double str, double dex, double luck, double resist, double critC, int hp, String name, int cod, int prec,String im)
    {
        imm = im;
        img = new ImageIcon(getClass().getResource(im));
        type = typ;
        tipoEquip = typEq;
        code = cod;
        qtd = 1;
        qtdMax=qm;
        pfe = fe;
        pintel = intel;
        pstr = str;
        pdex = dex;
        pluck = luck;
        presist = resist;
        pcritC = critC;
        chp = hp;
        nome = name;
        preco = prec;
    }
    
    public String getIm()
    {
        return imm;
    }
    
    public ImageIcon getImg()
    {
        return img;
    }
    
    public int getPreco() {
        return preco;
    }
     
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    

    public int getQtdMax() {
        return qtdMax;
    }

    public Const getType() {
        return type;
    }
    
    
    public double getPfe() {
        return pfe;
    }

    public double getPintel() {
        return pintel;
    }

    public double getPstr() {
        return pstr;
    }

    public double getPdex() {
        return pdex;
    }

    public double getPluck() {
        return pluck;
    }

    public double getPresist() {
        return presist;
    }

    public double getPcritC() {
        return pcritC;
    }

    public int getChp() {
        return chp;
    }

    public void setQtd(int q)
    {
        qtd = q;
    }
    
    public int getQtd()
    {
        return qtd;
    }
    
    public String getNome() {
        return nome;
    }

    public Const getTipoEquip() {
        return tipoEquip;
    }
    
    
   
    
    
            
}
