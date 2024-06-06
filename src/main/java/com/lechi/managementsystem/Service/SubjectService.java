package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.Subject;

import java.util.List;

public interface SubjectService {

    public void add(Subject subject);

    public List<Subject> getAll();

    public void delete(Integer id);

    public void update(Subject subject);

    public Subject getById(Integer id);
}
