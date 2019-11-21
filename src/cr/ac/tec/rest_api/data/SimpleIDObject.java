package cr.ac.tec.rest_api.data;

import java.util.UUID;

public class SimpleIDObject {
    private UUID id;
    public SimpleIDObject(){}
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
}
