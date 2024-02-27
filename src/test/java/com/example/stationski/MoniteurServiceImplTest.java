package com.example.stationski;

import com.example.stationski.entities.Moniteur;
import com.example.stationski.repositories.CoursRepository;
import com.example.stationski.repositories.MoniteurRepository;
import com.example.stationski.services.MoniteurServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MoniteurServiceImplTest {

    @Mock
    private MoniteurRepository moniteurRepository;

    @Mock
    private CoursRepository coursRepository;

    @InjectMocks
    private MoniteurServiceImpl moniteurService;

    private Moniteur moniteur;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        moniteur = Moniteur.builder()
                .idMoniteur(1)
                .numMoniteur(12345L)
                .nomM("Doe")
                .prenomM("John")
                .dateRecru(LocalDate.of(2020, 1, 1))
                .prime(0)
                .build();
    }

    @Test
    void addMoniteurTest() {
        when(moniteurRepository.save(any(Moniteur.class))).thenReturn(moniteur);
        moniteurService.addMoniteur(moniteur);
        verify(moniteurRepository, times(1)).save(any(Moniteur.class));
    }

    @Test
    void updateMoniteurTest() {
        when(moniteurRepository.save(any(Moniteur.class))).thenReturn(moniteur);
        moniteurService.updateMoniteur(moniteur);
        verify(moniteurRepository, times(1)).save(any(Moniteur.class));
    }

    @Test
    void retrieveMoniteurTest() {
        when(moniteurRepository.findById(anyInt())).thenReturn(Optional.of(moniteur));
        moniteurService.retrieveMoniteur(1);
        verify(moniteurRepository, times(1)).findById(anyInt());
    }

    @Test
    void deleteMoniteurTest() {
        doNothing().when(moniteurRepository).deleteById(anyInt());
        moniteurService.deleteMoniteur(1);
        verify(moniteurRepository, times(1)).deleteById(anyInt());
    }

    // Add more tests for other methods in MoniteurServiceImpl

}
