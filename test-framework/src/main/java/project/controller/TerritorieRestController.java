package project.controller;

import project.entity.Territorie;
import etu2024.framework.annotation.JsonObject;
import etu2024.framework.annotation.Url;
import etu2024.framework.annotation.RestAPI;
import etu2024.framework.utility.Mapping;
import mg.uniDao.core.Database;
import mg.uniDao.exception.DaoException;
import mg.uniDao.provider.GenericSqlProvider;
import mg.uniDao.core.Service;



public class TerritorieRestController {
    private final Database database;

	public TerritorieRestController() throws DaoException {
		database = GenericSqlProvider.get();
	}

    @Url(url="/territories", method=Mapping.POST)
	@RestAPI
    public void save(@JsonObject Territorie territorie) throws DaoException {
        Service service = database.connect();
		territorie.save(service);
		service.endConnection();
    }

    @Url(url="/territories")
	@RestAPI
    public Territorie[] readAll() throws DaoException {
        Service service = database.connect();

		Territorie[] territories = new Territorie().getList(service).toArray(new Territorie[0]);
		service.endConnection();

		return territories;
    }
    
    @Url(url="/territories/{page}/{limit}")
	@RestAPI
    public Territorie[] readAllPg(Integer limit, Integer page) throws DaoException {
        		Service service = database.connect();
		Territorie[] territories = new Territorie().getList(service, page, limit).toArray(new Territorie[0]);
		service.endConnection();
		return territories;
    }

    @Url(url="/territories/{id}")
	@RestAPI
    public Territorie read( Integer id) throws DaoException {
        Service service = database.connect();

		Territorie territorie = new Territorie().getById(service, id);
		service.endConnection();

		return territorie;
    }

    @Url(url="/territories/{id}", method=Mapping.PUT)
	@RestAPI
    public void update(@JsonObject Territorie territorie,  Integer id) throws DaoException {
        Service service = database.connect();
		database.updateById(service, territorie, id);
		service.endConnection();
    }

    @Url(url="/territories/{id}", method=Mapping.DELETE)
	@RestAPI
    public void delete( Integer id) throws DaoException {
        Service service = database.connect();
		database.deleteById(service, Territorie.class, id);
		service.endConnection();
    }
}