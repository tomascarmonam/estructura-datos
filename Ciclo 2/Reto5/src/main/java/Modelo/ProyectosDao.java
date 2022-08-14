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
public class ProyectosDao {
    public List<ProyectosVo> listar() throws SQLException{
        ArrayList<ProyectosVo> respuesta = new ArrayList<>();
        Connection conn=JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta="SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad " +
                        "FROM Proyecto p " +
                        "WHERE Ciudad IN('Santa Marta', 'Cartagena', 'Barranquilla') " +
                        "AND Clasificacion ='Casa Campestre';";
    
    try {
        stmt=conn.createStatement();
        rs=stmt.executeQuery(consulta);
        while (rs.next()){
            ProyectosVo objeto=new ProyectosVo();
            objeto.setId_proyecto(rs.getInt("id_proyecto"));
            objeto.setConstructora(rs.getString("constructora"));
            objeto.setNumero_habitaciones(rs.getInt("numero_habitaciones"));
            objeto.setCiudad(rs.getString("Ciudad"));
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
