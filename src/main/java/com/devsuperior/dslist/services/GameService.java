package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist.repositories.GameRepository;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private final GameRepository _service;

    public GameService(GameRepository service) {
        _service = service;
    }

    public List<GameMinDTO> findAll(){
        List<Game> result = _service.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
