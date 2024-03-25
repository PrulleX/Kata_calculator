import java.util.*;
import java.util.function.Consumer;

class Test3 {
    public static class MailMessage extends Mail<String> {
        MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }

    public static class Salary extends Mail<Integer> {
        Salary(String from, String to, int content) {
            super(from, to, content);
        }
    }

    public static abstract class Mail<T> {
        private String from;
        private String to;
        private T content;

        Mail(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public T getContent() {
            return content;
        }
    }

    public static class MailService<T> implements Consumer<Mail<T>> {
        Map<String, List<T>> list = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                return super.getOrDefault(key, Collections.emptyList());
            }
        };

        Map<String, List<T>> getMailBox() {
            return list;
        }

        @Override
        public void accept(Mail<T> o) {
            list.computeIfAbsent(o.getTo(), k -> new LinkedList<>()).add(o.getContent());
        }
    }
}

