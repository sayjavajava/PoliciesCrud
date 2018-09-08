package viseco.sc.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import viseco.sc.Models.Policy;

public interface PolicyRepository extends MongoRepository<Policy,String>{

}

