package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;
import org.iesabastos.dam.datos.ijg.pojos.Ciclista;
import org.iesabastos.dam.datos.ijg.pojos.Maillot;

import java.util.List;
import java.util.Scanner;

public class _03CiclistasCiudad {
	/*
	Desarrolla un programa (_03CiclistasCiudad) que muestre el nombre de los ciclistas que
	ganaron alguna etapa que salía de o llegaba a la ciudad indicada por el usuario.
	(2 puntos)
	 */
	public static void main(String[] args) {
		Scanner inText = new Scanner(System.in);

		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		String ciudad;

		System.out.println("Introduzca la ciudad de la que desea saber sus ganadores: ");
		ciudad = inText.nextLine();

		try {
			Query query = session.createQuery("select e.ganador from Etapa e WHERE e.salida = :ciudad or e.llegada = :ciudad group by e.ganador");
			query.setParameter("ciudad", ciudad);
			List<Ciclista> ciclistas = (List<Ciclista>) query.list();
			if (ciclistas.size() != 0) {
				System.out.println("Lista de ganadores que han pasado por " + ciudad + " son: ");
				for (Ciclista ciclista : ciclistas
				) {
					System.out.println(ciclista.getNombre());
				}
			} else {
				System.out.println("No se han encontrado resultados. Es posible que no haya ganadores o no haya introducido el nombre de la ciudad correctamente.");
			}

		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
		session.close();

	}
}
