import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FiscalBlockTestAndroid {

    private FiscalBlock fb;
    final String LOG_TAG = "TestLogAndr";

    //final String servicein = "{\"docSubType\": \"2\"}";

        final String servicein = "{\n" +
                "\"docSubType\": \"2\",\n" +
                "\"sum\": 500,\n" +
                "\"id\": \"b82d417a-7fc3-4d86-80c8-1419266260cc\",\n" +
                "\"cashierName\": \"Іванов Іван Іванович\"\n" +
                "}";

    final String serviceout = "{\n" +
            "\"docSubType\": \"4\",\n" +
            "\"sum\": 200,\n" +
            "\"id\": \"b82d417a-7fc3-4d86-80c8-1419266260cc\",\n" +
            "\"cashierName\": \"Іванов Іван Іванович\"\n" +
            "}";


    final String sale0 ="{\n" +
            "\"docSubType\": \"0\",\n" +
            "\"sum\": 13.6,\n" +
            "\"roundDiscount\": -0.04,\n" +
            "\"body\": [\n" +
            "{},\n" +
            "{},\n" +
            "{},\n" +
            "{},\n" +
            "{},\n" +
            "{},\n" +
            "{},\n" +
            "{}\n" +
            "],\n" +
            "\"id\": \"24d76279-c7ca-4d49-8927-8f241bb8cb07\",\n" +
            "\"cashierName\": \"Іванов Іван Іванович\"\n" +
            "}";

    final String sale ="{\n" +
            "   \"docSubType\":\"0\",\n" +
            "   \"sum\":386.00,\n" +
            "   \"roundDiscount\":0.02,\n" +
            "   \"body\":[\n" +
            "      {\n" +
            "         \"type\":\"0\",\n" +
            "         \"text\":\"Чек # 3 (1679)\",\n" +
            "         \"number\":1\n" +
            "      },\n" +
            "      {\n" +
            "         \"type\":\"0\",\n" +
            "         \"text\":\"Z: 23633 [370]\",\n" +
            "         \"number\":2\n" +
            "      },\n" +
            "      {\n" +
            "         \"type\":\"0\",\n" +
            "         \"text\":\"Каса: 503 [42]\",\n" +
            "         \"number\":3\n" +
            "      },\n" +
            "      {\n" +
            "         \"type\":\"1\",\n" +
            "         \"SKU\":13670,\n" +
            "         \"name\":\"Банан ваговий\",\n" +
            "         \"price\":11.49,\n" +
            "         \"quantity\":1.234,\n" +
            "         \"discountSum\":0.00,\n" +
            "         \"amount\":14.18,\n" +
            "         \"vatGroup\":\"А\",\n" +
            "         \"codeUnit\":3,\n" +
            "         \"unitName\":\"кг\",\n" +
            "         \"number\":4\n" +
            "      },\n" +
            "      {\n" +
            "         \"type\":\"1\",\n" +
            "         \"SKU\":13657,\n" +
            "         \"name\":\"Абрикос ваговий\",\n" +
            "         \"price\":21.99,\n" +
            "         \"quantity\":2.345,\n" +
            "         \"discountSum\":0.00,\n" +
            "         \"amount\":51.57,\n" +
            "         \"vatGroup\":\"А\",\n" +
            "         \"codeUnit\":3,\n" +
            "         \"unitName\":\"кг\",\n" +
            "         \"number\":5\n" +
            "      },\n" +
            "      {\n" +
            "         \"type\":\"1\",\n" +
            "         \"SKU\":36811,\n" +
            "         \"name\":\"ХанкiБанiстерблендВiск0,\",\n" +
            "         \"price\":127.49,\n" +
            "         \"quantity\":1,\n" +
            "         \"discountSum\":0.00,\n" +
            "         \"UKTZED\":\"2208304100\",\n" +
            "         \"amount\":127.49,\n" +
            "         \"vatGroup\":\"Г\",\n" +
            "         \"codeUnit\":1,\n" +
            "         \"unitName\":\"шт\",\n" +
            "         \"number\":6\n" +
            "      },\n" +
            "      {\n" +
            "         \"type\":\"1\",\n" +
            "         \"SKU\":37372,\n" +
            "         \"name\":\"ІкраЛососьДальм100гж/б\",\n" +
            "         \"price\":64.26,\n" +
            "         \"quantity\":3,\n" +
            "         \"discountSum\":0.00,\n" +
            "         \"amount\":192.78,\n" +
            "         \"vatGroup\":\"А\",\n" +
            "         \"codeUnit\":1,\n" +
            "         \"unitName\":\"шт\",\n" +
            "         \"number\":7\n" +
            "      },\n" +
            "      {\n" +
            "         \"type\":\"2\",\n" +
            "         \"sum\":386.00,\n" +
            "         \"returnSum\":14.00,\n" +
            "         \"name\":\"ГОТІВКА\",\n" +
            "         \"typePay\":0,\n" +
            "         \"number\":8\n" +
            "      }\n" +
            "   ],\n" +
            "   \"id\":\"92576911-1b17-46c9-9e7f-65adf4fcc7aa\",\n" +
            "   \"cashierName\":\"Іванов Іван Іванович\"\n" +
            "}";

    //final String serviceout ="";

    @Before
    public void init(){
        fb = new FiscalBlock();
    }

    @Test
    public void getDocTypeTest() throws Exception {
        String docSubTypeInt = fb.getDocType(servicein);
        Log.d(LOG_TAG, "docSubTypeInt = " + docSubTypeInt);
        assertEquals("2", docSubTypeInt);
    }

    @Test
    public void getDocCalcTest() throws Exception {
        int docSummInt = fb.calcSumm(sale);
        Log.d(LOG_TAG, "summ = " + docSummInt);
        assertEquals(38602, docSummInt);
    }
}
