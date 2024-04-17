package iuh.fit.dao;

import iuh.fit.entity.Position;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.util.List;

public interface positionDao extends Remote {
    public List<Position> findListByPosition(String name, Double from, Double to) throws RemoteException;
}
