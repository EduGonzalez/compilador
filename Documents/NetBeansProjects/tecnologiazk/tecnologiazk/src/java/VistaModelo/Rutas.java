/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VistaModelo;

import DAO.RutaTuristica;
import Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Edu Gonzalez
 */
public class Rutas {
      Session session = null;
    public String mess = "";
    int maxResults = 100;
    
             public Rutas()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
          public List<RutaTuristica> getListaRutas() {

        List<RutaTuristica> ListaCargos = null;      
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q1 = session.createQuery("from RutaTuristica");
            ListaCargos = q1.list();
            tx.commit();
        
        return ListaCargos;
    }
          
           public boolean saveRuta(RutaTuristica ruta)
    {
        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        try
        {
            session.save(ruta);
            tx.commit();
        }
        catch (HibernateException ex) {
            mess = ex.getMessage();
            tx.rollback();
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
