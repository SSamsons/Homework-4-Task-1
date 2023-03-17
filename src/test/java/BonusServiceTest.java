import HomeworkJavaMvn.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() { ////Корректное поступление бонусов. Зарегестрированный пользователь
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredOverUnderLimit() { //Максимальное начисление бонусов. Зарегестрированный пользователь
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() { //Корректное поступление бонусов. Незарегестрированный пользователь
        BonusService service = new BonusService();

        long amount = 10_000;
        boolean registered = false;
        long expected = 100;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredOverUnderLimit() { //Максимальный бонус. Незарегестрированный пользователь
        BonusService service = new BonusService();

        long amount = 100_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndBorderlineLimit() { //Пограничное значение. Незарегестрированный пользователь
        BonusService service = new BonusService();

        long amount = 100;
        boolean registered = false;
        long expected = 1;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndBorderlineInLimit() { //Пограничное значение. Незарегестрированный пользователь
        BonusService service = new BonusService();

        long amount = 49_900;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndNegative() { //Отрицательный результат. Незарегестрированный пользователь
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 600;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndNegative() { //Отрицательный результат. Зарегестрированный пользователь
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 300;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}