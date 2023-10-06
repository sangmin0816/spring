package kr.ed.haebeop.util;

import kr.ed.haebeop.domain.Holiday;
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

public class Holyday {
    //공휴일 정보 로딩 - yyyy-MM-dd 입력

    public String getDayOff(String date) throws Exception {
        String yyyy = date.substring(0, 4);
        String mm = date.substring(5, 7);
        String dd = date.substring(8, 10);

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
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
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
    //국경일 정보 로딩
    public String getHoliday(String date) throws Exception {
        String yyyy = date.substring(0, 4);
        String mm = date.substring(5, 7);
        String dd = date.substring(8, 10);

        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=w%2BrTXuzOm4hEphqqzsFctJRKCMRsbBvQ55%2BDsTk%2FptN8X%2FuZLBgseXYK3mPFkADq%2F4iE88pHQLFmYYOtQjA76w%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("solYear","UTF-8") + "=" + URLEncoder.encode(yyyy, "UTF-8")); /*연*/
        urlBuilder.append("&" + URLEncoder.encode("solMonth","UTF-8") + "=" + URLEncoder.encode(mm, "UTF-8")); /*월*/

        URL url = new URL(urlBuilder.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json; charset=UTF-8");

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

    //기념일 정보 로딩
    public String getAnniversary(String date) throws Exception {
        String yyyy = date.substring(0, 4);
        String mm = date.substring(5, 7);
        String dd = date.substring(8, 10);

        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getAnniversaryInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=w%2BrTXuzOm4hEphqqzsFctJRKCMRsbBvQ55%2BDsTk%2FptN8X%2FuZLBgseXYK3mPFkADq%2F4iE88pHQLFmYYOtQjA76w%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("solYear","UTF-8") + "=" + URLEncoder.encode(yyyy, "UTF-8")); /*연*/
        urlBuilder.append("&" + URLEncoder.encode("solMonth","UTF-8") + "=" + URLEncoder.encode(mm, "UTF-8")); /*월*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
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

    //24절기 로딩
    public String getSolarTerms(String date) throws Exception {
        String yyyy = date.substring(0, 4);
        String mm = date.substring(5, 7);
        String dd = date.substring(8, 10);

        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/get24DivisionsInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=w%2BrTXuzOm4hEphqqzsFctJRKCMRsbBvQ55%2BDsTk%2FptN8X%2FuZLBgseXYK3mPFkADq%2F4iE88pHQLFmYYOtQjA76w%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("solYear","UTF-8") + "=" + URLEncoder.encode(yyyy, "UTF-8")); /*연*/
        urlBuilder.append("&" + URLEncoder.encode("solMonth","UTF-8") + "=" + URLEncoder.encode(mm, "UTF-8")); /*월*/
        urlBuilder.append("&" + URLEncoder.encode("kst","UTF-8") + "=" + URLEncoder.encode("0120", "UTF-8")); /*한국표준시각*/
        urlBuilder.append("&" + URLEncoder.encode("sunLongitude","UTF-8") + "=" + URLEncoder.encode("285", "UTF-8")); /*태양황경*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("totalCount","UTF-8") + "=" + URLEncoder.encode("210114", "UTF-8")); /*전체 출력건수*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
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
    public List<Holiday> parseArrayList(String data) throws Exception{
        List<Holiday> holiList = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
        JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
        JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
        JSONObject jsonItems = (JSONObject) jsonBody.get("items");
        JSONArray dataArray = (JSONArray) jsonItems.get("item");
        for(int i=1;i<dataArray.size();i++) {
            JSONObject calObject = (JSONObject) dataArray.get(i);
            Holiday holi = new Holiday();

            holi.setDateName(calObject.get("dateName").toString());
            holi.setDateKind(calObject.get("dateKind").toString());
            holi.setLocdate(calObject.get("locdate").toString());

            if(calObject.containsKey("kst")){
                holi.setKst(calObject.get("kst").toString());
            }

            holi.setIsHoliday(calObject.get("isHoliday").toString());
            holi.setSeq(calObject.get("seq").toString());
            holiList.add(holi);
        }
        return holiList;
    }
    //공휴일 리스트 반환
    public List<Holiday> getDayOffList(String data) throws Exception {
        String h = this.getDayOff(data);
        List<Holiday> holiList = this.parseArrayList(this.parseJson(h));
        return holiList;
    }
    //국경일 리스트 반환
    public List<Holiday> getHolidayList(String data) throws Exception {
        String h = this.getHoliday(data);
        List<Holiday> holiList = this.parseArrayList(this.parseJson(h));
        return holiList;
    }
    //기념일 리스트 반환
    public List<Holiday> getAnniversaryList(String data) throws Exception {
        String h = this.getAnniversary(data);
        List<Holiday> holiList = this.parseArrayList(this.parseJson(h));
        return holiList;
    }
    //24절기 리스트 반환
    public List<Holiday> getSolarTermsList(String data) throws Exception {
        String h = this.getSolarTerms(data);
        List<Holiday> holiList = this.parseArrayList(this.parseJson(h));
        return holiList;
    }
}
