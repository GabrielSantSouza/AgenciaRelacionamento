/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import estrutura.Celula;
import estrutura.ListaIdentificadores;
import modelo.Candidato; 
import modelo.Estado;
/**
 *
 * @author gabriel
 */
public class GerenciadorCandidatos {
    
    private Candidato[] candidatos;
    private int quantidade;
    private int grauInteresseAtual;

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
        
       try (Scanner scanner = new Scanner(arquivo)) {
            if (!scanner.hasNextInt()) return false;
            int n = scanner.nextInt();
            scanner.nextLine();

            this.candidatos = new Candidato[n];
            this.quantidade = 0;
            long idContador = 1;

            while (scanner.hasNext() && quantidade < n) {
                if (scanner.hasNext("\\*\\*\\*\\*")) {
                    scanner.nextLine();
                }

                if (!scanner.hasNextLine()) break;
                String nome = scanner.nextLine().trim();

                String siglaEstado = scanner.nextLine().trim();
                Estado estado = Estado.deSigla(siglaEstado);

                char sexo = scanner.nextLine().trim().charAt(0);
                char sexoInteresse = scanner.nextLine().trim().charAt(0);

                Candidato c = new Candidato(idContador++, nome, estado, sexo, sexoInteresse);

                int numAreas = scanner.nextInt();
                for (int i = 0; i < numAreas; i++) {
                    c.adicionarInteresse(scanner.nextInt());
                }
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }

                this.candidatos[quantidade++] = c;
            }
            recalcularTodosPares();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return false;
        }
    }
       
    public void recalcularTodosPares() {
        for (int i = 0; i < quantidade; i++) {
            candidatos[i].limparCompanheiros();
        }

        for (int i = 0; i < quantidade; i++) {
            for (int j = 0; j < quantidade; j++) {
                if (i != j) {
                    if (candidatos[i].verificaPotencialCompanheiro(candidatos[j], grauInteresseAtual)) {
                        candidatos[i].inserePotencialCompanheiro(candidatos[j]);
                    }
                }
            }
        }
    }
    
     public Candidato buscarPorId(long id) {
        for (int i = 0; i < quantidade; i++) {
            if (candidatos[i].getId() == id) {
                return candidatos[i];
            }
        }
        return null;
    }

    public void consultarCompanheiros(long id) {
        Candidato c = buscarPorId(id);
        if (c == null) {
            System.out.println("Candidato não encontrado.");
            return;
        }

        System.out.println("\n--- Candidato: " + c.getNome() + " (ID: " + c.getId() + ") ---");
        System.out.println("Quantidade de potenciais companheiros: " + c.numeroCompanheiros());
        System.out.println("Lista de Companheiros:");

        Celula atual = c.getPotenciaisCompanheiros().getPrimeiro();
        while (atual != null) {
            Candidato comp = buscarPorId(atual.id);
            if (comp != null) {
                System.out.println("- ID: " + comp.getId() + " | Nome: " + comp.getNome());
            }
            atual = atual.prox;
        }
    }
    public void rankingTopK(int k) {
        Candidato[] copia = new Candidato[quantidade];
        for (int i = 0; i < quantidade; i++) {
            copia[i] = candidatos[i];
        }

        for (int i = 0; i < quantidade - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < quantidade; j++) {
                if (copia[j].numeroCompanheiros() > copia[maxIdx].numeroCompanheiros()) {
                    maxIdx = j;
                }
            }
            Candidato temp = copia[i];
            copia[i] = copia[maxIdx];
            copia[maxIdx] = temp;
        }

        int limite = Math.min(k, quantidade);
        System.out.println("\n--- TOP " + limite + " Candidatos com mais Companheiros ---");
        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + "º -> ID: " + copia[i].getId() + " | Nome: " + copia[i].getNome() + " | Companheiros: " + copia[i].numeroCompanheiros());
        }
    }

    public void candidatosSemPar() {
        System.out.println("\n--- Candidatos sem nenhum companheiro ---");
        boolean encontrou = false;
        for (int i = 0; i < quantidade; i++) {
            if (candidatos[i].numeroCompanheiros() == 0) {
                System.out.println("ID: " + candidatos[i].getId() + " | Nome: " + candidatos[i].getNome());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Todos os candidatos possuem ao menos um companheiro!");
        }
    }

    public void filtrarPorArea(int area) {
        System.out.println("\n--- Candidatos com interesse na área " + area + " ---");
        boolean encontrou = false;
        for (int i = 0; i < quantidade; i++) {
            if (candidatos[i].temInteresse(area)) {
                System.out.println("ID: " + candidatos[i].getId() + " | Nome: " + candidatos[i].getNome());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum candidato interessado nesta área.");
        }
    }

    public void filtrarPorEstado(String sigla) {
        System.out.println("\n--- Candidatos residentes no estado: " + sigla.toUpperCase() + " ---");
        boolean encontrou = false;
        for (int i = 0; i < quantidade; i++) {
            if (candidatos[i].reside(sigla)) {
                System.out.println("ID: " + candidatos[i].getId() + " | Nome: " + candidatos[i].getNome());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum candidato encontrado neste estado.");
        }
    }
    
    
}
    
