package Main;

import iuh.fit.dao.impl.candidateImpl;
import iuh.fit.dao.impl.positionImpl;
import iuh.fit.dao.positionDao;
import iuh.fit.dao.candidateDao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

public class main {
    static positionDao positionDao;
    static candidateDao candidate;

    @BeforeAll
    public static void setUp() throws RemoteException {
        positionDao = new positionImpl();
        candidate = new candidateImpl();
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
