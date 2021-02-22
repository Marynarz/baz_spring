# Budowanie nowoczesnych aplikacji bazodanowych
## Niedzielski 206074 ##
``Aplikacja prostych ankiet``

## Opis ##
Aplikacja do tworzenia prostych ankiet oraz glosowania, użytkownik ma możliwośc zagłosowania w trybie anonimowym oraz dodania ankiety z opisem i dowolna ilością pytań

## Działanie ##
* Obsluga uzytkownika
    * Panel logowania
    * Panel rejestracja
  
* Tworzenie ankiet
    * Dodawanie ankiet
    * Kasowanie ankiet
    * Dodawanie pytan
    * Podglad statystyk odpowiedzi
    
## Checklist
- [x] Rejestracja
- [x] Logowanie
- [x] Wylogowanie
- [ ] Dodwanie ankiety
- [ ] Dodawanie pytania
- [ ] Glosowanie
- [ ] Wyswietlanie statystyk
    
## Baza danych:
- instalacja: `sudo apt install mysql-server`
- uruchomienie konfiguracji: `sudo mysql_secure_installation`
- login: `sudo mysql --password`
- stworzenie bazy danych: `create database db_zajecia;`
- utworzenie użytkownia do bazy danych: `create user 'springuser'@'%' identified by 'springpassword';`
- nadanie przywilejów użytkownikowi: `grant all on db_zajecia.* to 'springuser'@'%';`
