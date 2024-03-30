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
public class CasillaCalle extends Casilla{
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private Jugador propietario;
    private int numHoteles, numCasas;
    
     final static float FACTORALQUILERCALLE = 1.0f, FACTORALQUILERCASA = 1.0f, FACTORALQUILERHOTEL = 4.0f;
     
    CasillaCalle(String  titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        super(titulo);
        
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.propietario = null;
        this.numHoteles = 0;
        this.numCasas = 0;
    }

    
    @Override
    public String getNombre() {
       return super.getNombre();
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getPrecioEdificar() {
        return precioEdificar;
    }

    public float getPrecioBaseAlquiler() {
        return precioBaseAlquiler;
    }
    
    public int getNumCasas(){
        return numCasas;
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    public float getPrecioAlquilerCompleto(){ //Devuelve el precio del alquiler calculado segun las normas del juego
        return (precioBaseAlquiler*(FACTORALQUILERCALLE+numCasas*FACTORALQUILERCASA+numHoteles*FACTORALQUILERHOTEL));
    }

    public int cantidadCasasHoteles(){ //Devuelve la suma de los hoteles + las casas de la casilla
        return (numHoteles + numCasas);
    }
    
    public boolean tienePropietario(){
        return this.propietario != null;
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        boolean esElPropietario = false;
       
        if(this.tienePropietario()){
            for(int i=0; i < jugador.getPropiedades().size(); i++){
                if(jugador.getPropiedades().get(i) == this){
                    esElPropietario = true;
                }
            }
        }
        
        return esElPropietario;
    }
    
    public void tramitarAlquiler(Jugador jugador){
        if(this.tienePropietario() && !esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
            this.propietario.recibe(this.getPrecioAlquilerCompleto());
        }
    }
    
    boolean derruirCasas(int numero, Jugador jugador){
        if(this.esEsteElPropietario(jugador) && this.numCasas >= numero){
            this.numCasas = this.numCasas - numero;
            return true;
        }
        else{
            return false;
        }
        
    }
    
    boolean construirHotel(Jugador jugador){
        jugador.paga(this.precioEdificar);
        
        this.numHoteles ++;
        
        return true;
    }
    
    boolean construirCasa(Jugador jugador){
        jugador.paga(this.precioEdificar);
        
        this.numCasas ++;
        
        return true;
    }
    
    boolean comprar(Jugador jugador){
        this.propietario = jugador;
        jugador.paga(precioCompra);
        
        return true;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        super.recibeJugador(iactual, todos);
        
        Jugador jugadorActual = todos.get(iactual);
        
        if(!this.tienePropietario()){
            jugadorActual.puedeComprarCasilla();
        }
        else{
            this.tramitarAlquiler(jugadorActual);
        }
    }
    
     @Override
    public String toString(){
        super.toString();
        
        return "casilla de tipo CALLE" + "\nNúmero de hoteles: "+this.numHoteles+"  \nNúmero de casas: "+this.numCasas+" Precio compra: "+this.precioCompra+"  Precio edificar: "+this.precioEdificar+"  Alquiler base: "+this.precioBaseAlquiler;
        
    }
    
    public void actualizaPropietarioPorConversion(JugadorEspeculador nuevoPropietario){
        this.propietario = nuevoPropietario;
    }
    
}
