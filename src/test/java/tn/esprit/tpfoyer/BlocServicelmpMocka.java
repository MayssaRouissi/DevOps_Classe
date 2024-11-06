package tn.esprit.tpfoyer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.BlocServiceImpl;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class BlocServiceImplTest {

    @Autowired
    IBlocService us;

    private BlocServiceImpl blocService;

    private static Long blocId;

    @Test
    @Order(1)
    public void testAddBloc() {
        Bloc bloc = new Bloc();
        bloc.setNomBloc("Bloc Test");
        bloc.setCapaciteBloc(100);

        Bloc createdBloc = blocService.addBloc(bloc);
        blocId = createdBloc.getIdBloc();  // Stocke l'ID pour les tests suivants

        assertNotNull(createdBloc);
        assertEquals("Bloc Test", createdBloc.getNomBloc());
    }

    @Test
    @Order(2)
    public void testRetrieveAllBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();

        // Après l'ajout d'un bloc dans le test précédent, la taille devrait être au moins 1
        assertTrue(listBlocs.size() >= 1);
    }

    @Test
    @Order(3)
    public void testRetrieveBloc() {
        Bloc bloc = blocService.retrieveBloc(blocId);

        assertNotNull(bloc);
        assertEquals("Bloc Test", bloc.getNomBloc());
        assertEquals(100, bloc.getCapaciteBloc());
    }

    @Test
    @Order(4)
    public void testModifyBloc() {
        Bloc bloc = blocService.retrieveBloc(blocId);
        bloc.setNomBloc("Bloc Modifié");
        bloc.setCapaciteBloc(200);

        Bloc updatedBloc = blocService.modifyBloc(bloc);

        assertEquals("Bloc Modifié", updatedBloc.getNomBloc());
        assertEquals(200, updatedBloc.getCapaciteBloc());
    }

    @Test
    @Order(5)
    public void testRemoveBloc() {
        blocService.removeBloc(blocId);
        Bloc deletedBloc = blocService.retrieveBloc(blocId);

        // Après suppression, le bloc ne devrait plus exister
        assertNull(deletedBloc);
    }

   
}
