/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author josev
 */
public class JugadorEspeculador extends Jugador{
    final static int FACTORESPECULADOR = 2;
    
   
    protected JugadorEspeculador(Jugador especulador){
        super(especulador);
        this.actualizaPropiedadesPorConversion(especulador);
    }
    
    public void actualizaPropiedadesPorConversion(Jugador otro){
        for(int i=0; i < otro.getPropiedades().size(); i++){
            otro.getPropiedades().get(i).actualizaPropietarioPorConversion(this);
        }
    }
    
    @Override
    boolean paga(float cantidad){
        return modificarSaldo((cantidad/FACTORESPECULADOR) * (-1));
    }
    
    @Override
    public String toString(){        
        return "(JUGADOR ESPECULADOR)  " + super.toString();
    }
    
    protected static int getCasasMax(){
        return CasasMax * FACTORESPECULADOR;
    }
    
    protected static int getHotelesMax(){
        return HotelesMax * FACTORESPECULADOR;
    }
    
    public Jugador volverAConvertir(){
        Jugador jugadorNormal= new Jugador(this);
        jugadorNormal.esEspeculador = false;
        return jugadorNormal;
    }
}
