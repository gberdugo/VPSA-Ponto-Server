package br.berdugo.vpsa.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import org.springframework.validation.ObjectError;

public class ValidationException extends Exception {
	
	private static final long serialVersionUID = 352557475195780037L;

	private Collection<String> errorMessages;
	
	@SuppressWarnings("unchecked")
	public ValidationException(List<ObjectError> list) {
		Collection<String> errorCodes = CollectionUtils.collect(list, TransformerUtils.invokerTransformer("getCode"));
		
		errorMessages = new ArrayList<String>();
		
		for (String errorCode : errorCodes) {
			errorMessages.add(I18N.getString(errorCode));
		}
	}
	
	@Override
	public String getMessage() {
		StringBuilder str = new StringBuilder();
		Iterator<String> itr = errorMessages.iterator();
		
		while(itr.hasNext()) {
			str.append(itr.next());
			
			if (itr.hasNext()) {
				str.append("\n");
			}
		}
		
		return str.toString();
	}
}