package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {



        IniciarBanco.criarTabela();

        Scanner sc = new Scanner(System.in);

    while (true) {

        System.out.println("== MENU INICIAL ==");
        System.out.println("1 - Novo Gasto");
        System.out.println("2 - Visualizar Gastos");

        System.out.println("3 - Sair");
        int escolha = sc.nextInt();
        sc.nextLine();


        switch(escolha){
            case 1:

                System.out.println("=== GASTOS ===");

                System.out.print("Com o que Gastou? (Ex. UBER, LANCHE ...):  ");
                String descricao = sc.nextLine();

                System.out.print("Valor gasto: ");
                double valorGasto = sc.nextFloat();
                sc.nextLine();

                System.out.print("Categoria: (EX. ALIMENTAÇÃO, TRASPORTE ...): ");
                String categoria = sc.nextLine();

                System.out.println("Forma de pagamento: ");
                System.out.println("1 - PIX");
                System.out.println("2 - DÉBITO");
                System.out.println("3 - CRÉDITO");
                System.out.println("4 - DINHEIRO");
                System.out.println("5 - BOLETO");
                int formaPagamentoOpcao = sc.nextInt();
                sc.nextLine();

                String formaPagamento = switch (formaPagamentoOpcao){
                    case 1 -> "PIX";
                    case 2 -> "DÉBITO";
                    case 3 -> "CRÉDITO";
                    case 4 -> "DINHEIRO";
                    case 5 -> "BOLETO";
                    default -> "Desconhecido";
                };

                double valorParcela = 0;
                int parcelas = 0;

                if (formaPagamento.equals("CRÉDITO")){
                    System.out.println("Quantas parcelas: ");
                    parcelas = sc.nextInt();
                    sc.nextLine();

                    if (parcelas > 0){
                    valorParcela = valorGasto / parcelas;

                    }else
                        valorParcela = 0;
                }

                System.out.print("Ano: ");
                int ano = sc.nextInt();
                System.out.print("Mes: ");
                int mes = sc.nextInt();
                System.out.print("Dia: ");
                int dia = sc.nextInt();

                LocalDate data = LocalDate.of(ano, mes, dia);

                Gastos gastos =  new Gastos(descricao, valorGasto,categoria,formaPagamento, valorParcela,data,parcelas);
                GastosDAO.salvar(gastos);
                System.out.println("Gastos cadastrados: " + gastos);
                sc.nextLine();
                break;

            case 2:
                System.out.println("=== GASTOS ===");
                List<Gastos> gastos1 = GastosDAO.listar();
                for (int i = 0; i < gastos1.size(); i++) {
                    System.out.println(i + 1 + " - " + gastos1.get(i));
                    System.out.println("=".repeat(80));
                }break;

            case 3:
                 System.out.println("Saindo... Até mais tarde");
                 return;

            default:
                throw new IllegalStateException("Unexpected value: " + escolha);
        }


    }






    }
}
