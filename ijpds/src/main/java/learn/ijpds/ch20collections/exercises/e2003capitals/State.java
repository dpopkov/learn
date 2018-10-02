package learn.ijpds.ch20collections.exercises.e2003capitals;

import java.util.Objects;

class State {
    private String title;
    private String capital;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public static State parseCsv(String csv) {
        String[] tokens = csv.split(",");
        State state = new State();
        state.setTitle(tokens[0]);
        state.setCapital(tokens[1]);
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(title, state.title) &&
                Objects.equals(capital, state.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, capital);
    }
}
