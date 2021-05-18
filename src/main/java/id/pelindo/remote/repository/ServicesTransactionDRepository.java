package id.pelindo.remote.repository;

import id.pelindo.remote.model.ServicesTransactionD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesTransactionDRepository extends JpaRepository<ServicesTransactionD,String> {
}
