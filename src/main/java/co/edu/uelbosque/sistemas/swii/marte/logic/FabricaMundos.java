/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.logic;

/**
 *
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class FabricaMundos {
    
    private static Marte marte;
    
    public enum TipoMundo
    {
        Marte
    }    
    
    public static Mundo getMundoActual(TipoMundo tipoMundo){
        
        if(tipoMundo == TipoMundo.Marte){
            if(marte==null)
                marte = new Marte();
            return marte;
        }
        else
            return null; //No hay otros tipos de mundos por el momento
    }
}