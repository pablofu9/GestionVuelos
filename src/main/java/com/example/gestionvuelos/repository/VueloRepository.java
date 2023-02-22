package com.example.gestionvuelos.repository;

import com.example.gestionvuelos.entity.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelos,String > {

    //Busqueda por origen
    @Query("SELECT v FROM Vuelos v WHERE v.origen = ?1")
    List<Vuelos> getVuelosByOrigen(String origen);

    //Busqueda por destino
    @Query("SELECT v FROM Vuelos v WHERE v.destino = ?1")
    List<Vuelos> getVuelosByDestino(String destino);

    //Busqueda por numero de escalas
    @Query("SELECT v FROM Vuelos v WHERE v.num_escalas = ?1")
    List<Vuelos> getVuelosByNum_escalas(int escalas);

    //Para obetener el vuelo por codigo y asi poder borrarlo
    @Query("SELECT v FROM Vuelos v WHERE v.cod_vuelo = ?1")
    Vuelos getVuelosByCod_vuelo(String cod);
}
