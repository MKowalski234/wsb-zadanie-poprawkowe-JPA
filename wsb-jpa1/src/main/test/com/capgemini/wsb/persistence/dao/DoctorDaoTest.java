package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)  // Uruchamia testy w kontekście Springa
@SpringBootTest  // Ładuje kontekst aplikacji Spring Boot
public class DoctorDaoTest {

    @Autowired
    private DoctorDao doctorDao;  // Wstrzykuje zależność do DoctorDao

    @Test
    @Transactional
    public void shouldFindDocsBySpecialization() {
        // given
        final Specialization spec = Specialization.OCULIST;  // Określa specjalizację, dla której będą szukani lekarze

        // when
        final List<DoctorEntity> doctors = doctorDao.findBySpecialization(spec);  // Pobiera listę lekarzy o danej specjalizacji

        // then
        assertThat(doctors.size()).isEqualTo(3L);  // Sprawdza, czy lista zawiera 3 lekarzy
        assertThat(doctors.stream().map(x -> x.getFirstName() + " " + x.getLastName()).collect(Collectors.toList()))
                .containsExactlyInAnyOrder("Jan Nowak", "Jan Terefere", "Jan Krzywy");  // Sprawdza, czy lista zawiera oczekiwane nazwiska lekarzy
    }

    @Test
    @Transactional
    public void shouldCountNumOfVisitsBetweenDocAndPatient() {
        // given
        // Przygotowanie środowiska (opcjonalnie można wprowadzić dane testowe)

        // when
        final long numOfVisits = doctorDao.countNumOfVisitsWithPatient("Jan", "Krzywy", "Krzysio", "Nowak");  // Liczy wizyty między danym lekarzem a pacjentem

        // then
        assertThat(numOfVisits).isEqualTo(3L);  // Sprawdza, czy liczba wizyt jest równa 3
    }

    @Test
    public void shouldProveCorrectMappingDoctorToVisit() {
        // given
        // Przygotowanie środowiska (opcjonalnie można wprowadzić dane testowe)

        // when
        final DoctorEntity doc = doctorDao.findOne(1L);  // Pobiera lekarza o ID 1 z bazy danych

        // then
        assertThat(doc.getVisits().size()).isEqualTo(2L);  // Sprawdza, czy lekarz ma 2 wizyty
        assertThat(doc.getVisits().stream().map(x -> x.getPatient().getFirstName() + " " + x.getPatient().getLastName()).collect(Collectors.toList()))
                .containsExactlyInAnyOrder("Krzysio Nowak", "Zbigniew Kowalski");  // Sprawdza, czy wizyty dotyczą oczekiwanych pacjentów
    }
}
