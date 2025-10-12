package org.example.dao;

import org.example.model.Gastos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.sql.Date.valueOf;

//Insere um novo gasto na tabela gastos.

public class GastosDAO {
    public static void salvar (Gastos g){
        String sql = "INSERT INTO Gastos(descricao,valor,categoria,formaPagamento,data,valorParcelas,parcelas,pago) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)){
            pstmt.setString(1, g.getDescricao());
            pstmt.setDouble(2, g.getValorGasto());
            pstmt.setString(3, g.getCategoria());
            pstmt.setString(4, g.getFormaPagamento());
            pstmt.setDate(5, valueOf(g.getData()));
            pstmt.setDouble(6, g.getValorParcelas());
            pstmt.setInt(7, g.getParcelas());
            pstmt.setInt(8, g.getPago() ? 1 : 0);


            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }

    }

    public static List<Gastos> listar(){
        List<Gastos> lista = new ArrayList<>();

        String sql = "SELECT * FROM Gastos";
        try(Connection conexao = Conexao.conectar();
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                String categoria = rs.getString("categoria");
                String formaPagamento = rs.getString("formaPagamento");
                LocalDate data = rs.getDate("data").toLocalDate();
                double valorParcelas = rs.getDouble("valorParcelas");
                int parcelas = rs.getInt("parcelas");
                boolean pago = rs.getInt("pago") == 1;
                int id = rs.getInt("id");
                Gastos g = new Gastos(descricao,valor,categoria,data,formaPagamento,valorParcelas,parcelas,pago,id);

                lista.add(g);
            }

        }catch (SQLException e){
            System.out.println("Erro ao listar: " + e.getMessage());

        }return lista;

    }
    public static void marcarComoPago(int id){
        String sql = "UPDATE Gastos SET pago = 1 WHERE id = ?";
        try (Connection conexao = Conexao.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql)){
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            System.out.println("Gasto marcado como pago");
        }catch (SQLException e){
            System.out.println("Erro ao marcar como pago: " + e.getMessage());
        }
    }

    public static void deletar(int id){
        String sql = "DELETE FROM Gastos WHERE id = ?";
        try(Connection conexao = Conexao.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql)){
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            System.out.println("Gasto deletado");
        }catch (SQLException e){
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
