package iuh.huynhquocbao_21107451_baitap1.repositories;

import iuh.huynhquocbao_21107451_baitap1.entities.Account;
import iuh.huynhquocbao_21107451_baitap1.entities.GrantAccess;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class AccountRepository {
      private EntityManagerFactory emf;
      public AccountRepository() {
          emf = Persistence.createEntityManagerFactory("JPA_MARIADB");
      }

      public Account getAccount(String account_id) {
          EntityManager em = null;
          try {
              em = emf.createEntityManager();
              return em.find(Account.class, account_id);
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              if (em != null) {
                  em.close();
              }
          }
          return null;
      }

      public boolean addAccount(Account account, GrantAccess grantAccess) {
          EntityManager em = null;
          try {
              em = emf.createEntityManager();
              em.getTransaction().begin();
              em.persist(account);
              em.merge(grantAccess);
              em.getTransaction().commit();
              return true;
          }catch (Exception e) {
              e.printStackTrace();
          }
          return false;
      }

      public boolean updateAccount(Account account) {
          EntityManager em = null;
          try {
              em = emf.createEntityManager();
              em.getTransaction().begin();
              em.merge(account);
              em.getTransaction().commit();
              return true;
          }catch(Exception e) {
              e.printStackTrace();
          }
          return false;
      }

      public boolean deleteAccount(String account_id) {
          EntityManager em = null;
          try {
              em = emf.createEntityManager();
              Account account = em.find(Account.class, account_id);
              em.getTransaction().begin();
              em.remove(account);
              em.getTransaction().commit();
              return true;
          }catch (Exception e) {
              e.printStackTrace();
          }
          return false;
      }
}
