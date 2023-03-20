import HomeworkJavaMvn.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {


    @Test
    public void shouldCalculateForRegisteredAndUnderLimit() { //Корректное поступление бонусов. Зарегестрированный пользователь
        BonusService service = new BonusService();

        int expected = 30;
        int actual = service.calcBonus(1000, true);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForRegisteredOverUnderLimit() { //Максимальное начисление бонусов. Зарегестрированный пользователь
        BonusService service = new BonusService();

        long expected = 500;
        long actual = service.calcBonus(1_000_000, true);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnregisteredAndUnderLimit() { //Корректное поступление бонусов. Незарегестрированный пользователь
        BonusService service = new BonusService();

        long expected = 100;
        long actual = service.calcBonus(10_000, false);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnregisteredOverUnderLimit() { //Максимальный бонус. Незарегестрированный пользователь
        BonusService service = new BonusService();


        long expected = 500;
        long actual = service.calcBonus(100_000_000, false);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnregisteredAndBorderlineLimit() { //Пограничное значение. Незарегестрированный пользователь
        BonusService service = new BonusService();

        long expected = 1;
        long actual = service.calcBonus(100, false);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnregisteredAndBorderlineInLimit() { //Пограничное значение. Незарегестрированный пользователь
        BonusService service = new BonusService();

        long expected = 499;
        long actual = service.calcBonus(49_900, false);

        Assertions.assertEquals(expected, actual);
    }
}