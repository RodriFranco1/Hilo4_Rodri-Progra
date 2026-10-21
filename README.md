El programa simula varios vehículos que quieren usar unas pistas de pruebas, pero hay menos pistas que vehículos. La clase Pistas es el recurso compartido: guarda qué pistas están libres y cuáles ocupadas. 
Cuando un vehículo quiere entrar, comprueba si hay alguna libre; si la hay, la ocupa y empieza su prueba. Si no hay ninguna, se queda esperando con wait(). 
Cuando un vehículo termina, libera su pista con salir() y avisa a los demás con notifyAll(), para que los que estaban esperando puedan intentar entrar otra vez. 
Se usa while porque, al despertarse, un vehículo debe volver a comprobar que realmente queda una pista libre, ya que otro podría habérsela quitado. 
Los métodos entrar() y salir() son synchronized para que dos vehículos no modifiquen las pistas a la vez. 
Así, los cuatro vehículos de Main se turnan automáticamente y cada uno usa una pista sin problemas.
