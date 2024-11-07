package tn.esprit.tpfoyer;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocServiceImpl;
import tn.esprit.tpfoyer.service.IBlocService;
import static org.mockito.Mockito.any;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyLong;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
 class BlocServiceImplTest {

    @Autowired
    IBlocService us;

    @Mock
    BlocRepository blocRepository;

    @InjectMocks
    BlocServiceImpl blocService;
    Bloc bloc = new Bloc(1L, "Bloc1", 50L, null, new HashSet<>());
    List<Bloc> listBlocs = new ArrayList<Bloc>() {{
        add(new Bloc(2L, "Bloc2", 100L, null, new HashSet<>()));
        add(new Bloc(3L, "Bloc3", 75L, null, new HashSet<>()));
    }};


    @Test
    public void testRetrieveAllBlocs() {
        Mockito.when(blocRepository.findAll()).thenReturn(listBlocs);
        List<Bloc> blocs = blocService.retrieveAllBlocs();
        Assertions.assertNotNull(blocs);
        Assertions.assertEquals(2, blocs.size());
    }

    @Test
    public void testRetrieveBloc() {
        Mockito.when(blocRepository.findById(anyLong())).thenReturn(Optional.of(bloc));
        Bloc retrievedBloc = blocService.retrieveBloc(1L);
        Assertions.assertNotNull(retrievedBloc);
    }

    @Test
    public void testAddBloc() {
        Mockito.when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);
        Bloc addedBloc = blocService.addBloc(bloc);
        Assertions.assertNotNull(addedBloc);
    }

    @Test
    public void testUpdateBloc() {
        Mockito.when(blocRepository.findById(anyLong())).thenReturn(Optional.of(bloc));
        Mockito.when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);
        Bloc updatedBloc = blocService.modifyBloc(bloc);
        Assertions.assertNotNull(updatedBloc);
    }

    @Test
    public void testRemoveBloc() {
        Mockito.when(blocRepository.findById(anyLong())).thenReturn(Optional.of(bloc));
        blocService.removeBloc(1L);
        Mockito.verify(blocRepository, Mockito.times(1)).deleteById(1L);
    }









//    @Test
//    @Order(1)
//    public void testRetrieveAllBlocs() {
//        List<Bloc> listBlocs = us.retrieveAllBlocs();
//        // Après l'ajout d'un bloc dans le test précédent, la taille devrait être 1
//        Assertions.assertEquals(1, listBlocs.size());
//    }
//


}
