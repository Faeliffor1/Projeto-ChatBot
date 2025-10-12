package org.example.model;

import java.time.LocalDate;

public class Gastos {

    private String descricao;
    private double valorGasto;
    private  String categoria;
    private LocalDate data;
    private String formaPagamento;
    private double valorParcelas;
    private int parcelas;
    private boolean pago;
    private int id;

    //CONSTRUTOR PARA A MAIN
    public Gastos(String descricao, double valorGasto, String categoria, String formaPagamento, double valorParcelas, LocalDate data, int parcelas) {
        this.descricao = descricao;
        this.valorGasto = valorGasto;
        this.categoria = categoria;
        this.data = data;
        this.valorParcelas = valorParcelas ;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.pago = false;

    }

    // CONSTRUTOR PARA O SQLLITE
    public Gastos(String descricao, double valorGasto,String categoria, LocalDate data, String formaPagamento, double valorParcelas, int parcelas, boolean pago, int id) {
        this.descricao = descricao;
        this.valorGasto = valorGasto;
        this.categoria = categoria;
        this.data = data;
        this.valorParcelas = valorParcelas;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.pago = pago;
        this.id=id;

    }


    public  String getDescricao(){

        return descricao;
    }
    public double getValorGasto(){
        return valorGasto;
    }
    public String getCategoria(){
        return categoria;
    }
    public LocalDate getData(){
        return data;
    }
    public String getFormaPagamento(){
        return formaPagamento;
    }
    public Double getValorParcelas(){
        return valorParcelas;
    }
    public int getParcelas(){
        return parcelas;
    }
    public boolean getPago(){
        return pago;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString(){

        String status = pago ? "[PAGO]" : "[NÃO PAGO]";

        String parcelasInfo = "";
        if ("CRÉDITO".equalsIgnoreCase(formaPagamento) && valorParcelas > 0){
            parcelasInfo = String.format("  | Parcela: R$ %.2f de %d vezes", valorParcelas , parcelas);
        }

        return descricao + String.format(" | R$ %.2f" , valorGasto ) +
                parcelasInfo + " | " + formaPagamento +
                " | CATEGORIA: " + categoria +
                " | " + data + " | " + status;

    }


}