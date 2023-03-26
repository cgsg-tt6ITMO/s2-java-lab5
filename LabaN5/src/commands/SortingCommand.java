/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package commands;

import management.CollectionManager;
import task.Route;

public class SortingCommand implements Command {
    private CollectionManager storage;

    public SortingCommand(CollectionManager collectionManager) {
        this.storage = collectionManager;
    }

    private void swap(int a, int b) {
        Route tmp = storage.stack().get(a);
        storage.stack().set(a, storage.stack().get(b));
        storage.stack().set(b, tmp);
    }

    @Override
    public void execute() {
        for (int j = 0; j < storage.stack().size() - 1; j++) {
            for (int i = j + 1; i < storage.stack().size(); i++) {
                if (storage.stack().get(i).getId() < storage.stack().get(i - 1).getId()) {
                    swap(i, j);
                }
            }
        }
    }
}
