package com.atividade.appMain.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Calc {

    private static List<Integer> numerosInseridos;

    @PostMapping("/calc")
    public static String calcular(@RequestBody List<Integer> numeros) {

        numerosInseridos = numeros;
        return "Números inseridos!" + "\n" + "Números inseridos: " + numerosInseridos.size() + " " +  numeros;
    }

    @GetMapping("/result")
    public String obterResultados() {
        if (numerosInseridos == null || numerosInseridos.isEmpty()) {
            return "Nenhum número foi inserido ainda.";
        }

        int somaNumeros = numerosInseridos.stream().mapToInt(Integer::intValue).sum();
        int totalNumeros = numerosInseridos.size();
        double media = (double) somaNumeros / totalNumeros;
        double desvioPadrao = calcDesvioPadrao(numerosInseridos, media);
        double mediana = calcMed(numerosInseridos);

        return "Números: " + numerosInseridos +
                "\nNúmero de dados: " + totalNumeros +
                "\nMédia: " + String.format("%.3f", media) +
                "\nDesvio Padrão: " + String.format("%.3f", desvioPadrao) +
                "\nMediana: " + mediana;
    }

    private double calcDesvioPadrao(List<Integer> numeros, double media) {
        double somaDiferencasQuadrado = 0;

        for (int numero : numeros) {
            double diferenca = numero - media;
            somaDiferencasQuadrado += diferenca * diferenca;
        }

        double variancia = somaDiferencasQuadrado / numeros.size();
        return Math.sqrt(variancia);
    }

    private double calcMed(List<Integer> numeros) {
        Collections.sort(numeros);
        int tamanho = numeros.size();

        if (tamanho % 2 == 0) {
            int indice1 = tamanho / 2 - 1;
            int indice2 = tamanho / 2;
            return (numeros.get(indice1) + numeros.get(indice2)) / 2.0;
        } else {
            int indice = tamanho / 2;
            return numeros.get(indice);
        }
    }
}