package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Medidor;


public class MedidorDao {
	private static Session session;
	private Transaction tx;

	/*-----------------PATRON SINGLETON-----------------*/

	private static MedidorDao instancia = null;

	protected MedidorDao() {
	}

	public static MedidorDao getInstance() {
		if (instancia == null)
			instancia = new MedidorDao();
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

	public int agregar(Medidor objeto) {
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

	public void actualizar(Medidor objeto) throws HibernateException {
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

	public void eliminar(Medidor objeto) throws HibernateException {
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

	public Medidor traerMedidor(long idMedidor) throws HibernateException {
		Medidor objeto = null;

		try {
			iniciaOperacion();
			objeto = (Medidor) session.createQuery("from Medidor a where a.nroSerie=" + idMedidor).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	

	@SuppressWarnings("unchecked")
	public List<Medidor> traerMedidores() throws HibernateException{
		List<Medidor> Medidores = null;
		try {
			iniciaOperacion();
			Medidores = session.createQuery("from Medidor a order by a.categoria asc").list();
		}
		finally {
			session.close();
		}
		return Medidores;
		
	}

}