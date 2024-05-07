package project.entity;

import mg.uniDao.annotation.Field;
import mg.uniDao.annotation.AutoSequence;
import mg.uniDao.core.sql.GenericSqlDao;
import mg.uniDao.annotation.Collection;


@Collection
public class Territorie extends GenericSqlDao {
	@Field(name = "territory_id", isPrimaryKey = true)
	@AutoSequence(name = "territorie")
	private Integer territoryId;
	@Field(name = "territory_description")
	private String territoryDescription;
	@Field(name = "region_id")
	private Integer regionId;



	public Integer getTerritoryId() {
		return territoryId;
	}
	public void setTerritoryId(Integer territoryId) {
		this.territoryId = territoryId;
	}

	public String getTerritoryDescription() {
		return territoryDescription;
	}
	public void setTerritoryDescription(String territoryDescription) {
		this.territoryDescription = territoryDescription;
	}

	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}


}