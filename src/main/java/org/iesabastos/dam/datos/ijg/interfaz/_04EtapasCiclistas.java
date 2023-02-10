package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;
import org.iesabastos.dam.datos.ijg.pojos.Ciclista;

import java.util.List;
import java.util.Scanner;

public class _04EtapasCiclistas {
	/*
	Desarrolla un programa (_04EtapasCiclistas) que muestre de cada etapa, el nombre del
	ciclista que la ha ganado y nombre del equipo al que pertenece.
	Se pide que se realice la consulta en una única query con acceso a varias tablas.
	(2 puntos)
	 */
	public static void main(String[] args) {

		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		try {
			Query query = session.createQuery("select e.netapa, c.nombre, eq.nomeq from Etapa as e inner join e.ganador as c inner join c.equipo as eq order by e.netapa");
			List<Object[]> etapas = query.list();
			for (Object[] e : etapas
			) {
				System.out.printf("Etapa %s cuyo ganador fue %s, del equipo %s.\n", e[0], e[1], e[2]);
			}

		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
		session.close();
	}
}
