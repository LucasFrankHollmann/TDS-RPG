package Model;


public class Vida {
    private int base, max, atual;
    private int eqPercent;
    private boolean death=false;

    public boolean isDead() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }
    
    public Vida(int b){
        this.base = b;
        this.atual = b;
        this.max = b;
        this.eqPercent = 0;
    }
    
    public void setBase(int b){
        this.base = b;
        this.max = this.base+eqPercent;
    }
    
    public void setMax(int m){
        this.max = m;
    }
    
    public void setAtual(int a){
        this.atual = a;
    }
    
    public void setEqPercent(int ep){
        this.eqPercent = ep;
        this.max = this.base+eqPercent;
    }
    
    public int getBase(){
        return this.base;
    }
    
    public int getMax(){
        return this.max;
    }
    
    public int getAtual(){
        return this.atual;
    }
    
    public int getEqPercent(){
        return this.eqPercent;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    public void heal(int h){
        if(this.atual+h<=this.max){
            this.atual = this.atual+h;
        }else{
            this.atual = this.max;
        }
    }
    
    public void damage(int d){
        if(this.atual-d>0){
            this.atual = this.atual-d;
        }else{
            this.atual = 0;
            this.death = true;
        }
    }
    
    
    
    
}
