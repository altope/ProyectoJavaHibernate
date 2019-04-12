package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoDao {
	private static Session session ;
	private Transaction tx ;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	
	@SuppressWarnings("unused")
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public Prestamo traerPrestamo( long idPrestamo) throws HibernateException {
		Prestamo obj = null ;
		try {
			iniciaOperacion();
			String hqL= "from Prestamo p inner join fetch p.cliente c where p.idPrestamo=" +idPrestamo;
			obj = (Prestamo) session.createQuery(hqL).uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}
		
	@SuppressWarnings ( "unchecked" )
	public List<Prestamo> traerPrestamo(Cliente c) throws HibernateException {
		List<Prestamo> lista = null ;
		try {
			iniciaOperacion();
			String hQL= " from Prestamo p inner join fetch p.cliente c where c.idCliente = " +c.getIdCliente(); 
			lista = session.createQuery(hQL).list();
		//	Query query = session.createQuery(" FROM Prestamo p where p.cliente="+c.getIdCliente());
		//	lista=query.list();
		} finally {
			session.close();
		}
		return lista;
	}


	public List<Prestamo> traerPrestamo() {
		List<Prestamo> prestamos= null;
		try{
			iniciaOperacion();
			Query query = session.createQuery(" FROM Prestamo as p inner join fetch p.");//SELECT p
			prestamos = query.list();
		}finally {
			session.close();
		}	
		return prestamos;
	}


	public int agregar(Prestamo obj) {
		int id=0;
		try{
			iniciaOperacion();
			id = Integer.parseInt(session.save(obj).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;	
		}finally {
			session.close();
		}		
		return id;
	}


	public void actualizar(Prestamo obj) {
		try{
			iniciaOperacion();
			session.update(obj);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;	
		}finally {
			session.close();
		}	
	}
	
}

/** Para la capa Acceso a datos DAO (Data Object Access), crear la clase PrestamoDao donde están
    implementados métodos sobrecargados traerPrestamo por idPrestamo o por cliente.
    Implementar alta, modificación de un objeto Prestamo
**/





