package org.jlab.groot.math;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionFactory02Test {

    @Test
    void asin2() throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/arcsintest.json"));
        JSONArray jsonArray = (JSONArray) obj;


        ArrayList<String> list = new ArrayList<String>();

        if (jsonArray != null) {

            for (Object o : jsonArray) {

                list.add(o.toString().replaceAll("\"testval\":","").replace("{","").replace("}",""));
            }
        }

        double[] expect = {0.4115,-0.6435,-0.7754,0.6435,1.1198};

        for (int i = 0; i<list.size();i++){
            assertEquals(expect[i],(double)Math.round( FunctionFactory.asin(Double.parseDouble(list.get(i)))* 10000d) / 10000d);
        }


    }
}
