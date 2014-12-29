/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VistaModelo;

import DAO.SitioRutaTuristica;
import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Edu Gonzalez
 */
public class SitiosRutas {
    
    Session session = null;
    public String mess = "";
    int maxResults = 100;
            
    public boolean saveSitioRuta(SitioRutaTuristica sitioRutaTuristica)
    {
        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        try
        {
            session.save(sitioRutaTuristica);
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
