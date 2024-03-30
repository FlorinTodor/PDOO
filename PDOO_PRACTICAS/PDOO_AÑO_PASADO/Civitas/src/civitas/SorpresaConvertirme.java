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
public class SorpresaConvertirme extends Sorpresa{
    
    public SorpresaConvertirme(String texto){
        super(texto, 0);
    }
    
    @Override
    protected void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.aplicarAJugador(actual, todos);
        Jugador jugadorActual = todos.get(actual);
        todos.remove(actual);
        if(jugadorActual.esEspeculador()){
            JugadorEspeculador especulador = (JugadorEspeculador)jugadorActual;
            todos.add(especulador.volverAConvertir());
        }
        else{
            todos.add(jugadorActual.convertir());
        }
        
    }
}
