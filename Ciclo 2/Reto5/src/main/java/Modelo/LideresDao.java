/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.JDBCUtilities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nefilym
 */
public class LideresDao {
    public List<LideresVo> listar() throws SQLException{
        ArrayList<LideresVo> respuesta = new ArrayList<>();
        Connection conn=JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta="SELECT ID_Lider,Nombre, Primer_Apellido, Ciudad_Residencia " +
                        "FROM Lider l " +
                        "ORDER BY Ciudad_Residencia ASC;";
    
    try {
        stmt=conn.createStatement();
        rs=stmt.executeQuery(consulta);
        while (rs.next()){
            LideresVo objeto=new LideresVo();
            objeto.setId_lider(rs.getInt("id_lider"));
            objeto.setNombre(rs.getString("nombre"));
            objeto.setPrimer_apellido(rs.getString("primer_apellido"));
            objeto.setCiudad_residencia(rs.getString("ciudad_residencia"));
            respuesta.add(objeto);
        }
        
    } finally {
        if (rs != null){
            rs.close(); 
            }
            if (stmt != null) {
            stmt.close(); 
            }
            if (conn != null){
            conn.close(); 
            }
    }
    return respuesta;
    }
}
