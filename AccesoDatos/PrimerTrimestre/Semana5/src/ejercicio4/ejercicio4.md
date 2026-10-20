# Ejercicio 4 - Semana 5

## Ficheros para la práctica: [JSON](productos.json) - [XML](productos.xml)

- ### Enunciado 3:

  Tamaño: Son ambos de un tamaño similar, el JSON es 6 líneas más largo debido a como está estructurado. En cuanto a espacio en disco, el JSON es más ligero (739 bytes), mientras que el XML ocupa algo más (910 bytes).

  Legibilidad: Ambos son legibles, aunque el XML es más fácil de leer, pues necesita de etiquetas en todos los datos, mientras que en JSON se declara el contenido dentro de corchetes sin necesidad de declarar un nombre.

  Representación de listas y objetos: Las listas en XML se declaran dentro de una etiqueta, en este caso `<productos>`, mientras que en JSON van dentro de un array `"productos": [ ... ]`. En el caso de los objetos, en XML van dentro de etiquetas `<producto codigo="n">` con el código como atributo y el resto de atributos como elementos hijos, mientras que en JSON se declaran dentro de corchetes `{ ... }` y los atributos dentro de los corchetes como pares Clave-Valor `"codigo": n, ...`

  Facilidad de modificación: Ambos formatos son fácilmente modificables, en JSON se modifican los pares Clave-Valor y en XML los Elementos y Atributos

- ### Enunciado 4:

  API Web: Escogería un JSON, son más ligeros y contienen datos primitivos (número, array, cadena, booleano), facilitando la lectura en código, pues ya existen y no hacen falta convertirlos, como sería necesario en un XML.

  Documento Muy Marcado: Usaría un XML, pues aprovecharía el marcaje para convertirlo en las etiquetas del XML.

  Archivo de Configuración: Para este caso seleccionaría un JSON, pues cada opción tiene un valor asociado, y es fácilmente aplicable en un formato Clave-Valor.

  Intercambio Entre Aplicaciones: Usaría el más compatible si una aplicación ya tiene uno (XML o JSON). Si no existe, utilizaría JSON, pues es más ligero y tiene los datos ya asociados a una clave.
