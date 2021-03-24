## JUEGO DE LA VIDA 

![Copyright.png](Copyright.png)

*Copyright [2021] [Daniel Fernández López]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at*

    http://www.apache.org/licenses/LICENSE-2.0

*Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*

# Creador: 

* Daniel Fernández López 

# Práctica 2: 

El objetivo de esta práctica es poder implementar a partir de una matriz cuadrada de 30x30 el Juego de la Vida. Durante el proceso se ha de tener en cuenta las siguientes reglas:  

* Si una célula está viva y dos o tres de sus vecinas también lo están, entonces continúa viva en el estado siguiente.
* Si una célula está muerta y tres de sus vecinas están vivas, entonces pasa a estar viva en el estado siguiente.
* El resto de células pasan a estar muertas en el estado siguiente.
# Funcionamiento: 

En primer lugar, asegúrese de que se encuentra en la carpeta correcta, para ello utilice los comandos "ls" (para ver donde se encuentra) y "cd Juego-vida" (para acceder a la carpeta de la práctica) en el terminal. Una vez dentro proceda a ejecutar los siguientes comandos:

* Para compilar y crear el JAR: "mvn compile assembly:single"

* Para ejecutar:"java -jar target/Juego-Vida-1.0-SNAPSHOT-jar-with-dependencies.jar"

<p align = "center">
<img width = "800" height = "400" src = "GameOfLive.gift">
</p>