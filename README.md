# Actividad 3.1 - Árbol Binario de Búsqueda (BST)

Aplicación de escritorio desarrollada en Java (Swing) que implementa un Árbol Binario de Búsqueda para administrar empleados. La clave de ordenamiento es el ID del empleado.

## Funcionalidades

- Crear el árbol.
- Insertar, buscar y eliminar empleados (clave: ID).
- Recorridos InOrden, PreOrden y PostOrden.
- Cálculo de la amplitud máxima (mayor cantidad de nodos en un nivel).
- Cálculo de la profundidad máxima del árbol.
- Balanceo del árbol conservando todos los empleados.
- Destruir el árbol.
- Visualización gráfica de la estructura del árbol.

## Estructura del proyecto

- `src/back_end`: lógica del árbol binario de búsqueda.
  - `Empleado.java`: registro con los datos del empleado.
  - `NodoABB.java`: nodo del árbol.
  - `ArbolBusqueda.java`: operaciones del árbol (inserción, búsqueda, eliminación, recorridos, amplitud, profundidad y balanceo).
- `src/front_end`: interfaz gráfica de usuario.
  - `Main.java`: punto de entrada de la aplicación.
  - `VentanaPrincipal.java`: ventana principal con los formularios y botones.
  - `VistaArbolPanel.java`: panel con la representación visual del árbol.

## Ejecución

Compilar las clases de `src/back_end` y `src/front_end` y ejecutar `front_end.Main`.

## Integrantes del equipo

- Geovani Gael Carmona Barbosa
- Victor Manuel Leyva Perez
- Manuel Angel Ezpinosa Lopez
