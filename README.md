# How to run server

## Run PostgreSQL
- Start docker
- Open terminal
```frontend
cd server
docker-compose -f dev.yml up
```
## Run Spring boot
- Click ServerApplication.java file in path trip-me/server/src/main/java/com/example/server/ServerApplication.java
- Run java spring boot

# How to run Front-End

## Run ReactJS
- New terminal
```frontend
cd trip-me-front
yarn install
yarn start
```
> **Note:** my node version use v20.17.0

## Example URL
- http://localhost:3000/trips
- http://localhost:3000/trips?keyword=ที่เที่ยว
