import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String json = readString("data.json");
        List<Employee> list = jsonToList(json);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    private static List<Employee> jsonToList(String json) {
        List<Employee> list = new ArrayList<>();
        JSONParser jp = new JSONParser();
        GsonBuilder gb = new GsonBuilder();
        Gson gson = gb.create();
        try {
            JSONArray jsonArray = (JSONArray) jp.parse(json);
            for (Object o : jsonArray) {
                Employee emp = gson.fromJson(String.valueOf(o), Employee.class);
                list.add(emp);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return list;
    }


    private static String readString(String file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }
}




