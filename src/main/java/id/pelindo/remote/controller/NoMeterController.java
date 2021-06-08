package id.pelindo.remote.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import id.pelindo.remote.model.ResponseNoMeter;
import id.pelindo.remote.repository.ServicesTransactionCRepository;
import id.pelindo.remote.repository.ServicesTransactionDRepository;
import id.pelindo.remote.repository.ServicesTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

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
    public ResponseEntity<ResponseNoMeter> insertServiceTransaction(@Valid @RequestBody ObjectNode param) {

//        get object first
        String idTrx = generateIdTransaksi();
        JsonNode installation_type = param.get("installation_type");
        JsonNode profit_center = param.get("profit_center");
        JsonNode customer = param.get("customer");
        JsonNode period = param.get("period");
        JsonNode amount = param.get("amount");
        JsonNode installation_number = param.get("installation_number");
        JsonNode billing_type = param.get("billing_type");
        JsonNode id_instalasi = param.get("id_instalasi");
        JsonNode gl_account = param.get("gl_account");
        JsonNode branch_id = param.get("branch_id");
        JsonNode installation_code = param.get("installation_code");
        JsonNode customer_name = param.get("customer_name");
        JsonNode created_date = param.get("created_date");
        JsonNode created_by = param.get("created_by");
        JsonNode status_dinas = param.get("status_dinas");

        ResponseNoMeter pesan = null;

        System.out.println("idTrx : "+idTrx+
                        "\ninstallation_type : "+removeFirstandLast(installation_type.toString()) +
                        "\nprofit_center : "+removeFirstandLast(profit_center.toString()) +
                        "\ncustomer : "+removeFirstandLast(customer.toString()) +
                        "\nperiod : "+removeFirstandLast(period.toString()) +
                        "\namount : "+removeFirstandLast(amount.toString()) +
                        "\ninstallation_number : "+removeFirstandLast(installation_number.toString()) +
                        "\nbilling_type : "+removeFirstandLast(billing_type.toString()) +
                        "\nid_instalasi : "+removeFirstandLast(id_instalasi.toString()) +
                        "\ngl_account : "+removeFirstandLast(gl_account.toString()) +
                        "\nbranch_id : "+removeFirstandLast(branch_id.toString()) +
                        "\ninstallation_code : "+removeFirstandLast(installation_code.toString()) +
                        "\ncustomer_name : "+removeFirstandLast(customer_name.toString()) +
                        "\ncreated_date : "+removeFirstandLast(created_date.toString())+
                        "\ncreated_by : "+removeFirstandLast(created_by.toString()) +
                        "\nstatus_dinas : "+removeFirstandLast(status_dinas.toString())
                );

        try {
            servicesTransactionRepository.insertData(idTrx,removeFirstandLast(installation_type.toString()),removeFirstandLast(profit_center.toString()),
                    removeFirstandLast(customer.toString()),removeFirstandLast(period.toString()),removeFirstandLast(amount.toString()),removeFirstandLast(installation_number.toString()),
                    removeFirstandLast(billing_type.toString()), removeFirstandLast(id_instalasi.toString()), removeFirstandLast(gl_account.toString()),removeFirstandLast(branch_id.toString()),removeFirstandLast(installation_code.toString()),
                    removeFirstandLast(customer_name.toString()), removeFirstandLast(created_date.toString()), removeFirstandLast(created_by.toString()),removeFirstandLast(status_dinas.toString()));
            pesan = new ResponseNoMeter("00", "Data berhasil ditambahkan");
        } catch (Exception e) {
            pesan = new ResponseNoMeter("06", "Data gagal ditambahkan, " + e);
        }

        JsonNode service_transaction_c = param.get("service_transaction_c");
        int panjang_c = service_transaction_c.size();

        System.out.println("length services trx c : "+panjang_c);

        try {
            for(int i = 0; i < panjang_c; i++){
                JsonNode valueC = service_transaction_c.get(i);
                JsonNode desc = valueC.get("description");
                JsonNode perc = valueC.get("percentage");
                JsonNode bid = valueC.get("branch_id");
//                insert into db
                servicesTransactionCRepository.insertData(
                        removeFirstandLast(desc.toString()),
                        removeFirstandLast(perc.toString()),
                        idTrx,
                        removeFirstandLast(bid.toString())
                );
            }
        } catch (Exception e){
            pesan = new ResponseNoMeter("06", "Data gagal ditambahkan, " + e);
        }

        JsonNode service_transaction_d = param.get("service_transaction_d");
        int panjang_d = service_transaction_d.size();

        System.out.println("length services trx d : "+panjang_d);

        try {
            for(int i = 0; i < panjang_d; i++){
                JsonNode valueD = service_transaction_d.get(i);
                JsonNode price_type = valueD.get("price_type");
                JsonNode price_code = valueD.get("price_code");
                JsonNode tariff = valueD.get("tariff");
                JsonNode meter_from = valueD.get("meter_from");
                JsonNode meter_to = valueD.get("meter_to");
                JsonNode used = valueD.get("used");
                JsonNode multiply = valueD.get("multiply");
                JsonNode brid = valueD.get("branch_id");
                JsonNode ic = valueD.get("installation_code");
                JsonNode ket = valueD.get("keterangan");

//                insert into db
                servicesTransactionDRepository.insertData(
                        idTrx,
                        removeFirstandLast(price_type.toString()),
                        removeFirstandLast(price_code.toString()),
                        removeFirstandLast(tariff.toString()),
                        removeFirstandLast(meter_from.toString()),
                        removeFirstandLast(meter_to.toString()),
                        removeFirstandLast(used.toString()),
                        removeFirstandLast(multiply.toString()),
                        removeFirstandLast(brid.toString()),
                        removeFirstandLast(ic.toString()),
                        removeFirstandLast(ket.toString())
                );
            }
        } catch (Exception e){
            pesan = new ResponseNoMeter("06", "Data gagal ditambahkan, " + e);
        }

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

    public static String removeFirstandLast(String str){
        str = str.substring(1, str.length() - 1);
        return str;
    }

}
