package id.pelindo.remote.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import id.pelindo.remote.model.Akun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import id.pelindo.remote.repository.AkunRepository;
import id.pelindo.remote.model.ResponseAkun;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AkunController {

    @Autowired
    private AkunRepository akunRepository;

    @PostMapping("/akun")
    public ResponseEntity<ResponseAkun> getLogin(@Valid @RequestBody Akun akun) {
        List<Akun> findAkuns = akunRepository.findLoginByUsernameAndPassword(akun.getUsername(), akun.getPassword());

        System.out.println("value findAkuns : "+findAkuns);

        ResponseAkun pesan = null;
        if (findAkuns.size() != 0) {
            pesan = new ResponseAkun("00", "Data ditemukan", findAkuns);
        } else if (findAkuns.size() == 0) {
            pesan = new ResponseAkun("06", "Data tidak ditemukan");
        }

        return ResponseEntity.ok().body(pesan);
    }

}