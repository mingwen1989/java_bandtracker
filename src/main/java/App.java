import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main (String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    get("/bands",(request, response) -> {
      HashMap<String, Object> model = new HashMap<String,Object>();
      model.put("bands", Band.all());
      model.put("template", "templates/bands.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/venues", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("venues", Venue.all());
      model.put("template", "templates/venues.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/bands", (request, response) -> {
      String name = request.queryParams("bandName");
      Band newBand = new Band(name);
      newBand.save();
      response.redirect("/bands");
      return null;
    });

    post("/venues", (request, response) -> {
      String venueName = request.queryParams("venueName");
      Venue newVenue = new Venue(venueName);
      newVenue.save();
      response.redirect("/venues");
      return null;
    });

    get("/bands/:id", (request, response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();
      Band band = Band.find(Integer.parseInt(request.params(":id")));
      model.put("band", band);
      model.put("allVenues", Venue.all());
      model.put("template", "templates/band.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/bands/:id/add_venue", (request, response) -> {
      Band band = Band.find(Integer.parseInt(request.params(":id")));
      int newVenue = Integer.parseInt(request.queryParams("venue_id"));
      band.addVenue(Venue.find(newVenue));
      response.redirect("/bands/" + band.getId());
      return null;
    });

    post("/bands/:id/update", (request, response) -> {
      Band band = Band.find(Integer.parseInt(request.params(":id")));
      String updateBandName = request.queryParams("updateBandName");
      band.update(updateBandName);
      response.redirect("/bands/" + band.getId());
      return null;
    });

    post("/bands/:id/delete", (request, response) -> {
      Band band = Band.find(Integer.parseInt(request.params(":id")));
      band.delete();
      response.redirect("/bands");
      return null;
    });

    get("/venues/:id", (request, response) -> {
      HashMap<String,Object> model = new HashMap<String,Object>();
      Venue venue = Venue.find(Integer.parseInt(request.params(":id")));
      model.put("venue", venue);
      model.put("allBands", Band.all());
      model.put("template", "templates/venue.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/venues/:id/update", (request, response) -> {
      Venue venue = Venue.find(Integer.parseInt(request.params(":id")));
      String updateVenue = request.queryParams("updateVenueName");
      venue.update(updateVenue);
      response.redirect("/venues/" + venue.getId());
      return null;
    });

    post("/venues/:id/delete", (request, response) -> {
      Venue venue = Venue.find(Integer.parseInt(request.params(":id")));
      venue.delete();
      response.redirect("/venues");
      return null;
    });

    post("/delete", (request, response) -> {
      Band.deleteAll();
      response.redirect("/bands");
      return null;
    });

  }
}
