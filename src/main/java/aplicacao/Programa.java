package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Jonathan", "jonathan@brant.com");
        Pessoa p2 = new Pessoa(null, "Sara", "sara@louzada.com");

//        Pessoa pessoa1 = new Pessoa();
//        Scanner input = new Scanner(System.in);
//
//        pessoa1.setId(null);
//        System.out.println("Insira um nome");
//        pessoa1.setNome(input.nextLine());
//        System.out.println("Insira um email");
//        pessoa1.setEmail(input.nextLine());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaTreino");
        EntityManager em = emf.createEntityManager();
        try {
            //Adcionar
            em.getTransaction().begin();
            Pessoa p = em.find(Pessoa.class, 1);
//       em.remove(p);
            p.setEmail("jonathan@gmail.com");
//        em.persist(p1);
//        em.persist(p2);
            em.getTransaction().commit();

            System.out.println("Cadastrado com sucesso!");

            //Consultar
        } finally {
            em.close();
            emf.close();
        }
    }
}
