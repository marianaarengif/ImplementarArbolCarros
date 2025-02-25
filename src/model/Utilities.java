package model;

import model.Carro; 

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utilities {

    private static final String ARCHIVO_JSON = "carros.json";

    public static void guardarJSON(List<Carro> listaCarros) {
        JSONArray jsonArray = new JSONArray();

        for (Carro carro : listaCarros) {
        JSONObject obj = new JSONObject();
        obj.put("marca", carro.getMarca());
        obj.put("modelo", carro.getModelo());
        obj.put("color", carro.getColor());
        obj.put("placa", carro.getPlaca());
        obj.put("precio", carro.getPrecio());

        jsonArray.put(obj);
    }

        try (FileWriter file = new FileWriter(ARCHIVO_JSON)) {
            file.write(jsonArray.toString(4)); 
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String cargarJSON() {
        File archivo = new File(ARCHIVO_JSON);
        if (!archivo.exists()) {
            return "El archivo JSON no existe.";
        }

        try {
            String contenido = new String(Files.readAllBytes(Paths.get(ARCHIVO_JSON)));
            return contenido; 
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al cagar el archivo JSON.";
        }
    }
}
