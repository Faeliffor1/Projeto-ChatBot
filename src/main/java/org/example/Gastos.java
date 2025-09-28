package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gastos {

    private String desgricao;
    private double valorGasto;
    private  String categoria;
    private LocalDate data;
    private String forma_Pagamneto;
    private float valorParcelas;
    private int parcelas;

    public Gastos(String desgricao, double valor, String categoria, String formaPagamento, LocalDate data,  float valorParcelas , int parcelas) {
        this.desgricao = desgricao;
        this.valorGasto = valor;
        this.categoria = categoria;
        this.data = data;
        this.valorParcelas = valorParcelas ;
        this.forma_Pagamneto = formaPagamento;
        this.parcelas = parcelas;

    }
    public  String getDesgricao(){
        return desgricao;
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
    public String getForma_Pagamneto(){
        return forma_Pagamneto;
    }
    public float getValorParcelas(){
        return valorParcelas;
    }
    public int getParcelas(){
        return parcelas;
    }

    @Override
    public String toString(){
        return desgricao + " | R$ " + valorGasto +
                (valorParcelas > 0 ? String.format(" | Parcela: R$ %.2f" , valorParcelas) : "") + " De " + parcelas + " vezes "+
                " | CATEGORIA: " + categoria +
                " | " + data +
                " | " + forma_Pagamneto;
    }

 }