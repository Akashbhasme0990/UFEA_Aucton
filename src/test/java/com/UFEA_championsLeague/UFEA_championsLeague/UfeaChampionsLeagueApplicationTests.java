package com.UFEA_championsLeague.UFEA_championsLeague;

import com.UFEA_championsLeague.UFEA_championsLeague.Repository.playerRepository;
import com.UFEA_championsLeague.UFEA_championsLeague.dto.PLayerRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;

import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class UfeaChampionsLeagueApplicationTests {

	@Container
	static  MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2").withReuse(true);;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private playerRepository playerRepository;

	static {
		mongoDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}
	@Test
	void shouldCreatePlayer() throws Exception {
		PLayerRequest pLayerRequest= getPLayerRequest();
		String playerRequestString = objectMapper.writeValueAsString(pLayerRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/players")
						.contentType(MediaType.ALL.APPLICATION_JSON)
						.content(playerRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(19, playerRepository.findAll().size());
	}

	private PLayerRequest getPLayerRequest() {
		return PLayerRequest.builder()
				.playerName("Ronnydd")
				.position("goalkeeper")
				.country("korea")
				.club("milan")
				.build();

	}

}
