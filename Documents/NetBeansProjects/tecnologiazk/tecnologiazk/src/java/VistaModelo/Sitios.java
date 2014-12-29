/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VistaModelo;

import DAO.Sitio;
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
public class Sitios {
    
     Session session = null;
    public String mess = "";
    int maxResults = 100;
    
         public Sitios()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
          public List<Sitio> getListaSitios() {

        List<Sitio> ListaCargos = null;      
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q1 = session.createQuery("from Sitio");
            ListaCargos = q1.list();
            tx.commit();
        
        return ListaCargos;
    }
          
          
          public List getSitios()
    {
        List<Sitio> sitioList = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery ("from Sitio as sitio order by Sitio.id");
            sitioList = (List<Sitio>) q.list();
            tx.commit();
        }
        catch (HibernateException ex) {
            mess = ex.getMessage();
            tx.rollback();
            ex.printStackTrace();
        }
        return sitioList;
    }
          
              public Sitio getSitio(int id)
    {
        Sitio sitio = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try
        {
            Query q = session.createQuery("from Sitio as sitio where Sitio.id=" + id);
            sitio = (Sitio) q.uniqueResult();
            tx.commit();
        }
        catch (HibernateException ex) {
            mess = ex.getMessage();
            tx.rollback();
            ex.printStackTrace();
        }

        return sitio;
    }
          
          
        public boolean saveSitio(Sitio sitio)
    {
        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        try
        {
            session.save(sitio);
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
        
         public boolean updateSitio(Sitio sitio)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.update(sitio);
            tx.commit();
        }
        catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return false;
        }
        return true;
    }
         
        public boolean deleteSitio(Sitio sitio)
    {
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.delete(sitio);
            tx.commit();
        }
        catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
