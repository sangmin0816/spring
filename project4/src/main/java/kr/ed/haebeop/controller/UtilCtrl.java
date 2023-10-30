package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Storage;
import kr.ed.haebeop.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/util/*")
public class UtilCtrl {

    @RequestMapping(value="imageUpload", method = RequestMethod.POST)
    public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile, @RequestParam MultipartFile upload) throws Exception{

        // 랜덤 문자 생성
        UUID uid = UUID.randomUUID();

        OutputStream out = null;
        PrintWriter printWriter = null;

        //인코딩
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        try{
            //파일 이름 가져오기
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();

            //이미지 경로 생성
            String path = request.getRealPath("/resource/upload/");
            String ckUploadPath = path + uid + "_" + fileName;
            File folder = new File(path);

            //해당 디렉토리 확인
            if(!folder.exists()){
                try{
                    folder.mkdirs(); // 폴더 생성
                }catch(Exception e){
                    e.getStackTrace();
                }
            }

            out = new FileOutputStream(new File(ckUploadPath));
            out.write(bytes);
            out.flush(); // outputStram에 저장된 데이터를 전송하고 초기화

            String callback = request.getParameter("CKEditorFuncNum");
            printWriter = response.getWriter();
            String fileUrl = request.getContextPath() + "/util/ckImgSubmit?uid=" + uid + "&fileName=" + fileName; // 작성화면

            // 업로드시 메시지 출력
            printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
            printWriter.flush();

        }catch(IOException e){

            e.printStackTrace();

        } finally {

            try {
                if(out != null) { out.close(); }
                if(printWriter != null) { printWriter.close(); }
            } catch(IOException e) { e.printStackTrace(); }

        }
    }

    //ckeditor를 이용한 서버에 전송된 이미지 뿌려주기
    @RequestMapping(value="ckImgSubmit")
    public void ckSubmit(@RequestParam(value="uid") String uid, @RequestParam(value="fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //서버에 저장된 이미지 경로
        String path = request.getRealPath("/resource/upload/");
        String sDirPath = path + uid + "_" + fileName;

        File imgFile = new File(sDirPath);

        //사진 이미지 찾지 못하는 경우 예외처리로 빈 이미지 파일을 설정한다.
        if(imgFile.isFile()){
            byte[] buf = new byte[1024];
            int readByte = 0;
            int length = 0;
            byte[] imgBuf = null;

            FileInputStream fileInputStream = null;
            ByteArrayOutputStream outputStream = null;
            ServletOutputStream out = null;

            try{
                fileInputStream = new FileInputStream(imgFile);
                outputStream = new ByteArrayOutputStream();
                out = response.getOutputStream();

                while((readByte = fileInputStream.read(buf)) != -1){
                    outputStream.write(buf, 0, readByte);
                }

                imgBuf = outputStream.toByteArray();
                length = imgBuf.length;
                out.write(imgBuf, 0, length);
                out.flush();

            }catch(IOException e){
                e.printStackTrace();
            }finally {
                outputStream.close();
                fileInputStream.close();
                out.close();
            }
        }
    }


    @Autowired
    private StorageService storageService;


    // .ajax 방식으로 파일 첨부
    // https://github.com/kktlove/springframework/blob/master/study7/src/main/webapp/WEB-INF/views/fileupload/fileUpload4.jsp
    @ResponseBody
    @PostMapping("fileInsert")
    public int fileInsert(MultipartHttpServletRequest files, HttpServletRequest req){
        // 파일 이외의 변수 입력
        Enumeration<String> e = files.getParameterNames();
        Map map = new HashMap();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = files.getParameter(name);
            map.put(name, value);
        }
        String boardName = (String) map.get("boardName");
        int boardNo = (int) map.get("boardNo");


        // 파일 Insert
        String realFolder = req.getRealPath("/resource/upload");

        String today = new SimpleDateFormat("yyMMdd").format(new Date());
        String saveFolder = realFolder + File.separator + today;
        File folder = new File(saveFolder);

        if(!folder.exists()){
            folder.mkdirs();
        }

        List<MultipartFile> fileList = files.getFiles("uploadFiles");

        int sno = 0;
        for(MultipartFile multipartFile : fileList){
            String originalName = multipartFile.getOriginalFilename();
            if(!originalName.isEmpty()){
                String saveName = UUID.randomUUID().toString()+"_"+originalName;

                Storage storage = new Storage();
                storage.setOriginName(originalName);
                storage.setSaveName(saveName);
                storage.setSavePath(today);
                storage.setBoardName(boardName);
                storage.setBoardNo(boardNo);

                storageService.storageInsert(storage);

                sno = storageService.storageRecentNo();

                File savefile = new File(saveFolder, saveName);

                try{
                    multipartFile.transferTo(savefile);
                } catch (Exception except){
                    System.out.println(except.getMessage());
                }
            }
        }

        return sno;
    }
}