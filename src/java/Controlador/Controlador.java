/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.factura;
import ModeloDAO.FacturaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RC
 */
public class Controlador extends HttpServlet {
    String listar="Vistas/listar.jsp";
    String add="vistas/add.jsp";
    String adit="vistas/edit.jsp";
    factura p=new factura();
    FacturaDAO dao=new FacturaDAO();
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String accion = request.getParameter("accion");
        
        
        if( accion.equalsIgnoreCase("listar")){
            acceso=listar;
        } else if(accion.equalsIgnoreCase("agregar")){
            String numeroFactura=request.getParameter("numFactura");
            int numero = Integer.parseInt(numeroFactura);
            String fecha=request.getParameter("dateFecha");
            String pago=request.getParameter("txtTipoPago");
            String documento=request.getParameter("numDocumento");
             int docu = Integer.parseInt(documento);
            String nombre=request.getParameter("txtNombre");
            String subtotal=request.getParameter("numSubtotal");
             int sub = Integer.parseInt(subtotal);
            String desceunto=request.getParameter("numDescuento");
            double des = Double.parseDouble(desceunto);
            String iva=request.getParameter("numIva");
             double i = Double.parseDouble(iva);
            String totalDes=request.getParameter("numTotalDes");
             double tDes = Double.parseDouble(totalDes);
            String totalImp=request.getParameter("numTotalImp");
            double tImp = Double.parseDouble(totalImp);
            String total=request.getParameter("numTotal");
            double t = Double.parseDouble(total);
            
            p.setNumeroFactura(numero);
            p.setTipoDePago(pago);
            p.setDocumentoCliente(docu);
            p.setNombreCliente(nombre);
            p.setSubTotal(sub);
            p.setDescuento(des);
            p.setIva(i);
            p.setTotalDescuento(sub*des);
            p.setTotalImpuesto(sub+tDes);
            p.setTotal(tDes+tImp);
            
           dao.añadir(p);
            acceso=listar;
        }
        
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
