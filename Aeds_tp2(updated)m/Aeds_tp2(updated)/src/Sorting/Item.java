package Sorting;
public class Item {
    private int value;

    // Construtor que inicializa o valor de inteiro
    public Item(int value) {
        this.value = value;
    }

    // Método get para obter o valor
    public int getValue() {
        return value;
    }
    public Item() {
        this.value = 0; // or any default value
    }

    // Método set para modificar o valor
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
