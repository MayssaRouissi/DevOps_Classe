package tn.esprit.tpfoyer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class BlocServiceImplTest {

    @Autowired
    IBlocService us;



    @Test
    @Order(1)
    public void testRetrieveAllBlocs() {
        List<Bloc> listBlocs = us.retrieveAllBlocs();
        // Après l'ajout d'un bloc dans le test précédent, la taille devrait être 1
        Assertions.assertEquals(1, listBlocs.size());
    }

   
}
