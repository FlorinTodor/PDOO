/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author josev
 */
public class TestP4 {
    
    public static void main(String[] args){
        Jugador jugador = new Jugador("Jose");
        CasillaCalle propiedad = new CasillaCalle("Camberos", 30, 10, 15);
        jugador.getPropiedades().add(propiedad);
        
        JugadorEspeculador especulador = jugador.convertir();
        
        System.out.println(especulador.toString());
    }
}
