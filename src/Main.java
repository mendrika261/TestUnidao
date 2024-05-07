import mg.uniDao.core.Database;
import mg.uniDao.core.Service;
import mg.uniDao.exception.DaoException;
import mg.uniDao.provider.GenericSqlProvider;
import project.Region;

public class Main {
    public static void main(String[] args) throws DaoException {
        Database postgresSql = GenericSqlProvider.get("database.json");

        Service service = postgresSql.connect("TEST", true);

        Region region = new Region();
        postgresSql.updateById(service, region, 48);

        service.endConnection();
    }
}