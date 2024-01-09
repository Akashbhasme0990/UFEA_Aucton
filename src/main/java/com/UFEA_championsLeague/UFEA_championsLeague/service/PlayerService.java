package com.UFEA_championsLeague.UFEA_championsLeague.service;

import com.UFEA_championsLeague.UFEA_championsLeague.Entity.Players;
import com.UFEA_championsLeague.UFEA_championsLeague.Repository.playerRepository;
import com.UFEA_championsLeague.UFEA_championsLeague.dto.PLayerRequest;
import com.UFEA_championsLeague.UFEA_championsLeague.dto.playerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {
    // Constructor injection of the PlayerRepository
    private final playerRepository playerRepository;

    public void createPlayer(PLayerRequest playerRequest) {
//        Players player = new Players();
        Players player = Players.builder()
                .playerName(playerRequest.getPlayerName())
                .position(playerRequest.getPosition())
                .country(playerRequest.getCountry())
                .club(playerRequest.getClub())
                .build();
        playerRepository.save(player);
        log.info("Player{} is created",player.getPlayerName());
    }

    public List<playerResponse> getAllPlayers() {
        List<Players> players=playerRepository.findAll();
        return  players.stream().map(this::mapToPlayerResponse).toList();
    }
//    modellmapper
    private playerResponse mapToPlayerResponse(Players players){
            return  playerResponse.builder()
                    .player_id(players.getPlayer_id())
                    .playerName(players.getPlayerName())
                    .position(players.getPosition())
                    .country(players.getCountry())
                    .club(players.getClub())
                    .build();
    }
}