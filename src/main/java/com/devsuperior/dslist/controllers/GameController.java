package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dslist.services.GameService;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService _service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        try{
            return _service.findAll();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
