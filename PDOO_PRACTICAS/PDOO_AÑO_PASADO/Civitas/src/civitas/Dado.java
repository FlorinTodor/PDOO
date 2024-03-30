/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.Random;
/**
 *
 * @author josev
 */
public class Dado {
    private Random random;
    private int ultimoResultado;
    private boolean debug;
    
    static final private Dado instance = new Dado();
    
    private Dado(){
        random = new Random();
        ultimoResultado = 0;
        debug = false;
    }
    
    static public Dado getInstance(){
        return instance;
    }
    
    public int tirar(){
        if(debug == false){
           ultimoResultado = random.nextInt(6);
        }
        
        else{
            ultimoResultado = 1;
        }
        return ultimoResultado;
    }
    
    public int quienEmpieza(int n){ 
        int posicionEmpieza;
        posicionEmpieza = random.nextInt(n);
        return posicionEmpieza;
    }
    
    public void setDebug (boolean d){
        debug = d;
        if(debug == true){
        Diario.getInstance().ocurreEvento("debug true");
        }
        
        else{
            Diario.getInstance().ocurreEvento("debug false");
        }
    }
    
    public int getUltimoResultado(){
        return ultimoResultado;
    }

    public boolean isDebug(){
        return debug;
    }
    
}
