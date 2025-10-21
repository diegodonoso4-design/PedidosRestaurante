# PedidosRestaurante

Aplicación educativa desarrollada en Android Studio que simula el cálculo de pedidos en un restaurante chileno. Permite seleccionar platos típicos, ingresar cantidades, visualizar subtotales y aplicar una propina opcional.

---

## Estructura del proyecto

El proyecto está organizado en dos paquetes principales:

- `model`: contiene la lógica de negocio y cálculo.
- `ui`: gestiona la interfaz y eventos del usuario.

---

## Interfaz

La interfaz fue construida con `ConstraintLayout` e incluye:

- Imágenes de platos típicos (Pastel de Choclo y Cazuela).
- Campos de entrada para cantidades (`EditText`).
- Switch para activar propina.
- TextViews para mostrar subtotales, total sin propina, propina y total final.

---

## Lógica funcional

La lógica está encapsulada en clases modelo:

- `ItemMenu`: representa un platillo con nombre y precio.
- `ItemMesa`: representa un pedido individual.
- `CuentaMesa`: calcula totales y propina.

---

## Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/PedidosRestaurante.git
2. Abre el proyecto en Android Studio.
3. Compila y ejecuta en un emulador o dispositivo físico.
   

