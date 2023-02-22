package com.example.gestionvuelos.services;

import com.example.gestionvuelos.entity.Vuelos;

import java.util.List;

public interface VueloService {

    //Listar todos los vuelos
    public List<Vuelos> getAllVuelos();

    //Vuelos por origen
    public List<Vuelos> getVuelosByOrigen(String origen);

    //vuelos pro destino
    public List<Vuelos> getVuelosByDestino(String destino);

    //Vuelos por escalas
    public List<Vuelos> getVuelosByNum_escalas(int escalas);

    //Eliminar los vuelos con x destino
    public void deleteByDestino(String destino);

    //Guardar vuelo nuevo
    public Vuelos save(Vuelos vuelo);

    //Para obtener el vuelvo por codigo y asi poder borrarlo
    public Vuelos getVueloByCod(String cod);

    //Una vez tenemos el vuelo por el codigo, lo borramos
    public void deleteByCod(String cod);


}
