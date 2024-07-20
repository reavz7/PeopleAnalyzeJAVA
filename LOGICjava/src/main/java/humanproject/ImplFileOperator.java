package humanproject;

import java.util.List;

public class ImplFileOperator implements  IFileOperator{
    @Override
    public void serialize(List<Human> users, String filename) {

    }

    @Override
    public List<Human> deserialize(String filename) {
        return List.of();
    }
}
