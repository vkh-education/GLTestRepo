package controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ResponseModel;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static config.ConfigService.globalConfig;
import static io.restassured.RestAssured.given;

public class ApiController {
    private static final Logger log = Logger.getLogger( ApiController.class.getName() );

    public ApiController() {
        RestAssured.baseURI = globalConfig.baseUri;
    }

    private RequestSpecification prepareSpecs( Map<String, Object> queryParams ) {

        RequestSpecification spec = given().queryParam( "apiKey", globalConfig.apiKey );
        for ( Map.Entry entry : queryParams.entrySet() ) {
            log.info( String.format( "Set query parameter [%s=%s]", entry.getKey(), entry.getValue() ) );
            spec.queryParam( String.valueOf( entry.getKey() ), entry.getValue() );
        }
        return spec;
    }

    public Response getRecordByTitle( String title ) {
        log.info( String.format( "Getting a response using title: '%s'", title ) );
        Response response = prepareSpecs( new HashMap<String, Object>() {{
            put( "t", title );
        }} )
                .log().params()
                .when().get();
        log.info( "Response body:" );
        response.then().log().body();
        return response;
    }

    public Response getRecordByTitleWithCustomParams( String title, Map<String, Object> queryParams ) {
        Map<String, Object> parameters = new HashMap<String, Object>() {{
            put( "t", title );
        }};
        parameters.putAll( queryParams );
        log.info( "Getting a response" );
        Response response = prepareSpecs( parameters )
                .log().params()
                .when().get();
        log.info( "Response body:" );
        response.then().log().body();
        return response;
    }

    public ResponseModel getResponseModel( Response response ) {
        return response.jsonPath().getObject( "", ResponseModel.class );
    }

}
