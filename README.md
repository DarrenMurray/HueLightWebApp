# HueLightWebApp
Research into philips hue Java sdk.

### Launch App from Terminal

Run the following from base directory
```
mvn clean install
mvn spring-boot:run
```

Go to localhost:8080 in your browser

---

### Test API

#### Test Lights on Request

```
curl -X POST \
  http://localhost:8080/api/LightsOn \
  -H 'cache-control: no-cache' \
  -H 'postman-token: ed0b7f3c-c958-047b-b053-b74f7c6c1e5a'
```

#### Test Lights off Request

```
curl -X POST \
  http://localhost:8080/api/LightsOff \
  -H 'cache-control: no-cache' \
  -H 'postman-token: ed0b7f3c-c958-047b-b053-b74f7c6c1e5a'
```

## Author
Darren Murray

