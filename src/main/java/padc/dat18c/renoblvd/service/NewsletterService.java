package padc.dat18c.renoblvd.service;

import padc.dat18c.renoblvd.Repository.NewsletterRepo;
import padc.dat18c.renoblvd.model.Newsletter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsletterService {

    final NewsletterRepo newsletterRepo;

    @Autowired
    private NewsletterService(NewsletterRepo newsletterRepo){
        this.newsletterRepo = newsletterRepo;
    }

    public void create(Newsletter newsletter){
        newsletterRepo.save(newsletter);
    }
    public void delete(int idNews){
        newsletterRepo.deleteById(idNews);
    }
    public void update(Newsletter newsletter){
        newsletterRepo.save(newsletter);
    }
    public Newsletter findById(int idNews){
        Optional<Newsletter>find = newsletterRepo.findById(idNews);
        if (find.isPresent()){
            return find.get();
        }
        return null;
    }
    public List<Newsletter>getAll(){
        return (List<Newsletter>) newsletterRepo.findAll();
    }

}
