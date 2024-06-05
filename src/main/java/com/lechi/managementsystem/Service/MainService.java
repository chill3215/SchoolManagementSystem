package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Enum.UserRole;

import java.util.List;

public interface MainService<Obj, Dto> {

    public List<Dto> getAll();

    public void add(Obj o);


    public Dto getDTOById(Integer id);

    public Obj getById(Integer id);

    public void deleteById(Integer id);

    public void update(Dto dto);

    public long count();
}
