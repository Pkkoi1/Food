package Client;

import iuh.fit.dao.candidateDao;
import iuh.fit.dao.positionDao;
import iuh.fit.dao.impl.candidateImpl;
import iuh.fit.dao.impl.positionImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class client {

    private static final String URL = "rmi://LAPTOP-5EKTP971:2951/";

    static positionDao positionDao;
     static candidateDao candidate;

    @BeforeAll
    public static void setUp() throws RemoteException{
        try {
            positionDao = (positionDao) Naming.lookup(URL + "position");
            candidate = (candidateDao) Naming.lookup(URL + "candidate");

        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterAll
    public static void tearDown() {
        positionDao = null;
        candidate = null;
    }

    @Test
    public void testA() throws RemoteException {
        positionDao.findListByPosition("Senior Software Engineer", 70000.0, 90000.0).forEach(System.out::println);
    }
    @Test
    public void testB() throws Exception {
        candidate.listCandicateByCompany().forEach((k, v) -> System.out.println(k + " : " + v));
    }
    @Test
    public void testC() throws Exception {
        candidate.listCandicateWithLongestWorking().forEach((k, v) -> System.out.println(k + " : " + v));
    }
    @Test
    public void testD() throws Exception {
        candidate.longestWorkingTime();
    }
}
