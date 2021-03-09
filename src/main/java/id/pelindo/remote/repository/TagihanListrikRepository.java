package id.pelindo.remote.repository;

import id.pelindo.remote.model.TagihanListrik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagihanListrikRepository extends JpaRepository<TagihanListrik, String> {

    @Query(value = "SELECT A.ID, A.INSTALLATION_TYPE, A.INSTALLATION_CODE, B.INSTALLATION_ADDRESS, A.PROFIT_CENTER ||'-'|| C.TERMINAL_NAME AS PROFIT_CENTER, B.CUSTOMER_ID || ' - ' || B.CUSTOMER_NAME AS CUSTOMER_NAME, A.BRANCH_ID, A.PERIOD, F.METER_FROM, F.METER_TO, F.USED QUANTITY, D.BE_ADDRESS, B.BE_ID, D.BE_NAME, A.PERIOD, D.BE_CITY, A.AMOUNT, B.CURRENCY, A.PRICE, B.BIAYA_ADMIN, B.POWER_CAPACITY, A.MULTIPLY_FACTOR, F.TARIFF, F.PRICE_TYPE, B.BIAYA_BEBAN, to_char(A.POSTING_DATE,'DD MONTH YYYY') POSTING_DATE, (SELECT DISTINCT PERCENTAGE FROM PROP_SERVICES_TRANSACTION_C WHERE SERVICES_TRANSACTION_ID = A.ID AND DESCRIPTION = 'PPJU') PPJU, (SELECT DISTINCT PERCENTAGE FROM PROP_SERVICES_TRANSACTION_C WHERE SERVICES_TRANSACTION_ID = A.ID AND DESCRIPTION = 'REDUKSI') REDUKSI FROM PROP_SERVICES_TRANSACTION A, PROP_SERVICES_INSTALLATION B, PROFIT_CENTER C, BUSINESS_ENTITY D, PROP_SERVICES_TRANSACTION_D F WHERE B.INSTALLATION_NUMBER = A.INSTALLATION_NUMBER AND B.PROFIT_CENTER_NEW = C.PROFIT_CENTER_ID AND A.BRANCH_ID = D.BRANCH_ID AND F.SERVICES_TRANSACTION_ID = A.ID AND A.INSTALLATION_CODE = :installation_code AND A.PERIOD = :period", nativeQuery = true)
    List<TagihanListrik> findTagihan(@Param("installation_code") String installation_code, @Param("period") String period);
}
