package com.lito.foro_hub.model.respuesta.validaciones.actualizar;

import com.lito.foro_hub.model.respuesta.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    public void validate(ActualizarRespuestaDTO data, Long respuestaId);

}

