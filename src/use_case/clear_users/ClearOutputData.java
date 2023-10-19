package use_case.clear_users;

import java.util.List;

public class ClearOutputData {
    private final List<String> deletedUsers;

    public ClearOutputData(List<String> deletedUsers) {
        this.deletedUsers = deletedUsers;
    }

    public List<String> getDeletedUsers() {
        return deletedUsers;
    }
}
