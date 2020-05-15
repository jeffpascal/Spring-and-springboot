## Dockerized spring-boot and angular

Made a full stack dockerized application.

### Step by step instructions to start working

1. git clone https://github.com/jeffpascal/Spring-and-springboot/tree/testingcompose
2. cd font-app
3. npm install
4. cd SpringSecurity
5. mvn clean install
6. docker-compose up

Features:

1. Hot-reloading works on Angular app (refresh on save)
2. Dockerizized spring-boot [no-hot-reloading]

## TODO:

- move npm install in container for Angular
- move mvn clean install in container for Spring boot
- make hot-reloading work on spring-boot