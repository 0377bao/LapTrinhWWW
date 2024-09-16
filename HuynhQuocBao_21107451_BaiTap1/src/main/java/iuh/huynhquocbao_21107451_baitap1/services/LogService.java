package iuh.huynhquocbao_21107451_baitap1.services;

import iuh.huynhquocbao_21107451_baitap1.entities.Log;
import iuh.huynhquocbao_21107451_baitap1.repositories.LogRepository;

public class LogService {
    private LogRepository logRepository;

    public LogService() {
        logRepository = new LogRepository();
    }

    public boolean writeLog(Log log) {
        return logRepository.addLog(log);
    }

    public Log getLog(String accountId) {
        return logRepository.getLog(accountId);
    }

    public boolean updateLog(Log log) {
        return logRepository.updateLog(log);
    }
}
