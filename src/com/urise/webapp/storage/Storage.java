package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public interface Storage {

    public void clear();

    public void save(Resume resume);

    public void update(Resume resume);

    public Resume get(String uuid);

    public void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll();

    int size();
}
