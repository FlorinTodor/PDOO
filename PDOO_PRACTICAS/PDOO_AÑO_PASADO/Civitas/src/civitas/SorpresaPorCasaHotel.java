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
public class SorpresaPorCasaHotel extends Sorpresa{
    
    SorpresaPorCasaHotel(String texto, int valor){
        super(texto, valor);
    }
    
    @Override
    protected void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.aplicarAJugador(actual, todos);
        todos.get(actual).modificarSaldo(this.valor + todos.get(actual).cantidadCasasHoteles());
    }
    
}
