package models;


import enums.ContentTypes;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@Getter
public class ResponseModel {

    public String Title;
    public String Year;
    public String Rated;
    public String Released;
    public String Runtime;
    public String Genre;
    public String Director;
    public String Writer;
    public String Actors;
    public String Plot;
    public String Language;
    public String Country;
    public String Awards;
    public String Poster;
    public List<RatingModel> Ratings = null;
    public String Metascore;
    public String imdbRating;
    public String imdbVotes;
    public String imdbID;
    public String Type;
    public String DVD;
    public String BoxOffice;
    public String Production;
    public String Website;
    public String totalSeasons;
    public String Response;
    public String Error;

    @Override
    public String toString() {
        return new ToStringBuilder( this ).append( "title", Title )
                                          .append( "year", String.valueOf( Year ) )
                                          .append( "rated", Rated )
                                          .append( "released", Released )
                                          .append( "runtime", Runtime )
                                          .append( "genre", Genre )
                                          .append( "director", Director )
                                          .append( "writer", Writer )
                                          .append( "actors", Actors )
                                          .append( "plot", Plot )
                                          .append( "language", Language )
                                          .append( "country", Country )
                                          .append( "awards", Awards )
                                          .append( "poster", Poster
                                          ).append( "ratings", Ratings )
                                          .append( "metascore", Metascore )
                                          .append( "imdbRating", imdbRating )
                                          .append( "imdbVotes", imdbVotes )
                                          .append( "imdbID", imdbID )
                                          .append( "type", Type )
                                          .append( "dVD", DVD )
                                          .append( "boxOffice", BoxOffice )
                                          .append( "production", Production )
                                          .append( "website", Website )
                                          .append( "totalSeasons", totalSeasons )
                                          .append( "response", Response )
                                          .append( "error", Error )
                                          .toString();
    }

}
