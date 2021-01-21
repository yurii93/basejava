package com.java.webapp.storage;

import com.java.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Resume newResume, Object resume) {
        map.put(newResume.getUuid(), newResume);
    }

    @Override
    protected void doSave(Resume newResume, Object resume) {
        map.put(newResume.getUuid(), newResume);
    }

    @Override
    protected void doDelete(Object resume) {
        map.remove(((Resume) resume).getUuid());
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
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
