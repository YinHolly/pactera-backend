package pactera;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pactera.backend.controller.PetsController;

/**
 * @author Holly.Y.Yin
 *
 */
public class PetsControllerTest extends PacteraApplicationTest {

	private MockMvc mockMvc;

	@Autowired
	private PetsController petsController;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(petsController).build();

	}

	@Test
	public void getCatsList() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/petsApi/getCatsList"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();

		mvcResult.getResponse().getContentAsString();
	}

}
