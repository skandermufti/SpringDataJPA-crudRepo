package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.framework;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceImplMock {
	
	@Mock
	SecteurActiviteRepository SecteurRepository;
	@Mock
	FournisseurRepository fr;
	
	@InjectMocks
	SecteurActiviteServiceImpl SecteurService;
	
	@InjectMocks
	FournisseurServiceImpl fs;

	/*@Test
	public void testRetrieveSecteur() {
		SecteurActivite secteur = new SecteurActivite(1L,"123","commercial",null);
		secteur.setIdSecteurActivite(1L);
		
		
		Mockito.when(SecteurRepository.findById(1L)).thenReturn(Optional.of(secteur));
		SecteurService.retrieveSecteurActivite(1L);
		Assertions.assertNotNull(secteur);
		
		System.out.println(secteur);
		System.out.println("Test 1 : ID retrival - work !");
	}*/
	
	@Test
	public void testRetriveFournisseur() {
		
		Fournisseur f = new Fournisseur(1L, "ss", null, null, null, null, null);
		f.setIdFournisseur(1L);
		Mockito.when(fr.findById(1L)).thenReturn(Optional.of(f));
		fs.retrieveFournisseur(1L);
		Assertions.assertNotNull(f);
		System.out.println(f);
		System.out.println("Test 1 : skander ");
	
	}
	
	@Test
	public void createFournisseurTest() {
		Fournisseur f2 = new Fournisseur(2L, "ss2", null, null, null, null, null);
		f2.setIdFournisseur(2L);
		fs.addFournisseur(f2);
		verify(fr, times(1)).save(f2);
		System.out.println(f2); 
		System.out.println("Test 2 : New instance of Fournisseur creation - work !");  
				
	}
	
	
	
	
	/*@Test
	public void getAllSecteursTest() {
		List<SecteurActivite> SecteurList = new ArrayList<SecteurActivite>() {{
			
			add(new SecteurActivite(null,"bbbb","gggg",null));
			add(new SecteurActivite(null,"kkkk","llll",null));
			add(new SecteurActivite(null,"uuuu","wwww",null));

		}};
		
		when(SecteurService.retrieveAllSecteurActivite()).thenReturn(SecteurList);
		List<SecteurActivite> sList = SecteurService.retrieveAllSecteurActivite();
		assertEquals(3, sList.size());
		System.out.println("Test 3 : Retrive all sector instances - work !");
		
	}*/
	
	@Test
	public void TestDeleteFournisseur() {
		Fournisseur f3 = new Fournisseur(3L, "ss2", null, null, null, null, null);
		f3.setIdFournisseur(3L);
		Mockito.lenient().when(fr.findById(f3.getIdFournisseur())).thenReturn(Optional.of(f3));
		fs.deleteFournisseur(3L);
		verify(fr).deleteById(f3.getIdFournisseur());
		System.out.println(f3);
		System.out.println("Test 3 : Delete Fournisseur instance - work !");
						
	}
	
	
}