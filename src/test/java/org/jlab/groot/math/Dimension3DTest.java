package org.jlab.groot.math;


import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class Dimension3DTest {


    @Test
    public void test_set() {
        List<Dimension3D> dim3ds = new ArrayList<>();

        try {
            // create reader
            BufferedReader reader = Files.newBufferedReader(Paths.get(Dimension3DTest.class.getResource("/MOCK_DATA.json").toURI()));

            // create parser
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

            JsonArray minMaxDims = (JsonArray) parser.get("data");
            minMaxDims.forEach(entry -> {
                JsonObject minMax3d = (JsonObject) entry;
                Dimension3D dim3d = new Dimension3D();
                dim3d.set(((BigDecimal) minMax3d.get("min_x")).doubleValue(), ((BigDecimal) minMax3d.get("max_x")).doubleValue(),
                        ((BigDecimal) minMax3d.get("min_y")).doubleValue(), ((BigDecimal)minMax3d.get("max_y")).doubleValue(),
                        ((BigDecimal) minMax3d.get("min_z")).doubleValue(), ((BigDecimal)minMax3d.get("max_z")).doubleValue());
                dim3ds.add(dim3d);
            });


            JsonArray entries = (JsonArray) parser.get("data");
            List<List<Double>> nums = new ArrayList<>();
            entries.forEach(entry -> {
                JsonObject threed = (JsonObject) entry;
                List<Double> tmp = new ArrayList<>();
                tmp.add(((BigDecimal) threed.get("min_x")).doubleValue());
                tmp.add(((BigDecimal) threed.get("max_x")).doubleValue());
                tmp.add(((BigDecimal) threed.get("min_y")).doubleValue());
                tmp.add(((BigDecimal) threed.get("max_y")).doubleValue());
                tmp.add(((BigDecimal) threed.get("min_z")).doubleValue());
                tmp.add(((BigDecimal) threed.get("max_z")).doubleValue());
                nums.add(tmp);
            });


            for (int i = 0; i < 1000; i++) {
                Dimension3D t3d = dim3ds.get(i);
                List<Double> nnn = nums.get(i);

                // test first dimension of 3d
                assertEquals(t3d.getDimension(0).getMin(), nnn.get(0));
                assertEquals(t3d.getDimension(0).getMax(), nnn.get(1));

                // test the second dimension of 3d
                assertEquals(t3d.getDimension(1).getMin(), nnn.get(2));
                assertEquals(t3d.getDimension(1).getMax(), nnn.get(3));

                // test the third dimension of 3d
                assertEquals(t3d.getDimension(2).getMin(), nnn.get(4));
                assertEquals(t3d.getDimension(2).getMax(), nnn.get(5));
            }
        } catch (IOException | JsonException e) {
            e.printStackTrace();
            fail("Cannot open Mock data file!");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}