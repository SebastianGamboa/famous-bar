# famous-bar

Local installation

You need Java 11 installed

Clone
--------

```sh
git clone https://github.com/SebastianGamboa/famous-bar.git
```

Project folder
--------

```sh
cd famous-bar
```

Run
--------

```sh
./gradlew bootRun
```

Access
--------

### GET Method

```
http://localhost:8080/api/stack/:iterations/:stackId
```

Example request:

```
http://localhost:8080/api/stack/3/1
```

Try on the server
--------

```
https://famous-bar.herokuapp.com/api/stack/:iterations/:stackId
```
