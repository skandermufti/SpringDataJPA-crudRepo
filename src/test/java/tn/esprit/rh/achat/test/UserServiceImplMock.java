package tn.esprit.rh.achat.test;


import java.util.Date;
import java.util.Optional;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;



import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;
import tn.esprit.rh.achat.repositories.StockRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceImplMock {
    @Mock
    StockRepository StockRepository;
    
    @InjectMocks
    StockServiceImpl StockService;
    
    Stock f1 = new Stock(null, null, null, null, null);



   @Test
    public void testRetrieveUser() {
    Mockito.when(StockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f1));
    Stock facture1 = StockService.retrieveStock(null);
    Assertions.assertNotNull(facture1);
    }
}