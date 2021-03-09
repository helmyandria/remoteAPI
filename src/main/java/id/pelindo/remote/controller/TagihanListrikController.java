package id.pelindo.remote.controller;

import id.pelindo.remote.model.ResponseTagihanListrik;
import id.pelindo.remote.model.TagihanListrik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import id.pelindo.remote.repository.TagihanListrikRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TagihanListrikController {

    @Autowired
    private TagihanListrikRepository tagihanListrikRepository;

    @PostMapping("/taglistrik")
    public ResponseEntity<ResponseTagihanListrik> getTagihan(@Valid @RequestBody TagihanListrik tagihan) {
        List<TagihanListrik> findTagihans = tagihanListrikRepository.findTagihan(tagihan.getInstallation_code(), tagihan.getPeriod());

        ResponseTagihanListrik pesan = null;
        for (TagihanListrik item : findTagihans) {
        }

        if (findTagihans.size() != 0) {
            pesan = new ResponseTagihanListrik("00", "Data ditemukan", findTagihans);
        } else if (findTagihans.size() == 0) {
            pesan = new ResponseTagihanListrik("06", "Data tidak ditemukan");
        }

        return ResponseEntity.ok().body(pesan);
    }

}
