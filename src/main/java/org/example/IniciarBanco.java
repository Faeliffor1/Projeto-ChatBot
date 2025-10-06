package org.example;

import java.sql.Connection;
import java.sql.Statement;

//Cria a tabela gastos com os campos que você precisa: descrição, valor, categoria, forma de pagamento, data, parcelas etc.

public class IniciarBanco {
    public static void criarTabela(){
        String sql = """ 
                      CREATE TABLE IF NOT EXISTS Gastos (
                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                      descricao TEXT ,
                      valor REAL,
                      categoria TEXT,
                      formaPagamento TEXT,
                      data DATE,
                      valorParcelas REAL,
                      parcelas INTEGER,
                      pago BOOLEAN DEFAULT 0
                      )
                      
                      """;

        try(Connection conexao = Conexao.conectar();
            Statement stmt = conexao.createStatement()){
            stmt.execute(sql);
            System.out.println("\n");
        }catch (Exception e){
            System.out.println("Erro ao criar Tabela: " + e.getMessage());
        }
    }

}
