package iuh.fit.dao.impl;

import iuh.fit.dao.candidateDao;
import iuh.fit.entity.Candidate;
import iuh.fit.entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class candidateImpl extends UnicastRemoteObject implements candidateDao {
    private EntityManager em;

    public candidateImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }
    @Override
    public Map<Candidate, Long> listCandicateByCompany() throws RemoteException {
        Map<Candidate, Long> result = new LinkedHashMap<>();
        String query = "SELECT c, COUNT(e) FROM Candidate c JOIN c.experiences e GROUP BY c";
        List<?> list = em.createQuery(query).getResultList();
        list.stream()
                .map(o -> (Object[]) o)
                .forEach(o -> {
                    Candidate c = (Candidate) o[0];
                    Long count = (Long) o[1];
                    result.put(c, count);
                });
        return result;
    }

    @Override
    public Map<Candidate, Position> listCandicateWithLongestWorking() throws RemoteException {
        Map<Candidate, Position> result = new LinkedHashMap<>();
        String query = "SELECT c, p FROM Candidate c JOIN c.experiences e JOIN e.position p " +
                "WHERE e.toDate - e.fromDate = (SELECT MAX(e.toDate - e.fromDate) FROM Experience e)";
        List<?> list = em.createQuery(query).getResultList();
        list.stream()
                .map(o -> (Object[]) o)
                .forEach(o -> {
                    Candidate c = (Candidate) o[0];
                    Position p = (Position) o[1];
                    result.put(c, p);
                });
        return result;
    }

    @Override
    public void longestWorkingTime() throws RemoteException
    {
        String query = "SELECT MAX(e.toDate - e.fromDate) FROM Experience e";
        System.out.println(em.createQuery(query).getSingleResult());
    }
}
