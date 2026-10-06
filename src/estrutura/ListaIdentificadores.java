/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estrutura;

/**
 *
 * @author gabriel
 */
public class ListaIdentificadores {
    private Celula head;
    private Celula tail;
    private int quantidade;
    
    public ListaIdentificadores(){
        this.head = new Celula(0);
        this.tail = this.head;
        this.head.prox = null;
        this.quantidade = 0;
        
        
    }
    
}
