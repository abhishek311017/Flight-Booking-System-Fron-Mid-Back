package io.project.AdminService;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.project.AdminService.model.Flight;
import io.project.AdminService.repository.AdminRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AdminServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private AdminRepository adminRepo;
	
	
	Flight flight1 = new Flight("C123", "IndiGo", "Chennei", "Delhi", 1000, 5000, "30-03-2021", "6.30AM", "8.30",
			25);
	Flight flight2 = new Flight("C124", "AirGo", "Delhi", "Chennei", 1000, 5050, "31-03-2021", "8.45AM", "10.15AM", 15);
	Flight flight3 = new Flight("C125", "Vistara", "Kolkata", "Mumbai", 1032, 7000, "29-03-2021", "16.00PM", "18.00Pm", 30);

	@Test
	public void testFlightList() throws Exception {
		List<Flight> list = new ArrayList<>();
		list.add(flight1);
		list.add(flight2);
		list.add(flight3);
		
		Mockito.when(adminRepo.findAll()).thenReturn(list);
		String url = "/Admin/findAllFlight";
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(list);
		assertEquals(expectedJsonResponse, actualJsonResponse);
	}

	@Test
	public void testAddFlight() throws JsonProcessingException,Exception {
		Flight flight=new Flight();
		flight.setArrival_time("6:30");
		flight.setDate_of_travel("31-01-2021");
		flight.setDeparture_time("8:30");
		flight.setDistance_in_km(458);
		flight.setFlight_fare_in_rupees(5845);
		flight.setFlight_name("IndiaJet");
		flight.setFlight_number("C1254");
		flight.setNumber_of_available_seats(10);
		flight.setTraveling_from("Mumbai");
		flight.setTraveling_to("Pune");
		
		Mockito.when(adminRepo.save(flight)).thenReturn(flight);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/Admin/addFlight")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.objectMapper.writeValueAsString(flight));
		
		mockMvc.perform(mockRequest)
		.andExpect(status().isOk());
		//.andExpect(jsonPath("$.flight_number",is("C1254")));
	
	}
	@Test
	public void testDelete() throws Exception {
		
		Mockito.when(adminRepo.findByFlight_Number(flight2.getFlight_number())).thenReturn((flight2));
		  this.mockMvc.perform(MockMvcRequestBuilders
		            .delete("/Admin/delete/C124")
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk());
	}
	
	/*
	 * //.string("C123")
	 * 
	 * @Test
	 * 
	 * @Order(1) public void testaddFlight() { Flight flight = new Flight();
	 * flight.setFlight_number("C4512"); flight.setFlight_name("TruJet");
	 * flight.setFlight_fare_in_rupees(4000); flight.setDistance_in_km(1500);
	 * flight.setDeparture_time("18:30"); flight.setArrival_time("16:20");
	 * flight.setDate_of_travel("30/6/2021");
	 * flight.setNumber_of_available_seats(10); flight.setTraveling_from("Kolkata");
	 * flight.setTraveling_to("Mumbai");
	 * 
	 * adminRepo.save(flight);
	 * assertNotNull(adminRepo.findByFlight_Number("C4512"));
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @Order(2) public void testReadAllFlight() { List<Flight> list =
	 * adminRepo.findAll(); assertThat(list).size().isGreaterThan(0);
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @Order(3) public void testUpdate() { Flight flight1 =
	 * adminRepo.findByFlight_Number("C4512");
	 * flight1.setFlight_fare_in_rupees(3500); adminRepo.save(flight1);
	 * assertNotEquals(4000,adminRepo.findByFlight_Number("C4512").
	 * getFlight_fare_in_rupees());
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test
	 * 
	 * @Order(4) public void testDelete() {
	 * adminRepo.deleteByFlight_Number("C4512");
	 * assertNull(adminRepo.findByFlight_Number("C4512")); }
	 * 
	 */

}
