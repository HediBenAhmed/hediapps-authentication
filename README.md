Hediapps-authentification


docker run --network mynet --ip 172.28.5.100 -p 3306:3306 mysql/mysql-server:5.7 
docker run --network mynet --ip 172.28.5.12 -p 8081:8081 hediapps/authentication
