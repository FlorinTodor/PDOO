/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josev
 */
import java.util.ArrayList;
import GUI.CivitasView;
import GUI.CapturaNombres;
import civitas.CivitasJuego;
import controladorCivitas.Controlador;


public class TestP5 {
    public static void main(String[] args) {
        CivitasView vistaPrincipal = new CivitasView();
        CapturaNombres capturaNombres = new CapturaNombres(vistaPrincipal, true);
        ArrayList<String> nombres = new ArrayList<String>();
        boolean modoDebug = false;
        
        nombres = capturaNombres.getNombres();
        
        CivitasJuego juego = new CivitasJuego(nombres, modoDebug);
        Controlador controlador = new Controlador(juego, vistaPrincipal);
        
        vistaPrincipal.setCivitasJuego(juego);
        controlador.juega();
    }
}
