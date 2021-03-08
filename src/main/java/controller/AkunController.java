package controller;

import java.util.List;

import model.Akun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.AkunRepository;

@RestController
@RequestMapping("/api/v1")
public class AkunController {

    @Autowired
    private AkunRepository akunRepository;

    @GetMapping("/akun")
    public List<Akun> getAllAkun() {
        return akunRepository.findAll();
    }

}