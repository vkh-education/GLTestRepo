package tests;

import controllers.ApiController;
import io.restassured.response.Response;
import models.ResponseModel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static enums.ContentTypes.*;

public class OmdbSearchPositiveTest extends BaseTest {

    private ApiController controller;

    @BeforeClass
    public void beforeSuite() {
        controller = new ApiController();
    }

    @Test
    public void getMovieWithTitle() {
        String searchTitle = "Tenet";
        Response response = controller.getRecordByTitle( searchTitle );
        Assert.assertEquals( response.getStatusCode(), 200, "Incorrect response code" );
        Assert.assertTrue(
                response.jsonPath().getObject( "", ResponseModel.class ).getTitle().contains( searchTitle ),
                "Returned object title doesn't contain search title"
        );

    }

    @Test
    public void getMovieWithYearAndTitle() {
        String searchTitle = "Lion king";
        int year = 2019;
        Response response = controller.getRecordByTitleWithCustomParams( searchTitle, new HashMap<String, Object>() {
            {
                put( "y", year );
            }
        } );
        Assert.assertEquals( response.getStatusCode(), 200, "Incorrect response code" );
        Assert.assertEquals( controller.getResponseModel( response ).getYear(), String.valueOf( year ),
                             "Search result doesn't met with search criteria"
        );
    }

    @DataProvider( name = "contentType", parallel = true )
    public static Object[][] getContentType() {

        return new Object[][]{
                { MOVIE.getVisibleName(), "Son" },
                { SERIES.getVisibleName(), "Friends" },
//                {EPISODE.getVisibleName(), "Pilot"} // looks like get episode data doesn't work. Test will fail
        };
    }

    @Test( dataProvider = "contentType" )
    public void getMovieWythType( String type, String title ) {
        Response response = controller.getRecordByTitleWithCustomParams( title, new HashMap<String, Object>() {
            {
                put( "type", type );
            }
        } );
        Assert.assertEquals( response.getStatusCode(), 200, "Incorrect response code" );
        Assert.assertEquals( controller.getResponseModel( response ).getType(), type );
    }
}
