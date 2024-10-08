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

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BlocServicelmpMocka {



        @Autowired
        IBlocService us;
        @Test
        @Order(1)
        public void testRetrieveAllUsers() {
            List<Bloc> listUsers = us.retrieveAllBlocs();
            Assertions.assertEquals(0, listUsers.size());
        }






}
