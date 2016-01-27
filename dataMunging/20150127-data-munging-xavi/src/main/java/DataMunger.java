import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class DataMunger {

    private final String data;

    public DataMunger(String data) {
        this.data = data;
    }

    public Observable<String> lines() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String[] lines = data.split("\n");
                for (String line : lines) {
                    subscriber.onNext(line);
                }
                subscriber.onCompleted();
            }
        });
    }

    public Observable<String> entries() {
         return lines()
                 .filter(headers())
                 .filter(emptyLines())
                 .filter(monthlyAverage());
    }

    private Func1<String, Boolean> headers() {
        return new Func1<String, Boolean>() {
            @Override
            public Boolean call(String line) {
                return !line.contains("Dy");
            }
        };
    }

    private Func1<String, Boolean> emptyLines() {
        return new Func1<String, Boolean>() {
            @Override
            public Boolean call(String line) {
                return !line.isEmpty();
            }
        };
    }

    private Func1<String, Boolean> monthlyAverage() {
        return new Func1<String, Boolean>() {
            @Override
            public Boolean call(String line) {
                return !line.contains("mo");
            }
        };
    }
}
