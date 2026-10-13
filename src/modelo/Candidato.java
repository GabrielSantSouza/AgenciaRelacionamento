/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import estrutura.ListaIdentificadores;

/**
 *
 * @author gabriel
 */
public class Candidato {
    private long id;
    private String nome;
    private Estado estado;
    private char sexo;
    private char sexoInteresse;
    
    
    private ListaIdentificadores interesses;
    private ListaIdentificadores potenciaisCompanheiros;
    
    
    public Candidato (long id, String nome, Estado estado, char sexo, char sexoInteresse){
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.sexo = sexo;
        this.sexoInteresse = sexoInteresse;
        
        this.interesses = new ListaIdentificadores();
        this.potenciaisCompanheiros = new ListaIdentificadores();
    }
    
    public long getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Estado getEstado(){
        return estado;
    }
    
    public char getSexo(){
        return sexo;
    }
    
    public char getSexoInteresse(){
        return sexoInteresse;
    }
    
    public ListaIdentificadores getInteresses(){
        return this.interesses;
    }
    
    public ListaIdentificadores getPotenciaisCompanheiros() { 
        return this.potenciaisCompanheiros; 
    } 

    public ListaIdentificadores listaCompanheiros() { 
        return this.potenciaisCompanheiros; 
    }
    
    public void adicionarInteresse(int codigoArea) { 
        this.interesses.inserir(codigoArea); 
    }
    
    
}
