"# LAB_JPA_POPRAWKA" 

 - prosze uruchomic aplikacje, przeczytac logi w konsoli, zlokalizowac blad i usunac. dopiero wtedy mozna przystapic do dalszych punktow
 - prosze wyszukac wszystkie TODO i wypelnic je zgodnie z poleceniem. Calosc sprowadza sie do uruchomienia wszystkich testow - testy MUSZA przechodzic. 
 - w wiekszosci przypadkow nalezy napisac zapytania JPQL tak aby test przeszedl - wtedy TODO jest na poziomie implementacji zapytania. Tam ma tez sie znalezc implementacja - nie w interfejsie jako parametr adnotacji
 - jesli TODO jest w tescie - nalezy postepowac zgodnie z instrukcja. Jedyne, co w testach mozna zmienic, to dodac adnotacje
 - uzywanie Spring Data (JpaRepository, adnotacje w interfejsie), dorabianie Mockow itp. skutkuja ocena 2.0
 
 
 Podsumowujac - nalezy napisac zapytanie w JPQL z uzyciem EntityManagera, naprawic relacje w modelu i ustawic odpowiednia adnotacje w tescie tam gdzie to wymagane (tylko w jednym)
