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
public class CasillaSorpresa extends Casilla{
    private Sorpresa sorpresa;              
    private MazoSorpresas mazo;
    
    public CasillaSorpresa(String nombre, MazoSorpresas mazo){
        super(nombre);
        this.mazo = mazo;
        this.sorpresa = null;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        this.sorpresa = this.mazo.siguiente();
        super.recibeJugador(iactual, todos);
        sorpresa.aplicarAJugador(iactual, todos);
    }
    
    @Override
    public String toString(){
        return super.toString() + "Casilla sorpresa";
    }
}
