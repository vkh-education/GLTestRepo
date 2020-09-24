package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ContentTypes {
    MOVIE( "movie" ),
    SERIES( "series" ),
    EPISODE( "episode" );

    private final String visibleName;
}
