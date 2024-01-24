package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        boolean rev = false;
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        try {
            memTracker.delete(id);
            out.println("Заявка удалена успешно.");
            rev = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return rev;
    }
}
