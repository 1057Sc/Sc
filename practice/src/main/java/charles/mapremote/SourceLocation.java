package charles.mapremote;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SourceLocation {

    private String protocol;
    private String host;
    private String port;
    private String path;
}
