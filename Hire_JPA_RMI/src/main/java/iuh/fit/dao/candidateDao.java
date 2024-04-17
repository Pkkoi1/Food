package iuh.fit.dao;

import iuh.fit.entity.Candidate;
import iuh.fit.entity.Position;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface candidateDao extends Remote {
    public Map<Candidate, Long> listCandicateByCompany() throws RemoteException;
    public Map<Candidate, Position> listCandicateWithLongestWorking() throws RemoteException;
    public void longestWorkingTime() throws RemoteException;

}
