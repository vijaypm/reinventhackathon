package aws2013.team26.rest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;

import aws2013.team26.data.QueryDatabase;

@Path("browse")
public class BrowseResource {

    @GET
    @Path("/{table-name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllDonation(@PathParam("table-name") String tablename) throws SQLException {
    	Map model = new HashMap();
        String resultJSON = new QueryDatabase().executeQuery("select * from " + tablename + " limit 1000");
        model.put("resultsJSON", resultJSON);
//        return new Viewable("/results.jsp", resultJSON);
        return Response.ok(new Viewable("/results.jsp", model)).build();
    }

}
