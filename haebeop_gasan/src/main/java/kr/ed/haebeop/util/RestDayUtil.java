package kr.ed.haebeop.util;

import kr.ed.haebeop.domain.RestDay;
import org.json.JSONException;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class RestDayUtil {
    //공휴일 정보 로딩 - yyyy-MM-dd 입력

    public String getRestDay(String yyyymm) throws Exception {
        String yyyy = yyyymm.substring(0, 4);
        String mm = yyyymm.substring(4);

        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=w%2BrTXuzOm4hEphqqzsFctJRKCMRsbBvQ55%2BDsTk%2FptN8X%2FuZLBgseXYK3mPFkADq%2F4iE88pHQLFmYYOtQjA76w%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("solYear","UTF-8") + "=" + URLEncoder.encode(yyyy, "UTF-8")); /*연*/
        urlBuilder.append("&" + URLEncoder.encode("solMonth","UTF-8") + "=" + URLEncoder.encode(mm, "UTF-8")); /*월*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    //xml을 JSON으로 변환
    public String parseJson(String data) throws JSONException {
        org.json.JSONObject json = XML.toJSONObject(data);
        String jdata = json.toString();
        return jdata;
    }

    //JSON을 리스트로 변환
    public List<RestDay> parseArrayList(String data) throws Exception{
        List<RestDay> restList = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
        JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
        JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
        JSONObject jsonItems = (JSONObject) jsonBody.get("items");
        JSONArray dataArray = (JSONArray) jsonItems.get("item");
        for(int i=1;i<dataArray.size();i++) {
            JSONObject calObject = (JSONObject) dataArray.get(i);
            RestDay rest = new RestDay();

            rest.setDateName(calObject.get("dateName").toString());
            rest.setDateKind(calObject.get("dateKind").toString());
            rest.setLocdate(calObject.get("locdate").toString());

            if(calObject.containsKey("kst")){
                rest.setKst(calObject.get("kst").toString());
            }

            rest.setIsHoliday(calObject.get("isHoliday").toString());
            rest.setSeq(calObject.get("seq").toString());
            restList.add(rest);
        }
        return restList;
    }
    //공휴일 리스트 반환
    public List<RestDay> getRestDayList(String data) throws Exception {
        String h = this.getRestDay(data);
        List<RestDay> restList = this.parseArrayList(this.parseJson(h));

        return restList;
    }
}
