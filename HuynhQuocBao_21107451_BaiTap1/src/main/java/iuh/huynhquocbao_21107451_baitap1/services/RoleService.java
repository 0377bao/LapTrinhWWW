package iuh.huynhquocbao_21107451_baitap1.services;

import iuh.huynhquocbao_21107451_baitap1.entities.Account;
import iuh.huynhquocbao_21107451_baitap1.entities.Role;
import iuh.huynhquocbao_21107451_baitap1.repositories.RoleRepository;

import java.util.List;

public class RoleService {
    private RoleRepository roleRepository;

    public RoleService() {
        roleRepository = new RoleRepository();
    }

    public List<Account> getAccountsOfRole(String roleName) {
        return roleRepository.getAccountsOfRole(roleName);
    }

    public Role getRoleOfAccount(String accountId) {
        return roleRepository.getRoleOfAccount(accountId);
    }

    public Role getRole(String name) {
        return roleRepository.getRole(name);
    }


}
