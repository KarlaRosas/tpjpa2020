package jpa;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;




public class JpaTestFiche {

    private EntityManager manager;

    public JpaTestFiche(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
		/*EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();*/
        EntityManager manager = EntityManagerHelper.getEntityManager();
        JpaTestFiche test = new JpaTestFiche(manager);


        EntityTransaction tx = manager.getTransaction();


        tx.begin();
        try {
            test.createFiches();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        test.listFiches();

        manager.close();
        System.out.println(".. done");
        EntityManagerHelper.closeEntityManagerFactory();
    }

    private void createFiches() {
        int numOfFiches = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        if (numOfFiches == 0) {
            Tableau tableau = new Tableau("tab1");
            Tableau tableau2 = new Tableau("tab2");
            manager.persist(tableau);
            manager.persist(tableau2);

            manager.persist(new Fiche("Jakab Gipsz",tableau));
            manager.persist(new Fiche("Captain Nemo",tableau));
            manager.persist(new Fiche("Bon Toronja",tableau2));
            manager.persist(new Fiche("Bebecito bebeLean",tableau2));

        }
    }

    private void listFiches() {
        List<Fiche> resultList = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
        System.out.println("num of fiches:" + resultList.size());
        for (Fiche next : resultList) {
            System.out.println("next fiche: " + next);
        }
    }
}


