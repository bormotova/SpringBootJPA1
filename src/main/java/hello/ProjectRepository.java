package hello;

/**
 * Created by admin1 on 15.03.2017.
 */
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "project", path = "project")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    List<Project> findByName(@Param("name") String name);

    @Query("SELECT p.name FROM Project p join p.customers c WHERE " +
            "LOWER(c.firstname) LIKE LOWER(CONCAT('%',:searchTerm,'%')) OR " +
            "LOWER(c.lastname) LIKE LOWER(CONCAT('%',:searchTerm,'%'))")
    List<String> findProjectByCustomer(@Param("searchTerm") String searchTerm);

/*    @Query("SELECT c FROM Project p, Customer c WHERE c = p.customers AND " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%',:searchTerm,'%'))")
    List<Customer> findCustomerByProject(@Param("searchTerm") String searchTerm);*/
}
