package com.UFEA_championsLeague.UFEA_championsLeague.Repository;

import com.UFEA_championsLeague.UFEA_championsLeague.Entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface playerRepository extends JpaRepository<Players, Integer> {
}
