# Comparador CSV Productos

Aplicación Java para cargar, revisar y preparar la comparación de productos entre archivos CSV procedentes de un ERP interno y PrestaShop.

## Desarrollador

Gabriel Acaro Sánchez

## Descripción general

El programa está pensado para trabajar con listados de productos exportados desde distintos sistemas y facilitar su revisión antes de realizar comparaciones automáticas.

Actualmente permite cargar productos desde CSV, convertir los datos a objetos Java, revisar la información cargada y mostrar productos por consola de forma completa o filtrada por intervalos de filas y columnas.

El objetivo final es poder detectar productos equivalentes entre ERP y PrestaShop, confirmar coincidencias manualmente, generar códigos comunes y exportar resultados revisados.

## Tecnologías y lenguajes utilizados

- Java
- Ant
- NetBeans
- CSV
- Consola

Tecnologías previstas a futuro:

- Maven
- JavaFX

## Estructura del proyecto

```text
ComparadorCSVProductos/
├── data/
│   ├── entrada/
│   └── salida/
│
├── src/
│   └── main/
│       └── java/
│           └── main/java/com/carriloutdoor/comparadorcsvproductos/
│               ├── Main.java
│               ├── config/
│               ├── model/
│               ├── service/
│               ├── ui/
│               └── util/
│
├── build.xml
└── README.md
```

## Carpetas principales

### `data/`

Contiene los archivos de entrada y salida del programa.

- `entrada/`: archivos CSV originales.
- `salida/`: futuros archivos generados o exportados.

### `config/`

Contiene configuración general y futuras reglas de comparación.

### `model/`

Contiene las clases que representan los datos principales del programa.

Modelos principales:

- `ProductoERP`
- `ProductoPrestaShop`
- `Coincidencia`
- `Vinculacion`

### `service/`

Contiene la lógica principal del programa.

Servicios principales:

- `CsvService`
- `InformeResultadoService`
- `BuscadorProductosService`
- `ComparadorProductoService`
- `GeneradorCodigoService`
- `GestorVinculacionService`
- `NormalizadorService`

### `ui/`

Carpeta prevista para la futura interfaz gráfica.

Actualmente el programa funciona por consola.

### `util/`

Contiene clases auxiliares para validaciones, tratamiento de texto y utilidades generales.

## Funcionalidades completadas

- Lectura de archivos CSV.
- Separación correcta de columnas respetando comillas.
- Soporte para campos con comas internas.
- Detección básica del tipo de CSV.
- Conversión de filas CSV a objetos `ProductoERP`.
- Conversión de filas CSV a objetos `ProductoPrestaShop`.
- Carga de productos en listas.
- Menú de consola.
- Visualización completa de productos ERP.
- Visualización completa de productos PrestaShop.
- Visualización por intervalo de filas.
- Visualización por intervalo de columnas.

## Funcionalidades pendientes

- Crear resumen de calidad de carga.
- Validar EAN.
- Detectar EAN en notación científica.
- Normalizar nombres, referencias y códigos.
- Separar atributos de PrestaShop.
- Decidir si se añade stock a `ProductoPrestaShop`.
- Crear buscador de productos.
- Crear comparador de coincidencias.
- Confirmar coincidencias manualmente.
- Generar códigos comunes para productos equivalentes.
- Exportar resultados revisados.
- Crear interfaz gráfica.
- Migrar el proyecto a Maven.

## Objetivo actual

El objetivo actual del desarrollo es consolidar la carga, revisión y visualización de datos antes de empezar con la comparación avanzada.

Prioridades actuales:

1. Cargar correctamente los CSV.
2. Revisar productos cargados.
3. Mostrar información por filas y columnas.
4. Crear resumen de calidad de datos.
5. Validar datos básicos.

## Objetivo futuro

El objetivo futuro del programa es comparar productos entre ERP y PrestaShop siguiendo distintos criterios:

1. Coincidencia por EAN válido.
2. Coincidencia por referencia.
3. Coincidencia por código ERP contra referencia PrestaShop.
4. Coincidencia por nombre normalizado.
5. Coincidencia por nombre y marca.
6. Coincidencia por nombre y atributos.
7. Coincidencia débil por palabras comunes.

El sistema deberá permitir revisar coincidencias manualmente, confirmar productos equivalentes y exportar resultados finales.

## Estado del proyecto

Proyecto en desarrollo.

Fase actual:

```text
Carga CSV + diagnóstico + visualización básica de datos
```

Todavía no se ha iniciado la comparación avanzada de productos.