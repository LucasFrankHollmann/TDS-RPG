package Model;

import java.util.Random;


public class Dado {
    private int faces;
    private Random r = new Random();
    private int status;
    private int valor;
    
    /**
    * Construtor da classe Dado, recebendo o número de faces que o mesmo contém, e qual o status atual dele
    * (se ele poderá ou não ser jogado)
    * @param f  número de faces
    */
    public Dado(int f){
        this.faces = f;
        this.status = 0;
    }

    public void setStatus(int status) {
        this.status += status;
    }
    
    /**
     * Função Rolagem, onde é verificado se o dado atual pode ou não ser utilizado (por estar sob efeito
     * de alguma habilidade)
     * Se o valor do dado for 0, ele pode ser utilizado
     * Caso contrário, o mesmo irá ter seu valor decrementado apenas, indo para o próximo turno
     * @return valor da rolagem
     */
    public int rolagem(){
        if(status==0){
            return (r.nextInt(this.faces))+1;
        }else{
            status--;
            return 0;
        }
    }
    
    public int getValor()
    {
        return valor;
    }

    void prende() {
        status = 1;
    }
}