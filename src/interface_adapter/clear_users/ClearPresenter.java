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
            resultMessage = "No users were cleared.";
        } else {
            resultMessage = String.format("%d users were cleared: %s", deletedUsers.size(), String.join(", ", deletedUsers));
        }

        ClearState clearState = clearViewModel.getState();
        clearState.setStatusMessage(resultMessage);
        clearViewModel.setState(clearState);
        clearViewModel.firePropertyChanged();
    }
}
