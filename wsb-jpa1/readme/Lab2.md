Laboratorium II - Architektura warstwowa, EntityManager oraz testy

Uwaga! Do wykonania zadan konieczne jest zaimplementowanie modelu obiektowo-relacyjnego bazy z Laboratorium I !

1. Korzystajac z przykladowego kodu dla encji AddressEntity utworz warstwy dostepu do danych (Repository, Service, mappery, TOsy, opcjonalnie RESTy - dla chetnych) dla encji PatientEntity. Spelnione maja byc nasteoujace wymagania:
   - TO pacjenta ma miec liste wizyt ktore sie odbyly
   - kazda wizyta ma miec informacje o lekarzu oraz pacjencie
   - rozszerz encje PatientEntity o jedno dowolne pole innego typu niz String, odwzoruj je w TO.
2. Korzystajac z przykladowych insertow w pliku data.sql uzupelnij encje pacjenta, doktorow oraz wizyt danymi testowymi
3. Korzystajac z przykladoych testow dla encji Address, napisz testy do serwisu (uwaga! serwisu, nie DAO!) pacjenta:
   - test usuwajacy pacjenta sprawdza czy usuniete zostaly wszystkie wizyty (kaskada) i czy nie zostali usunieci doktorzy
   - pobranie pacjenta po ID powinno zwrocic struktore TO-sow odpowiadajaca wczesniejszym zalozeniom. W asercjach sprawdz poprawnosc odczytu dodanego przez Ciebie pola z punktu pierwszego