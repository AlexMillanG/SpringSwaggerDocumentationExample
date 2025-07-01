package mx.edu.utez.unidadtres.modules.cede;


import mx.edu.utez.unidadtres.utils.APIResponse;
import mx.edu.utez.unidadtres.utils.ClaveGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class CedeService {
    
    @Autowired
    private CedeRepository cedeRepository;

    public APIResponse findAll(){
        APIResponse response = new APIResponse(cedeRepository.findAll(),"",false, HttpStatus.OK   );
        return response;
    }

    @Transactional(readOnly = true)
    public APIResponse findById(Long id){
        try {
            Optional<CedeEntity> found = cedeRepository.findById(id);
            if (found.isEmpty()){
                return new APIResponse("no se encontró la cede",true,HttpStatus.NOT_FOUND);
            }
            return new APIResponse(found.get(),"operación existosa",false,HttpStatus.OK);
        } catch (Exception e) {
            return new APIResponse("Error interno, no se puedo consultar la cede",true,HttpStatus.NOT_FOUND);
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public APIResponse save (CedeEntity payload){
        try {
            payload.setClave("pending...");
            CedeEntity saved = cedeRepository.save(payload);

            saved.setClave(ClaveGenerator.generateCedeClave(saved.getId()));



            return new APIResponse(cedeRepository.save(saved),"creado exitosamente",false,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new APIResponse("error",true,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public APIResponse update (CedeEntity payload){
        try {
            Optional<CedeEntity> found = cedeRepository.findById(payload.getId());
            if (found.isEmpty())
                return new APIResponse("error, cede no encontrada",true,HttpStatus.NOT_FOUND);

                return new APIResponse(cedeRepository.save(payload),"actualizado",false,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new APIResponse("error no se pudo actualizar correctamente",true,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public APIResponse delete (Long id){
        try {
            Optional<CedeEntity> found = cedeRepository.findById(id);
            if (found.isEmpty())
            return new APIResponse("error, cede no encontrada",true,HttpStatus.NOT_FOUND);

            cedeRepository.deleteById(id);
            return new APIResponse(found.get(),"cede eliminada correctamente",false,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new APIResponse("error no se pudo eliminar correctamente",true,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
