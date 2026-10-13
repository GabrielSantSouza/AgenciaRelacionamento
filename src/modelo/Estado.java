/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author gabriel
 */
public enum Estado {
    AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO;
    
    public static Estado deSigla(String sigla){
        if(sigla == null){
            return null;
        }try{
            return Estado.valueOf(sigla.trim().toUpperCase());
        }catch(IllegalArgumentException e){
            return null;
        }
    }
}
