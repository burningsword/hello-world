package pers.wk.test.java8.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;

@Slf4j
public class HystrixTest {

    public static void main(String[] args) throws InterruptedException {
//        String result = new CommandHelloWorld("wk").execute();
//        System.out.println(result);


//        observable.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.printf("%s receive result: %s \n", Thread.currentThread(), s);
//            }
//        });
//        observable.subscribe(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                throwable.printStackTrace();
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.printf("%s receive result: %s \n", Thread.currentThread(), s);
//            }
//        });

        ObservableCommandHelloWorld observableCommand = new ObservableCommandHelloWorld("wk");
        Observable<String> observable2 = observableCommand.observe();
        observable2.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

            }
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    static class CommandHelloWorld extends HystrixCommand<String> {

        private final String name;

        protected CommandHelloWorld(String name) {
            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
            this.name = name;
        }

        @Override
        protected String run() throws Exception {
            return "hello " + this.name;
        }
    }

    static class ObservableCommandHelloWorld extends HystrixObservableCommand<String> {

        private final String name;

        protected ObservableCommandHelloWorld(String name) {
            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
            this.name = name;
        }

        @Override
        protected Observable<String> construct() {
            return Observable.create(new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> subscriber) {
                    if (!subscriber.isUnsubscribed()) {

                    }
                }
            });
        }
    }
}
