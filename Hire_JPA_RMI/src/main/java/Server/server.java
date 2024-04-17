package Server;

import iuh.fit.dao.candidateDao;
import iuh.fit.dao.impl.candidateImpl;
import iuh.fit.dao.impl.positionImpl;
import iuh.fit.dao.positionDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class server {

    private static final String URL = "rmi://LAPTOP-5EKTP971:2951/";

    public static void main(String[] args) {
        try{
            Context context = new InitialContext();

            candidateDao a = new candidateImpl();
            positionDao b = new positionImpl();
            LocateRegistry.createRegistry(2951);

            context.bind(URL + "candidate", a);
            context.bind(URL + "position", b);
            System.out.println("Server is running...");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
