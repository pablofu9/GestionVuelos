package com.example.gestionvuelos.controller;

import com.example.gestionvuelos.entity.Vuelos;
import com.example.gestionvuelos.services.VueloServiceImp;
import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Vuelos", description = "Guía de vuelos internacionales")
@RequestMapping("/")
public class VueloController {

    @Autowired
    VueloServiceImp serviceImp;

    //Get all vuelos
    @Operation(summary = "Obtiene el listado de vuelos total")
    //	@ApiResponses: Permite documentar la forma en que una operación concreta responde,
    // teniendo en cuenta las posibles respuestas en caso de error
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de vuelos",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Vuelos.class)))),
    })
    @GetMapping("/vuelos")
    public List<Vuelos> getVuelos(){
        return serviceImp.getAllVuelos();
    }

    //Busqueda por origen

    @Operation(summary = "Obtiene los vuelos filtrados por origen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe", content = @Content(schema = @Schema(implementation = Vuelos.class))),
            @ApiResponse(responseCode = "404", description = "No existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping("/vuelos/origen/{origen}")
    public List<Vuelos> getVuelosByOrigen(@PathVariable String origen){
        return serviceImp.getVuelosByOrigen(origen);
    }

    //Busqueda por destino

    @Operation(summary = "Obtiene los vuelos filtrados por destino")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe", content = @Content(schema = @Schema(implementation = Vuelos.class))),
            @ApiResponse(responseCode = "404", description = "No existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping("/vuelos/destino/{destino}")
    public List<Vuelos> getVuelosByDestino(@PathVariable String destino){
        return serviceImp.getVuelosByDestino(destino);
    }

    //Busqueda por escalas
    @Operation(summary = "Obtiene los vuelos filtrados por escalas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe", content = @Content(schema = @Schema(implementation = Vuelos.class))),
            @ApiResponse(responseCode = "404", description = "No existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })

    @GetMapping("/vuelos/escalas/{escalas}")
    public List<Vuelos> getVuelosByEscalas(@PathVariable int escalas){
        return serviceImp.getVuelosByNum_escalas(escalas);
    }

    @Operation(summary = "Elimina una lista de vuelos por destino")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se elimina el vuelo", content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    //Borrar por destino
    @DeleteMapping("/vuelos/borrar/{destino}")
    public void deleteVuelos(@PathVariable String destino){
        serviceImp.deleteByDestino(destino);
    }

    //Para guardar vuelo nuevo
    //Debemos hacer un post en el postman, pasandole en el body un vuelo en forma de JSON
    @Operation(summary = "Insertar un nuevo vuelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Se registra el vuelo", content = @Content(schema = @Schema(implementation = Vuelos.class)))
    })
    @PostMapping("/vuelos/save")
    public ResponseEntity<Vuelos> savePerro(@RequestBody Vuelos vuelo){
        Vuelos nuevoVuelo = serviceImp.save(vuelo);
        return new ResponseEntity<>(nuevoVuelo, HttpStatus.CREATED);
    }

    //Borrar por codigo, usamos el metodo que hemos hecho con la query para sacar el vuelo por codigo
    //y lo borramos
    @Operation(summary = "Elimina un vuelo por codigo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se elimina el vuelo", content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping("/vuelos/eliminar/{cod}")
    public void deleteByCod(@PathVariable String cod){
        serviceImp.deleteByCod(cod);
    }
    //Update de un vuelo
    //debemos meter en el body un json del vuelo que queremos modificar con las caracteristicas a
    //modificar ya cambiadas
    @Operation(summary = "Modifica un vuelo en el catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se modifica el vuelo", content = @Content(schema = @Schema(implementation = Vuelos.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PutMapping("/vuelos/modificar")
    public ResponseEntity<Vuelos> update(@RequestBody Vuelos vuelo){
        Vuelos v1 =serviceImp.save(vuelo);
        return new ResponseEntity<>(v1,HttpStatus.CREATED);
    }
}
