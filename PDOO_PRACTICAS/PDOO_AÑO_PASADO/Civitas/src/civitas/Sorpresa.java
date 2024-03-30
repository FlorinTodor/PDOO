/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
/**
 *
 * @author josev
 */
public class Sorpresa {
    protected String texto;   //Indica cual es la sorpres
    protected int valor;  //Indica el valor con el que se va a modificar el saldo del jugador
    
    
    Sorpresa(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    
    private void informe(int actual, ArrayList<Jugador>todos){      //Informa al diario de que al jugador "x" se le aplica una sorpresa
        Diario.getInstance().ocurreEvento(todos.get(valor).getNombre());
    }
    
    protected void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
    }
    
    public String toString(){
        return texto;
    }
}
