/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VistaModelo;

import DAO.Evento;
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
public class Eventos {
         Session session = null;
    public String mess = "";
    int maxResults = 100;
    
         public Eventos()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
         
         public List<Evento> getListaEventos() {

            List<Evento> ListaCargos = null;      
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q1 = session.createQuery("from Evento");
            ListaCargos = q1.list();
            tx.commit();
        
        return ListaCargos;
    }
      
         public Evento getEvento(int id)
    {
        Evento evento = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try
        {
            Query q = session.createQuery("from Evento as evento where Evento.id=" + id);
            evento = (Evento) q.uniqueResult();
            tx.commit();
        }
        catch (HibernateException ex) {
            mess = ex.getMessage();
            tx.rollback();
            ex.printStackTrace();
        } 
          return evento;
    }
         
           public boolean saveEvento(Evento evento)
    {
        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        try
        {
            session.save(evento);
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
           
         public boolean updateEvento(Evento evento)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.update(evento);
            tx.commit();
        }
        catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return false;
        }
        return true;
    }
         
        public boolean deleteEvento(Evento evento)
    {
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.delete(evento);
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
