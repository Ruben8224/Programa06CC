package com.mycompany.programa06cc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ruben
 */
public class DAOVenta implements IDAOGeneral<Venta, Long> {

    @Override
    public Venta create(Venta p) {

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            session.save(p);
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se guardo Empleado");

            t.commit();
       

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());

        }
        return p;
    }

    @Override
    public boolean delete(Long id) {

        boolean b = false;

        Venta empleadoo = findByID(id);

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            if (empleadoo != null) {
                session.delete(empleadoo);
                Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se elimino Empleado");
                b = true;
            } else {
                return b;
            }

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }

        return b;
    }

    @Override
    public Venta update(Long id, Venta p) {

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            Venta empleado = findByID(id);
            if (empleado != null) {
                session.update(empleado);
                Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se actualizo Empleado");
            }

            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }

        return p;

    }

    @Override
    public List<Venta> findAll() {
        List<Venta> empleados = null;
        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

           // List<Empleado> lstRes=
             //       Session.
            empleados = session.createQuery("FROM Empleado").list();
            t.commit();
            session.close();
        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }
        return empleados;
    }

    @Override
    public Venta findByID(Long id) throws IllegalArgumentException, HibernateException {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("El argumento id no puede ser nulo o cero");
        }

        Venta empleado = null;

        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

            empleado = session.get(Venta.class, id);

            t.commit();
        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, "Error al buscar el Empleado por ID", ex);
            throw ex;
        }

        return empleado;
        
        
        
        
        

//        Venta empleado = null;
//
//        try ( Session session = HibernateUtil.getSession()) {
//            Transaction t = session.beginTransaction();
//
//            empleado = session.get(Venta.class, id);  //Original            
//
//            t.commit();
//            session.close();
//
//        } catch (HibernateException ex) {
//            Logger.getLogger(DAOVenta.class.getName());
//        }
//
//        return empleado;
    }    

}