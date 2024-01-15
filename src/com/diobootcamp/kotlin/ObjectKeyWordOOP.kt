package com.diobootcamp.kotlin

object ReceitaFederal {
    fun calcularImposto(salario: Double): Double {
        val aliquota = when {
            (salario >= 0.0 && salario <= 1100.0) -> 0.05;
            (salario > 1100.0 && salario <= 2500.0) -> 0.10;
            (salario > 2500.0) -> 0.15;
            else -> 0.0;
        }
        return salario * aliquota
    }
}

fun main() {
    val valorSalario = readLine()!!.toDouble();
    val valorBeneficios = readLine()!!.toDouble();

    val valorImposto = ReceitaFederal.calcularImposto(valorSalario);
    val saida = valorSalario - valorImposto + valorBeneficios;

    println(String.format("%.2f", saida));
}