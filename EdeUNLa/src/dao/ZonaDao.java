package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Zona;

public class ZonaDao {
	private static Session session;
	private Transaction tx;

	/*-----------------PATRON SINGLETON-----------------*/

	private static ZonaDao instancia = null;

	protected ZonaDao() {
	}

	public static ZonaDao getInstance() {
		if (instancia == null)
			instancia = new ZonaDao();
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

	public int agregar(Zona objeto) {
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

	public void actualizar(Zona objeto) throws HibernateException {
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

	public void eliminar(Zona objeto) throws HibernateException {
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

	public Zona traerZona(long idZona) throws HibernateException {
		Zona objeto = null;

		try {
			iniciaOperacion();
			objeto = (Zona) session.get(Zona.class, idZona);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Zona traerZona(String nombre) throws HibernateException {
		Zona objeto = null;

		try {
			iniciaOperacion();
			objeto = (Zona) session.get(Zona.class, nombre);
		} finally {
			session.close();
		}
		return objeto;
	}


}