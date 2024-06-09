Laboratorium I - Relacje w JPA

1. Zapoznaj sie ze struktura projektu - nazwy pakietow, encje, enumy. Zwroc uwage na application.properties w resources, oraz na data.sql. Zapoznaj sie z ustawieniami aplikacji (przede wszystkim jpa). W trakcie analizy dzialania programu zwroc uwage na to jak i kiedy wykorzystywany jest plik data.sql
2. Uruchom aktualna konfiguracje 'WsbJpaApplication' badz kliknij prawym ma WsbJpaApplication i wybierz opcje RUN. Obserwuj logi konsoli, zwlaszcza logi Hibernate'a
3. Po starcie aplikacji (w logach widoczny ostatni wpis "Started WsbJpaApplication in XXXX seconds (JVM running for X.XX)") uruchom przegladarke i przejdz do adresu http://localhost:8091/h2/ . Pojawi sie ponizsza strona logowania. Wpisz odpowiednie username i password jesli nie zostalo uzupelnione automatycznie (sprawdz ustawienia w pliku application.properties) i polacz sie z baza H2
![](H2_console.png)
4. Po zalogowaniu sie do bazy H2 pojawi sie ponizszy interfejs graficzny z listingiem wszystkich tabel (po lewej) oraz miejscem na wprowadzania komend sql
![](H2_console_tables.png)
5. Jesli zmieniasz nazwy tabel, pamietaj o wywolaniu komendy "drop all objects" - inaczej hibernate utworzy na nowo tylko znane mu aktualnie tabele, zostawiajac poprzednie nietkniete, co moze byc mocno mylace.
6. Zapoznaj sie z ponizszym schematem relacyjnym bazy danych. Korzystajac z wiedzy przekazanej na wykladzie, literatury oraz internetu uzupelnij brakujace relacje w aktualnej definicji encji (zwroc uwage takze na nazwy tabel). Okresl nullowalnosc kolumn i kaskady. 
Ustaw relacje tak, aby przynajmniej raz byla wykorzystana relacja jednostronna i dwustronna.
Przy kazdej relacji napisz jako komentarz czy jest to relacja jednostronna od strony rodzica (wlasciciela relacji), jednostronna od strony dziecka, czy dwustronna.
   ![](db_schema.png)
7. Uzupelnij plik data.sql danymi (komendy insert) w odpowiedniej kolejnosci potwierdzajac poprawnosc modelu
