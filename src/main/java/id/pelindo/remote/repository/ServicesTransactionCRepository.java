package id.pelindo.remote.repository;

import id.pelindo.remote.model.ServicesTransaction;
import id.pelindo.remote.model.ServicesTransactionC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesTransactionCRepository  extends JpaRepository<ServicesTransactionC,String> {

}
