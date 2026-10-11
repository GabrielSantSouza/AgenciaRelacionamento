package app;
import estrutura.ListaIdentificadores;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author gabriel
 */
public class Maintest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListaIdentificadores lista = new ListaIdentificadores();
        System.out.println("lista inicial: "+ lista);
        
        System.out.println("\nInserindo IDs de interesses/candidatos: 10, 20, 30, 40..."); 
        lista.inserir(10); 
        lista.inserir(20); 
        lista.inserir(30); 
        lista.inserir(40);
        
        
        System.out.println("Lista após inserções: " + lista);
        
        System.out.println("Contém o ID 20? " + lista.contem(20) + " (Esperado: true)"); 
        System.out.println("Contém o ID 99? " + lista.contem(99) + " (Esperado: false)"); 
        System.out.println("Contém o ID 10 (primeiro)? " + lista.contem(10) + " (Esperado: true)"); 
        System.out.println("Contém o ID 40 (último)? " + lista.contem(40) + " (Esperado: true)");
        
        
    }
    
}
