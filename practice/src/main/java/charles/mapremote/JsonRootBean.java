package charles.mapremote;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonRootBean {

    private SourceLocation sourceLocation;
    private DestLocation destLocation;
    private String preserveHostHeader = "false";
    private String enabled = "true";


}
