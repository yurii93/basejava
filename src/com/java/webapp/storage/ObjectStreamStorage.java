package com.java.webapp.storage;

import com.java.webapp.exception.StorageException;
import com.java.webapp.model.Resume;

import java.io.*;

public class ObjectStreamStorage extends AbstractFileStorage {

    protected ObjectStreamStorage(File directory) {
        super(directory);
    }

    @Override
    protected void doWrite(Resume resume, OutputStream os) throws IOException {
        try (ObjectOutputStream oss = new ObjectOutputStream(os)) {
            oss.writeObject(resume);
        }
    }

    @Override
    protected Resume doRead(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }
}
