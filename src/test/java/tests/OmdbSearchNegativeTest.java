package tests;

import controllers.ApiController;
import io.restassured.response.Response;
import models.ResponseModel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class OmdbSearchNegativeTest extends BaseTest {
    private static final String FALSE = "False";
    private static final String INCORRECT_ID = "Incorrect IMDb ID.";
    private static final String NOT_FOUND = "Movie not found!";
    private static final String INVALID_API_KEY = "Invalid API key!";

    private ApiController controller;

    @BeforeClass
    public void beforeSuite() {
        controller = new ApiController();
    }

    @Test
    public void testSearchEmptyTitle() {
        Response response = controller.getRecordByTitle( "" );
        ResponseModel model = controller.getResponseModel( response );
        Assert.assertEquals( model.getResponse(), FALSE, "Incorrect 'Response' value" );
        Assert.assertEquals( model.getError(), INCORRECT_ID, "Wrong Error message" );
    }

    @Test
    public void testSendNameWithIncorrectId() {
        mainScenario( "tenet", new HashMap<String, Object>() {{
            put( "i", "tt672359" );
        }}, INCORRECT_ID );
    }

    @Test
    public void testSendNameWithInvalidYear() {
        mainScenario( "tenet", new HashMap<String, Object>() {{
            put( "y", "672359" );
        }}, NOT_FOUND );
    }

    @Test
    public void testSendRequestWithInvalidApiKey() {
        Response response = mainScenario( "tenet", new HashMap<String, Object>() {{
            put( "apiKey", "672359" );
        }}, INVALID_API_KEY );
        Assert.assertEquals( response.getStatusCode(), 401, "Wrong status code" );
    }

    private Response mainScenario( String title, Map<String, Object> parameters, String errorMessage ) {
        Response response = controller.getRecordByTitleWithCustomParams( title, parameters );
        ResponseModel model = controller.getResponseModel( response );
        Assert.assertEquals( model.getResponse(), FALSE, "Incorrect 'Response' value" );
        Assert.assertEquals( model.getError(), errorMessage, "Wrong Error message" );
        return response;
    }
}
