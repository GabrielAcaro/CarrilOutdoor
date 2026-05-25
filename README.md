# Comparador CSV Productos

Aplicación Java para cargar, revisar y preparar la comparación de productos entre archivos CSV procedentes de un ERP interno y PrestaShop.

## Desarrollador

Gabriel Acaro Sánchez

## Descripción general

El programa está pensado para trabajar con listados de productos exportados desde distintos sistemas y facilitar su revisión antes de realizar comparaciones automáticas.

Actualmente permite cargar productos desde CSV, convertir los datos a objetos Java, revisar la información cargada y mostrar productos por consola de forma completa o filtrada por intervalos de filas y columnas.

El objetivo final es detectar productos equivalentes entre ERP y PrestaShop, confirmar coincidencias manualmente, generar códigos comunes y exportar resultados revisados.

## Tecnologías utilizadas

- Java 21
- Maven
- CSV

Tecnología prevista a futuro:

- JavaFX

## Estructura del proyecto

```text
ComparadorCSVProductos/
├── data/
│   ├── entrada/
│   └── salida/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/carriloutdoor/comparadorcsvproductos/
│   │   │       ├── Main.java
│   │   │       ├── config/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       ├── ui/
│   │   │       └── util/
│   │   │
│   │   └── resources/
│   │
│   └── test/
│       └── java/
│           └── com/carriloutdoor/comparadorcsvproductostest/
│
├── pom.xml
├── .gitignore
└── README.md
```

## Paquete base

```text
com.carriloutdoor.comparadorcsvproductos
```

## Directorios principales

- `data/entrada/`: archivos CSV originales de entrada.
- `data/salida/`: futuros archivos generados o exportados.
- `src/main/java/`: código fuente principal.
- `src/main/resources/`: recursos del proyecto.
- `src/test/java/`: pruebas del proyecto.
- `target/`: carpeta generada automáticamente por Maven al compilar.

Los archivos CSV reales no se suben al repositorio Git.

## Capas del proyecto

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

Contiene las clases relacionadas con la interacción del usuario.

Actualmente el programa funciona por consola.

### `util/`

Contiene clases auxiliares para validaciones, tratamiento de texto y utilidades generales.

## Compilación

Para compilar el proyecto desde consola:

```bash
mvn clean compile
```

## Ejecución

Actualmente el programa se ejecuta desde la clase principal:

```text
src/main/java/com/carriloutdoor/comparadorcsvproductos/Main.java
```

## Funcionalidades completadas

- Migración del proyecto a Maven.
- Estructura estándar compatible con distintos IDE.
- Uso de Java 21.
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
- Crear interfaz gráfica con JavaFX.

## Objetivo actual

El objetivo actual del desarrollo es consolidar la carga, revisión y visualización de datos antes de empezar con la comparación avanzada.

Prioridades actuales:

1. Cargar correctamente los CSV.
2. Revisar productos cargados.
3. Mostrar información por filas y columnas.
4. Crear resumen de calidad de datos.
5. Validar datos básicos.
6. Normalizar datos relevantes.

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
Carga CSV + diagnóstico + visualización básica de datos + migración a Maven
```

Todavía no se ha iniciado la comparación avanzada de productos.