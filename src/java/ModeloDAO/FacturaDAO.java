/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.crud;
import Modelo.factura;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author RC
 */
public class FacturaDAO implements crud{
//    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    factura f = new factura();
    
    @Override
    public List listar() {
      ArrayList<factura>list= new ArrayList();
        String sql = "SELECT * FROM facturas";
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
               factura fac = new factura();
               fac.setIdFactura(rs.getInt("idFactura"));
               fac.setNumeroFactura(rs.getInt("NumeroFactura"));
               fac.setFecha(rs.getDate("Fecha"));
               fac.setTipoDePago(rs.getString("TipodePago"));
               fac.setDocumentoCliente(rs.getInt("DocumentoCliente"));
               fac.setNombreCliente(rs.getString("NombreCliente"));
               fac.setSubTotal(rs.getInt("Subtotal"));
               fac.setDescuento(rs.getDouble("Descuento"));
               fac.setIva(rs.getDouble("IVA"));
               fac.setTotalDescuento(rs.getDouble("TotalDescuento"));
               fac.setTotalImpuesto(rs.getDouble("TotalImpuesto"));
               fac.setTotal(rs.getDouble("Total"));
               list.add(fac);
                
            }

  
        } catch (SQLException e) {
            System.err.println("No se ha logrado realizar consulta");
        }
        return list;
    }

    @Override
    public factura list(int idFactura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean añadir(factura fact) {
       String sql="insert into facturas(NumeroFactura,TipodePago,DocuemntoCliente,NombreCliente,Subtotal,Desceunto, IVA, TotalDescuento,TotalImpuesto,Total)values('"+fact.getNumeroFactura()+"','"+fact.getTipoDePago()+"','"+fact.getDocumentoCliente()+"','"+fact.getNombreCliente()+"','"+fact.getSubTotal()+"','"+fact.getDescuento()+"','"+fact.getIva()+"','"+fact.getTotalDescuento()+"','"+fact.getTotalImpuesto()+"','"+fact.getTotal()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;    }

    @Override
    public boolean editar(factura fact) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int idFactura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
