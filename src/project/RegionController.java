package project;

import etu2024.framework.annotation.JsonObject;
import etu2024.framework.annotation.RestAPI;
import etu2024.framework.annotation.Url;
import etu2024.framework.utility.Mapping;
import mg.uniDao.core.Database;
import mg.uniDao.core.Service;
import mg.uniDao.exception.DaoException;
import mg.uniDao.provider.GenericSqlProvider;

import java.util.List;

public class RegionController {
    private final Database database;

    public RegionController() throws DaoException {
        database = GenericSqlProvider.get();
    }

    @Url(url = "/regions/{id}")
    @RestAPI
    public Region getOne(Integer id) throws DaoException {
        Service service = database.connect();

        Region region = new Region().getById(service, id);
        service.endConnection();

        return region;
    }

    @Url(url = "/regions")
    @RestAPI
    public List<Region> get() throws DaoException {
        Service service = database.connect();

        List<Region> regions = new Region().getList(service);
        service.endConnection();

        return regions;
    }

    @RestAPI
    @Url(url = "/regions", method = Mapping.POST)
    public void create(@JsonObject Region region) throws DaoException {
        Service service = database.connect();
        System.out.println("Creating region: " + region);
        region.save(service);
        service.endConnection();
    }

    @RestAPI
    @Url(url = "/regions/{id}", method = Mapping.PUT)
    public void update(@JsonObject Region region, Integer id) throws DaoException {
        Service service = database.connect();
        database.updateById(service, region, id);
        service.endConnection();
    }

    @RestAPI
    @Url(url = "/regions/{id}", method = Mapping.DELETE)
    public void delete(Integer id) throws DaoException {
        Service service = database.connect();
        database.deleteById(service, Region.class, id);
        service.endConnection();
    }
}
