package id.pelindo.remote.repository;

import id.pelindo.remote.model.PriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceTypeRepository extends JpaRepository<PriceType, String> {

    @Query(value = "SELECT * FROM PROP_SERVICES_TRANSACTION_D WHERE ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'KVARH') or ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'WBP') or ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'LWBP') or ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'BLOK1') or ID = (SELECT MAX(ID) FROM PROP_SERVICES_TRANSACTION_D WHERE INSTALLATION_CODE= :installation_code AND PRICE_TYPE  = 'BLOK2')  ", nativeQuery = true)
    List<PriceType> getPriceType(@Param("installation_code") String installation_code);

}
