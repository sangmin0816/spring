package kr.ed.haebeop.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GeoCoder {
    private static String apikey = "B722D185-9BDE-335C-B24F-B7A3EB2CC967";

    public static void main(String[] args) {
        String searchAddr = "서울특별시 금천구 디지털로9길 23";
        String searchType = "road";
        List<String> points = geocode(searchType, searchAddr);
    }

    public static List<String> geocode(String searchType, String searchAddr) {
        String epsg = "epsg:4326";

        StringBuilder sb = new StringBuilder("https://api.vworld.kr/req/address");

        sb.append("?service=address");
        sb.append("&request=getCoord");
        sb.append("&format=json");
        sb.append("&crs=" + epsg);
        sb.append("&key=" + apikey);
        sb.append("&type=" + searchType);
        sb.append("&address=" + URLEncoder.encode(searchAddr, StandardCharsets.UTF_8));

        try {
            URL url = new URL(sb.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

            JSONParser jspa = new JSONParser();
            JSONObject jsob = (JSONObject) jspa.parse(reader);
            JSONObject jsrs = (JSONObject) jsob.get("response");
            JSONObject jsResult = (JSONObject) jsrs.get("result");
            JSONObject jspoitn = (JSONObject) jsResult.get("point");

            List<String> points = new ArrayList<>();
            points.add((String) jspoitn.get("x"));
            points.add((String) jspoitn.get("y"));

            return points;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
