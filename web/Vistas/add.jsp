<%-- 
    Document   : add.jsp
    Created on : 25/07/2022, 11:42:48 p. m.
    Author     : RC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Persona</h1>
                <form action="Controlador">
                    Numero factcura<br>
                    <input class="form-control" type="number" name="numFactura"><br>
                    Fecha <br>
                    <input class="form-control" type="date" name="dateFecha"><br>
                    Tipo de pago<br>
                    <input class="form-control" type="text" name="txtTipoPago"><br>
                    Numero documento<br>
                    <input class="form-control" type="number" name="numDocumento"><br>
                    
                    Nombre cliente<br>
                    <input class="form-control" type="text" name="txtNombre"><br>
                    Subtoal<br>
                    <input class="form-control" type="number" name="numSubtotal"><br>
                    Descuento<br>
                    <input class="form-control" type="number" name="numDescuento"><br>
                    IVA<br>
                    <input class="form-control" type="number" name="numIva"><br>
                    Total Descuento<br>
                    <input class="form-control" type="number" name="numTotalDes"><br>
                    Total impuesto<br>
                    <input class="form-control" type="number" name="numTotalImp"><br>
                    Total<br>
                    <input class="form-control" type="number" name="numTotal"><br>
                    
                    
                    
                   
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
