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
  
        String name = request.queryParams("name");
        Squad newSquad = new Squad(name);
        request.session().attribute("squad", newSquad);
  
        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("squad", request.session().attribute("squad"));
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

  }
}