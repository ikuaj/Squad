import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
  
    post("/squad", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
  
      ArrayList<Squad> squads = request.session().attribute("squads");
      if (squads == null) {
        squads = new ArrayList<Squad>();
        request.session().attribute("squads", squads);
      }
  
      String name = request.queryParams("name");
      Squad newSquad = new Squad(name);
      squads.add(newSquad);
  
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("squads", request.session().attribute("squads"));
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
    
  }
}