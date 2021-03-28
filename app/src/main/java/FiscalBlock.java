import org.json.JSONArray;
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
        String docSubType = jObject.getString("docSubType");
        return docSubType;
    }

    // тестовий витяг значення sum
    public int getSumm(String inJson) throws JSONException {
        JSONObject jObject = new JSONObject(inJson);
        String docSubType = jObject.getString("docSubType");
        if(!docSubType.equals("0")) return - 1;
        int summInt = jObject.getInt("sum");
        return summInt;
    }

    // тестовий підрахунок значення суми всіх товарів
    public int calcSumm(String inJson) throws JSONException {
        JSONObject jObject = new JSONObject(inJson);
        String docSubType = jObject.getString("docSubType");
        if(!docSubType.equals("0")) return - 2;
        //int summInt = jObject.getInt("sum");

        JSONArray jArray = jObject.getJSONArray("body");
        int summ = 0;
        for (int i=0; i < jArray.length(); i++)
        {
            try {
                JSONObject bodyObject = jArray.getJSONObject(i);
                // Pulling items from the array
                String bodyTypeString = bodyObject.getString("type");
                if(bodyTypeString.equals("1") ){
                    double summInt = bodyObject.getDouble("amount");
                    summ += summInt * 100;
                }
            } catch (JSONException e) {
                // Oops
                summ = -1;
            }
        }

        return summ;
    }

}
