package iuh.fit.dao.impl;

import iuh.fit.dao.positionDao;
import iuh.fit.entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class positionImpl extends UnicastRemoteObject implements positionDao {
    private EntityManager em;

    public positionImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }
    @Override
    public List<Position> findListByPosition(String name, Double from, Double to) throws RemoteException {
        return em.createQuery("SELECT p FROM Position p WHERE p.name LIKE :name AND p.salary >= :from AND p.salary <= :to", Position.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
    }
}
