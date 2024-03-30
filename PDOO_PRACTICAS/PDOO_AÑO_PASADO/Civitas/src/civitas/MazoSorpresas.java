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
public class MazoSorpresas{
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init(){
        sorpresas = new ArrayList();
        barajada = false;
        usadas = 0;
    }
    
    public MazoSorpresas(boolean debug){
        this.debug=debug;
        this.init();
        
        if(this.debug == true){
            Diario.getInstance().ocurreEvento("debug true");
        }
    }
    
    public MazoSorpresas(){
        this.init();
        debug = false;
    }
    
    void alMazo(Sorpresa s){
        if(barajada == false){
            sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente(){
        if(barajada == false || usadas == sorpresas.size()){
            usadas = 0;
            barajada = true;
        }
        usadas++;
        Sorpresa actual;
        actual = sorpresas.get(0);
        sorpresas.add(actual);
        sorpresas.remove(0);
        return actual;
    }
}
