package civitas;

import java.util.ArrayList;

public class Casilla {
    private String nombre; 
    
    //CONSTRUCTOR
    
    public Casilla(String nombre){
        this.nombre = nombre;        
    }
   
    //CONSULTORES
    public String getNombre(){
        return nombre;
    }
    
    //MÉTODOS

    
    public String toString(){
        return "NOMBRE: " + this.nombre + "\n";
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(actual) + "ha caido en " + this.toString());
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
            this.informe(iactual, todos);
    }
    
    
}
