package hello;

/**
 * Created by admin1 on 15.03.2017.
 */
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByName(String name);
}
