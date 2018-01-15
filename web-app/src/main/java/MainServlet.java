import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import zoo.service.Service;
import zoo.model.Animal;

public class MainServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("ShowAnimals in MainServlet servlet is working!");
        JSONStreamAware responseJSONStreamAware;
        JSONObject resultJSONObject = new JSONObject();
        JSONObject animalsJSONObject = new JSONObject();

        ArrayList<Animal> animalsList = Service.serviceShowAnimals();

        for(int i= 0; i<animalsList.size(); i++) {
            JSONObject animalJson = new JSONObject();
            animalJson.put("name", animalsList.get(i).getAnimalName());
            animalJson.put("age", animalsList.get(i).getAnimalAge());
            animalJson.put("class", animalsList.get(i).getAnimalClass());
            animalsJSONObject.put(i, animalJson);
        }

        resultJSONObject.put("result",animalsJSONObject);
        System.out.print("resultJSONObject is ");
        System.out.println(resultJSONObject.toString());
        responseJSONStreamAware = resultJSONObject;
        try (Writer writer = resp.getWriter()) {
            responseJSONStreamAware.writeJSONString(writer);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONStreamAware response;
        JSONObject result = new JSONObject();

//        int number = Integer.parseInt(req.getParameter("number"));

        String animalName = req.getParameter("animalName");
        int animalAge = Integer.parseInt(req.getParameter("animalAge"));
        String animalClass = req.getParameter("animalClass");

//        System.out.println("servlet works, parameters are "+ animalName + ":" + animalAge);

        Service.serviceAddAnimal(animalName, animalAge, animalClass);

//        result.put("result",2018);
//        response = result;
//        try (Writer writer = resp.getWriter()) {
//            response.writeJSONString(writer);
//        }
    }
}
