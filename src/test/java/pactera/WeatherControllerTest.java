package pactera;

import org.springframework.http.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pactera.backend.controller.WeatherController;

/**
 * @author Holly.Y.Yin
 *
 */
public class WeatherControllerTest extends PacteraApplicationTest {
	private MockMvc mockMvc;

	@Autowired
	private WeatherController weatherController;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();

	}

	@Test
	public void getWehtherInfo() throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/weatherAPI/getWehtherInfo").accept(MediaType.APPLICATION_JSON)
						.param("city", "Sydney"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();

		mvcResult.getResponse().getContentAsString();
	}

}
