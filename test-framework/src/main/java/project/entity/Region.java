package project.entity;

import mg.uniDao.annotation.Field;
import mg.uniDao.annotation.AutoSequence;
import mg.uniDao.core.sql.GenericSqlDao;
import mg.uniDao.annotation.Collection;


@Collection
public class Region extends GenericSqlDao {
	@Field(name = "region_id", isPrimaryKey = true)
	@AutoSequence(name = "region")
	private Integer regionId;
	@Field(name = "region_description")
	private String regionDescription;



	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionDescription() {
		return regionDescription;
	}
	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}


}