package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;
import org.iesabastos.dam.datos.ijg.pojos.Maillot;

import java.util.List;

public class _02ModificarPremio {
	/*
	Desarrolla un programa (_02ModificarPremio) para convertir el premio de todos los
maillots en euros (€), ya que se encuentra en pesetas (pts). El cambio de € a pts está a 1€
 166,386 pts. Puedes redondear el precio en € si el resultado tiene decimales. El programa
deberá mostrar el número total de maillots que se han actualizado
(2 puntos).
	 */
	public static void main(String[] args) {

		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Maillot");
		List<Maillot> maillots = (List<Maillot>) query.list();
		for (Maillot maillot : maillots
		) {
			maillot.setPremio((int) (maillot.getPremio() / 166.386));
			session.save(maillot);
		}
		try {
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error al actualizar las pesetas a euros");
		}
		System.out.println("Número de maillots actualizados: " + maillots.size());
		session.close();

	}
}
