package mx.edu.utez.unidadtres.modules.cliente;

import mx.edu.utez.unidadtres.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional(rollbackFor = SQLException.class)
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public APIResponse findAll(){
        APIResponse response = new APIResponse(clientRepository.findAll(),"",false, HttpStatus.OK   );
        return response;
    }

    @Transactional(readOnly = true)
    public APIResponse findById(Long id){
        try {
            Optional<ClientEntity> found = clientRepository.findById(id);
            if (found.isEmpty()){
                return new APIResponse("no se encontró al cliente",true,HttpStatus.NOT_FOUND);
            }
            return new APIResponse(found.get(),"operación existosa",false,HttpStatus.OK);
        } catch (Exception e) {
            return new APIResponse("Error interno, no se puedo consultar al cliente",true,HttpStatus.NOT_FOUND);
        }
    }

    @Transactional(readOnly = false)
    public APIResponse save (ClientEntity payload){
        try {

            return new APIResponse(clientRepository.save(payload),"creado exitosamente",false,HttpStatus.CREATED);
        } catch (Exception e) {
            return new APIResponse("error",true,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
