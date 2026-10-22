package app;
import estrutura.ListaIdentificadores;
import java.util.Scanner;
import modelo.GerenciadorCandidatos;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author gabriel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        GerenciadorCandidatos gerenciador = new GerenciadorCandidatos();

        System.out.println("=== SISTEMA DE AGÊNCIA DE RELACIONAMENTO ===");
        
        String caminhoArquivo = "src/modelo/Candidatos.TXT";

        if (!gerenciador.CarregarCandidatos(caminhoArquivo)) {
            System.out.println("Erro ao carregar o arquivo " + caminhoArquivo + ". Encerrando o sistema.");
            scanner.close();
            return;
        }

        System.out.println("Candidatos carregados com sucesso de " + caminhoArquivo + "!");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n================ MENU PRINCIPAL ================");
            System.out.println("Grau de Interesse Atual: " + gerenciador.getGrauInteresseAtual());
            System.out.println("1. Ajustar Grau de Interesse Desejado");
            System.out.println("2. Consultar Potenciais Companheiros de um Candidato");
            System.out.println("3. Ranking TOP K Candidatos com Mais Companheiros");
            System.out.println("4. Listar Candidatos Sem Par");
            System.out.println("5. Filtrar Candidatos por Área de Interesse (1-8)");
            System.out.println("6. Filtrar Candidatos por Estado (UF)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo Grau de Interesse desejado: ");
                    int grau = Integer.parseInt(scanner.nextLine().trim());
                    gerenciador.setGrauInteresseAtual(grau);
                    System.out.println("Grau de interesse atualizado e pares recalculados!");
                    break;
                case 2:
                    System.out.print("Digite o ID do Candidato: ");
                    long id = Long.parseLong(scanner.nextLine().trim());
                    gerenciador.consultarCompanheiros(id);
                    break;
                case 3:
                    System.out.print("Digite o valor de K: ");
                    int k = Integer.parseInt(scanner.nextLine().trim());
                    gerenciador.rankingTopK(k);
                    break;
                case 4:
                    gerenciador.candidatosSemPar();
                    break;
                case 5:
                    System.out.println("Áreas disponíveis: 1:ESPORTES, 2:ARTES, 3:MÚSICA, 4:CINEMA, 5:TECNOLOGIA, 6:ANIMAIS, 7:GASTRONOMIA, 8:CIÊNCIAS");
                    System.out.print("Digite o código da área (1 a 8): ");
                    int area = Integer.parseInt(scanner.nextLine().trim());
                    gerenciador.filtrarPorArea(area);
                    break;
                case 6:
                    System.out.print("Digite a sigla do Estado (ex: MG, SP, RJ): ");
                    String uf = scanner.nextLine().trim();
                    gerenciador.filtrarPorEstado(uf);
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();        
    }
    
}
