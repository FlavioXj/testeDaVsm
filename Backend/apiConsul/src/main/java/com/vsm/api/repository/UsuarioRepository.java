package com.vsm.api.repository;

import com.vsm.api.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <UsuarioModel, Integer> {

}
