enum ClothingSize {
    XXS(32), XS(34), S(36), M(38), L(40);

    private int euroSize;

    // Конструктор перечисления, который устанавливает соответствующий euroSize
    ClothingSize(int euroSize) {
        this.euroSize = euroSize;
    }

    // Переопределяем метод getDescription для XXS
    public String getDescription() {
        if (this == XXS) {
            return "Детский размер";
        }
        return "Взрослый размер";
    }

    // Метод для получения euroSize
    public int getEuroSize() {
        return euroSize;
    }
}

// Создаем интерфейсы для мужской и женской одежды
interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWoman();
}

// Абстрактный класс Одежда
abstract class Clothing {
    private ClothingSize size;
    private double cost;
    private String color;

    // Конструктор для класса Одежда
    public Clothing(ClothingSize size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    // Метод для получения информации о одежде
    public void getInfo() {
        System.out.println("Размер: " + size + " (" + size.getEuroSize() + " EUR)");
        System.out.println("Цена: " + cost + " руб.");
        System.out.println("Цвет: " + color);
    }
}

// Класс Футболка
class TShirt extends Clothing implements MenClothing, WomenClothing {
    public TShirt(ClothingSize size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская футболка:");
        getInfo();
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская футболка:");
        getInfo();
    }
}

// Класс Штаны
class Pants extends Clothing implements MenClothing, WomenClothing {
    public Pants(ClothingSize size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские штаны:");
        getInfo();
    }

    @Override
    public void dressWoman() {
        System.out.println("Женские штаны:");
        getInfo();
    }
}

// Класс Юбка
class Skirt extends Clothing implements WomenClothing {
    public Skirt(ClothingSize size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Юбка:");
        getInfo();
    }
}

// Класс Галстук
class Tie extends Clothing implements MenClothing {
    public Tie(ClothingSize size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук:");
        getInfo();
    }
}

// Класс Ателье
class Atelier {
    // Метод для одевания мужчины
    public void dressMan(MenClothing[] clothes) {
        System.out.println("Одеваем мужчину:");
        for (MenClothing clothing : clothes) {
            clothing.dressMan();
            System.out.println();
        }
    }

    // Метод для одевания женщины
    public void dressWoman(WomenClothing[] clothes) {
        System.out.println("Одеваем женщину:");
        for (WomenClothing clothing : clothes) {
            clothing.dressWoman();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем массивы с разными типами одежды
        TShirt menTShirt = new TShirt(ClothingSize.M, 25.0, "Белая");
        TShirt womenTShirt = new TShirt(ClothingSize.S, 20.0, "Розовая");
        Pants menPants = new Pants(ClothingSize.L, 45.0, "Черные");
        Pants womenPants = new Pants(ClothingSize.XS, 35.0, "Синие");
        Skirt skirt = new Skirt(ClothingSize.S, 30.0, "Зеленая");
        Tie tie = new Tie(ClothingSize.XXS, 15.0, "Синий");


        MenClothing[] menClothes = {menTShirt, menPants, tie};
        WomenClothing[] womenClothes = {womenTShirt, womenPants, skirt};

        Atelier atelier = new Atelier();
        atelier.dressMan(menClothes);
        System.out.println("==================================");
        atelier.dressWoman(womenClothes);

        System.out.println("==================================");
        ClothingSize size = ClothingSize.XXS;
        String description = size.getDescription();
        System.out.println(description); // Выведет "Детский размер"
    }
}
