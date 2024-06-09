package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)  // Uruchamia testy w kontekście Springa
@SpringBootTest  // Ładuje kontekst aplikacji Spring Boot
public class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;  // Wstrzykuje zależność do AddressDao

    @Transactional
    @Test
    public void testShouldFindAddressById() {
        // given
        // Krok przygotowawczy (opcjonalnie można wprowadzić dane testowe)

        // when
        AddressEntity addressEntity = addressDao.findOne(1L);  // Pobiera encję AddressEntity o ID 1

        // then
        assertThat(addressEntity).isNotNull();  // Sprawdza, czy encja została znaleziona
        assertThat(addressEntity.getPostalCode()).isEqualTo("62-030");  // Sprawdza, czy kod pocztowy jest zgodny z oczekiwaniami
    }

    @Test
    public void testShouldSaveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();  // Tworzy nową encję AddressEntity
        addressEntity.setAddressLine1("line1");  // Ustawia pierwszą linię adresu
        addressEntity.setAddressLine2("line2");  // Ustawia drugą linię adresu
        addressEntity.setCity("City1");  // Ustawia miasto
        addressEntity.setPostalCode("66-666");  // Ustawia kod pocztowy
        long entitiesNumBefore = addressDao.count();  // Liczy liczbę encji przed zapisaniem nowej

        // when
        final AddressEntity saved = addressDao.save(addressEntity);  // Zapisuje nową encję do bazy danych

        // then
        assertThat(saved).isNotNull();  // Sprawdza, czy encja została zapisana
        assertThat(saved.getId()).isNotNull();  // Sprawdza, czy encja ma przypisane ID
        assertThat(addressDao.count()).isEqualTo(entitiesNumBefore + 1);  // Sprawdza, czy liczba encji wzrosła o 1
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();  // Tworzy nową encję AddressEntity
        addressEntity.setAddressLine1("line1");  // Ustawia pierwszą linię adresu
        addressEntity.setAddressLine2("line2");  // Ustawia drugą linię adresu
        addressEntity.setCity("City1");  // Ustawia miasto
        addressEntity.setPostalCode("66-666");  // Ustawia kod pocztowy

        // when
        final AddressEntity saved = addressDao.save(addressEntity);  // Zapisuje nową encję do bazy danych
        assertThat(saved.getId()).isNotNull();  // Sprawdza, czy encja ma przypisane ID
        final AddressEntity newSaved = addressDao.findOne(saved.getId());  // Pobiera zapisaną encję z bazy danych
        assertThat(newSaved).isNotNull();  // Sprawdza, czy encja została znaleziona

        addressDao.delete(saved.getId());  // Usuwa zapisaną encję z bazy danych

        // then
        final AddressEntity removed = addressDao.findOne(saved.getId());  // Próbuje ponownie pobrać usuniętą encję
        assertThat(removed).isNull();  // Sprawdza, czy encja została usunięta
    }
}
