package edu.jsp.ak.Service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import edu.jsp.ak.Dao.NewsDao;
import edu.jsp.ak.Dto.NewsData;
import edu.jsp.ak.repo.NewsDataRepository;

@Service
public class NewsService {
	@Autowired
	public NewsDao dao;
	
	@Autowired
    private NewsDataRepository newsDataRepository;

	private NewsDataRepository newsRepository;
	
	public NewsData saveData(NewsData i) {
		return dao.saveData(i);
	}
	
	public NewsData fetchById(int id) {
		return dao.fetchById(id);
	}
	
	public String deleteById(int id) {
		NewsData i=dao.fetchById(id);
	    if(i!=null) {
	    	dao.deleteById(id);
	    	return id+" deleted";
	    }
	    return null;
	}

	
	public NewsService(NewsDataRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void updateData(int id, String heading, String paragraph, byte[] imageData) throws IOException {
        Optional<NewsData> optionalNewsData = newsRepository.findById(id);
        if (optionalNewsData.isPresent()) {
            NewsData newsData = optionalNewsData.get();
            newsData.setHeading(heading);
            newsData.setParagraph(paragraph);
            newsData.setCompressedImageData(imageData);
            newsRepository.save(newsData);
        } else {
            throw new IllegalArgumentException("News data with ID " + id + " not found");
        }
    }

}
