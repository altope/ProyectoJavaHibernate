package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.DatosContacto;

public class DatosContactoDao {
	private static Session session;
	private Transaction tx;

	/*-----------------PATRON SINGLETON-----------------*/

	private static DatosContactoDao instancia = null;

	protected DatosContactoDao() {
	}

	public static DatosContactoDao getInstance() {
		if (instancia == null)
			instancia = new DatosContactoDao();
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

	public int agregar(DatosContacto objeto) {
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

	public void actualizar(DatosContacto objeto) throws HibernateException {
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

	public void eliminar(DatosContacto objeto) throws HibernateException {
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

	public DatosContacto traerDatosContacto(long idContacto) throws HibernateException {
		DatosContacto objeto = null;
		try {
			iniciaOperacion();
			objeto = (DatosContacto) session.get(DatosContacto.class, idContacto);
		} finally {
			session.close();
		}
		return objeto;
	}

	/*ERROR: por el atributo cliente dice que el get no soporta eso, capaz este mal usado;
	public DatosContacto traerDatosContacto(Cliente cliente) throws HibernateException {
		DatosContacto objeto = null;

		try {
			iniciaOperacion();
			objeto = (DatosContacto) session.get(DatosContacto.class, cliente);
		} finally {
			session.close();
		}
		return objeto;
	}*/

}