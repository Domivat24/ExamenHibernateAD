package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.pojos.Maillot;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _01CrearMaillot {
	/*
Desarrolla un programa (_01CrearMaillot) para crear un nuevo maillot. El programa
informará al usuario si el maillot ya existía. El programa no finalizará hasta que no se haya
introducido un nuevo maillot.
(2 puntos).
	 */
	public static void main(String[] args) {
		Scanner inText = new Scanner(System.in);
		Scanner inNum = new Scanner(System.in);

		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		boolean inserted = false;
		String codigo, tipo, color;
		Maillot maillot;
		int premio;
		while (!inserted) {
			try {
				System.out.println("Introduzca el codigo del maillot (3 caracteres): ");
				codigo = inText.nextLine();
				System.out.println("Introduzca el tipo: ");
				tipo = inText.nextLine();
				System.out.println("Introduzca el color: ");
				color = inText.nextLine();
				System.out.println("Introduzca el premio (entero): ");
				premio = inNum.nextInt();
				maillot = new Maillot();
				maillot.setCodigo(codigo);
				maillot.setColor(color);
				maillot.setTipo(tipo);
				maillot.setPremio(premio);
				session.save(maillot);
				session.getTransaction().commit();
				inserted = true;
			} catch (Exception e) {
				System.out.println("Maillot ya se encuentra en la base de datos o problema con los campos introducidos.");
			}

		}
		session.close();

	}
}
