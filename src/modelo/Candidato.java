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
    
    public boolean reside(String sigla) {
        if (this.estado == null || sigla == null) {
            return false;
        }
        return estado.toString().equalsIgnoreCase(sigla.trim());
    }

    public boolean temInteresse(int idArea) {
        return this.interesses.contem(idArea);
    }

    public void inserePotencialCompanheiro(Candidato v) {
        if (v != null) {
            this.potenciaisCompanheiros.inserir(v.getId());
        }
    }

    public int numeroCompanheiros() {
        return this.potenciaisCompanheiros.getQuantidade();
    }
    
    public int calcularGrauInteresseComum(Candidato v){
        if (v==null){
            return 0;
        }
        
        int somaPesos = 0;
        for(int area = 1; area<=8; area++){
           if(this.temInteresse(area) && v.temInteresse(area)){
               if (area == 1 || area == 3 || area == 4) { 
                   somaPesos += 1; 
               } else if (area == 2 || area == 6 || area == 7) { 
                   somaPesos += 2; 
               } else if (area == 5 || area == 8) { 
                   somaPesos += 3; 
               }
               
           }
        }
        
        return somaPesos;
        
    }
    
    public boolean verificaPotencialCompanheiro(Candidato v, int grauDesejado){
        if(v == null || v.getId() == this.getId()){
            return false;
        }
        if (this.estado != v.getEstado()) { 
            return false; 
        }
        boolean esteAceitaV = (this.sexoInteresse == 'I' || this.sexoInteresse == v.getSexo());
        boolean vAceitaEste = (v.getSexoInteresse() == 'I' || v.getSexoInteresse() == this.sexo);
        
        if (!esteAceitaV || !vAceitaEste) {
            return false;
        }
        
        int grauObtido = calcularGrauInteresseComum(v);
        return grauObtido >= grauDesejado;
    }
    
    public void limparCompanheiros(){
        this.potenciaisCompanheiros = new ListaIdentificadores();
    }
    
    
    
}
