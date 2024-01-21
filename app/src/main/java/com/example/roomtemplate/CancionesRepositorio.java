package com.example.roomtemplate;

import java.util.ArrayList;
import java.util.List;

public class CancionesRepositorio {
    List<Canciones> canciones = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Canciones> canciones);
    }

    CancionesRepositorio(){
        canciones.add(new Canciones("Mil preguntas", "Marina Reche"));
        canciones.add(new Canciones("Guerrera", "Dellafuente"));
        canciones.add(new Canciones("Meu Amore", "Sen Senra"));
        canciones.add(new Canciones("Lo Sabía", "Babi"));
        canciones.add(new Canciones("Emocional", "Dani Martín"));
        canciones.add(new Canciones("Hundido", "Marc Seguí"));
        canciones.add(new Canciones("La Pared", "Cupido"));
        canciones.add(new Canciones("Badtrip :(", "Mora"));
    }

    List<Canciones> obtener() {
        return canciones;
    }

    void insertar(Canciones canciones, Callback callback){
        this.canciones.add(canciones);
        callback.cuandoFinalice(this.canciones);
    }

    void eliminar(Canciones canciones, Callback callback) {
        this.canciones.remove(canciones);
        callback.cuandoFinalice(this.canciones);
    }

}

