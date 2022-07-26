
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="Modelo.factura"%>
<%@page import="ModeloDAO.FacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>facturas</div>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Numero factura</th>
                    <th>Nombre Cliente</th>
                    <th>Total</th>
                </tr>
            </thead>
            <%
                  FacturaDAO dao=new FacturaDAO();
                    List<factura>list=dao.listar();
                    Iterator<factura>iter=list.iterator();
                    factura fa=null;
                    while(iter.hasNext()){
                        fa=iter.next();
            %>
            <tbody>
                <tr>
                    <td><%= fa.getFecha() %></td>
                    <td><%= fa.getNumeroFactura() %></td>
                    <td><%= fa.getNombreCliente() %></td>
                    <td><%= fa.getTotal() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>

    </body>
</html>
