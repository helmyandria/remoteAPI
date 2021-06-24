package id.pelindo.remote.repository;

import id.pelindo.remote.model.ServicesTransactionD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ServicesTransactionDRepository extends JpaRepository<ServicesTransactionD,String> {

    @Modifying
    @Query(value = "INSERT INTO PROP_SERVICES_TRANSACTION_D (SERVICES_TRANSACTION_ID, PRICE_TYPE, PRICE_CODE, TARIFF, METER_FROM, " +
            "METER_TO, USED, MULTIPLY, BRANCH_ID, INSTALLATION_CODE, KETERANGAN, URL_FOTO) " +
            "VALUES (:services_transaction_id, :price_type, :price_code ,:tariff, :meter_from, " +
            ":meter_to, :used, :multiply, :branch_id, :installation_code, :keterangan, :url_foto ) ", nativeQuery = true)
    @Transactional
    void insertData(
            @Param("services_transaction_id") String services_transaction_id,
            @Param("price_type") String price_type,
            @Param("price_code") String price_code,
            @Param("tariff") String tariff,
            @Param("meter_from") String meter_from,
            @Param("meter_to") String meter_to,
            @Param("used") String used,
            @Param("multiply") String multiply,
            @Param("branch_id") String branch_id,
            @Param("installation_code") String installation_code,
            @Param("keterangan") String keterangan,
            @Param("url_foto") String url_foto
    );
}
