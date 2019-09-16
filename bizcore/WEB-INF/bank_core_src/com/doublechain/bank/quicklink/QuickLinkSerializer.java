package com.doublechain.bank.quicklink;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.bank.BankObjectPlainCustomSerializer;
public class QuickLinkSerializer extends BankObjectPlainCustomSerializer<QuickLink>{

	@Override
	public void serialize(QuickLink quickLink, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, quickLink, provider);
		
	}
}


