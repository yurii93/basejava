import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int storageSize = size();
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int storageSize = size();

        if (storageSize >= 1) {
            for (int i = 0; i < storageSize; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                    System.arraycopy(storage, i + 1, storage, i, storageSize - i);
                    storage[storageSize - i - 1] = null;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (Objects.isNull(resume)) {
                break;
            } else {
                size++;
            }
        }
        return size;
    }
}
