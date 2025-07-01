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

    @GetMapping(value = {"","/"})
    public ResponseEntity<APIResponse> findAll (){
        APIResponse response = cedeService.findAll();
        return new ResponseEntity<>(response,response.getStatus());
    }

    @PostMapping(value = {"","/"})
    public ResponseEntity<APIResponse> save (@RequestBody CedeEntity cede){
        APIResponse response = cedeService.save(cede);
        return new ResponseEntity<>(response,response.getStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> findById(@PathVariable Long id){
        APIResponse response = cedeService.findById(id);
        return new ResponseEntity<>(response,response.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> delete(@PathVariable Long id){
        APIResponse response = cedeService.delete(id);
        return new ResponseEntity<>(response,response.getStatus());
    }

    @PutMapping(value = {"","/"})
    public ResponseEntity<APIResponse> update (@RequestBody CedeEntity cede){
        APIResponse response = cedeService.update(cede);
        return new ResponseEntity<>(response,response.getStatus());
    }
}
