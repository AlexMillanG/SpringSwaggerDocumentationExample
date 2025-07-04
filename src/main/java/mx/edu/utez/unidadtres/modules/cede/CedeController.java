package mx.edu.utez.unidadtres.modules.cede;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edu.utez.unidadtres.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/cede")
@RestController
@Tag(name = "controlador de cedes", description = "Controlador para gestión de cedes")
public class CedeController {

    @Autowired
    private CedeService cedeService;

    @GetMapping(value = {"", "/"})
    @Operation(summary = "Obtener todas las cedes", description = "Devuelve una lista de todas las cedes registradas")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de cedes obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> findAll() {
        APIResponse response = cedeService.findAll();
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping(value = {"", "/"})
    @Operation(summary = "Guardar una nueva cede", description = "Registra una nueva cede en la base de datos")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Cede creada exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al guardar la cede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> save(@RequestBody CedeEntity cede) {
        APIResponse response = cedeService.save(cede);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cede por ID", description = "Devuelve una cede según su ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cede encontrada exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró la cede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al consultar la cede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> findById(@PathVariable Long id) {
        APIResponse response = cedeService.findById(id);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cede", description = "Elimina una cede por su ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cede eliminada exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró la cede a eliminar",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al eliminar la cede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> delete(@PathVariable Long id) {
        APIResponse response = cedeService.delete(id);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping(value = {"", "/"})
    @Operation(summary = "Actualizar cede", description = "Actualiza una cede existente")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cede actualizada exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró la cede a actualizar",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al actualizar la cede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> update(@RequestBody CedeEntity cede) {
        APIResponse response = cedeService.update(cede);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
