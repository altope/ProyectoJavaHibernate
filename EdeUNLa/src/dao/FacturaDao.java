package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Factura;

public class FacturaDao {
	private static Session session;
	private Transaction tx;

	/*-----------------PATRON SINGLETON-----------------*/

	private static FacturaDao instancia = null;

	protected FacturaDao() {
	}

	public static FacturaDao getInstance() {
		if (instancia == null)
			instancia = new FacturaDao();
		return instancia;
	}

	/*--------------------------------------------------*/

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos", he);
	}

	public int agregar(Factura objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Factura objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Factura objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Factura traerFactura(long idFactura){
		Factura objeto = null;
		try {
			iniciaOperacion();
			objeto = (Factura)session.createQuery("from Factura f where f.idFactura ="+idFactura).uniqueResult();
		} finally {
			session.close();
		} 
		return objeto;
	} 

	@SuppressWarnings("unchecked")
	public List<Factura> traerFacturas() throws HibernateException{
		List<Factura> Facturas = null;
		try {
			iniciaOperacion();
			Facturas = session.createQuery("from Factura a order by a.idFactura asc").list();
		}
		finally {
			session.close();
		}
		return Facturas;
		
	}

	
}