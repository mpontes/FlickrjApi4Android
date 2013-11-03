/*
 * Copyright (c) 2005 Aetrion LLC.
 */
package com.googlecode.flickrjandroid;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Flickr Response object.
 *
 * @author Anthony Eden
 */
public class RESTResponse implements Response {

    private static final Logger logger = LoggerFactory.getLogger(RESTResponse.class);

    private String stat;
    
    private JSONObject jsonObj;
    private String rawResponse;
    private String errorCode;
    private String errorMessage;
    
    /**
     * @param rawResponse
     * @throws JSONException 
     */
    public RESTResponse(String rawResponse) throws JSONException {
        super();
        this.rawResponse = rawResponse;
        parse(this.rawResponse);
    }

    /* (non-Javadoc)
     * @see com.googlecode.flickrjandroid.Response#parse(java.lang.String)
     */
    @Override
    public void parse(String rawMessage) throws JSONException {
		try {
            this.rawResponse = rawMessage;
            this.jsonObj = new JSONObject(rawMessage);
            stat = this.jsonObj.getString("stat");
            if ("ok".equals(stat)) {

            } else if ("fail".equals(stat)) {
                this.errorCode = this.jsonObj.getString("code");
                this.errorMessage = this.jsonObj.getString("message");
            }
        } catch (JSONException e) {
            logger.error("JSONException on " + rawMessage);
            throw e;
        }
	}

    public String getStat() {
        return stat;
    }

    @Override
    public JSONObject getData() {
        return this.jsonObj;
    }

    public boolean isError() {
        return errorCode != null;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    /* (non-Javadoc)
     * @see com.googlecode.flickrjandroid.Response#getRawResponse()
     */
    @Override
    public String getRawResponse() {
        return rawResponse;
    }

}
