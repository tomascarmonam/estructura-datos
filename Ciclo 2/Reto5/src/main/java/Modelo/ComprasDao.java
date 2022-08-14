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
public class ComprasDao {
    public List<ComprasVo> listar() throws SQLException{
        ArrayList<ComprasVo> respuesta = new ArrayList<>();
        Connection conn=JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta="SELECT ID_Compra, p.Constructora, p.Banco_Vinculado " +
                        "FROM Compra c " +
                        "INNER JOIN Proyecto p ON c.ID_Proyecto =p.ID_Proyecto " +
                        "WHERE p.Ciudad ='Salento'" +
                        "AND c.Proveedor ='Homecenter';";
    
    try {
        stmt=conn.createStatement();
        rs=stmt.executeQuery(consulta);
        while (rs.next()){
            ComprasVo objeto=new ComprasVo();
            objeto.setId_compra(rs.getInt("id_compra"));
            objeto.setConstructora(rs.getString("constructora"));
            objeto.setBanco_vinculado(rs.getString("banco_vinculado"));
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
