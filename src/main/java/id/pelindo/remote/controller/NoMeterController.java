package id.pelindo.remote.controller;

import id.pelindo.remote.model.ServicesTransaction;
import id.pelindo.remote.model.ResponseNoMeter;
import id.pelindo.remote.model.ServicesTransactionC;
import id.pelindo.remote.model.ServicesTransactionD;
import id.pelindo.remote.repository.ServicesTransactionCRepository;
import id.pelindo.remote.repository.ServicesTransactionDRepository;
import id.pelindo.remote.repository.ServicesTransactionRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.CallableStatement;
import java.sql.Types;

@RestController
@RequestMapping("/api/v1")
public class NoMeterController {

    @Autowired
    private ServicesTransactionRepository servicesTransactionRepository;

    @Autowired
    private ServicesTransactionDRepository servicesTransactionDRepository;

    @Autowired
    private ServicesTransactionCRepository servicesTransactionCRepository;

    @PostMapping("/inputnometer")
    public ResponseEntity<ResponseNoMeter> insertServiceTransaction(@Valid @RequestBody ServicesTransaction servicesTransaction) {

        System.out.println("value inst type : "+servicesTransaction.getInstallation_type());
        String noMeter = servicesTransactionRepository.generateNomor("1", "TRANS_LISTRIK", "43", "6");
        ResponseNoMeter pesan = null;

        System.out.println("call func : "+noMeter);

//        try {
//            servicesTransaction.setId(noMeter);
//            System.out.println("get id no meter : " + servicesTransaction.getId());
//            servicesTransactionRepository.save(servicesTransaction);
//
//            pesan = new ResponseNoMeter("00", "Data berhasil ditambahkan");
//        } catch (Exception e) {
//            pesan = new ResponseNoMeter("06", "Data gagal ditambahkan, " + e);
//        }

//        tes
//        System.out.println("Parent: " + servicesTransaction.toString());
//        for (ServicesTransactionC child : servicesTransaction.getServicestransactioncs()) {
//            child.setServicesTransaction(servicesTransaction);
//        }
//
//        try {
//            servicesTransaction.setServicestransactioncs(servicesTransaction.getServicestransactioncs());
//            servicesTransactionRepository.save(servicesTransaction);
//            pesan = new ResponseNoMeter("00", "Data berhasil ditambahkan");
//        } catch (Exception e) {
//            pesan = new ResponseNoMeter("06", "Data gagal ditambahkan, " + e);
//        }
//        tes

        return ResponseEntity.ok().body(pesan);
    }

}
