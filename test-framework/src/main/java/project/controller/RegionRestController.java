package project.controller;

import project.entity.Region;
import etu2024.framework.annotation.JsonObject;
import etu2024.framework.annotation.Url;
import etu2024.framework.annotation.RestAPI;
import etu2024.framework.utility.Mapping;
import mg.uniDao.core.Database;
import mg.uniDao.exception.DaoException;
import mg.uniDao.provider.GenericSqlProvider;
import mg.uniDao.core.Service;



public class RegionRestController {
    private final Database database;

	public RegionRestController() throws DaoException {
		database = GenericSqlProvider.get();
	}

    @Url(url="/regions", method=Mapping.POST)
	@RestAPI
    public void save(@JsonObject Region region) throws DaoException {
        Service service = database.connect();
		region.save(service);
		service.endConnection();
    }

    @Url(url="/regions")
	@RestAPI
    public Region[] readAll() throws DaoException {
        Service service = database.connect();

		Region[] regions = new Region().getList(service).toArray(new Region[0]);
		service.endConnection();

		return regions;
    }
    
    @Url(url="/regions/{page}/{limit}")
	@RestAPI
    public Region[] readAllPg(Integer limit, Integer page) throws DaoException {
        		Service service = database.connect();
		Region[] regions = new Region().getList(service, page, limit).toArray(new Region[0]);
		service.endConnection();
		return regions;
    }

    @Url(url="/regions/{id}")
	@RestAPI
    public Region read( Integer id) throws DaoException {
        Service service = database.connect();

		Region region = new Region().getById(service, id);
		service.endConnection();

		return region;
    }

    @Url(url="/regions/{id}", method=Mapping.PUT)
	@RestAPI
    public void update(@JsonObject Region region,  Integer id) throws DaoException {
        Service service = database.connect();
		database.updateById(service, region, id);
		service.endConnection();
    }

    @Url(url="/regions/{id}", method=Mapping.DELETE)
	@RestAPI
    public void delete( Integer id) throws DaoException {
        Service service = database.connect();
		database.deleteById(service, Region.class, id);
		service.endConnection();
    }
}