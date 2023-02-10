package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;
import org.iesabastos.dam.datos.ijg.pojos.Ciclista;
import org.iesabastos.dam.datos.ijg.pojos.Equipo;

import java.util.List;

public class _05CrearEquipo {
	/*
	Desarrolla un programa (_05CrearEquipo) que añada un equipo llamado “VIP” cuyo
	director será “Edvard Grieg” que contendrá a todos los ciclistas que han Ganado un maillot
	con un premio superior a 40.000€ (o 6.000.000 pts si no se ha realizado el ejercicio 2).
	(2 puntos)
	 */
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		try {
			Equipo vip = new Equipo();
			vip.setDirector("Edvard Grieg");
			vip.setNomeq("VIP");

			Query query = session.createQuery("select e.ganador from Etapa as e inner join e.ganador as c inner join c.llevars as l inner join l.maillot as m WHERE m.premio >= 40000 group by c.nombre");
			List<Ciclista> ciclistas = query.list();
			vip.setCiclistas(ciclistas);
			//Bucle técnicamente innecesario, pues el mappeo debería hacerse por si solo al guardar el equipo, pero no lo hace
			//puede que sea problema del IDE o algo que habré hecho mal con los mappeos, pero a saber
			for (Ciclista c : ciclistas
			) {
				c.setEquipo(vip);
				System.out.println(c.getNombre());
				session.save(c);
			}
			session.save(vip);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Error al crear el equipo VIP");
			e.printStackTrace();
		}
		session.close();
	}
}
