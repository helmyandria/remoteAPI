package id.pelindo.remote.controller;

import id.pelindo.remote.config.DataSourceConfig;
import id.pelindo.remote.mapper.RemoteMapper;
import id.pelindo.remote.model.ServicesTransaction;
import id.pelindo.remote.model.ResponseNoMeter;
import id.pelindo.remote.model.ServicesTransactionC;
import id.pelindo.remote.model.ServicesTransactionD;
import id.pelindo.remote.model.bbs.BbsInputNoMeter;
import id.pelindo.remote.model.bbs.BbsServicesTransaction;
import id.pelindo.remote.model.bbs.BbsServicesTransactionC;
import id.pelindo.remote.repository.ServicesTransactionCRepository;
import id.pelindo.remote.repository.ServicesTransactionDRepository;
import id.pelindo.remote.repository.ServicesTransactionRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.SqlParameter;
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
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@RestController
@RequestMapping("/api/v1")
public class NoMeterController {

    @Autowired
    private ServicesTransactionRepository servicesTransactionRepository;

    @Autowired
    private ServicesTransactionDRepository servicesTransactionDRepository;

    @Autowired
    private ServicesTransactionCRepository servicesTransactionCRepository;

//    @Autowired
//    private RemoteMapper rm;

    @Autowired
    public DataSource dataSource;

    @PostMapping("/inputnometer")
    public ResponseEntity<ResponseNoMeter> insertServiceTransaction(@Valid @RequestBody ServicesTransaction servicesTransaction) {

//        System.out.println("value inst type : " + BbsInputNoMeter.getInstallation_type());
//        System.out.println("value id transaksi : " + generateIdTransaksi());
        String idTrx = generateIdTransaksi();
        System.out.println("value id trx : "+idTrx);

//        BbsServicesTransaction servicesTransaction = request.getServicesTransaction();
//        servicesTransaction.setId(idTrx);
//
//        if (request.getServiceTransactionC() != null) {
//            List<BbsServicesTransactionC> serviceTransactionC = request.getServiceTransactionC();
//
////            boolean exist = rm.prop_services_transaction_c();
//
//        }

//        String noMeter = servicesTransactionRepository.generateNomor("1", "TRANS_LISTRIK", "43", "6");

        ResponseNoMeter pesan = null;

//        insert into 3 table
//        ServicesTransaction sm = new ServicesTransaction();
//        sm.setId();
//        sm = rm.prop_services_transaction(sm);
//        insert into 3 table

//        System.out.println("call func : "+noMeter);
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

    private String generateIdTransaksi() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        SimpleJdbcCall call = new SimpleJdbcCall(template)
                .withFunctionName("GENERATE_NOMOR_TRANS")
                .withSchemaName("REMOTE");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_BE_ID", "1")
                .addValue("P_MODULE_TYPE", "TRANS_LISTRIK")
                .addValue("P_PARAM1", "43")
                .addValue("p_padding", "6");

        String idTrans = call.executeFunction(String.class, paramMap);

        return idTrans;
    }

}
