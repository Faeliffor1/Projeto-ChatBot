package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Cria uma conexão com o banco de dados SQLite chamado gastos.db

public class Conexão {
    public static Connection conectar(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:sqlite:gastos.db");
            System.out.println("Conexão com o banco concedida com sucesso!");

        }catch (SQLException e){
            System.out.println("Erro ao conectar" + e.getMessage());
        }return conexao;
    }
}


