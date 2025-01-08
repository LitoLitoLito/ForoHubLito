package com.lito.foro_hub.model.respuesta.validaciones.actualizar;

import com.lito.foro_hub.model.respuesta.ActualizarRespuestaDTO;
import com.lito.foro_hub.model.respuesta.Respuesta;
import com.lito.foro_hub.model.respuesta.RespuestaRepository;
import com.lito.foro_hub.model.topico.Estado;
import com.lito.foro_hub.model.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
        if (data.solucion()){
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED){
                throw new ValidationException("Este topico ya esta solucionado.");
            }
        }
    }
}



