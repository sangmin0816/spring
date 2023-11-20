package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.CourseMaterials;
import kr.ed.haebeop.service.CourseMaterialsService;

import kr.ed.haebeop.domain.Storage;
import kr.ed.haebeop.service.StorageService;
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
@RequestMapping("/courseMaterials/*")
public class CourseMaterialsCtrl {
    @Autowired
    private CourseMaterialsService courseMaterialsService;

    @Autowired
    private StorageService storageService;
    
    // CourseMaterials
    @GetMapping("courseMaterialsList")
    public String courseMaterialsList(HttpServletRequest request, Model model) throws Exception {
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        int curPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        Page page = new Page();
        page.setSearchType(type);
        page.setSearchKeyword(keyword);
        page.setCourseNo(courseNo);

        int total;

        if(type==null){type="";}
        switch(type){
            case "title":
                total = courseMaterialsService.courseMaterialsTitleCount(page);
                break;
            case "content":
                total = courseMaterialsService.courseMaterialsContentCount(page);
                break;
            case "id":
                total = courseMaterialsService.courseMaterialsIdCount(page);
                break;
            default:
                total = courseMaterialsService.courseMaterialsCount(courseNo);
        }

        page.makeBlock(curPage, total);
        page.makeLastPageNum(total);
        page.makePostStart(curPage, total);

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("curPage", curPage);

        List<CourseMaterials> courseMaterialsList;
        switch(type){
            case "title":
                courseMaterialsList = courseMaterialsService.courseMaterialsTitleList(page);
                break;
            case "content":
                courseMaterialsList = courseMaterialsService.courseMaterialsContentList(page);
                break;
            case "id":
                courseMaterialsList = courseMaterialsService.courseMaterialsIdList(page);
                break;
            default:
                courseMaterialsList = courseMaterialsService.courseMaterialsPageList(page);
        }

        model.addAttribute("courseNo", courseNo);
        model.addAttribute("courseMaterialsList", courseMaterialsList);
        return "/course/courseMaterials/courseMaterialsList";
    }

    @GetMapping("courseMaterialsGet")
    public String courseMaterialsGet(HttpServletRequest request, Model model) throws Exception {
        int materialNo = Integer.parseInt(request.getParameter("materialNo"));
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        CourseMaterials dto = courseMaterialsService.courseMaterialsGet(materialNo);

        if(dto.isHasFile()){
            Storage temp = new Storage();
            temp.setBoardName("courseMaterials");
            temp.setBoardNo(materialNo);

            List<Storage> storages = storageService.storageBoardList(temp);

            System.out.println(storages);

            model.addAttribute("storages", storages);
        }

        model.addAttribute("courseNo", courseNo);
        model.addAttribute("courseMaterials", dto);

        return "/course/courseMaterials/courseMaterialsGet";
    }

    @GetMapping("courseMaterialsInsert")
    public String courseMaterialsInsertForm(HttpServletRequest request, Model model) {
        int courseNo = Integer.parseInt(request.getParameter("courseNo"));
        model.addAttribute("courseNo", courseNo);

        return "/course/courseMaterials/courseMaterialsInsert";
    }


    // private static String uploadFolder = "D:\\sangmin0816\\luigi\\project3\\src\\main\\webapp\\resources\\upload";

    @PostMapping("courseMaterialsInsert")
    public String courseMaterialsInsert(MultipartHttpServletRequest files, HttpServletRequest req, Model model) throws Exception {
        String realFolder = req.getRealPath("/resource/upload");

        CourseMaterials dto = new CourseMaterials();

        Enumeration<String> e = files.getParameterNames();
        Map map = new HashMap();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = files.getParameter(name);
            map.put(name, value);
        }

        int courseNo = Integer.parseInt((String)map.get("courseNo"));

        dto.setCourseNo(courseNo);
        dto.setTitle((String) map.get("title"));
        dto.setContent((String) map.get("contents"));
        dto.setId((String) map.get("sid"));

        courseMaterialsService.courseMaterialsInsert(dto);
        CourseMaterials last = courseMaterialsService.courseMaterialsGetLast();


        String today = new SimpleDateFormat("yyMMdd").format(new Date());
        String saveFolder = realFolder + File.separator + today;
        File folder = new File(saveFolder);

        if(!folder.exists()){
            folder.mkdirs();
        }

        List<MultipartFile> fileList = files.getFiles("uploadFiles");

        boolean hasFile = false;
        for(MultipartFile multipartFile : fileList){
            String originalName = multipartFile.getOriginalFilename();
            if(!originalName.isEmpty()){
                hasFile = true;
                String saveName = UUID.randomUUID().toString()+"_"+originalName;

                Storage storage = new Storage();
                storage.setBoardNo(last.getMaterialNo());
                storage.setOriginName(originalName);
                storage.setSaveName(saveName);
                storage.setSavePath(today);
                storage.setBoardName("courseMaterials");

                storageService.storageInsert(storage);

                File savefile = new File(saveFolder, saveName);

                try{
                    multipartFile.transferTo(savefile);
                } catch (Exception except){
                    System.out.println(except.getMessage());
                }
            }
        }


        if(hasFile){
            last.setHasFile(true);
            courseMaterialsService.courseMaterialsUpdate(last);
        }

        return "redirect:courseMaterialsList?courseNo="+courseNo;
    }

    @GetMapping("courseMaterialsDelete")
    public String courseMaterialsDelete(HttpServletRequest request) throws Exception {
        int bno = Integer.parseInt(request.getParameter("bno"));
        courseMaterialsService.courseMaterialsDelete(bno);

        int courseNo = Integer.parseInt(request.getParameter("courseNo"));

        return "redirect:courseMaterialsList?courseNo="+courseNo;
    }

    @GetMapping("courseMaterialsUpdate")
    public String courseMaterialsUpdateForm(HttpServletRequest request, Model model) throws Exception {
        int bno = Integer.parseInt(request.getParameter("bno"));

        CourseMaterials dto = courseMaterialsService.courseMaterialsGet(bno);
        Storage temp = new Storage();
        temp.setBoardNo(bno);
        temp.setBoardName("databoard");
        List<Storage> storages = storageService.storageBoardList(temp);

        model.addAttribute("dto", dto);
        model.addAttribute("storages", storages);

        return "/course/courseMaterials/courseMaterialsUpdate";
    }

    @PostMapping("courseMaterialsUpdate")
    public String courseMaterialsUpdatePro(MultipartHttpServletRequest files, HttpServletRequest req, Model model) throws Exception {
        String realFolder = req.getRealPath("/resources/upload");

        CourseMaterials dto = new CourseMaterials();

        Enumeration<String> e = files.getParameterNames();
        Map map = new HashMap();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = files.getParameter(name);
            map.put(name, value);
        }

        int bno = Integer.parseInt((String) map.get("bno"));
        dto.setMaterialNo(bno);
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

                Storage storage = new Storage();
                storage.setBoardNo(bno);
                storage.setOriginName(originalName);
                storage.setSaveName(saveName);
                storage.setSavePath(saveFolder);

                storageService.storageInsert(storage);

                File savefile = new File(saveFolder, saveName);

                try{
                    multipartFile.transferTo(savefile);
                } catch (Exception except){
                    System.out.println(except.getMessage());
                }
            }
        }


        courseMaterialsService.courseMaterialsUpdate(dto);

        return "redirect:courseMaterialsList";
    }
}
