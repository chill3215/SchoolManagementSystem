package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Enum.UserRole;

import java.util.List;

public interface MainService<T> {

    public List<T> getAll();

    public void add(T t);

    public T findByEmail(String email);

    public T getById(Integer id);

    public void deleteById(Integer id);

    public void update(T t);

}
