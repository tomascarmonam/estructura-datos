/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nefilym
 */
public class ReportesController {
    private LideresDao lideresDao;
    private ProyectosDao proyectosDao;
    private ComprasDao comprasDao;

    public ReportesController(){
        lideresDao=new LideresDao();
        proyectosDao=new ProyectosDao();
        comprasDao=new ComprasDao();
    }
    
    public List<LideresVo> ListaTotalLideres() throws SQLException{
        return lideresDao.listar();
    }

    public List<ProyectosVo> ListaTotalProyectos() throws SQLException{
        return proyectosDao.listar();
    }

    public List<ComprasVo> ListaTotalCompras() throws SQLException{
        return comprasDao.listar();
    }

}
