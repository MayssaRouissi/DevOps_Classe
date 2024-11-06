package tn.esprit.tpfoyer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.ChambreServiceImpl;
import tn.esprit.tpfoyer.service.IChambreService;


import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ChambreServiceImplMocka {

    @Mock
    IChambreService us;

    @InjectMocks
    ChambreServiceImpl chambreServiceImpl;

    @Test
    @Order(1)
    public void testRetrieveAllChambres() {
        List<Chambre> mockChambres = Collections.emptyList();
        when(us.retrieveAllChambres()).thenReturn(mockChambres);

        List<Chambre> listChambres = chambreServiceImpl.retrieveAllChambres();

        Assertions.assertEquals(0, listChambres.size());
    }
}
