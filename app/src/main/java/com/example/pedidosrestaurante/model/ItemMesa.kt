package com.example.pedidosrestaurante.model

data class ItemMesa(
    val platillo: ItemMenu,
    var cantidad: Int
) {
    fun calcularSubtotal(): Int {
        return platillo.Precio * cantidad
    }
}
