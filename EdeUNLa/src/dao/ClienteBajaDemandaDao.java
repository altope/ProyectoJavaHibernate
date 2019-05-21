package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ClienteBajaDemanda;

public class ClienteBajaDemandaDao {

	private static Session session;
	private Transaction tx;

	/*-----------------PATRON SINGLETON-----------------*/

	private static ClienteBajaDemandaDao instancia = null;

	protected ClienteBajaDemandaDao() {
	}

	public static ClienteBajaDemandaDao getInstance() {
		if (instancia == null)
			instancia = new ClienteBajaDemandaDao();
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

	public int agregar(ClienteBajaDemanda objeto) {
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

	public void actualizar(ClienteBajaDemanda objeto) throws HibernateException {
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

	public void eliminar(ClienteBajaDemanda objeto) throws HibernateException {
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

	public ClienteBajaDemanda traerClienteBajaDemanda(long idCliente) throws HibernateException {
		ClienteBajaDemanda objeto = null;

		try {
			iniciaOperacion();
			objeto = (ClienteBajaDemanda) session.get(ClienteBajaDemanda.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}
}
