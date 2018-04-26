# androidjsondemo
Zadanie AsyncTask i JSON:

JSON wikipedia:
https://pl.wikipedia.org/wiki/JSON

AsyncTask:
https://developer.android.com/reference/android/os/AsyncTask

HttpURLConnection:
https://developer.android.com/reference/java/net/HttpURLConnection

GET i POST:
https://www.w3schools.com/tags/ref_httpmethods.asp


Otwórz projekt przykładowy AsyncTaskDemo,
Program łączy się z serwerem w oddzielnym wątku ( AsyncTask )
i pobiera 10 pierwszych obiektów typu JSON z danymi osób za pomocą HttpURLConnection ,
tworzy nowego użytkownika a następnie go usuwa.
 dodatkowo wyświetlając postęp w ProgressBar i TextView.

/**
 * Example :
 * {"id":1,"first_name":"Joshia","last_name":"Bruni","email":"jbruni0@free.fr","gender":"Male","ip_address":"129.135.147.239"},
 */

Program parsuje obiekt typu JSON z tablicy do objektu Javowego typu Person i wyświetla je w TextView.

Api na serwerze zapewnia kilka pożytecznych funkcji jak
filtorwanie, dodawanie, usuwanie osob.



Napisz podobną aplikację, która , będzie wyszukiwała osoby używając danych wypisywanych przez użytkownika ( id,  i/lub first_name i\lub last_name)
Danymi uzupełniała pola do wpisywania.
Wyświetlała w liście wszystkich użytkowników.

Aplikacja ma mieć umożliwić też tworzenie nowych użytkowników w jsonowej bazie na serwerze oraz ich usuwanie (po id)
