/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josev
 */

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import GUI.VistaTextual;
import java.util.ArrayList;

public class JuegoTexto {

    public static void main(String[] args){
        ArrayList<String> participantes = new ArrayList<String>();
        CivitasJuego juego;
        VistaTextual vista;
        Controlador controlador;
        
        participantes.add("Jose");
        participantes.add("Encarni");
        participantes.add("Teresa");
        participantes.add("JoseJR");
        
        juego = new CivitasJuego(participantes, false);
        vista = new VistaTextual(juego);
        //controlador = new Controlador(juego, vista);
        
        //controlador.juega();
    }
}
