/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.factura;
import java.util.List;

/**
 *
 * @author RC
 */
public interface crud {
    public List listar();
    public factura list(int idFactura);
    public  boolean  añadir(factura fact);
    public  boolean  editar(factura fact);
    public  boolean  eliminar(int idFactura);
            
    
}
