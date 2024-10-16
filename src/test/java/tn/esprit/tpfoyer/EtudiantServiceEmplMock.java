package tn.esprit.tpfoyer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)


public class EtudiantServiceEmplMock {
    @Autowired
    IEtudiantService et;
    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Etudiant> listUsers = et.retrieveAllEtudiants();
        Assertions.assertEquals(0, listUsers.size());
    }
}
