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
public class EscribirHBM {
    
    public String tablaMayus;

    public void EscribirCabezeraHBM(String tabla) {

//La cadena que queremos transformar
        String mayuscula = tabla.charAt(0) + "";
//Obtenemos el primer caracteres y concatenamos "" para que se transforme el char en String
        mayuscula = mayuscula.toUpperCase();//Lue… lo transformamos en mayúscula
        tablaMayus = tabla;
        tablaMayus = tablaMayus.replaceFirst(tablaMayus.charAt(0) + "", mayuscula);


        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\src\\java\\DAO\\" + tablaMayus + ".hbm.xml");
            pw = new PrintWriter(fichero);

            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            +"<!DOCTYPE hibernate-mapping PUBLIC \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\" \"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\">\n"
            +"<!-- Generated Dec 11, 2014 10:21:31 PM by Hibernate Tools 3.6.0 -->"
            +"<hibernate-mapping>\n"
            +"<class  name=\"DAO." + tablaMayus + "\" table=\"" + tabla + "\"  catalog=\"tecnologiazk\">");
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
    
    public void EscribirIdHBM(String tabla, String campo, String tipo) {
        System.out.println("Escribir ID HBM");
//La cadena que queremos transformar
        String mayuscula = tabla.charAt(0) + "";
//Obtenemos el primer caracteres y concatenamos "" para que se transforme el char en String
        mayuscula = mayuscula.toUpperCase();//Lue… lo transformamos en mayúscula
        tablaMayus = tabla;
        tablaMayus = tablaMayus.replaceFirst(tablaMayus.charAt(0) + "", mayuscula);


        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\src\\java\\DAO\\" + tablaMayus + ".hbm.xml" + tablaMayus + ".hbm.xml", true);
            pw = new PrintWriter(fichero);

            pw.println("<id name=\"" + campo + "\" type=\"java.lang." + tipo + "\">\n"
                    + "      <column name=\"" + campo + "\"/>\n"
                    + "      <generator class=\"identity\"/>\n"
                    + "    </id>");
            System.out.println("Escribir ID HBM = ok");
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
    
    public void EscribirCamposHBM(String tabla, String campo, String tipo, String extra) {
        System.out.println("Escribir Campos HBM");
//La cadena que queremos transformar
        String mayuscula = tabla.charAt(0) + "";
//Obtenemos el primer caracteres y concatenamos "" para que se transforme el char en String
        mayuscula = mayuscula.toUpperCase();//Lue… lo transformamos en mayúscula
        tablaMayus = tabla;
        tablaMayus = tablaMayus.replaceFirst(tablaMayus.charAt(0) + "", mayuscula);



        //La cadena que queremos transformar
        String tipominum = tipo.charAt(0) + "";
//Obtenemos el primer caracteres y concatenamos "" para que se transforme el char en String
        tipominum = tipominum.toLowerCase();//Lue… lo transformamos en mayúscula
        String tipominuscula = tipo;
        tipominuscula = tipominuscula.replaceFirst(tipominuscula.charAt(0) + "", tipominum);



        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\src\\java\\DAO\\" + tablaMayus + ".hbm.xml", true);
            pw = new PrintWriter(fichero);
            if (extra == "time") {
                 pw.println(" <property name=\"" + campo + "\" type=\"" + "time" + "\">\n"
                        + "      <column length=\"100\" name=\"" + campo + "\"/>\n"
                        + "    </property>");
            } else {
                pw.println(" <property name=\"" + campo + "\" type=\"" + tipominuscula + "\">\n"
                        + "      <column length=\"100\" name=\"" + campo + "\"/>\n"
                        + "    </property>");
            }
            System.out.println("Escribir Campos HBM = ok");
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
    
    public void EscribirFinHBM(String tabla) {

//La cadena que queremos transformar
        String mayuscula = tabla.charAt(0) + "";
//Obtenemos el primer caracteres y concatenamos "" para que se transforme el char en String
        mayuscula = mayuscula.toUpperCase();//Lue… lo transformamos en mayúscula
        tablaMayus = tabla;
        tablaMayus = tablaMayus.replaceFirst(tablaMayus.charAt(0) + "", mayuscula);




        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\src\\java\\DAO\\" + tablaMayus + ".hbm.xml", true);
            pw = new PrintWriter(fichero);

            pw.println(" </class>\n"
                    + "</hibernate-mapping>");
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
