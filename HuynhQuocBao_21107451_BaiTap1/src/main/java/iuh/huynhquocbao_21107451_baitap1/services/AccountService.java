package iuh.huynhquocbao_21107451_baitap1.services;

import iuh.huynhquocbao_21107451_baitap1.entities.Account;
import iuh.huynhquocbao_21107451_baitap1.entities.GrantAccess;
import iuh.huynhquocbao_21107451_baitap1.repositories.AccountRepository;

public class AccountService {
    private AccountRepository accountRepository;
    public AccountService() {
        accountRepository = new AccountRepository();
    }
    public Account getAccount(String id) {
        return accountRepository.getAccount(id);
    }
    public boolean deleteAccount(String id){
        return accountRepository.deleteAccount(id);
    }
    public boolean addAccount(Account account, GrantAccess grantAccess) {
        return accountRepository.addAccount(account, grantAccess);
    }
    public boolean updateAccount(Account account) {
        return accountRepository.updateAccount(account);
    }
}
