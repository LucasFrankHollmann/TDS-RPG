package Model;


public class Atributo {
    private int atual, efetiva, base;
    private double buffPercent, debuffPercent, eqPercent;
    
    
    /**
     *
     * Construtor da classe Atributos, que são características que os personagens jogáveis possuem. Eles podem ser melhorados ou degradados
     */
    public Atributo(int x){
        this.atual=x;
        this.base=x;
        this.efetiva=x;
        this.buffPercent=0;
        this.debuffPercent=0;
        this.eqPercent=0;
    }
    
    public void setBase(int x){
        this.base=x;
        this.atual=x+(int)(x*eqPercent);
        this.efetiva= (this.atual+(int)(x*buffPercent)-(int)(x*debuffPercent));
    }
    
    public void setEqPercent(double x){
        this.eqPercent=x;
        this.atual=(int) (this.base+(int)(this.base*eqPercent));
        this.efetiva= (this.atual+(int)(this.base*buffPercent)-(int)(this.base*debuffPercent));
    }
    
    public void setBuff(double b){
        this.buffPercent=b;
        this.efetiva= (this.atual+(int)(this.base*buffPercent));
    }
    
    public void setDebuff(double db){
        this.debuffPercent=db;
        this.efetiva= (this.atual-(int)(this.base*debuffPercent));
    }
    
    public int getAtual(){
        return this.atual;
    }
    
    public int getEfetiva(){
        return this.efetiva;
    }
    
    public int getBase(){
        return this.base;
    }
    
    public double getEqPercent(){
        return this.eqPercent;
    }
    
    public double getBuffPercent(){
        return this.buffPercent;
    }
    
    public double getDebuffPercent(){
        return this.debuffPercent;
    }
    
    public void printAt(){
        System.out.println("Atual -> "+this.atual);
        System.out.println("Efetiva -> "+this.efetiva);
        System.out.println("Base -> "+this.base);
        System.out.println("Eq. Percent -> "+this.eqPercent);
        System.out.println("Buff Percent -> "+this.buffPercent);
        System.out.println("Debuff Percent -> "+this.debuffPercent);
    }
}
