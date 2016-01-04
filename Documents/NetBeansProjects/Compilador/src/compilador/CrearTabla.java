/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

import java.sql.*;


/**
 *
 * @author Edu Gonzalez
 */
public class CrearTabla {
    
    public CrearTabla(String sentencia) 
    {
        // Se mete todo en un try por los posibles errores de MySQL
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost:3306/tecnologiazk","root", "");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            
            // Se realiza la consulta.
            s.executeUpdate (sentencia);

       
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
