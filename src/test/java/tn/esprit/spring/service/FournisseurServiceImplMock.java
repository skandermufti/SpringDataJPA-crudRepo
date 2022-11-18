package tn.esprit.spring.service;

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
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplMock {
	 @Mock
	    FactureRepository FactureRepository;
	    
	    @InjectMocks
	    FactureServiceImpl factureService;
	    
	    Facture f1 = new Facture(null, 0, 0, new Date(), null, null, null, null, null);



	   @Test
	    public void testRetrieveUser() {
	    Mockito.when(FactureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f1));
	    Facture facture1 = factureService.retrieveFacture(null);
	    Assertions.assertNotNull(facture1);
	    }
}
