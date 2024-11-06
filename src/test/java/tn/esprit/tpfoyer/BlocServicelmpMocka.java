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
    public void testAddBloc() {
        Bloc bloc = new Bloc();
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(100);

        // Ajouter un bloc et vérifier que le nom et la capacité sont corrects
        Bloc savedBloc = us.addBloc(bloc);
        Assertions.assertNotNull(savedBloc);
        Assertions.assertEquals("Bloc A", savedBloc.getNomBloc());
        Assertions.assertEquals(100, savedBloc.getCapaciteBloc());
    }

    @Test
    @Order(2)
    public void testRetrieveAllBlocs() {
        List<Bloc> listBlocs = us.retrieveAllBlocs();
        // Après l'ajout d'un bloc dans le test précédent, la taille devrait être 1
        Assertions.assertEquals(1, listBlocs.size());
    }

    @Test
    @Order(3)
    public void testModifyBloc() {
        // Vérification de l'existence du bloc avant modification
        List<Bloc> allBlocs = us.retrieveAllBlocs();
        Assertions.assertFalse(allBlocs.isEmpty(), "Aucun bloc n'est présent pour modification.");
        Long blocId = allBlocs.get(0).getIdBloc();

        // Récupérer le bloc et modifier son nom
        Bloc bloc = us.retrieveBloc(blocId);
        bloc.setNomBloc("Bloc B");
        Bloc updatedBloc = us.modifyBloc(bloc);

        // Vérifier que le nom a été modifié
        Assertions.assertEquals("Bloc B", updatedBloc.getNomBloc());
    }

    @Test
    @Order(4)
    public void testRemoveBloc() {
        // Vérifier qu'il y a des blocs avant la suppression
        List<Bloc> allBlocs = us.retrieveAllBlocs();
        Assertions.assertFalse(allBlocs.isEmpty(), "Aucun bloc n'est présent pour suppression.");

        Long blocId = allBlocs.get(0).getIdBloc();

        // Supprimer le bloc et vérifier qu'il a été supprimé
        us.removeBloc(blocId);

        // Vérifier que l'élément a bien été supprimé en cherchant à le récupérer
        Assertions.assertThrows(NoSuchElementException.class, () -> us.retrieveBloc(blocId));
    }
}
