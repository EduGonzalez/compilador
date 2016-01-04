/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author Edu Gonzalez
 */
   

public class EscribirConf {
    public String tablaMayus;
    
    public void EscribirCabezeraConf() {



        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\src\\java\\hibernate.cfg.xml");
            pw = new PrintWriter(fichero);

            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + "<!DOCTYPE hibernate-configuration PUBLIC \"-//Hibernate/Hibernate Configuration DTD 3.0//EN\" \"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd\">\n"
                    + "<hibernate-configuration>\n"
                    + "  <session-factory>\n"
                    + "    <property name=\"hibernate.dialect\">org.hibernate.dialect.MySQLDialect</property>\n"
                    + "    <property name=\"hibernate.connection.driver_class\">com.mysql.jdbc.Driver</property>\n"
                    + "    <property name=\"hibernate.connection.url\">jdbc:mysql://localhost:3306/policia_database</property>\n"
                    + "    <property name=\"hibernate.connection.username\">root</property>\n"
                    + "    <property name=\"hibernate.show_sql\">true</property>\n"
                    + "    <property name=\"hibernate.current_session_context_class\">thread</property>\n"
                    + "    <property name=\"hibernate.query.factory_class\">org.hibernate.hql.classic.ClassicQueryTranslatorFactory</property> \n"
                    + "    <mapping resource=\"DAO/SitioCategoriaSitio.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/Foto.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/CalificacionRutaTuristica.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/Checkin.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/Dia.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/RolUsuarioUsuario.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/Sitio.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/Evento.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/SitioRutaTuristica.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/EventoCategoriaEvento.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/TelefonoSitio.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/DAO/CategoriaEvento.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/ComentarioRutaTuristica.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/CategoriaSitio.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/CalificacionSitio.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/Usuario.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/RutaTuristica.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/DAO/HorarioSitio.hbm.xml\"/>\n"
                    + "    <mapping resource=\"DAO/ComentarioSitio.hbm.xml\"/>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }    
    
    public void EscribirFINConf(String tabla) {

//La cadena que queremos transformar
        String mayuscula = tabla.charAt(0) + "";
//Obtenemos el primer caracteres y concatenamos "" para que se transforme el char en String
        mayuscula = mayuscula.toUpperCase();//Lue… lo transformamos en mayúscula
        tablaMayus = tabla;
        tablaMayus = tablaMayus.replaceFirst(tablaMayus.charAt(0) + "", mayuscula);


        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\src\\java\\hibernate.cfg.xml", true);
            pw = new PrintWriter(fichero);

            pw.println(" </session-factory>\n"
                    + "</hibernate-configuration>\n"
                    + "");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}