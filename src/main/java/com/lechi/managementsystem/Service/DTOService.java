package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Error.UserCannotBeAddedException;
import com.lechi.managementsystem.Error.UserCannotBeUpdatedException;

import java.util.List;

public interface DTOService<Obj, Dto> {

    public List<Dto> getAll();

    public void add(Obj o) throws UserCannotBeAddedException;

    public Dto getDTOById(Integer id);

    public Obj getById(Integer id);

    public void deleteById(Integer id);

    public void update(Dto dto) throws UserCannotBeUpdatedException;

    public long count();
}
