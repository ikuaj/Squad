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
      int size = Integer.parseInt(request.queryParams("size"));
      String purpose = request.queryParams("purpose");
      Squad newSquad = new Squad(name, size, purpose);
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

              //Heros 
      post("/hero", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
    
        ArrayList<Hero> heros = request.session().attribute("heros");
        if (heros == null) {
          heros = new ArrayList<Hero>();
          request.session().attribute("heros", heros);
        }
    
        String name = request.queryParams("name");
        int age = Integer.parseInt(request.queryParams("age"));
        String power = request.queryParams("power");
        String weakness = request.queryParams("weakness");
        String squad = request.queryParams("squad");
        Hero newHero = new Hero(name, age, power, weakness, squad);
        heros.add(newHero);
    
        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());
  
        get("/", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("heros", request.session().attribute("heros"));
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    
  }
}