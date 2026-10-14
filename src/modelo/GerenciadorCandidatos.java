/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import modelo.Candidato; 
import modelo.Estado;
/**
 *
 * @author gabriel
 */
public class GerenciadorCandidatos {
    
    private Candidato[] candidatos;
    private int quantidade;

    public GerenciadorCandidatos() {
        this.candidatos = new Candidato[0];
        this.quantidade = 0;
    }
    
    public boolean CarregarCandidatos(String caminhoArquivo){
        File arquivo =  new File(caminhoArquivo);
        
        if (!arquivo.exists()) { 
            System.out.println("Erro: O arquivo " + caminhoArquivo + " não foi encontrado."); 
            return false; 
        }
        
        try(Scanner scanner = new Scanner(arquivo)){
            if (!scanner.hasNextInt()) return false; 
            int n = scanner.nextInt();
            scanner.nextLine(); 
            this.candidatos = new Candidato[n]; 
            this.quantidade = 0; 
            long idContador = 1;
        
            
            while(scanner.hasNext() && quantidade<n){
                
                String linha = scanner.nextLine().trim();
                
            }
                
            
        }
    
}
