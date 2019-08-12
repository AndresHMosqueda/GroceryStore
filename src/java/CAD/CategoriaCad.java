/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import java.sql.CallableStatement;
import JavaBeans.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author andres
 */
public class CategoriaCad {
    public static ArrayList<Categoria> listar(){
        try {
            String sql = "{call sp_listarCategoriaSuperior()}";
            Connection c= Conexion.conectar();
            CallableStatement sentencia = (CallableStatement) c.prepareCall(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            while (resultado.next()) {
                Categoria cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al conectar la base de datos: " + ex.getLocalizedMessage());
            return null;
        } 
    }
}
