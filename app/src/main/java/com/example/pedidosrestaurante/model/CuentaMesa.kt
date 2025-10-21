package com.example.pedidosrestaurante.model

import java.text.NumberFormat
import java.util.Locale

class CuentaMesa(
    private val pedidos: List<ItemMesa>,
    private val AceptaPropina: Boolean
) {
    fun calcularTotalSinPropina(): Int {
        return pedidos.sumOf { it.calcularSubtotal() }
    }

    fun calcularPropina(): Int {
        return if (AceptaPropina) (calcularTotalSinPropina() * 0.1).toInt() else 0
    }

    fun calcularTotalFinal(): Int {
        return calcularTotalSinPropina() + calcularPropina()
    }

    fun formatearPesos(valor: Int): String {
        val formato = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
        return formato.format(valor)
    }
}
