package unsafe;

public class dd {
    public void volatiles(Object arg) {
        System.out.println("同步之外------1--" + Thread.currentThread().getName());
        synchronized (getClassLoadingLock(arg)) {
            try {
                Thread.sleep(10000);
                System.out.println("------4--" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    public Object getClassLoadingLock(Object o) {
        System.out.println("同步之内------2--" + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("同步之内------3--" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (o != null) {
            return o;
        } else {
            return new Object();
        }
    }

    public static void main(String[] args) {
        dd d = new dd();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                d.volatiles(d);
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                d.volatiles(d);
            }
        };
        new Thread(runnable).start();
        new Thread(runnable2).start();
    }
}
