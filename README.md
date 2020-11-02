# intelsisLatam

java version : JavaSE-1.8

Instrucciones de instalación despliegue local en windows:
1. clonar proyecto en directorio windows a eleccion  : 
git clone https://github.com/pmenesesse/intelsisLatam.git

En directorio raiz del proyecto ejecutar : 
mvnw package

se generará dentro del directorio ./target un archivo de extension <nombre_proyecto>.jar,el cual, se debe ejecutar con java -jar

Ejemplo : 
java -jar /target/intelsisLatam-0.0.1-SNAPSHOT.jar
 
se desplegará localmente en el puerto 8084, si requiere cambio de puerto debe editar: 
intelsisLatam\src\main\resources\application.properties -> server.port = 8084
