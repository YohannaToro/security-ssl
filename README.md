# Servidor  SSL

## objetivo: 
establecer conexion entre dos servidores para garantizar autenticación, autorización e integridad de usuarios.

## conexion ssl entre cliente y servidor:

![Captura](https://www.ibm.com/support/knowledgecenter/en/SSZHJ2_9.1.0/securing/graphics/hndshake.jpg)
1. Un cliente intenta acceder a https://localhost:4567/secureServer

2. El servidor responde proporcionando un certificado SSL (que se almacena en su keyStore con nombre (serverKeystore.jks))

3. El cliente recibe el certificado SSL y lo verifica a través de trustStore (es decir, el trustStore del cliente ya tiene un conjunto de certificados predefinidos en los que confía). 

4. despues de la verificacion por parte del cliente se establece  la comunicación SSL a través de una clave secreta compartida.

### Pre-requisitos

Es necesario tener instalado:


```
*  Maven 3.6 en caso de no tener istalado maven siga el siguiente tutorial dependiendo del sistema operativo que posea https://maven.apache.org/install.html
* Java 1.8 si no tiene instalado java en su dispositivo siga el sigueinte tutorial https://java.com/en/download/help/download_options.xml
* Git tutorial: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
* Spark 
```

## Instalaciòn y ejecucion del proyecto

### De forma local
Descargue el repositorio lo puede realizar de dos formas descargando el .zip o usando git 

En caso de usar git la linea de comando para clonar el repositiorio es:

```
git clone https://github.com/YohannaToro/security-ssl
```



## Built With
* [Maven](https://maven.apache.org/) - Dependency Management


## Autor

* **Yohanna Toro**  - [YohannaToro](https://github.com/YohannaToro)


## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details





Simple example showing how to set up SSL with [Spark](http://sparkjava.com)
