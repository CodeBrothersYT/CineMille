# Cinemille Application

## Descrizione

L'applicazione Cinemille consente di visualizzare una lista di film tramite un'interfaccia utente intuitiva. Cliccando su "Home" si possono visualizzare i film disponibili, mentre cliccando su "Movies History" si può accedere allo storico dei film andati in onda.

## Endpoint Disponibili

- `/api/v1/movies`: Questo endpoint consente di visualizzare la lista di film mediante una richiesta GET.
- `/api/v1/movies/history`: Questo endpoint consente di visualizzare lo storico dei film.
- `/api/v1/movies/import`: Questo endpoint consente di effettuare l'import dei film tramite un file CSV.

## Avvio dell'applicazione

Per avviare la parte frontend, eseguire lo script `$ npm start` dalla directory CineMilleFE.

Per avviare la parte backend, lanciare l'applicazione Spring Boot eseguendo il plugin `$ spring-boot:run`.

