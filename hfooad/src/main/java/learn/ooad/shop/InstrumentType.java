package learn.ooad.shop;

public enum InstrumentType {
    GUITAR,
    BANJO,
    DOBRO,
    FIDDLE,
    BASS,
    MANDOLIN;

    @Override
    public String toString() {
        String upper = super.toString();
        return upper.charAt(0) + upper.substring(1).toLowerCase();
    }
}
