package interface_adapter.clear_users;

import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

import java.util.List;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;

    public ClearPresenter(ClearViewModel clearViewModel) {
        this.clearViewModel = clearViewModel;
    }

    @Override
    public void prepareClearedView(ClearOutputData data) {
        List<String> deletedUsers = data.getDeletedUsers();
        String resultMessage;

        if (deletedUsers.isEmpty()) {
            resultMessage = "";
        } else {
            resultMessage = String.join("\n", deletedUsers);
        }

        ClearState clearState = clearViewModel.getState();
        clearState.setStatusMessage(resultMessage);
        clearViewModel.setState(clearState);
        clearViewModel.firePropertyChanged();
    }
}
