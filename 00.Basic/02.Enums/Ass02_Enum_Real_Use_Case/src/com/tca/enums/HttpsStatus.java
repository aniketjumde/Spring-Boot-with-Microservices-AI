
package com.tca.enums;

import com.tca.MessageProvider;

public enum HttpsStatus implements MessageProvider
{
	Ok(200,"Success"),
	NOT_FOUND(404,"Resources Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

	
	private final int code;
	private final String message;
	
	private HttpsStatus(int code,String message)
	{
		this.code=code;
		this.message=message;
	}

	public int getCode() {
		return code;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
	
}
