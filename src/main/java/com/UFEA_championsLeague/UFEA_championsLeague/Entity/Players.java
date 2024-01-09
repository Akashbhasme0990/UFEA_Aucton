package com.UFEA_championsLeague.UFEA_championsLeague.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="players")
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int player_id;
    @Column(name= "player_name")
    private String playerName;
    @Column(name = "position")
    private  String position;
    @Column(name = "country")
    private  String country;
    @Column(name = "club")
    private String club;
}
