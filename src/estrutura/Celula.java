/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estrutura;

/**
 *
 * @author gabriel
 */
public class Celula {

    public long id;
    public Celula prox;
    
    public Celula(long id){
        this.id = id;
        this.prox = null;
    }
}

