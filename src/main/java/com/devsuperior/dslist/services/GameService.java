package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private final GameRepository _repository;

    public GameService(GameRepository repository) {
        _repository = repository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = _repository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = _repository.findById(id).get();

        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> searchByList(Long idList){
        List<GameMinProjection> result = _repository.searchByList(idList);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
