package learn.core1.ch08generics.exceptions;

public abstract class Block {
    public abstract void body() throws Exception;

    @SuppressWarnings("AnonymousHasLambdaAlternative")
    public Thread toThread() {
        return new Thread() {
            public void run() {
                try {
                    body();
                } catch (Throwable e) {
                    Block.<RuntimeException>throwAs(e);
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T) e;
    }
}
