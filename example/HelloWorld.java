class HelloWorld {
    private static native String hello(String input);
    private static native void factAndCallMeBack(int n, HelloWorld callback);

    private static native long counterNew(HelloWorld callback);
    private static native void counterIncrement(long counter_ptr);
    private static native void counterDestroy(long counter_ptr);

    private static native void asyncComputation(HelloWorld callback);

    static {
        System.loadLibrary("mylib");
    }

    public static void main(String[] args) {
        while (true) {
            String output = HelloWorld.hello("josh");
            System.out.println(output);
        }
    }

    public void factCallback(int res) {
      System.out.println("factCallback: res = " + res);
    }

    public void counterCallback(int count) {
      System.out.println("counterCallback: count = " + count);
    }

    public void asyncCallback(int progress) {
        System.out.println("asyncCallback: thread id = " + Thread.currentThread().getId() + ", progress = " + progress + "%");
    }
}
