package id.pelindo.remote.controller;

import id.pelindo.remote.model.Akun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import id.pelindo.remote.repository.TagihanListrikRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TagihanListrikController {

    @Autowired
    private TagihanListrikRepository tagihanListrikRepository;

    @GetMapping("/taglistrik")
    public List<Akun> getTagihanListrik() {
        return tagihanListrikRepository.findAll();
    }
}
