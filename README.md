
# Proyecto1SO
![Java](https://usemoslinux.net/wp-content/uploads/2016/01/Java-Netbeans.png)

## Proyecto para el curso Sistemas Operativos de la Escuela de Ingenieria Sistemas de la Universidad Metropolitana de Caracas

![Java2](https://club28blog.files.wordpress.com/2018/01/imagen1.png)

## Enunciado del Proyecto


### Proyecto 1
Una importante compañía de videojuegos lo ha contratado para realizar una modelación de la fabricación de sus sistemas de videojuegos. Para ello, se le pide que realice un programa en Java, que haga uso de hilos, semáforos y las soluciones conocidas a los problemas de productor/consumidor y lector/escritor. 
Durante el proceso de fabricación se requieren dos tipos de empleados:
#### 1.	Productores: Encargados de producir las distintas partes necesarias para vender una consola. Es necesario mencionar que tienen a su disposición almacenes de capacidades finitas en los que guardan las piezas una vez están listas. Antes de producir una pieza, un productor comprueba si existe espacio en el almacén para guardarla. Existen tres grupos de productores:

##### a.	Productores de controles: A un productor le toma 1 día producir un control. El almacén que disponen cuenta con una capacidad inicial de 30 unidades. Por normativa de la compañía, puede haber un máximo de 5 productores de controles en la fábrica, con una cantidad inicial de 3 productores.

##### b.	Productores de consola: A un productor le toma 3 días producir 1 consola. El almacén que disponen cuenta con una capacidad inicial de 20 unidades. Por normativa de la compañía, puede haber un máximo de 10 productores de consolas en la fábrica, con una cantidad inicial de 2 productores.

##### c.	Productores de paquetes: A un productor le toma 1 días producir 1 paquete. El almacén que disponen cuenta con una capacidad inicial de 40 unidades. Por normativa de la compañía, puede haber un máximo de 3 productores de paquetes en la fábrica, con una cantidad inicial de 1 productor.

##### 2.	Ensambladores: Estos empleados tienen la responsabilidad de armar el producto final, para que luego sea despachado de la fábrica. Para ello toman 2 controles, 1 consola y 1 paquete de los respectivos almacenes. Una vez obtenidas todas las piezas, a un ensamblador le toma 2 días realizar su trabajo. Al terminar, el ensamblador tiene la responsabilidad de aumentar el contador de unidades disponibles y guardarla junto a las demás. Puede haber un máximo de 4 ensambladores en la compañía.

Además, la fábrica cuenta también con: 

##### 3.	Cronometrador: La única tarea del cronometrador es registrar el paso de los días. El cronometrador posee un contador inicializado en el número de días que faltan para el despacho. Cada día, el cronometrador disminuye su contador en una unidad, lo que le toma 1,2 horas. Si hay alguien leyendo el contador cuando el cronometrador va a modificarlo, él debe esperar a que el lector termine. Cuando el contador vaya a pasar el valor 0, el cronometrador lo reinicializa. Hay solo 1 cronometrador en la compañía y solo 1 contador. El resto del tiempo, el cronometrador está dormido.

##### 4.	Gerente: Cada día se dirige al contador, para verificar cuantos días faltan para el despacho. Si el cronometrador está modificando el contador en ese momento, el gerente espera a que él termine antes de leer. Si el contador es distinto a 0, el gerente va a dormir, por un período aleatorio entre 6 y 18 horas. Si el contador es igual a 0, el gerente manda a despachar las unidades finales disponibles, reinicializando el contador.
Su programa deberá hacer uso de una interfaz gráfica que permita observar y controlar el sistema. Se debe poder conocer en cualquier momento:
•	La cantidad de productores de cada tipo.
•	La cantidad de controles, consolas y paquetes disponibles en el almacén.
•	La cantidad de ensambladores.
•	La cantidad de unidades finales disponibles.
•	Los días que faltan para el despacho.
•	Qué está haciendo el cronometrador.
•	Qué estás haciendo el gerente.
•	Cualquier otro dato que considere relevante.
La simulación debe permitir, en tiempo de ejecución:
•	Contratar o despedir un productor de cualquiera de los tres tipos.
•	Contratar o despedir un ensamblador.
Además, a través de un archivo (el tipo de archivo queda a elección del estudiante), se le debe poder indicar al programa los siguientes parámetros:
•	Tiempo, en segundos, que dura un día en el programa.
•	Cantidad de días entre despachos.
•	La capacidades máximas para cada tipo de almacenes (No tome en cuenta el almacén de los productos finales, para efectos de la simulación se considerará capaz de contener cualquier cantidad de sistemas de videojuegos)
•	La cantidad inicial de productores de cada tipo.
•	La cantidad máximo de productores de cada tipo.
•	La cantidad inicial de ensambladores.
•	La cantidad máxima de ensambladores.


# Implementacion en java
![Java2](https://club28blog.files.wordpress.com/2018/01/imagen1.png)



