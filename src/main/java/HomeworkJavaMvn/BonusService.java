package HomeworkJavaMvn;

public class BonusService {
    public long calculate (long amount, boolean registered) {
        long percent = registered ? 3 : 1;
        long bonus = amount * percent / 100;
        if (bonus > 500) {
            bonus = 500;
        }
        return bonus;
    }
}
