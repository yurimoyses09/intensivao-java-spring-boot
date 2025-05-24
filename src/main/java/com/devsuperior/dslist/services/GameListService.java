package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private final GameListRepository _repository;

    public GameListService(GameListRepository repository) {
        _repository = repository;
    }

    public List<GameListDTO> findAll(){
        List<GameList> result = _repository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}

