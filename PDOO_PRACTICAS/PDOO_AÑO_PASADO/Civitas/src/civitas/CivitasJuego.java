/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author josev
 */
public class CivitasJuego {
    private int indiceJugadorActual;
    private ArrayList<Jugador> jugadores;
    private MazoSorpresas mazo;
    private Tablero tablero;
    private EstadosJuego estado;
    private GestorEstados gestorEstados;
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        jugadores = new ArrayList<Jugador>();
        
        //Inicializa el array de jugadores
        for(int i=0; i<nombres.size(); i++){
            Jugador nuevoJugador;
            nuevoJugador = new Jugador(nombres.get(i));
            
            jugadores.add(nuevoJugador);
        }
        
        //Inicializa el gestor de estados
        gestorEstados = new GestorEstados();
        this.estado = gestorEstados.estadoInicial();
        
        //Inicializa el estado del dado (debug ON/OFF)
        Dado.getInstance().setDebug(debug);
        
        //Elige quien empieza la partida
        this.indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        
        //Inicializa y crea el mazo de sorpresas
        mazo = new MazoSorpresas(debug);
        this.inicializaMazoSorpresas();
        //Crea el tablero
        tablero = new Tablero();
        this.inicializaTablero(mazo);
    }
    
    private void inicializaTablero (MazoSorpresas mazo){

        tablero.añadeCasilla(new CasillaCalle("Camberos", 1000, 500, 250));
        tablero.añadeCasilla(new CasillaCalle("Portugal", 1000, 500, 250));
        tablero.añadeCasilla(new CasillaCalle("Calle Ancha", 1000, 500, 250));
        tablero.añadeCasilla(new CasillaCalle("Comedias", 1250, 750, 500));
        tablero.añadeCasilla(new CasillaCalle("Noria", 1250, 750, 500));
        tablero.añadeCasilla(new CasillaCalle("Galdopar", 1250, 750, 500));
        tablero.añadeCasilla(new CasillaCalle("Coso Viejo", 1500, 1000, 750));
        tablero.añadeCasilla(new CasillaCalle("General Castaños", 1500, 1000, 750));
        tablero.añadeCasilla(new CasillaCalle("Las Palmeras", 1500, 1000, 750));
        tablero.añadeCasilla(new CasillaCalle("Casas del Campo", 1750, 1250, 1000));
        tablero.añadeCasilla(new CasillaCalle("Concepción Arenal", 1750, 1250, 1000));
        tablero.añadeCasilla(new CasillaCalle("Plaza Castilla", 1750, 1250, 1000));
        tablero.añadeCasilla(new CasillaCalle("Grove Street", 2000, 1500, 1250));
        tablero.añadeCasilla(new CasillaCalle("Evergreen Terrace", 2000, 1500, 1250));
        
        tablero.añadeCasilla(new Casilla("Parking"));
        
        tablero.añadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
    }
    
    private void inicializaMazoSorpresas(){ //Crea las diferentes sorpresas y las introduce en el mazo
        Sorpresa sorpresaPaga = new SorpresaPagarCobrar("El jugador debe pagar", -1000);
        Sorpresa sorpresaRecibe = new SorpresaPagarCobrar("El jugador recibe un premio", 1000);
        Sorpresa SorpresaPorCasaHotel_paga = new SorpresaPorCasaHotel("El jugador paga por cada casa y hotel de su propiedad", jugadores.get(indiceJugadorActual).cantidadCasasHoteles() * -500);
        Sorpresa sorpresaPorCasaHotel_cobra = new SorpresaPorCasaHotel("El jugador cobra por cada casa y hotel de su propiedad", jugadores.get(indiceJugadorActual).cantidadCasasHoteles() * 500);
        
        //3 sorpresas buenas y 3 malas(TipoSorpresa.PAGARCOBRAR),  2 sorpresas buenas y 2 malas(TipoSorpresa.PORCASAHOTEL)
        mazo.alMazo(sorpresaPaga);
        mazo.alMazo(sorpresaRecibe);
        mazo.alMazo(SorpresaPorCasaHotel_paga);
        mazo.alMazo(sorpresaPorCasaHotel_cobra);
        mazo.alMazo(sorpresaPaga);
        mazo.alMazo(sorpresaRecibe);
        mazo.alMazo(SorpresaPorCasaHotel_paga);
        mazo.alMazo(sorpresaPorCasaHotel_cobra);
        mazo.alMazo(sorpresaPaga);
        mazo.alMazo(sorpresaRecibe);
    }
        
    public Jugador getJugadorActual(){
        return this.jugadores.get(indiceJugadorActual);
    }
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    public Tablero getTablero(){
        return tablero;
    }
    
    //Actualiza el indice del jugador actual, teniendo en cuenta que pueda ser el ultimo
    private void pasarTurno(){
        this.indiceJugadorActual = (this.indiceJugadorActual + 1) % this.jugadores.size();
    }
    

    public void siguientePasoCompletado(OperacionJuego operacion){
        this.estado = this.gestorEstados.siguienteEstado(this.jugadores.get(indiceJugadorActual), this.estado, operacion);
    }
    
    public boolean construirCasa(int ip){
        return this.jugadores.get(this.indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return this.jugadores.get(this.indiceJugadorActual).construirHotel(ip);
    }

    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        if(tablero.computarPasoPorSalida()){
            jugadorActual.pasaPorSalida();
        }
    }
    
    public boolean finalDelJuego(){
        int numJugadores = this.jugadores.size();
        boolean jugadorBancarrota = false;
        
        for(int i = 0; i < numJugadores; i++)
            if(this.jugadores.get(i).enBancarrota() == true){
                jugadorBancarrota = true;
            }
            
        return jugadorBancarrota;
    }
    
    
    public String ranking(){
        Collections.sort(this.jugadores);
        
        String ranking = "";
        int puesto = 1;
        
        for (int i = jugadores.size()-1; i >=0; i--){
            ranking += "-PUESTO " + puesto + ":      "+ jugadores.get(i).getNombre() + "\n";
            puesto++;
        }
        return ranking;
    }
    
    
    private void avanzaJugador(){
        Jugador jugadorActual = this.getJugadorActual();
        
        int posicionActual = jugadorActual.getCasillaActual();
        
        int tirada = Dado.getInstance().tirar();
        
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        
       // Casilla casilla  = tablero.getCasilla(posicionNueva);
        
        this.contabilizarPasosPorSalida(jugadorActual);
        
        jugadorActual.moverACasilla(posicionNueva);
        
        tablero.getCasilla(posicionNueva).recibeJugador(this.indiceJugadorActual, jugadores);
    }
 
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = this.getJugadorActual();
        OperacionJuego operacion = this.gestorEstados.siguienteOperacion(jugadorActual, estado);
        
        if(operacion == OperacionJuego.PASAR_TURNO){
            this.pasarTurno();
            this.siguientePasoCompletado(operacion);
        }
        
        if(operacion == OperacionJuego.AVANZAR){
            this.avanzaJugador();
            this.siguientePasoCompletado(operacion);
        }
        return operacion;
    }
    
    public boolean comprar(){
        Jugador jugadorActual = this.getJugadorActual();
        
        int numCasillaActual = jugadorActual.getCasillaActual();
        
        CasillaCalle casilla = (CasillaCalle)tablero.getCasilla(numCasillaActual);
        
        return jugadorActual.comprar(casilla);
    }
}
