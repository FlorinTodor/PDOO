/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorCivitas;
import civitas.CivitasJuego;
import GUI.CivitasView;
import civitas.OperacionJuego;
import civitas.OperacionInmobiliaria;
import civitas.GestionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;

/**
 *
 * @author josev
 */
public class Controlador {
    private CivitasJuego juego;
    private CivitasView vista;

    
    public Controlador(CivitasJuego juego, CivitasView vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    public void juega(){
        while(!juego.finalDelJuego()){
            vista.actualiza();
            
            vista.pausa();
            
            OperacionJuego pasoSiguiente = juego.siguientePaso();
            juego.siguientePaso();
            vista.mostrarSiguienteOperacion(pasoSiguiente);
            
            if(pasoSiguiente != OperacionJuego.PASAR_TURNO){
                this.vista.mostrarEventos();
                this.vista.actualiza();
            }
            
            if(pasoSiguiente == OperacionJuego.COMPRAR){
                Respuesta respuesta = vista.comprar();
                
                if(respuesta == Respuesta.SI){
                    this.juego.comprar();
                }
                
                this.juego.siguientePasoCompletado(pasoSiguiente);
            }
            
            if(pasoSiguiente == OperacionJuego.GESTIONAR){
                OperacionInmobiliaria operacionARealizar = this.vista.elegirOperacion();
                
                if(operacionARealizar != OperacionInmobiliaria.TERMINAR){
                    int indicePropiedad = this.vista.elegirPropiedad();
                    
                    GestionInmobiliaria gestion = new GestionInmobiliaria(operacionARealizar, indicePropiedad);
                    
                    if(operacionARealizar == OperacionInmobiliaria.CONSTRUIR_CASA){
                        juego.construirCasa(indicePropiedad);
                    }
                    
                    if(operacionARealizar == OperacionInmobiliaria.CONSTRUIR_HOTEL){
                        juego.construirHotel(indicePropiedad);
                    }
                }
                
                else{
                    juego.siguientePasoCompletado(pasoSiguiente);
                }
            }   
            
        }
        
        
        vista.actualiza();
    }
    
}
