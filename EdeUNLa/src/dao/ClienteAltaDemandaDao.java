package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ClienteAltaDemanda;

public class ClienteAltaDemandaDao {

	private static Session session;
	private Transaction tx;

	/*-----------------PATRON SINGLETON-----------------*/

	private static ClienteAltaDemandaDao instancia = null;

	protected ClienteAltaDemandaDao() {
	}

	public static ClienteAltaDemandaDao getInstance() {
		if (instancia == null)
			instancia = new ClienteAltaDemandaDao();
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

	public int agregar(ClienteAltaDemanda objeto) {
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

	public void actualizar(ClienteAltaDemanda objeto) throws HibernateException {
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

	public void eliminar(ClienteAltaDemanda objeto) throws HibernateException {
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

	public ClienteAltaDemanda traerClienteAltaDemanda(long idCliente) throws HibernateException {
		ClienteAltaDemanda objeto = null;

		try {
			iniciaOperacion();
			objeto = (ClienteAltaDemanda) session.get(ClienteAltaDemanda.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}
}
