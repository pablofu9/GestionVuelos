package com.example.gestionvuelos.services;

import com.example.gestionvuelos.entity.Vuelos;
import com.example.gestionvuelos.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImp implements VueloService {

    @Autowired
    VueloRepository repository;

    @Override
    public List<Vuelos> getAllVuelos() {
        return repository.findAll();
    }

    @Override
    public List<Vuelos> getVuelosByOrigen(String origen) {
        return repository.getVuelosByOrigen(origen);
    }

    @Override
    public List<Vuelos> getVuelosByDestino(String destino) {
        return repository.getVuelosByDestino(destino);
    }

    @Override
    public List<Vuelos> getVuelosByNum_escalas(int escalas) {
        return repository.getVuelosByNum_escalas(escalas);
    }
    //Borrar por destino
    //Lo que hacemos es una busqueda de vuelos por destino, los sacamos en una lista con el metodo del repositorio
    //y despues borramos esa lista
    @Override
    public void deleteByDestino(String destino) {
        List<Vuelos> vuelos= repository.getVuelosByDestino(destino);
        repository.deleteAll(vuelos);
    }

    //Guardar vuelo nuevo
    @Override
    public Vuelos save(Vuelos vuelo) {
        return repository.save(vuelo);
    }

    //Obtener el vuelo por el codigo asi podemos borrarlo
    @Override
    public Vuelos getVueloByCod(String cod) {
        return repository.getVuelosByCod_vuelo(cod);
    }

    @Override
    public void deleteByCod(String cod) {
        Vuelos vueloBorrar = repository.getVuelosByCod_vuelo(cod);
        repository.delete(vueloBorrar);
    }
}
