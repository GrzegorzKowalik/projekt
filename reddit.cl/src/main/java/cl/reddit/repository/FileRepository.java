package cl.reddit.repository;

import cl.reddit.model.file.File;

import java.util.List;

public class FileRepository extends AbstractRepository<File> {

    public File findById(Long id) {
        return super.findById(id, File.class);
    }

    public List<File> findAll() {
        return super.findAll(File.class);
    }

    public boolean delete(Long id) {
        return super.delete(id, File.class);
    }

    @Override
    public File create(File file) {
        file.setId((Long)super.create(file));
        return file;
    }
}
