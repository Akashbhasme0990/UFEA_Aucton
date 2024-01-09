package com.UFEA_championsLeague.UFEA_championsLeague.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PLayerRequest {

    private String playerName;
    private  String position;
    private  String country;
    private String club;
}
