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
public class Escribir {
    public String tablaMayus;

    public void EscribirCabezeraTabla(String tabla) {

        String mayuscula = tabla.charAt(0) + "";
//Obtenemos el primer caracteres y concatenamos "" para que se transforme el char en String
        mayuscula = mayuscula.toUpperCase();//Lue… lo transformamos en mayúscula
        tablaMayus = tabla;
        tablaMayus = tablaMayus.replaceFirst(tablaMayus.charAt(0) + "", mayuscula);

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul");
            pw = new PrintWriter(fichero);


            pw.println("<?component name=\"Menu\" macroURI=\"/MacroMenu.zul\"?>\n"
                    + "<zk>\n"
                    + "<Menu/>\n"
                    + "<window sclass=\"cardSys\" border=\"none\"\n"
                    + "        apply=\"org.zkoss.bind.BindComposer, Controller.ModalDialogCargosAdd\"\n"
                    + "        viewModel=\"@id('vm') @init('UIVM." + tablaMayus
                    + "VM')\">\n"
                    + "    \n"
                    + "    \n"
                    + "    <hlayout spacing=\"0\" height=\"500px\">\n"
                    + "        <listbox sclass=\"ListaPatru\" vflex=\"true\" hflex=\"1\"\n"
                    + "                 model=\"@load(vm."
                    + tabla + "list)\" selectedItem=\"@bind(vm.seleccionado)\" >\n"
                    + "            <auxhead>\n"
                    + "                <auxheader colspan=\"3\" class=\"topic\">Lista de " + tabla + "</auxheader>\n"
                    + "            </auxhead>\n"
                    + "            \n"
                    + "                \n"
                    + "            \n"
                    + "            <listhead>");

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
    
    public void EscribirCampoCabezera(String tabla, String campo, String tipo, String pk) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul", true);
            pw = new PrintWriter(fichero);

            if (pk.equals("0")){
            pw.println("<listheader label=\"" + campo + "\" align=\"center\" />");}
            else{
            pw.println("<listheader label=\"" + campo + "\" align=\"center\" >\n");  
            pw.println("  <textbox id=\"FiltroCargo\" width=\"69%\" cols=\"50\" value=\"@bind(vm."+campo+")\" onChange = \"@command('doFilter')\" instant=\"true\"/>\n");  
            pw.println("</listheader>\n");  
            }

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
    
    public void EscribirDespuesCabezera(String tabla) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul", true);
            pw = new PrintWriter(fichero);


            pw.println("</listhead>\n"
                    + "            <template name=\"model\" var=\"contributor\">\n"
                    + "                <listitem>");

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
    
    public void EscribirDatoCabezera(String tabla, String campo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul", true);
            pw = new PrintWriter(fichero);


            pw.println("<listcell label=\"@load(contributor." + campo + ")\" />");

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
    
    public void EscribirDespuesDatoCabezera(String tabla) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul", true);
            pw = new PrintWriter(fichero);


            pw.println("  </listitem>\n"
                    + "            </template>\n"
                    + " \n"
                    + "        </listbox>\n"
                    + "      \n"
                    + "    </hlayout>\n"
                    + "    <grid>\n"
                    + "        <auxhead>\n"
                    + "            <auxheader class=\"topic\">Editar " + tabla + "</auxheader>\n"
                    + "            \n"
                    + "        </auxhead>\n"
                    + "        \n"
                    + "        <columns>");

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
    
    public void EscribirLabelEditarFinal(String tabla, String campo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul", true);
            pw = new PrintWriter(fichero);


            pw.println("<column label=\"" + campo + "\" align=\"left\" />");

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
    
    public void EscribirDespuesLabelEditarFinal(String tabla) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul", true);
            pw = new PrintWriter(fichero);


            pw.println(""
                    + "  </columns>\n"
                    + "        <rows>\n"
                    + "            <row>");

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
    
    public void EscribirDatosEditarFinal(String tabla, String campo, String tipo, String extra) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul", true);
            pw = new PrintWriter(fichero);

             if ((tipo=="String")||(tipo=="Integer"))
            {
            pw.println("<textbox value=\"@bind(vm.seleccionado." + campo + ")\" width=\"98%\"  />");
            }
             
             if (tipo.equals("Date"))
            {
              if (extra.equals("time"))
              {
                 pw.println("<timebox value=\"@bind(vm.seleccionado." + campo + ")\" format=\"a hh:mm:ss\" width=\"98%\"  />");   
              }else
              {
                  pw.println("<datebox value=\"@bind(vm.seleccionado." + campo + ")\" width=\"98%\"  />");   
              }
            }
               System.out.println("5321646546546456543128484846       "+extra);

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
    
    public void EscribirDespuesDatosEditarFinal(String tabla) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Edu Gonzalez\\Documents\\NetBeansProjects\\tecnologiazk\\tecnologiazk\\web\\Prueba" + tabla + ".zul", true);
            pw = new PrintWriter(fichero);


            pw.println(""
                    + "                \n"
                    + "\n"
                    + "            </row>\n"
                    + "        </rows>\n"
                    + "        \n"
                    + "    </grid>\n"
                    + "     \n <space/> <space/>"
                    + "<div align=\"center\">\n"
                    + "                    <button id=\"aceptar\" label=\"Guardar\" width=\"70px\" height=\"25px\"  onClick=\"@global-command('Guardar')\"/>\n"
                    + "               \n"
                    + "                    <button id=\"eliminar\" label=\"Eliminar\" width=\"70px\" height=\"25px\" onClick=\"@command('Eliminar')\" />\n"
                    + "                    <button id=\"nuevo" + tabla + "\" label=\"Nuevo\" width=\"70px\" height=\"25px\" />\n"
                    + "                </div>\n"
                    + "</window> \n"
                    + "</zk>");

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
