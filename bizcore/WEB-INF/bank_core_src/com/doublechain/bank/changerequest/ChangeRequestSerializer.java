package com.doublechain.bank.changerequest;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.bank.BankObjectPlainCustomSerializer;
public class ChangeRequestSerializer extends BankObjectPlainCustomSerializer<ChangeRequest>{

	@Override
	public void serialize(ChangeRequest changeRequest, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, changeRequest, provider);
		
	}
}


