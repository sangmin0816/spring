package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.DataBoard;
import kr.ed.haebeop.domain.DataFile;
import kr.ed.haebeop.service.DataBoardService;
import kr.ed.haebeop.service.DataFileService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/dataBoard/*")
public class DataBoardController {
    @Autowired
    private DataBoardService dataBoardService;

    @Autowired
    private DataFileService dataFileService;

    // DataBoard
    @GetMapping("dataBoardList")
    public String dataBoardList(HttpServletRequest request, Model model) throws Exception {
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);
        int total = dataBoardService.dataBoardCount(page);

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<DataBoard> boardList = dataBoardService.dataBoardList(page);
        model.addAttribute("fileboardList", boardList);
        return "/dataBoard/dataBoardList";
    }

    @GetMapping("dataBoardGet")
    public String dataBoardGet(HttpServletRequest request, Model model) throws Exception {
        int bno = Integer.parseInt(request.getParameter("bno"));
        DataBoard dto = dataBoardService.dataBoardGet(bno);
        DataFile temp = new DataFile();
        temp.setBno(bno);
        temp.setRelations("databoard");
        List<DataFile> dataFiles = dataFileService.dataFileBoardList(temp);

        model.addAttribute("dto", dto);
        model.addAttribute("dataFiles", dataFiles);
        return "/dataBoard/dataBoardGet";
    }

    @GetMapping("dataBoardInsert")
    public String dataBoardInsertForm() {
        return "/dataBoard/dataBoardInsert";
    }


    // private static String uploadFolder = "D:\\sangmin0816\\luigi\\project3\\src\\main\\webapp\\resources\\upload";

    @PostMapping("dataBoardInsert")
    public String dataBoardInsert(MultipartHttpServletRequest files, HttpServletRequest req, Model model) throws Exception {
        String realFolder = req.getRealPath("/resources/upload");

        DataBoard dto = new DataBoard();

        Enumeration<String> e = files.getParameterNames();
        Map map = new HashMap();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = files.getParameter(name);
            map.put(name, value);
        }

        dto.setTitle((String) map.get("title"));
        dto.setContent((String) map.get("contents"));
        dto.setAuthor((String) map.get("sid"));

        String today = new SimpleDateFormat("yyMMdd").format(new Date());
        String saveFolder = realFolder + File.separator + today;
        File folder = new File(saveFolder);

        if(!folder.exists()){
            folder.mkdirs();
        }

        List<MultipartFile> fileList = files.getFiles("uploadFiles");

        for(MultipartFile multipartFile : fileList){
            String originalName = multipartFile.getOriginalFilename();
            if(!originalName.isEmpty()){
                String saveName = UUID.randomUUID().toString()+"_"+originalName;

                DataFile dataFile = new DataFile();
                dataFile.setBno(0);
                dataFile.setFileName(originalName);
                dataFile.setSaveName(saveName);
                dataFile.setFileType(multipartFile.getContentType());
                dataFile.setSaveFolder(today);

                dataFileService.dataFileInsert(dataFile);

                File savefile = new File(saveFolder, saveName);

                try{
                    multipartFile.transferTo(savefile);
                } catch (Exception except){
                    System.out.println(except.getMessage());
                }
            }
        }


        dataBoardService.dataBoardInsert(dto);

        return "redirect:dataBoardList";
    }

    @GetMapping("dataBoardDelete")
    public String dataBoardDelete(HttpServletRequest request) throws Exception {
        int bno = Integer.parseInt(request.getParameter("bno"));
        dataBoardService.dataBoardDelete(bno);

        return "redirect:dataBoardList";
    }

    @GetMapping("dataBoardUpdate")
    public String dataBoardUpdateForm(HttpServletRequest request, Model model) throws Exception {
        int bno = Integer.parseInt(request.getParameter("bno"));

        DataBoard dto = dataBoardService.dataBoardGet(bno);
        DataFile temp = new DataFile();
        temp.setBno(bno);
        temp.setRelations("databoard");
        List<DataFile> dataFiles = dataFileService.dataFileBoardList(temp);

        model.addAttribute("dto", dto);
        model.addAttribute("dataFiles", dataFiles);

        return "/dataBoard/dataBoardUpdate";
    }

    @PostMapping("dataBoardUpdate")
    public String dataBoardUpdatePro(MultipartHttpServletRequest files, HttpServletRequest req, Model model) throws Exception {
        String realFolder = req.getRealPath("/resources/upload");

        DataBoard dto = new DataBoard();

        Enumeration<String> e = files.getParameterNames();
        Map map = new HashMap();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = files.getParameter(name);
            map.put(name, value);
        }

        int bno = Integer.parseInt((String) map.get("bno"));
        dto.setBno(bno);
        dto.setTitle((String) map.get("title"));
        dto.setContent((String) map.get("contents"));

        String today = new SimpleDateFormat("yyMMdd").format(new Date());
        String saveFolder = realFolder + File.separator + today;
        File folder = new File(saveFolder);

        if(!folder.exists()){
            folder.mkdirs();
        }

        List<MultipartFile> fileList = files.getFiles("uploadFiles");

        for(MultipartFile multipartFile : fileList){
            String originalName = multipartFile.getOriginalFilename();
            if(!originalName.isEmpty()){
                String saveName = UUID.randomUUID().toString()+"_"+originalName;

                DataFile dataFile = new DataFile();
                dataFile.setBno(bno);
                dataFile.setFileName(originalName);
                dataFile.setSaveName(saveName);
                dataFile.setFileType(multipartFile.getContentType());
                dataFile.setSaveFolder(saveFolder);

                dataFileService.dataFileInsert(dataFile);

                File savefile = new File(saveFolder, saveName);

                try{
                    multipartFile.transferTo(savefile);
                } catch (Exception except){
                    System.out.println(except.getMessage());
                }
            }
        }


        dataBoardService.dataBoardUpdate(dto);

        return "redirect:dataBoardList";
    }
}
