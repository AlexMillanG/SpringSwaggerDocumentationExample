package mx.edu.utez.unidadtres.modules.cede;

import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edu.utez.unidadtres.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/cede")
@RestController
@Tag(name = "controlador de cedes", description = "nsdflknadsflsdnn")
public class CedeController {

    @Autowired
    private CedeService cedeService;

    @GetMapping("")
    public ResponseEntity<APIResponse> findAll (){
        APIResponse response = cedeService.findAll();
        return new ResponseEntity<>(response,response.getStatus());
    }

    @PostMapping("")
    public ResponseEntity<APIResponse> save (@RequestBody CedeEntity cede){
        APIResponse response = cedeService.save(cede);
        return new ResponseEntity<>(response,response.getStatus());
    }
}
