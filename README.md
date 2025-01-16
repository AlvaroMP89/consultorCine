# Buscador de Información Cinematográfica 🎬📽️

Este proyecto es una aplicación diseñada para **buscar información cinematográfica** a partir del título de la película, el director o el actor principal. El objetivo es permitir a los usuarios realizar búsquedas utilizando **datos parciales** y, si existen varios resultados coincidentes, mostrar toda la información relevante. Si no se encuentra ninguna coincidencia, se notifica al usuario con un mensaje claro. La aplicación utiliza un archivo **XML**, estructurado y validado mediante un **DTD** para almacenar la información de las películas.

## Características 📋

- **Búsqueda Parcial**: Los usuarios pueden realizar búsquedas utilizando solo una parte del dato. Por ejemplo, no es necesario ingresar el nombre completo del director para encontrar una película.
- **Múltiples Resultados**: Si hay varias películas que coinciden con la búsqueda, se mostrará toda la información relacionada con ellas.
- **Mensaje de No Resultados**: Si no se encuentran coincidencias, aparecerá un mensaje explicativo indicando que no se han encontrado resultados.
- **Datos en XML**: La información de las películas se almacena en un archivo XML, validado por un archivo DTD, para garantizar que los datos estén bien estructurados.

## Estructura de Datos 📂

El proyecto maneja dos archivos esenciales para la gestión de los datos de las películas: un archivo **XML** y su respectivo archivo **DTD**.
