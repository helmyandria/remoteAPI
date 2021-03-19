package id.pelindo.remote.repository;

import id.pelindo.remote.model.PriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceTypeRepository extends JpaRepository<PriceType, String> {

    @Query(value = "SELECT * FROM PROP_SERVICES_INSTALLATION_P WHERE INSTALLATION_CODE = :installation_code", nativeQuery = true)
    List<PriceType> getPriceType(@Param("installation_code") String installation_code);

}
