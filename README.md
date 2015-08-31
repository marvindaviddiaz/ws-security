# README #

La configuracion de wss4j, permite que cada cliente utilice su propio key-pair(unico por cliente), y el servidor utilice un mismo key-pair para responder a todos los usuarios.

### Intercambio de llaves ###

* El cliente debe tener la llave publica del server
* El server debe tener la llave publica de todos los clientes