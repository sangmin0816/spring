package kr.ed.haebeop.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.ed.haebeop.domain.FileDTO;
import kr.ed.haebeop.mapper.FileUploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/files/")
public class FilesCtrl {
    @Autowired
    String uploadPath;

    @Autowired
    FileUploadMapper fileUploadMapper;

    @GetMapping("fileupload")
    public String files(Model model){
        List<FileDTO> fileList = fileUploadMapper.fileList();
        model.addAttribute("fileList", fileList);

        return "/files/fileupload";
    }

    @PostMapping("fileupload1")
    public String upload1(HttpServletRequest request, HttpServletResponse response) {
        int maxFileSize = 1024 * 1024 * 10;
        String encType = "utf-8";

        MultipartRequest multi = null;

        try {
            multi = new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
            System.out.println(multi.getOriginalFileName("upload"));
            System.out.println(multi.getFilesystemName("upload"));

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        }

        return "/files/fileupload";
    }

    @PostMapping("fileupload2")
    public String upload2(MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
//        개발 서버의 업로드 디렉토리
        List<MultipartFile> storageList = multipartHttpServletRequest.getFiles("files");
        for(MultipartFile multipartFile: storageList){
            if(multipartFile.isEmpty()){continue;}
            String uploadFilename = multipartFile.getOriginalFilename();

            fileInsert(multipartFile.getOriginalFilename(), uploadFilename, multipartFile.getContentType(), getDateFolder());
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
        }

        return "/files/fileupload";
    }

    @PostMapping("fileupload3")
    public String upload3(HttpServletRequest request, RedirectAttributes rttr, List<MultipartFile> storages) throws IOException {
        ServletContext application = request.getSession().getServletContext();
        String realPath = application.getRealPath("/resources/upload");
//        실제 운영 서버의 업로드 디렉토리

        File uploadPath = new File(realPath, getDateFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for(MultipartFile multipartFile: storages){
            if(multipartFile.isEmpty()){continue;}
            String uploadFilename = multipartFile.getOriginalFilename();

            UUID uuid = UUID.randomUUID();
            uploadFilename = uuid.toString()+"_"+uploadFilename;

            fileInsert(multipartFile.getOriginalFilename(), uploadFilename, multipartFile.getContentType(), getDateFolder());
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
        }

        return "/files/fileupload";
    }

    @ResponseBody
    @PostMapping("fileupload4")
    public List<String> upload4(MultipartHttpServletRequest multipartRequest) throws IOException{
        List<MultipartFile> storageList = multipartRequest.getFiles("files");
        List<String> storageNames = new ArrayList<>();

        ServletContext application = multipartRequest.getSession().getServletContext();
        String realPath = application.getRealPath("/resources/upload");

        File uploadPath = new File(realPath);
        for (MultipartFile multipartFile : storageList) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            String uploadFilename = multipartFile.getOriginalFilename();

            fileInsert(multipartFile.getOriginalFilename(), uploadFilename, multipartFile.getContentType(), getDateFolder());
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
            storageNames.add(uploadFilename);
        }
        return storageNames;
    }

    private String getDateFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }

    private void fileInsert(String originalFilename, String uploadFilename, String fileType, String uploadPath){
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFileName(originalFilename);
        fileDTO.setSaveName(uploadFilename);
        fileDTO.setFileType(fileType);
        fileDTO.setSaveFolder(uploadPath);
        fileUploadMapper.fileInsert(fileDTO);
    }
}
