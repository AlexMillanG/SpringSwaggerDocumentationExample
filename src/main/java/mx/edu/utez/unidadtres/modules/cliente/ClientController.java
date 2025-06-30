package mx.edu.utez.unidadtres.modules.cliente;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edu.utez.unidadtres.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@Tag(name = "controlador de clientes", description = "nsdflknadsflsdnn")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    @Operation(summary = "Traer clientes", description = "trae clientes")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "trae todos los fakin clientes",
                    content = {
                        @Content(mediaType = "application/json", schema = @Schema (implementation = APIResponse.class)),
                        @Content(mediaType = "application/xml", schema = @Schema (implementation = APIResponse.class)),
                        @Content(mediaType = "application/html", schema = @Schema (implementation = APIResponse.class))
                    }
            )
    })
    public ResponseEntity<APIResponse> findAll(){
        APIResponse apiResponse = clientService.findAll();
        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID", description = "Devuelve un cliente según su ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cliente encontrado exitosamente",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró al cliente",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al consultar al cliente",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
                    }
            )
    })
    public ResponseEntity<APIResponse> findById(@PathVariable Long id) {
        APIResponse response = clientService.findById(id);
        return new ResponseEntity<>(response, response.getStatus());
    }

}
