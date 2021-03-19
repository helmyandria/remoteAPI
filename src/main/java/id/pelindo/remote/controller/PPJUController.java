package id.pelindo.remote.controller;


import id.pelindo.remote.model.PPJU;
import id.pelindo.remote.model.ResponsePPJU;
import id.pelindo.remote.model.ResponsePriceType;
import id.pelindo.remote.repository.PPJURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PPJUController {

    @Autowired
    PPJURepository ppjuRepository;

    @PostMapping("/ppju")
    public ResponseEntity<ResponsePPJU> getPPJU(@Valid @RequestBody PPJU ppju){
        List<PPJU> findPPJUs = ppjuRepository.findPPJU(ppju.getInstallation_code());

        ResponsePPJU pesan = null;
        if (findPPJUs.size()!=0){
            pesan = new ResponsePPJU("00", "Data ditemukan", findPPJUs);
        } else {
            pesan = new ResponsePPJU("06", "Data tidak ditemukan");
        }

        return ResponseEntity.ok().body(pesan);
    }

}
