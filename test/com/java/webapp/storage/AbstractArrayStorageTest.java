package com.java.webapp.storage;

import com.java.webapp.exception.ExistStorageException;
import com.java.webapp.exception.NotExistStorageException;
import com.java.webapp.exception.StorageException;
import com.java.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    private final Storage storage;
    private static final int STORAGE_LIMIT = 10000;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume oldResume = storage.get(UUID_1);
        storage.update(new Resume(UUID_1));
        Resume updateResume = storage.get(UUID_1);
        Assert.assertNotSame(oldResume, updateResume);
        Assert.assertEquals(oldResume.getUuid(), updateResume.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume(UUID_4));
    }

    @Test
    public void save() {
        storage.save(new Resume(UUID_4));
        Resume savedResume = storage.get(UUID_4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(UUID_4, savedResume.getUuid());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(new Resume(UUID_1));
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void get() {
        Resume resume = storage.get(UUID_1);
        Assert.assertEquals(UUID_1, resume.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        Resume[] allResumes = storage.getAll();
        Assert.assertEquals(storage.size(), allResumes.length);
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() {
        int storageLimit = AbstractArrayStorage.STORAGE_LIMIT - storage.size();
        for (int i = 0; i < storageLimit; i++) {
            storage.save(new Resume());
        }
        storage.save(new Resume());
    }
}