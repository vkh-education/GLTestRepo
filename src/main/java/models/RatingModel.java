package models;

import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Getter
public class RatingModel {

    public String Source;
    public String Value;


    @Override
    public String toString() {
        return new ToStringBuilder( this ).append( "source", Source )
                                          .append( "value", Value )
                                          .toString();
    }

}
