package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lectura;

public class LecturaDao {
	private static Session session;
	private Transaction tx;

	/*-----------------PATRON SINGLETON-----------------*/

	private static LecturaDao instancia = null;

	protected LecturaDao() {
	}

	public static LecturaDao getInstance() {
		if (instancia == null)
			instancia = new LecturaDao();
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

	public int agregar(Lectura objeto) {
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

	public void actualizar(Lectura objeto) throws HibernateException {
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

	public void eliminar(Lectura objeto) throws HibernateException {
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

/*
 * //no se de que forma ordenar las lecturas, si es por fecha y no por caracter
 * //no se de que forma ordenar las lecturas, si es por fecha y no por caracter
 * 
	@SuppressWarnings("unchecked")
	public List<Lectura> traerLecturas() throws HibernateException{
		List<Lectura> Lecturas = null;
		try {
			iniciaOperacion();
			Lecturas = session.createQuery("from Lectura a order by a.fecha asc").list();
		}
		finally {
			session.close();
		}
		return Lecturas;
		
	}
*/
	
}