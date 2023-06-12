# Hotel-Booking
Hotel Booking: Tablas de Dispersión (Hash Tables) y Árboles Binarios de Búsqueda.
El problema:
Un reconocido Hotel de la Ciudad ha contratado a su equipo de trabajo para construir un sistema en Java para la administración de las reservas.  El sistema deberá implementar una solución con uso eficiente de los recursos del computador.  


Requerimientos funcionales:
1. Registro de clientes. El usuario podrá conocer los clientes que actualmente se encuentran hospedados en el hotel; para lo cual se deberá introducir el apellido del cliente y el nombre, para luego obtener el número de la habitación en la que se encuentra alojado. La solución para tal requerimiento deberá tener una complejidad en tiempo lo más cercano posible a O(1). 
2. Búsqueda de reservación: Dada la cédula de identidad del cliente, el recepcionista podrá conocer los datos de la reservación, en caso de existir.  La solución para tal requerimiento deberá tener una complejidad en tiempo de O(log N).
3. Historial de habitación: dado el número de una habitación, el sistema emitirá una lista de los clientes que alguna vez se hospedaron en ella.  La solución para tal requerimiento deberá tener una complejidad en tiempo lo más cercado a O(log N). Deberá utilizar un ABB.
4. Check-in: Un cliente con reservación llega para comenzar su estadía. En ese momento el recepcionista le asignará una habitación de manera que la reservación para al registro de los huéspedes del hotel. 
5. Check-out: Al terminar su estadía, el recepcionista cierra el registro del cliente, quedando libre la habitación y actualizándose el historial de la habitación utilizada. 
