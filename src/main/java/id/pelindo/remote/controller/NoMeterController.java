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

import java.math.BigDecimal;

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
    public ResponseEntity<ObjectNode> insertServiceTransaction(@Valid @RequestBody ObjectNode param) {
//
////        get object first
//        String idTrx = generateIdTransaksi();
//        JsonNode installation_type = param.get("installation_type");
//        JsonNode profit_center = param.get("profit_center");
//        JsonNode customer = param.get("customer");
//        JsonNode period = param.get("period");
//        JsonNode amount = param.get("amount");
//        JsonNode installation_number = param.get("installation_number");
//        JsonNode billing_type = param.get("billing_type");
//        JsonNode id_instalasi = param.get("id_instalasi");
//        JsonNode gl_account = param.get("gl_account");
//        JsonNode branch_id = param.get("branch_id");
//        JsonNode installation_code = param.get("installation_code");
//        JsonNode customer_name = param.get("customer_name");
//        JsonNode multiply = param.get("multiply");
//        JsonNode created_date = param.get("created_date");
//        JsonNode created_by = param.get("created_by");
//        JsonNode status_dinas = param.get("status_dinas");
//        JsonNode ket = param.get("keterangan");
//
////        ubah nilai json, idtrx & amount
////        param.put("id",idTrx);
////        param.put("amount","909090");
//
//        System.out.println("idTrx : "+idTrx+
//                        "\ninstallation_type : "+removeFirstandLast(installation_type.toString()) +
//                        "\nprofit_center : "+removeFirstandLast(profit_center.toString()) +
//                        "\ncustomer : "+removeFirstandLast(customer.toString()) +
//                        "\nperiod : "+removeFirstandLast(period.toString()) +
//                        "\namount : "+removeFirstandLast(amount.toString()) +
//                        "\ninstallation_number : "+removeFirstandLast(installation_number.toString()) +
//                        "\nbilling_type : "+removeFirstandLast(billing_type.toString()) +
//                        "\nid_instalasi : "+removeFirstandLast(id_instalasi.toString()) +
//                        "\ngl_account : "+removeFirstandLast(gl_account.toString()) +
//                        "\nbranch_id : "+removeFirstandLast(branch_id.toString()) +
//                        "\ninstallation_code : "+removeFirstandLast(installation_code.toString()) +
//                        "\ncustomer_name : "+removeFirstandLast(customer_name.toString()) +
//                        "\ncreated_date : "+removeFirstandLast(created_date.toString())+
//                        "\ncreated_by : "+removeFirstandLast(created_by.toString()) +
//                        "\nstatus_dinas : "+removeFirstandLast(status_dinas.toString())
//                );
//
//        try {
//            servicesTransactionRepository.insertData(idTrx,removeFirstandLast(installation_type.toString()),removeFirstandLast(profit_center.toString()),
//                    removeFirstandLast(customer.toString()),removeFirstandLast(period.toString()),removeFirstandLast(amount.toString()),removeFirstandLast(installation_number.toString()),
//                    removeFirstandLast(billing_type.toString()), removeFirstandLast(id_instalasi.toString()), removeFirstandLast(gl_account.toString()),removeFirstandLast(branch_id.toString()),removeFirstandLast(installation_code.toString()),
//                    removeFirstandLast(customer_name.toString()), removeFirstandLast(created_date.toString()), removeFirstandLast(created_by.toString()),removeFirstandLast(status_dinas.toString()));
//        } catch (Exception e) {
//            param.put("messageCode", "06");
//            param.put("messageDesc", "Data gagal ditambahkan");
//        }
//
//        JsonNode service_transaction_c = param.get("service_transaction_c");
//        int panjang_c = service_transaction_c.size();
//
//        System.out.println("length services trx c : "+panjang_c);
//
//        try {
//            for(int i = 0; i < panjang_c; i++){
//                JsonNode valueC = service_transaction_c.get(i);
//                JsonNode desc = valueC.get("description");
//                JsonNode perc = valueC.get("percentage");
////                insert into db
//                servicesTransactionCRepository.insertData(
//                        removeFirstandLast(desc.toString()),
//                        removeFirstandLast(perc.toString()),
//                        idTrx,
//                        removeFirstandLast(branch_id.toString())
//                );
//            }
//        } catch (Exception e){
//            param.put("messageCode", "06");
//            param.put("messageDesc", "Data gagal ditambahkan");
//        }
//
//        JsonNode service_transaction_d = param.get("service_transaction_d");
//        int panjang_d = service_transaction_d.size();
//
//        System.out.println("length services trx d : "+panjang_d);
//
//        try {
//
//            for(int i = 0; i < panjang_d; i++){
//                JsonNode valueD = service_transaction_d.get(i);
//                JsonNode price_type = valueD.get("price_type");
//                JsonNode price_code = valueD.get("price_code");
//                JsonNode tariff = valueD.get("tariff");
//                JsonNode meter_from = valueD.get("meter_from");
//                JsonNode meter_to = valueD.get("meter_to");
//                JsonNode used = valueD.get("used");
//                JsonNode foto = valueD.get("url_foto");
//
////                insert into db
//                servicesTransactionDRepository.insertData(
//                        idTrx,
//                        removeFirstandLast(price_type.toString()),
//                        removeFirstandLast(price_code.toString()),
//                        removeFirstandLast(tariff.toString()),
//                        removeFirstandLast(meter_from.toString()),
//                        removeFirstandLast(meter_to.toString()),
//                        removeFirstandLast(used.toString()),
//                        removeFirstandLast(multiply.toString()),
//                        removeFirstandLast(branch_id.toString()),
//                        removeFirstandLast(installation_code.toString()),
//                        removeFirstandLast(ket.toString()),
//                        removeFirstandLast(foto.toString())
//                );
//
//                param.put("messageCode", "00");
//                param.put("messageDesc", "Data berhasil ditambahkan");
//
//                System.out.println("id trx : " + idTrx +
//                        "\n price type : "+ removeFirstandLast(price_type.toString()) +
//                        "\n price_code : "+ removeFirstandLast(price_code.toString()) +
//                        "\n tariff : "+ removeFirstandLast(tariff.toString()) +
//                        "\n meter_from : "+ removeFirstandLast(meter_from.toString()) +
//                        "\n meter_to : "+ removeFirstandLast(meter_to.toString()) +
//                        "\n used : "+ removeFirstandLast(used.toString()) +
//                        "\n multiply : "+ removeFirstandLast(multiply.toString()) +
//                        "\n branch_id : "+ removeFirstandLast(branch_id.toString()) +
//                        "\n installation_code : "+ removeFirstandLast(installation_code.toString()) +
//                        "\n ket : "+ removeFirstandLast(ket.toString()) +
//                        "\n foto : "+ removeFirstandLast(foto.toString())
//                        );
//            }
//        } catch (Exception e){
//            param.put("messageCode", "06");
//            param.put("messageDesc", "Data gagal ditambahkan");
//        }

        return ResponseEntity.ok().body(param);

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

    @PostMapping("/calculate")
    public ResponseEntity<ObjectNode>  menghitungTagihan(@Valid @RequestBody ObjectNode param){

        double totalTagihan = 0; //result

//        get data from param
        JsonNode branch_id = param.get("branch_id");
        JsonNode profit_center = param.get("profit_center");
        JsonNode min_payment = param.get("minimum_payment");
        JsonNode power_capacity = param.get("power_capacity");
        JsonNode biaya_beban = param.get("biaya_beban");
        JsonNode biaya_admin = param.get("biaya_admin");
        JsonNode min_KWH = param.get("minimum_used");
        JsonNode multiply = param.get("multiply");

//        konversi tipe data from param
        double kodeCabang = Double.parseDouble(removeFirstandLast(branch_id.toString())); // header branch_id
        double profitCenter = Double.parseDouble(removeFirstandLast(profit_center.toString())); // header profit_center
        double minimumPayment = Double.parseDouble(removeFirstandLast(min_payment.toString())); // header minimum_payment
        double powerCapacity = Double.parseDouble(removeFirstandLast(power_capacity.toString())); // header power_capacity
        double biayaBeban = Double.parseDouble(removeFirstandLast(biaya_beban.toString())); // header biaya_beban
        double biayaAdmin = Double.parseDouble(removeFirstandLast(biaya_admin.toString())); // header biaya_admin
        double minKWH = Double.parseDouble(removeFirstandLast(min_KWH.toString())); // header minimum_used
        double multiplyFactor = Double.parseDouble(removeFirstandLast(multiply.toString())); // header minimum_used

        System.out.println("Kode cabang : "+ kodeCabang);
        System.out.println("Profit center : "+ profitCenter);
        System.out.println("Minimum Payment : "+ minimumPayment);
        System.out.println("Power Capacity : "+ powerCapacity);
        System.out.println("Biaya Beban : "+ biayaBeban);
        System.out.println("Biaya Admin : "+ biayaAdmin);
        System.out.println("Minimum KWH : "+ minKWH);
        System.out.println("Multiply Factor : "+ multiplyFactor);

//        data service_transaction_d
        JsonNode service_transaction_d = param.get("service_transaction_d");
        int panjang_d = service_transaction_d.size();
        System.out.println("panjang D : "+ panjang_d);

//        param service_transaction_d
        double usedLWBP = 0, tarifLWBP = 0, usedWBP = 0, tarifWBP = 0;
        double usedKVARH = 0, tarifKVARH = 0 ;
        double usedBlok1 = 0, maxRangeUsedBlok1 = 0, tarifBlok1 = 0 ;
        double usedBlok2 = 0, maxRangeUsedBlok2 = 0, tarifBlok2 = 0 ;

//        set data to variable service_transaction_d
        for (int i = 0; i < panjang_d; i++) {
            JsonNode valueD = service_transaction_d.get(i);

            if (removeFirstandLast(valueD.get("price_type").toString()).equals("KVARH")){
                JsonNode used_KVARH = valueD.get("used");
                usedKVARH = Double.parseDouble(removeFirstandLast(used_KVARH.toString()));
                JsonNode tarif_KVARH  = valueD.get("tariff");
                tarifKVARH = Double.parseDouble(removeFirstandLast(tarif_KVARH.toString()));
                System.out.println("used KVARH : " + usedKVARH);
                System.out.println("tarif KVARH : " + tarifKVARH);
            }

            if (removeFirstandLast(valueD.get("price_type").toString()).equals("LWBP")){
                JsonNode used_LWBP = valueD.get("used");
                usedLWBP = Double.parseDouble(removeFirstandLast(used_LWBP.toString()));
                JsonNode tarif_LWBP  = valueD.get("tariff");
                tarifLWBP = Double.parseDouble(removeFirstandLast(tarif_LWBP.toString()));
                System.out.println("used LWBP : " + usedLWBP);
                System.out.println("tarif LWBP : " + tarifLWBP);
            }

            else if (removeFirstandLast(valueD.get("price_type").toString()).equals("WBP")){
                JsonNode used_WBP = valueD.get("used");
                usedWBP = Double.parseDouble(removeFirstandLast(used_WBP.toString()));
                JsonNode tarif_WBP  = valueD.get("tariff");
                tarifWBP = Double.parseDouble(removeFirstandLast(tarif_WBP.toString()));
                System.out.println("used WBP : " + usedWBP);
                System.out.println("tarif WBP : " + tarifWBP);
            }

            else if (removeFirstandLast(valueD.get("price_type").toString()).equals("BLOK1")){
                JsonNode used_blok1 = valueD.get("used");
                usedBlok1 = Double.parseDouble(removeFirstandLast(used_blok1.toString()));
                JsonNode max_range_used_blok1 = valueD.get("max_range_used");
                maxRangeUsedBlok1 = Double.parseDouble(removeFirstandLast(max_range_used_blok1.toString()));
                JsonNode tarif_blok1  = valueD.get("tariff");
                tarifBlok1 = Double.parseDouble(removeFirstandLast(tarif_blok1.toString()));
                System.out.println("used Blok1 : " + usedBlok1);
                System.out.println("max range used Blok1 : " + maxRangeUsedBlok1);
                System.out.println("tarif Blok1 : " + tarifBlok1);
            }

            else if (removeFirstandLast(valueD.get("price_type").toString()).equals("BLOK2")){
                JsonNode used_blok2 = valueD.get("used");
                usedBlok2 = Double.parseDouble(removeFirstandLast(used_blok2.toString()));
                JsonNode max_range_used_blok2 = valueD.get("max_range_used");
                maxRangeUsedBlok2 = Double.parseDouble(removeFirstandLast(max_range_used_blok2.toString()));
                JsonNode tarif_blok2  = valueD.get("tariff");
                tarifBlok2 = Double.parseDouble(removeFirstandLast(tarif_blok2.toString()));
                System.out.println("used Blok2 : " + usedBlok2);
                System.out.println("max range used Blok2 : " + maxRangeUsedBlok2);
                System.out.println("tarif Blok2 : " + tarifBlok2);
            }
        }

//      data service_transaction_c
        JsonNode service_transaction_c = param.get("service_transaction_c");
        int panjang_c = service_transaction_c.size();
        System.out.println("panjang C : "+ panjang_c);

//      param service_transaction_c
        double persenPPJU = 0, persenREDUKSI = 0;

//      set data to variable service_transaction_c
        for (int i = 0; i < panjang_c; i++){
            JsonNode valueC = service_transaction_c.get(i);

            if (removeFirstandLast(valueC.get("description").toString()).equals("PPJU")){
                JsonNode percentage = valueC.get("percentage");
                persenPPJU = Double.parseDouble(removeFirstandLast(percentage.toString()));
                System.out.println("percentage PPJU: " + persenPPJU);
            }

            if (removeFirstandLast(valueC.get("description").toString()).equals("REDUKSI")){
                JsonNode percentage = valueC.get("percentage");
                persenREDUKSI = Double.parseDouble(removeFirstandLast(percentage.toString()));
                System.out.println("percentage REDUKSI: " + persenREDUKSI);
            }
        }

//        Rumus pehitungan
        try{
            // 1. Perhitungan Untuk Kode Cabang TANJUNG PERAK atau LEGI
            if (kodeCabang == 2 || profitCenter == 10301) { //2
                double cekPertama = (usedLWBP * multiplyFactor) + (usedWBP * multiplyFactor);
                double cekKedua = (usedLWBP * multiplyFactor) + (usedWBP * multiplyFactor) * 62/100;

                // Untuk pengecekan kondisi
                double kvarhKaliMfact = usedKVARH * multiplyFactor;

                //Kondisi Pertama Untuk Cabang Perak
                if (cekPertama <= minKWH) {
                    double totalTagihana = minKWH * tarifLWBP;
                    double totalTagihana1 = totalTagihana + (totalTagihana * persenPPJU / 100);
                    totalTagihan = Math.round(totalTagihana1 - (totalTagihana1 * persenREDUKSI / 100));
                }
                if (kvarhKaliMfact < cekKedua && cekPertama > minKWH) {
                    double totalTagihan1 = (usedLWBP * multiplyFactor * tarifLWBP) + (usedWBP * multiplyFactor * tarifWBP);
                    double totalTagihan2 = totalTagihan1 + (totalTagihan1 * persenPPJU / 100);
                    totalTagihan = Math.round(totalTagihan2 - (totalTagihan2 * persenREDUKSI / 100));
                }
                if (kvarhKaliMfact > cekKedua && cekPertama > minKWH) {
                    double x = ((usedLWBP * multiplyFactor) + (usedWBP * multiplyFactor)) * 62/100;
                    double y = (usedKVARH * multiplyFactor);
                    double x1 = y - x;
                    double hitung1 = (usedLWBP * multiplyFactor * tarifLWBP) + (usedWBP * multiplyFactor * tarifWBP);
                    double hitung2 = x1 * tarifKVARH;
                    double hitung3 = hitung1 + hitung2;
                    double hitung4 = hitung3 + (hitung3 * persenPPJU / 100);

                    totalTagihan = Math.round(hitung4 - (hitung4 * persenREDUKSI / 100));
                }
            }

//        Khusus SEMARANG yg sebelumnya rame2 skrg dipisah
            if (kodeCabang == 9 || profitCenter == 10201) {
                double t1 = (usedLWBP * tarifLWBP * multiplyFactor) + (usedWBP * tarifWBP * multiplyFactor);
                System.out.println("t1 : " + t1);

                if (t1 <= minimumPayment && powerCapacity > 900) {
                    double t2 = minimumPayment + biayaBeban;
                    System.out.println("t2 : " + t2);
                    double t3 = t2 + (t2 * persenPPJU / 100);
                    System.out.println("t3 : " + t3);
                    totalTagihan = Math.round(t3 - (t3 * persenREDUKSI / 100));
                } else if (t1 > minimumPayment && powerCapacity > 900) {
                    double t2 = t1 + biayaBeban;
                    double t3 = t2 + (t2 * persenPPJU / 100);
                    totalTagihan = Math.round(t3 - (t3 * persenREDUKSI / 100));
                    System.out.println("else if : "+t2);
                    System.out.println("else if : "+t3);
                }
                else if (powerCapacity == 450) {
                    if (usedBlok1 <= maxRangeUsedBlok1) {
                        double hitungBlok1 = usedBlok1 * tarifBlok1;
                        double tambahBiayaBeban = hitungBlok1 + biayaBeban;
                        double kali1 = tambahBiayaBeban;
                        double kali2 = kali1 + (tambahBiayaBeban * (persenPPJU / 100));
                        totalTagihan = Math.round(kali2);
                    } else {
                        double hitungBlok1 = maxRangeUsedBlok1 * tarifBlok1;
                        double hitungBlok2 = (usedBlok1 - maxRangeUsedBlok1) * tarifBlok2;

                        double sumBlok = hitungBlok1 + hitungBlok2;
                        double tambahBiayaBeban = sumBlok + biayaBeban;
                        double kali1 = tambahBiayaBeban;
                        double kali2 = kali1 + (tambahBiayaBeban * (persenPPJU / 100));
                        totalTagihan = Math.round(kali2);
                    }
                }
                else if (powerCapacity == 900) {
                    double t1_1 = usedLWBP * tarifLWBP * multiplyFactor;
                    double t2 = t1_1 + biayaBeban;
                    double t3 = t2 + (t2 * persenPPJU / 100);
                    double t4 = t3 + biayaAdmin;
                    totalTagihan = Math.round(t4 - (t4 * persenREDUKSI / 100));
                } else {
                    System.out.println("else kodeCabang == 9 || profitCenter == 10201");
                }
            }

//            convert total tagihan to big decimal
            BigDecimal d = new BigDecimal(String.valueOf(totalTagihan));
            String result = d.toPlainString();
            System.out.println("Big Decimal is "+ result);
            System.out.println("Total tagihan : "+ totalTagihan);

            param.put("amount", String.valueOf(result));
            param.put("messageCode", "00");
            param.put("messageDesc", "Data berhasil dikalkulasi");
        } catch (Exception e){
            param.put("messageCode", "06");
            param.put("messageDesc", "Data gagal dikalkulasi");
        }

        return ResponseEntity.ok().body(param);
    }

}
