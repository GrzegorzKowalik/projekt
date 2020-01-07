package cl.reddit.service.post;

import cl.reddit.model.file.File;
import cl.reddit.repository.FileRepository;

public class FileService {

    private FileRepository fileRepository = new FileRepository();

    public File createFile(File file) {
        return getFileRepository().create(file);
    }

    private FileRepository getFileRepository() {
        return fileRepository;
    }

    public void setFileRepository(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
}
