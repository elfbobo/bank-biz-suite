package com.doublechain.bank.candidateelement;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.bank.BankObjectPlainCustomSerializer;
public class CandidateElementSerializer extends BankObjectPlainCustomSerializer<CandidateElement>{

	@Override
	public void serialize(CandidateElement candidateElement, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, candidateElement, provider);
		
	}
}







