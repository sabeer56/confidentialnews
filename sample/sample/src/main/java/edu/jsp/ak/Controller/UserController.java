package edu.jsp.ak.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.jsp.ak.Dto.AdminDetails;
import edu.jsp.ak.Dto.NewsData;
import edu.jsp.ak.Dto.UserDetails;
import edu.jsp.ak.Service.AdminService;
import edu.jsp.ak.Service.NewsService;
import edu.jsp.ak.Service.UserService;
import edu.jsp.ak.repo.NewsDataRepository;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    public UserService serv;

    @Autowired
    public NewsService nserv;

    @Autowired
    public NewsDataRepository nrepo;

    @Autowired
    public AdminService aserv;

    // User Endpoints
    @PostMapping("login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("keyverification.jsp");

        if (serv.authenticateUser(username, password)) {
            return mv;
        } else {
            mv.setViewName("login.jsp");
            mv.addObject("error", "Invalid username or password");
            return mv;
        }
    }

    @PostMapping("/deleteuserrun")
    public ResponseEntity<String> deleteUser(@RequestBody UserDetails userDetails) {
        if (serv.deleteUserByUsernameAndPassword(userDetails.getUsername(), userDetails.getPassword())) {
            return ResponseEntity.ok("User account has been successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User account does not exist");
        }
    }

    // Admin Endpoints
    @PostMapping("saveadmin")
    public ModelAndView saveIdentityAdmin(@ModelAttribute AdminDetails i) {
        ModelAndView mv = new ModelAndView();
        aserv.saveIdentity(i);
        mv.setViewName("loginasadmin.jsp");
        return mv;
    }

    @PostMapping("loginasadmin")
    public ModelAndView adminLogin(@RequestParam String username, @RequestParam String password) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Key.jsp");

        if (aserv.authenticateUser(username, password)) {
            return mv;
        } else {
            mv.setViewName("loginasadmin.jsp");
            mv.addObject("error", "Invalid username or password");
            return mv;
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNewsById(@PathVariable("id") int id) {
        nserv.deleteById(id);
        return "News item with ID " + id + " deleted successfully";
    }

    // News Endpoints
    @GetMapping("newsadmin")
    public ModelAndView getNewsAdmin(HttpServletRequest req) {
        List<NewsData> newsList = nrepo.findAll();
        req.setAttribute("newses", newsList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList", newsList);
        mv.setViewName("NewsAdmin.jsp");
        return mv;
    }

    @GetMapping("news")
    public ModelAndView getNews(HttpServletRequest req) {
        List<NewsData> newsList = nrepo.findAll();
        req.setAttribute("newses", newsList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList", newsList);
        mv.setViewName("News.jsp");
        return mv;
    }

    @PostMapping("savenews")
    public ModelAndView saveNewsData(@ModelAttribute NewsData newsData, @RequestParam("image") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            // Get the original image data
            byte[] originalImageData = imageFile.getBytes();

            // Compress the image data
            byte[] compressedImageData = compressImageData(originalImageData);

            // Set both original and compressed image data to the newsData object
            newsData.setImageData(originalImageData);
            newsData.setCompressedImageData(compressedImageData);
        }

        // Save the news data
        nserv.saveData(newsData);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("newsdata.jsp");
        return mv;
    }

    @PostMapping("/update")
    public ModelAndView updateNewsData(@RequestParam int id,
                                       @RequestParam String heading,
                                       @RequestParam String paragraph,
                                       @RequestParam MultipartFile image,
                                       HttpServletRequest req) {
        try {
            byte[] compressedImageData = compressImageData(image.getBytes());
            nserv.updateData(id, heading, paragraph, compressedImageData);
            List<NewsData> newsList = nrepo.findAll();
            req.setAttribute("newses", newsList);

            ModelAndView mv = new ModelAndView();
            mv.addObject("newsList", newsList);
            mv.setViewName("NewsAdmin.jsp");
            return mv;
        } catch (IOException e) {
            return null;
        }
    }

    @GetMapping("/news/{id}")
    public NewsData getNewsById(@PathVariable("id") int id) {
        return nserv.fetchById(id);
    }

    // User Utility Methods
    @PostMapping("save")
    public ModelAndView saveIdentity(@ModelAttribute UserDetails i) {
        ModelAndView mv = new ModelAndView();
        serv.saveIdentity(i);
        mv.setViewName("login.jsp");
        return mv;
    }

    @GetMapping("getbyid")
    public UserDetails fetchById(@RequestParam("mn") int id) {
        return serv.fetchById(id);
    }

    @DeleteMapping("deleteuser/{id}")
    public String deleteById(@PathVariable int id) {
        serv.deleteById(id);
        return "deleted";
    }

    @PutMapping("updateuser")
    public UserDetails updateIdentity(@RequestParam int id, @RequestBody UserDetails i) {
        return serv.updateIdentity(id, i);
    }
    
    @GetMapping("/keyverification")
    public ModelAndView keyVerificationForNews(@RequestParam("key") String key) {
    	 ModelAndView modelAndView = new ModelAndView();
    	 String keys="AzKm162";
    	 if(key.equals(keys)) {
    		 modelAndView.setViewName("News.jsp");
    	 }
    	 else {
    		 modelAndView.setViewName("keyverification.jsp");
    	 }
    	 return modelAndView;
    }

    // Directory Endpoints
    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Home.jsp");
        return modelAndView;
    }

    @GetMapping("home")
    public ModelAndView homeDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Home.jsp");
        return mv;
    }

    @GetMapping("login")
    public ModelAndView loginDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.jsp");
        return mv;
    }

    @GetMapping("signin")
    public ModelAndView signDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signin.jsp");
        return mv;
    }

    @GetMapping("signinasadmin")
    public ModelAndView signAsAdminDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signinAsAdmin.jsp");
        return mv;
    }

    @GetMapping("loginasadmin")
    public ModelAndView loginAsAdminDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("loginasadmin.jsp");
        return mv;
    }

    @GetMapping("key")
    public ModelAndView keyDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Key.jsp");
        return mv;
    }

    @GetMapping("newsdata")
    public ModelAndView addNewsDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("newsdata.jsp");
        return mv;
    }

    @GetMapping("deleteuser")
    public ModelAndView deleteUserDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("DeleteUser.jsp");
        return mv;
    }

    @GetMapping("deleted")
    public ModelAndView deletedDirectory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("deleted.html");
        return mv;
    }

    // Utility Methods
    private byte[] compressImageData(byte[] originalImageData) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(originalImageData);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        deflater.end();
        return outputStream.toByteArray();
    }

    private byte[] decompressImageData(byte[] compressedImageData) throws IOException, DataFormatException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Inflater inflater = new Inflater();
        inflater.setInput(compressedImageData);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        inflater.end();
        return outputStream.toByteArray();
    }
}
