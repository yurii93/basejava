package com.java.webapp.storage;

import com.java.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey.toString());
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        map.put((String) searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        map.put((String) searchKey, resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove(searchKey.toString());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey.toString());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
