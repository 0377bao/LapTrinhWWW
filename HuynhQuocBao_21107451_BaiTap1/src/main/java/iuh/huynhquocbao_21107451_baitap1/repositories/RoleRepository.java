package iuh.huynhquocbao_21107451_baitap1.repositories;

import iuh.huynhquocbao_21107451_baitap1.entities.Account;
import iuh.huynhquocbao_21107451_baitap1.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private EntityManagerFactory emf;

    public RoleRepository() {
        emf = Persistence.createEntityManagerFactory("JPA_MARIADB");
    }

    public List<Account> getAccountsOfRole(String roleName) {
        List<Account> accountList = new ArrayList<Account>();
         EntityManager em = null;
          try {
              em = emf.createEntityManager();
            Query q = em.createQuery("select acc from Account acc join GrantAccess g on acc.accountId = g.account.id where g.role.id = :role");
            q.setParameter("role", roleName);
            accountList = (List<Account>) q.getResultList();
            return accountList;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public Role getRoleOfAccount(String accountId) {
        Role role = null;
         EntityManager em = null;
          try {
              em = emf.createEntityManager();
            Query q = em.createQuery("select r from Role r join GrantAccess g on r.roleId = g.role.roleId where g.account.accountId = :accountId");
            q.setParameter("accountId", accountId);
            role = (Role) q.getSingleResult();
            return role;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    public Role getRole(String name) {
        return emf.createEntityManager().find(Role.class, name);
    }
}
