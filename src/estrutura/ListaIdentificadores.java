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
    
    
    public void inserir(long id){
        Celula nova  = new Celula(id);
        this.tail.prox = nova;
        this.tail = nova;
        this.quantidade++;
    }
    
    public boolean contem(int id){
        Celula atual = this.head.prox;
        
        while(atual != null){
            if(atual.id == id){
                return true;
            }
        }
        return false;
    }
    

    public int getQuantidade() {
        return this.quantidade;
    }
    
     public Celula getPrimeiro() {
        return this.head.prox;
    }
    
    @Override
    public String toString(){
        StringBuilder sb =  new StringBuilder();
        sb.append("[");
        
        Celula atual = this.head.prox;
        
        while(atual!=null){
            sb.append(atual.id);
            if(atual.prox != null){
                sb.append( "," );
            }
            atual = atual.prox;
        }
        
        sb.append("]");
        return sb.toString();
    }
    
}


