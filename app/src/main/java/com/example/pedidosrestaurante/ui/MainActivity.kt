package com.example.pedidosrestaurante.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pedidosrestaurante.R
import com.example.pedidosrestaurante.model.CuentaMesa
import com.example.pedidosrestaurante.model.ItemMesa
import com.example.pedidosrestaurante.model.ItemMenu

class MainActivity : AppCompatActivity() {

    private lateinit var inputCantidadPastel: EditText
    private lateinit var inputCantidadCazuela: EditText
    private lateinit var switchPropina: Switch

    private lateinit var textSubtotalPastel: TextView
    private lateinit var textSubtotalCazuela: TextView
    private lateinit var textTotalSinPropina: TextView
    private lateinit var textMontoPropina: TextView
    private lateinit var textTotalFinal: TextView
git
    private val pastel = ItemMenu("Pastel de Choclo", 12000)
    private val cazuela = ItemMenu("Cazuela", 10000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vincular vistas
        inputCantidadPastel = findViewById(R.id.inputCantidadPastel)
        inputCantidadCazuela = findViewById(R.id.inputCantidadCazuela)
        switchPropina = findViewById(R.id.switchPropina)

        textSubtotalPastel = findViewById(R.id.textSubtotalPastel)
        textSubtotalCazuela = findViewById(R.id.textSubtotalCazuela)
        textTotalSinPropina = findViewById(R.id.textTotalSinPropina)
        textMontoPropina = findViewById(R.id.textMontoPropina)
        textTotalFinal = findViewById(R.id.textTotalFinal)

        // Eventos
        inputCantidadPastel.addTextChangedListener(watcher)
        inputCantidadCazuela.addTextChangedListener(watcher)
        switchPropina.setOnCheckedChangeListener { _, _ -> actualizarMontos() }

        actualizarMontos()
    }

    private val watcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            actualizarMontos()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun actualizarMontos() {
        val cantidadPastel = inputCantidadPastel.text.toString().toIntOrNull() ?: 0
        val cantidadCazuela = inputCantidadCazuela.text.toString().toIntOrNull() ?: 0

        val pedidoPastel = ItemMesa(pastel, cantidadPastel)
        val pedidoCazuela = ItemMesa(cazuela, cantidadCazuela)

        val calculadora = CuentaMesa(listOf(pedidoPastel, pedidoCazuela), switchPropina.isChecked)

        textSubtotalPastel.text = "Subtotal: ${calculadora.formatearPesos(pedidoPastel.calcularSubtotal())}"
        textSubtotalCazuela.text = "Subtotal: ${calculadora.formatearPesos(pedidoCazuela.calcularSubtotal())}"
        textTotalSinPropina.text = "Total sin propina: ${calculadora.formatearPesos(calculadora.calcularTotalSinPropina())}"
        textMontoPropina.text = "Propina: ${calculadora.formatearPesos(calculadora.calcularPropina())}"
        textTotalFinal.text = "Total a pagar: ${calculadora.formatearPesos(calculadora.calcularTotalFinal())}"
    }
}