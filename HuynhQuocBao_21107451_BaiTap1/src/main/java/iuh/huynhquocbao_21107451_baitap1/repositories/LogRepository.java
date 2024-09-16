package iuh.huynhquocbao_21107451_baitap1.repositories;

import iuh.huynhquocbao_21107451_baitap1.entities.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class LogRepository {
    private EntityManagerFactory emf;

    public LogRepository() {
        emf = Persistence.createEntityManagerFactory("JPA_MARIADB");
    }

    public boolean addLog(Log log) {
        EntityManager em = null;
        try {
            System.out.println(2);
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Log getLog(String accountId) {
         EntityManager em = null;
          try {
              em = emf.createEntityManager();
            Query q = em.createQuery("select l from Log l where l.accountId = :accountId order by l.loginTime desc limit 1");
            q.setParameter("accountId", accountId);
            return (Log) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateLog(Log log) {
         EntityManager em = null;
          try {
              em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(log);
            em.getTransaction().commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
