/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import modelo.Candidato;
import modelo.Estado;

/**
 *
 * @author gabriel
 */
public class LeitorArquivo {
    
    public static Candidato[] lerCandidatos(String caminhoArquivo){
         File arquivo =  new File(caminhoArquivo);
        
        if (!arquivo.exists()) { 
            System.out.println("Erro: O arquivo " + caminhoArquivo + " não foi encontrado ou não existe."); 
            return new Candidato[0]; 
        }
        
        try (Scanner scanner = new Scanner(arquivo)){
            if(!scanner.hasNextInt()){
                return new Candidato[0];
            }
            
            int n = scanner.nextInt();
            scanner.nextLine();
            
            Candidato[] candidatos = new Candidato[n]; 
            int quantidade = 0; 
            long idContador = 1;
            
            while(scanner.hasNext() && quantidade<n){
                if(scanner.hasNext("\\*\\*\\*\\*")){
                    scanner .nextLine();
                }
                
                if(!scanner.hasNextLine()){
                    break;
                }
                
                String nome = scanner.nextLine().trim();
                String siglaEstado = scanner.nextLine().trim();
                Estado estado = Estado.deSigla(siglaEstado);
                
                char sexo = scanner.nextLine().trim().charAt(0);
                char sexoInteresse = scanner.nextLine().trim().charAt(0);
                
                Candidato c = new Candidato(idContador++, nome, estado, sexo, sexoInteresse);
                
                if (scanner.hasNextInt()) {
                    int numAreas = scanner.nextInt();
                    for (int i = 0; i< numAreas; i++) { 
                        if (scanner.hasNextInt()) {
                            c.adicionarInteresse(scanner.nextInt());
                        }
                    }
                    if (scanner.hasNextLine()) {
                        scanner.nextLine(); 
                    } 
                }
                
                candidatos[quantidade++] = c;
           
            }
            
            return candidatos;
            
        }catch(FileNotFoundException e){
            System.out.println("Erro ao ler o arquivo: "+ e.getMessage());
            return new Candidato[0];
        }
    }
    
}
