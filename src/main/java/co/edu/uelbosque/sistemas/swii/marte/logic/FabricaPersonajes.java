/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.logic;

import java.util.HashMap;

/**
 *
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class FabricaPersonajes {
    
    private HashMap<String, Explorador> prototipos;
    
    public FabricaPersonajes(){

        prototipos = new HashMap<String, Explorador>();
        
        Explorador explorador1 = new Explorador(1, 2, 'N');
        Explorador explorador2 = new Explorador(3, 3, 'E');
        
        prototipos.put("1 2 N", explorador1);
        prototipos.put("3 3 E", explorador2);
    }
    
    public Explorador construirExploradorDesdePrototipo(String datoPrototipo){
        
        Explorador explorador = prototipos.get(datoPrototipo);
        if(explorador==null)
            explorador = crearNuevoExplorador(datoPrototipo);
            
        return (Explorador)explorador.clonar();
    }
    
    private Explorador crearNuevoExplorador(String datoPrototipo){
        
        return new Explorador(Integer.parseInt(datoPrototipo.split("\\s")[0]),
                Integer.parseInt(datoPrototipo.split("\\s")[1]),
                datoPrototipo.split("\\s")[2].toCharArray()[0]);
    }
}