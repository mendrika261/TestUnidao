import mg.uniDao.annotation.AutoSequence;
import mg.uniDao.annotation.Collection;
import mg.uniDao.annotation.Field;
import mg.uniDao.core.sql.GenericSqlDao;

@Collection
public class Region extends GenericSqlDao {
    @AutoSequence(name = "student", prefix = "ETU", length = 8)
    @Field(name = "region_id", isPrimaryKey = true)
    private String regionId;

    @Field(name = "region_description")
    private String regionDescription;

    public Region() {
    }

    public Region(String regionDescription) {
        this.regionDescription = regionDescription;
    }
}
