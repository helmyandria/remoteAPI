package id.pelindo.remote.controller;

import id.pelindo.remote.model.PriceType;
import id.pelindo.remote.model.ResponsePriceType;
import id.pelindo.remote.repository.PriceTypeRepository;
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
public class PriceTypeController {

    @Autowired
    private PriceTypeRepository priceTypeRepository;

    @PostMapping("/pricetype")
    public ResponseEntity<ResponsePriceType> getPriceType(@Valid @RequestBody PriceType priceType) {
        List<PriceType> getPriceTypes = priceTypeRepository.getPriceType(priceType.getInstallation_code());

        ResponsePriceType pesan = null;

        if (getPriceTypes.size() != 0) {
            pesan = new ResponsePriceType("00", "Data ditemukan", getPriceTypes);
        } else {
            pesan = new ResponsePriceType("06", "Data tidak ditemukan");
        }

        return ResponseEntity.ok().body(pesan);
    }

}
