package use_case.clear_users;

import entity.User;
import java.util.List;

public class ClearInteractor implements ClearInputBoundary {

    private final ClearUserDataAccessInterface userDataAccessObject;
    private final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessObject, ClearOutputBoundary clearPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.clearPresenter = clearPresenter;
    }

    @Override
    public void execute() {
        List<String> allUsers = userDataAccessObject.getAllUsers();

        userDataAccessObject.clearAllUsers();

        ClearOutputData clearOutputData = new ClearOutputData(allUsers);
        clearPresenter.prepareClearedView(clearOutputData);
    }
}
