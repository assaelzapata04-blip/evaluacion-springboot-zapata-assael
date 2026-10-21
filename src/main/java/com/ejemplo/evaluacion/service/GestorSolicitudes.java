package com.ejemplo.evaluacion.service;

import com.ejemplo.evaluacion.model.Solicitud;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.springframework.stereotype.Component;

@Component
public class GestorSolicitudes {

    private final List<Solicitud> lista = new ArrayList<>();
    private final Queue<Solicitud> cola = new LinkedList<>();
    private final Stack<Solicitud> historial = new Stack<>();

    public void agregar(Solicitud s) {
        lista.add(s);
        cola.add(s);
        historial.push(s);
    }

    public Solicitud procesarSiguiente() {
        Solicitud s = cola.poll();
        if (s != null) {
            s.setEstado("PROCESADA");
        }
        return s;
    }

    public List<Solicitud> verHistorial() {
        List<Solicitud> recientes = new ArrayList<>();
        Stack<Solicitud> copia = new Stack<>();
        copia.addAll(historial);
        int contador = 0;
        while (!copia.isEmpty() && contador < 5) {
            recientes.add(copia.pop());
            contador++;
        }
        return recientes;
    }

    public Solicitud buscarPorDescripcion(String texto) {
        for (Solicitud s : lista) {
            if (s.getDescripcion().contains(texto)) {
                return s;
            }
        }
        return null;
    }

    public String mensajeEstado(String estado) {
        switch (estado) {
            case "PENDIENTE":
                return "En espera";
            case "PROCESADA":
                return "Atendida";
            default:
                return "Desconocido";
        }
    }

    public List<Solicitud> ordenadas() {
        List<Solicitud> copia = new ArrayList<>(lista);
        copia.sort(Comparator.comparing(Solicitud::getDescripcion));
        return copia;
    }
}