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
public class Jugador implements Comparable<Jugador> {
    protected static int CasasMax = 4, CasasPorHotel = 4, HotelesMax = 4;
    protected static float PasoPorSalida = 1000;
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    private static float SaldoInicial = 7500;
    protected boolean esEspeculador = false;
    
    private ArrayList<CasillaCalle> propiedades;
    //CONSTRUCTORES
    Jugador(String nombre){
        this.nombre = nombre;
        this.propiedades = new ArrayList<CasillaCalle>();
        this.casillaActual = 0;
        this.saldo = SaldoInicial;
        this.puedeComprar = true;
    }
    
    protected Jugador(Jugador otro){
        this.nombre = otro.nombre;
        this.propiedades = otro.getPropiedades();
        this.puedeComprar     = otro.getPuedeComprar();
        this.saldo            = otro.getSaldo();
        this.casillaActual = otro.getCasillaActual();
    }
    
    //CONSULTORES
    public String getNombre(){
        return this.nombre;
    }
    
    public int getCasillaActual(){
        return this.casillaActual;
    }
    
    int cantidadCasasHoteles(){
        int cantidadCasasHoteles = 0;
        for(int i=0; i<propiedades.size(); i++){
           cantidadCasasHoteles += propiedades.get(i).cantidadCasasHoteles();
        }
        return cantidadCasasHoteles;
    }
    
    boolean tieneAlgoQueGestionar (){   
        if(!this.propiedades.isEmpty()){
            return true;
        }
        
        else return false;
    }

    private boolean puedoGastar (float precio){
        if(precio > this.saldo){
            return false;
        }
        
        else return true;
    }

    boolean puedeComprarCasilla(){
        this.puedeComprar =true;
        return puedeComprar;
    }    
    
    boolean enBancarrota(){
        if(this.saldo <= 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean existeLaPropiedad(int ip){
        if(this.propiedades.get(ip) != null && this.propiedades.size() > ip){
            return true;
        }
        else return false;
    }
    
    protected static int getCasasMAX(){
        return CasasMax;
    }
    
    protected static int getHotelesMAX(){
        return HotelesMax;
    }
    
    protected static int getCasasPorHotel(){ //Casas por hotel limite
        return CasasPorHotel;
    }
   
    public ArrayList<CasillaCalle> getPropiedades(){
        return this.propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    public float getSaldo(){
        return this.saldo;
    }
    
    
    private boolean puedoEdificarCasa(CasillaCalle propiedad){
       
        if(propiedad.esEsteElPropietario(this) && propiedad.getNumCasas() <= getCasasMAX()){
            return true;
        }
        else return false;
    }
    
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        
        if(propiedad.esEsteElPropietario(this) && propiedad.getNumHoteles() <= getHotelesMAX() && propiedad.getNumCasas() >= getCasasPorHotel()){
            return true;
        }
        else return false;
    }

    
    
    //METODOS PUBLICOS
    
    public String toString(){
        String descripcion = this.nombre + ",   saldo: " + this.saldo + ",    Listado de propiedades: ";
        for(int i=0; i < propiedades.size(); i++){
            descripcion = descripcion + propiedades.get(i).getNombre() + ", ";
        }
        
        return descripcion + "\n";
    }
    
    boolean pagaAlquiler(float cantidad){ 
        this.paga(cantidad);
        return true;
    }
    
    boolean recibe(float cantidad){
        return modificarSaldo(cantidad);
    }
    
    boolean paga(float cantidad){
        return modificarSaldo(cantidad * (-1));
    }
    
    boolean modificarSaldo(float cantidad){
        this.saldo += cantidad;
        Diario.getInstance().ocurreEvento("El nuevo saldo de " + this.getNombre() + " es " + this.getSaldo());
        return true;
    }
        
    boolean moverACasilla (int c){
        this.casillaActual = c;
        this.puedeComprar = false;
        Diario.getInstance().ocurreEvento("el jugador " + this.getNombre() + " pasa a la casilla " + c);
        return true;
    }    
    
    boolean pasaPorSalida (){   //El jugador que pasa por la casilla de salida gana 10000 euros
        this.recibe(getPremioPasoPorSalida());
        Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " pasa por la casilla de salida");
        return true;
    }
    
    private static float  getPremioPasoPorSalida(){
        return PasoPorSalida;
    }
    
    //Si el saldo del jugador actual es > que el pasado por parametro devuelve 1
    // si es < devuelve -1
    public int compareTo (Jugador otro){
        int orden = 0;
        if( this.getSaldo() > otro.getSaldo() )
            orden = 1;
        else if ( this.getSaldo() < otro.getSaldo() )
            orden = -1;
             
        return orden;
    }
    
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        
        if(this.puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if(this.puedoGastar(precio)){
                result = titulo.comprar(this);
               
                this.propiedades.add(titulo);
                
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " compra la propiedad " + titulo.getNombre());
            }
            
            else{
                this.puedeComprar = false;
                
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " no dispone de saldo suficiente para comprar la propiedad " + titulo.getNombre());
            }
        }
        
        return result;
    }
    
    boolean construirHotel(int ip){
        boolean result = false;
        
        if(this.existeLaPropiedad(ip)){
            CasillaCalle propiedad = this.propiedades.get(ip);
            
            boolean puedoEdificarHotel = this.puedoEdificarHotel(propiedad);
            
            float precio  = propiedad.getPrecioEdificar();
            
            if(!this.puedoGastar(precio)){
                puedoEdificarHotel = false;
            }
            
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " construye hotel en la propiedad " + propiedad.getNombre());
            }
        }
        
        return result;
    }
    
    boolean construirCasa(int ip){
        boolean result = false;
        
        boolean existe = this.existeLaPropiedad(ip);
        
        if(existe){
            CasillaCalle propiedad = propiedades.get(ip);
            
            boolean puedoEdificar = this.puedoEdificarCasa(propiedad);
            
            float precioEdificar = propiedad.getPrecioEdificar();
            
            if(!this.puedoGastar(propiedad.getPrecioEdificar())){
                puedoEdificar = false;
            }
            if(puedoEdificar){
                propiedad.construirCasa(this);
                result = true;
                
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " construye una casa en la propiedad " + propiedad.getNombre());
            }
        }
        
        return result;
    }
    
    public JugadorEspeculador convertir(){
        JugadorEspeculador especulador = new JugadorEspeculador(this);
        especulador.esEspeculador = true;
        return especulador;
    }
    
    public boolean esEspeculador(){
        return esEspeculador;
    }
}
