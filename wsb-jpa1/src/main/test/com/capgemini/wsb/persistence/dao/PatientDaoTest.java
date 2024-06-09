package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)  // Uruchamia testy w kontekście Springa
@SpringBootTest  // Ładuje kontekst aplikacji Spring Boot
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;  // Wstrzykiwanie zależności do PatientDao

    @Autowired
    private VisitsDao visitsDao;  // Wstrzykiwanie zależności do VisitsDao

    @Test
    @Transactional
    public void shouldRemoveVisitsWhenRemovingPatients() {
        // given
        final Collection<VisitEntity> visits = patientDao.findOne(1L).getVisits();  // Pobiera wizyty pacjenta o ID 1

        // when
        patientDao.delete(1L);  // Usuwa pacjenta o ID 1

        // then
        assertThat(visits.stream().filter(x -> visitsDao.exists(x.getId())).collect(Collectors.toList())).isEmpty();  // Sprawdza, czy wizyty zostały usunięte
    }

    @Test
    @Transactional
    public void shouldFindPatientsByDoctor() {
        // given

        // when
        final List<PatientEntity> patients = patientDao.findByDoctor("Jan", "Cygwin");  // Szuka pacjentów obsługiwanych przez lekarza "Jan Cygwin"

        // then
        assertThat(patients.size()).isEqualTo(2L);  // Sprawdza, czy znaleziono 2 pacjentów
        assertThat(patients.stream().map(x -> x.getFirstName() + " " + x.getLastName()).collect(Collectors.toList()))
                .containsExactlyInAnyOrder("Benek Bobo", "Zbigniew Kowalski");  // Sprawdza, czy znaleziono oczekiwane nazwiska pacjentów
    }

    @Test
    @Transactional
    public void shouldFindPatientsHavingTreatmentType() {
        // given

        // when
        final List<PatientEntity> patients = patientDao.findPatientsHavingTreatmentType(TreatmentType.EKG);  // Szuka pacjentów mających leczenie typu EKG

        // then
        assertThat(patients.size()).isEqualTo(3L);  // Sprawdza, czy znaleziono 3 pacjentów
        assertThat(patients.stream().map(x -> x.getFirstName() + " " + x.getLastName()).collect(Collectors.toList()))
                .containsExactlyInAnyOrder("Benek Bobo", "Zbigniew Kowalski", "Kajetan Beton");  // Sprawdza, czy znaleziono oczekiwane nazwiska pacjentów
    }

    @Test
    @Transactional
    public void shouldFindSharingSameAddressWithDoc() {
        // given

        // when
        final List<PatientEntity> patients = patientDao.findPatientsSharingSameLocationWithDoc("Jan", "Beton");  // Szuka pacjentów mieszkających w tej samej lokalizacji co lekarz "Jan Beton"

        // then
        assertThat(patients.size()).isEqualTo(2L);  /
