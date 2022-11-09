package tn.esprit.rh.achat.test;




import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;





import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;



import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;



@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class UserServiceImplMockTest {
    @Mock
    FactureRepository FactureRepository;
    
    @InjectMocks
    FactureServiceImpl factureService;
    @InjectMocks
    Facture facture = new Facture(null, 0, 0, new Date(), null, null, null, null, null);



@Test
  public void retrieveAllFactures() {
   when(FactureRepository.findAll()).thenReturn(new ArrayList());
List<Facture> response= factureService.retrieveAllFactures();
assertEquals(0, response.size());
       
}
}



