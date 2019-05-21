package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.DetalleAlta;

public class DetalleAltaDao {

	private static Session session;
	private Transaction tx;

	/*-----------------PATRON SINGLETON-----------------*/

	private static DetalleAltaDao instancia = null;

	protected DetalleAltaDao() {
	}

	public static DetalleAltaDao getInstance() {
		if (instancia == null)
			instancia = new DetalleAltaDao();
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

	public int agregar(DetalleAlta objeto) {
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

	public void actualizar(DetalleAlta objeto) throws HibernateException {
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

	public void eliminar(DetalleAlta objeto) throws HibernateException {
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

	public DetalleAlta traerDetalleAlta(long idDetalleAlta) throws HibernateException {
		DetalleAlta objeto = null;

		try {
			iniciaOperacion();
			objeto = (DetalleAlta) session.get(DetalleAlta.class, idDetalleAlta);
		} finally {
			session.close();
		}
		return objeto;
	}
}
