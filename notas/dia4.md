# Orden de complejidad de un algoritmo

Cómo se degrada el rendimiento cuando trabajo con conjuntos de datos MAS GRANDES.
O(n)
O(n·log(n))

# Complejidad ciclomática

Número posible de caminos que puede tomar un software /función, método) al ejecutarse

condicion1 && condicion2                        tarea1 tarea2 tarea3
condicion1 && !condicion2 && condicion3         tarea1 tarea2 tarea4
condicion1 && !condicion2 && !condicion3        tarea1 tarea2

!condicion1 && condicion5 && condicion6                      tarea1 tarea5 tarea6
!condicion1 && condicion5 && !condicion6                     tarea1 tarea5 tarea7
!condicion1 && ! condicion5                                  tarea1 tarea8

    tarea1                          
    if condicion1:
        tarea2                      
        if condicion2:
            tarea3                     
        elseif condicion3:
            tarea4      : numero1/numero2               
    else if condicion5
        tarea5
        if condicion6:
            tarea6
        else:
            tarea7
    else
        tarea8
    
    Como poco hemos de hacer tantas pruebas a una función como su complejidad ciclomática

    SONARQUBE si una función tiene una complejidad ciclomática demasiado alta, me pedirá que la divida en varias funciones.

# Complejidad cognitiva

Cómo de difícil es para un ser humano entender un código

    switch(variable1):  
        caso 1
            tarea1
        caso 2
            tarea2
        caso 3
            tarea3
        caso 4
            tarea4
        caso 5
            tarea5
        otros casos
            tarea6

# Niveles de prueba

Pruebas unitarias               √               ? NO                                                    1
    vvv
Pruebas de integración          SI √            ? NO                                                    2
    vvv
Pruebas de sistema                  SI          √               x ? Que cojo nes??? esta pasando?       3








