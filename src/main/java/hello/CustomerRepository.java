package hello;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findBylastname(@Param("lastName") String lastname);

    @Query("SELECT c FROM Customer c WHERE " +
        "LOWER(c.firstname) LIKE LOWER(CONCAT('%',:searchTerm,'%')) OR " +
        "LOWER(c.lastname) LIKE LOWER(CONCAT('%',:searchTerm,'%'))")
    List<Customer> findBySearchTerm(@Param("searchTerm") String searchTerm);
}
