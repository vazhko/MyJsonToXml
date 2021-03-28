import org.json.JSONException;
import org.json.JSONObject;

public class FiscalBlock {
    public String getSomeShit(){
        return "This is really shit";
    }

    public String getDoc(String inJson) throws JSONException {
        JSONObject jObject = new JSONObject(inJson);
        return "This is really shit";
    }
    // тестовий витяг значення docSubType
    public String getDocType(String inJson) throws JSONException {
        JSONObject jObject = new JSONObject(inJson);
        String docSubTypeInt = jObject.getString("docSubType");
        return docSubTypeInt;
    }




}
