package org.example;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        System.out.println("=== GASTOS ===");
        System.out.print("Com o que Gastou? (Ex. UBER, LANCHE ...):  ");
        String desgricao = sc.nextLine();
        System.out.print("Valor gasto: ");
        float valor = sc.nextFloat();
        sc.nextLine();
        System.out.print("Categoria: (EX. ALIMENTAÇÃO, TRASPORTE ...): ");
        String categoria = sc.nextLine();
        System.out.print("Forma de pagamento: ");
        String formaPagamento = sc.nextLine();

        float valorParcela = 0;
        int parcelas = 0;

        if (formaPagamento.trim().toLowerCase().equals("crédito")){
            System.out.println("Quantas parcelas: ");
            parcelas = sc.nextInt();

            valorParcela = valor / parcelas;

        }
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        System.out.print("Mes: ");
        int mes = sc.nextInt();
        System.out.print("Dia: ");
        int dia = sc.nextInt();

        LocalDate data = LocalDate.of(ano, mes, dia);

        Gastos gastos =  new Gastos(desgricao,valor,categoria,formaPagamento,data, valorParcela,parcelas);
        System.out.println("Gastos cadastrodos: " + gastos);
    }
}
