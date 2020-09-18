package payment_gateway.api;


import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface PGApi {

    @POST
    @Path("/request")
    public String request(String param);

}
