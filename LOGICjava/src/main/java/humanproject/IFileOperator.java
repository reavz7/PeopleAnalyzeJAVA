package humanproject;

import java.util.List;

public interface IFileOperator {

    void serialize(List<Human> users, String filename);
    List<Human> deserialize(String filename);
}
