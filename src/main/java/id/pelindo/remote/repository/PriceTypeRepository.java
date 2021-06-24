package id.pelindo.remote.repository;

import id.pelindo.remote.model.PriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceTypeRepository extends JpaRepository<PriceType, String> {

    @Query(value = "SELECT pstd.ID AS ID, psip.INSTALLATION_CODE, psip.PRICE_TYPE, psip.PRICE_CODE, NVL(psip.MAX_RANGE_USED, 0) AS MAX_RANGE_USED, pstd.meter_to, s.AMOUNT AS TARIFF FROM PROP_SERVICES_INSTALLATION_P psip INNER JOIN PROP_SERVICES_TRANSACTION_D pstd ON psip.INSTALLATION_CODE = pstd.INSTALLATION_CODE AND psip.PRICE_CODE = pstd.PRICE_CODE INNER JOIN SERVICES s ON pstd.PRICE_CODE = s.TARIFF_CODE WHERE pstd.INSTALLATION_CODE=:installation_code AND pstd.ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'KVARH') or pstd.ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'WBP') or pstd.ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'LWBP') or pstd.ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'BLOK1') or pstd.ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'BLOK2')", nativeQuery = true)
    List<PriceType> getPriceType(@Param("installation_code") String installation_code);

}
