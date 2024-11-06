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
    public void testAddBloc() {
        Bloc bloc = new Bloc();
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(100);
        Bloc savedBloc = us.addBloc(bloc);
        Assertions.assertEquals("Bloc A", savedBloc.getNomBloc());
    }

    @Test
    @Order(2)
    public void testRetrieveAllBlocs() {
        List<Bloc> listBlocs = us.retrieveAllBlocs();
        // After adding one bloc in the previous test, the size should be 1
        Assertions.assertEquals(1, listBlocs.size());
    }

    @Test
    @Order(3)
    public void testModifyBloc() {
        Long blocId = 1L;
        Bloc bloc = us.retrieveBloc(blocId);
        bloc.setNomBloc("Bloc B");
        Bloc updatedBloc = us.modifyBloc(bloc);
        Assertions.assertEquals("Bloc B", updatedBloc.getNomBloc());
    }

    @Test
    @Order(4)
    public void testRemoveBloc() {
        Long blocId = 1L;
        us.removeBloc(blocId);
        Assertions.assertThrows(Exception.class, () -> us.retrieveBloc(blocId));
    }
}
