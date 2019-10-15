package br.com.souza.solutions.iorganize.web.rest;


import static org.assertj.core.api.Assertions.assertThat;
import static br.com.souza.solutions.iorganize.web.rest.utils.Utils.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.souza.solutions.iorganize.models.Goal;
import br.com.souza.solutions.iorganize.service.GoalService;
import br.com.souza.solutions.iorganize.web.rest.builders.EntityBuilder;
import br.com.souza.solutions.iorganize.web.rest.dto.GoalDTO;
import br.com.souza.solutions.iorganize.web.rest.mapper.GoalMapper;
import br.com.souza.solutions.iorganize.web.rest.utils.OptionalUtils;
import br.com.souza.solutions.iorganize.web.rest.utils.PagebleUtils;


@RunWith(SpringRunner.class)
@WebMvcTest(GoalController.class)
public class GoalControllerTest {

	private static final String URL = "/v1/api/goal/1";
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private GoalService service;
	
	@MockBean
	private GoalMapper mapper;
	
	
	@Before
	public void setUp() {
		Page<GoalDTO> goalsDTO = new PagebleUtils<GoalDTO>().getEmptyPageObject();
		Mockito.when(mapper.toGoalDTO(ArgumentMatchers.any())).thenReturn(goalsDTO);
	}

	@Test
	public void testGetUserById_shouldReturn200() throws Exception {
		Optional<Goal> optional = new OptionalUtils<Goal>().createOptionalObject(EntityBuilder.buildGoal());
		
		Mockito.when(service.findById(ArgumentMatchers.anyLong())).thenReturn(optional);
		
		this.mock.perform(get(URL))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.status").exists())
			.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
	}
	
	@Test
	public void testCreateUser_shouldReturn201() throws Exception {
		Mockito.when(service.save(ArgumentMatchers.any(Goal.class))).thenReturn(EntityBuilder.buildGoal());
		
		this.mock.perform(post("/v1/api/goal")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(EntityBuilder.buildGoalForm("trip"))))
			.andExpect(status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath("$.status").exists())
			.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
	}
	
	@Test
	public void testUpdateUser_shouldReturn200() throws Exception {
		Goal goal = EntityBuilder.buildGoal();
		
		Optional<Goal> optional = new OptionalUtils<Goal>().createOptionalObject(goal);
		Mockito.when(service.findById(ArgumentMatchers.anyLong())).thenReturn(optional);
		
		Mockito.when(service.save(ArgumentMatchers.any(Goal.class))).thenReturn(goal);
		
		this.mock.perform(put(URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(EntityBuilder.buildGoalForm("house"))))
			.andExpect(status().isOk())
			.andExpect(jsonPath("name", equalTo("house")));
	}
	
	@Test
	public void testDeleteUser_shouldReturn204() throws Exception {
		Goal goal = EntityBuilder.buildGoal();
		Optional<Goal> optional = new OptionalUtils<Goal>().createOptionalObject(goal);
		
		Mockito.when(service.findById(ArgumentMatchers.anyLong())).thenReturn(optional);
		Mockito.doNothing().when(service).disable(goal);
		
		this.mock.perform(delete(URL))
			.andExpect(status().isNoContent());
		
	}

}
