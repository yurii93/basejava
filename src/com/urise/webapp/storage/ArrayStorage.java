package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (ifExistsIndex(getIndex(resume.getUuid()))) {
            System.out.println("Resume already exists!");
        } else if (size == storage.length) {
            System.out.println("Storage is already filled!");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void update(Resume resume) {
        int elemIndex = getIndex(resume.getUuid());

        if (!ifExistsIndex(elemIndex)) {
            System.out.println("Resume doesn't exist!");
        } else {
            storage[elemIndex] = resume;
        }
    }

    public Resume get(String uuid) {

        int elemIndex = getIndex(uuid);

        if (!ifExistsIndex(elemIndex)) {
            System.out.println("Resume doesn't exist!");
            return null;
        }
        return storage[elemIndex];
    }

    public void delete(String uuid) {

        if (!ifExistsIndex(getIndex(uuid))) {
            System.out.println("Resume doesn't exist! Nothing to delete!");
        } else {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    storage[i] = null;
                    System.arraycopy(storage, i + 1, storage, i, size - i);
                    size--;
                    break;
                }
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    private boolean ifExistsIndex(int index) {
        return index != -1;
    }
}
