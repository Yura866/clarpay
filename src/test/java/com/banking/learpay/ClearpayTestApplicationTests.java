package com.banking.learpay;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.banking.learpay.to.TransferRequest;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class ClearpayApplicationTests {

	@Autowired
	private MockMvc mockMvc;   	


	@Test
	void transfer_successful() throws Exception {		
		TransferRequest req = new TransferRequest();
		req.setAmount(10);
		req.setSourceAccountNumber("2gu58d6");
		req.setDestinationAccountNumber("C3X2gu58");		

		mockMvc.perform(MockMvcRequestBuilders.post("/api/transfer")
				.content(asJsonString(req))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("The transaction was successful !")));;

	}
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	} 

}
