package com.UFEA_championsLeague.UFEA_championsLeague.Controller;

import com.UFEA_championsLeague.UFEA_championsLeague.dto.PLayerRequest;
import com.UFEA_championsLeague.UFEA_championsLeague.dto.playerResponse;
import com.UFEA_championsLeague.UFEA_championsLeague.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class playerController {
    private final PlayerService playerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void createPlayer(@RequestBody PLayerRequest pLayerRequest){
        playerService.createPlayer(pLayerRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<playerResponse> getAllPlayers(){
        return playerService.getAllPlayers();
    }
}
