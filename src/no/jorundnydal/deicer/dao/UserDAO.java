package no.jorundnydal.deicer.dao;

import java.util.List;

import no.jorundnydal.deicer.dao.GenericDao;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.User;

import com.google.appengine.api.datastore.Key;

public interface UserDAO extends GenericDao<User, Key> {
 
    public List<Admin> findAllAdmins();
 
}